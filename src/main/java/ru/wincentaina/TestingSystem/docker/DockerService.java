package ru.wincentaina.TestingSystem.docker;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.wincentaina.TestingSystem.dto.CodeRequestDto;
import ru.wincentaina.TestingSystem.dto.ExecutionResultDto;

import java.util.List;

@Service
public class DockerService {

    private final DockerClient dockerClient;

    @Autowired
    public DockerService(DockerClient dockerClient) {
        this.dockerClient = dockerClient;
    }

    public ExecutionResultDto runCodeInContainer(CodeRequestDto request) {
        System.out.println("Hi");
        List<Container> containers = dockerClient.listContainersCmd().exec();
        return new ExecutionResultDto("", "", 0);
    }

//    public ExecutionResultDto runCodeInContainer(CodeRequestDto request) {
//        // Создание и запуск контейнера
//        String containerId = dockerClient.createContainerCmd("java-sandbox")
//                .withCmd("java", "Main")
//                .exec()
//                .getId();
//
//        dockerClient.startContainerCmd(containerId).exec();
//
//        // Получение логов выполнения
//        String logs = dockerClient.logContainerCmd(containerId)
//                .withStdOut(true)
//                .withStdErr(true)
//                .exec()
//                .toString();
//
//        dockerClient.stopContainerCmd(containerId).exec();
//        dockerClient.removeContainerCmd(containerId).exec();
//
//        return new ExecutionResultDto(logs, null, 0);
//    }
}