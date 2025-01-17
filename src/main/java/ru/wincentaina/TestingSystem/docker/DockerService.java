package ru.wincentaina.TestingSystem.docker;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.BuildImageResultCallback;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.command.StartContainerCmd;
import com.github.dockerjava.api.model.Bind;
import com.github.dockerjava.api.model.BuildResponseItem;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.Volume;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientImpl;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import com.github.dockerjava.transport.DockerHttpClient;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import ru.wincentaina.TestingSystem.dto.CodeRequestDto;
import ru.wincentaina.TestingSystem.dto.ExecutionResultDto;
import ru.wincentaina.TestingSystem.helpers.Helpers;
import ru.wincentaina.TestingSystem.model.Task;
import ru.wincentaina.TestingSystem.storage.postgres.Tasks;

import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Service
public class DockerService {

    public DockerClient dockerClient;

    public void setDockerClient(DockerClient dockerClient) {
        this.dockerClient = dockerClient;
    }

    @PostConstruct
    public void initDocker() throws Exception {
        DefaultDockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder().build();

        DockerHttpClient httpClient = new ApacheDockerHttpClient.Builder()
                .dockerHost(config.getDockerHost())
                .sslConfig(config.getSSLConfig())
                .maxConnections(10)
                .connectionTimeout(Duration.ofSeconds(30))
                .responseTimeout(Duration.ofSeconds(45))
                .build();

        DockerClient dockerClient = DockerClientImpl.getInstance(config, httpClient);
        setDockerClient(dockerClient);

        if (!buildBaseImage()) {
            System.out.println("Не удалось собрать базовый Docker-образ.");
            throw new Exception("Не удалось собрать базовый Docker-образ.");
        }
    }

    public boolean buildBaseImage() {
        try {
            BuildImageResultCallback callback = new BuildImageResultCallback() {
                public void onNext(BuildResponseItem item) {
                    System.out.println(item.getStream()); // Логи сборки
                    super.onNext(item);
                }
            };

            String imageId = dockerClient.buildImageCmd(Paths.get("./src/main/java/ru/wincentaina/TestingSystem/codeExecutorDocker/Dockerfile").toFile())
                    .withTags(Set.of("java-base"))
                    .exec(callback)
                    .awaitImageId();
            System.out.println("Собран образ с ID: " + imageId);
            return true;
        } catch (Exception e) {
            System.err.println("Ошибка при сборке образа: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public ExecutionResultDto runCodeInContainer(CodeRequestDto request) throws Exception {
        int taskId = request.getTaskId();
        Task task = Tasks.taskById(taskId);
        final String BASE_PATH = Paths.get( "./src/main/java/ru/wincentaina/TestingSystem/docker").toAbsolutePath().normalize().toString();

        // подготовим временные директории для вмонтирования в контейнер
        String tmpDirPath = BASE_PATH + "/tmp";
        Helpers.createDir(tmpDirPath);

        String uniqueName = UUID.randomUUID().toString().replaceAll("-", "");
        String tmpInpDirPath = BASE_PATH + "/tmp/" + uniqueName + "_input";
        String tmpOutDirPath = BASE_PATH + "/tmp/" + uniqueName + "_output";
        Helpers.createDir(tmpInpDirPath);
        Helpers.createDir(tmpOutDirPath);

        // создаем inp.json и out.json. В inp входные данные
        Helpers.createFile(tmpInpDirPath + "/inp.json");
        Helpers.createFile(tmpOutDirPath + "/out.json");

        // запишем mock данные
        Helpers.writeToFile(tmpInpDirPath + "/inp.json", "{\n" +
                "  \"taskId\": 3,\n" +
                "  \"description\": \"my description\",\n" +
                "  \"tests\": [\n" +
                "    {\n" +
                "      \"testId\": 2,\n" +
                "      \"input\": \"inp2\",\n" +
                "      \"timeoutMs\": 100\n" +
                "    },\n" +
                "    {\n" +
                "      \"testId\": 5,\n" +
                "      \"input\": \"inp5\",\n" +
                "      \"timeoutMs\": 20\n" +
                "    }\n" +
                "  ]\n" +
                "}");

        // запускаем контейнер и монтируем в него директории
        String imageName = "java-base";
        CreateContainerResponse container = dockerClient.createContainerCmd(imageName)
                .withEnv("USER_CODE=import java.util.Scanner; public class UserClass { public static void main(String[] args) { Scanner scanner = new Scanner(System.in); String text = scanner.nextLine(); System.out.println(text); } }") // Передача переменной окружения
                .withHostConfig(new HostConfig()
                        .withBinds(
                                // Монтируем локальные директории в контейнер
                                new Bind(tmpInpDirPath, new Volume("/app/input_data")),
                                new Bind(tmpOutDirPath, new Volume("/app/output_data"))
                        )
                )
                .withCmd()
                .exec();

        System.out.println("Создан контейнер с ID: " + container.getId());

        try (StartContainerCmd startCmd = dockerClient.startContainerCmd(container.getId())) {
            startCmd.exec();
        }
        System.out.println("Контейнер запущен.");

        // Ожидание завершения работы контейнера
        dockerClient.waitContainerCmd(container.getId()).start().awaitStatusCode();

        //

        System.out.println("Контейнер завершил выполнение.");

//        Helpers.deleteDirectory(tmpInpDirPath);
//        Helpers.deleteDirectory(tmpOutDirPath);

        return new ExecutionResultDto("", "", 0);
    }

}