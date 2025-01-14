package ru.wincentaina.TestingSystem.service;

import org.springframework.stereotype.Service;
import ru.wincentaina.TestingSystem.docker.DockerService;
import ru.wincentaina.TestingSystem.dto.CodeRequestDto;
import ru.wincentaina.TestingSystem.dto.ExecutionResultDto;

@Service
public class CodeExecutionService {
    private final DockerService dockerService;

    public CodeExecutionService(DockerService dockerService) {
        this.dockerService = dockerService;
    }

    public ExecutionResultDto executeCode(CodeRequestDto request) {
        // Передача кода в Docker для выполнения
        return dockerService.runCodeInContainer(request);
    }
}
