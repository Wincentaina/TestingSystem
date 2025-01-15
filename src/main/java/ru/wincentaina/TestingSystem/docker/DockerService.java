package ru.wincentaina.TestingSystem.docker;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.BuildImageResultCallback;
import com.github.dockerjava.api.model.BuildResponseItem;
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
        final String BASE_PATH = "./src/main/java/ru/wincentaina/TestingSystem/docker" ;

        // подготовим временные директории для вмонтирования в контейнер
        String tmpDirPath = BASE_PATH + "/tmp";
        Helpers.createDir(tmpDirPath);

        String uniqueID = UUID.randomUUID().toString();
        String tmpInpDirPath = BASE_PATH + "/tmp/" + uniqueID + "_input";
        String tmpOutDirPath = BASE_PATH + "/tmp/" + uniqueID + "_output";
        Helpers.createDir(tmpInpDirPath);
        Helpers.createDir(tmpOutDirPath);

        // запускаем контейнер и монтируем в него директории



//        Helpers.deleteDirectory(tmpDirPath);

        return new ExecutionResultDto("", "", 0);
    }

}