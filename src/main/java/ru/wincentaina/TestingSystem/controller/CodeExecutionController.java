package ru.wincentaina.TestingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.wincentaina.TestingSystem.dto.CodeRequestDto;
import ru.wincentaina.TestingSystem.dto.ExecutionResultDto;
import ru.wincentaina.TestingSystem.service.CodeExecutionService;

@RestController
@RequestMapping("/api/v1")
public class CodeExecutionController {

    private final CodeExecutionService codeExecutionService;

    @Autowired
    public CodeExecutionController(CodeExecutionService codeExecutionService) {
        this.codeExecutionService = codeExecutionService;
    }

    @PostMapping("/execute")
    public ResponseEntity<ExecutionResultDto> executeCode(@RequestBody CodeRequestDto request) {
        try {
            ExecutionResultDto result = codeExecutionService.executeCode(request);
            return new ResponseEntity<>(result, HttpStatus.OK);  // Возвращаем успешный результат
        } catch (Exception e) {
            return new ResponseEntity<>(new ExecutionResultDto(null, "Error: " + e.getMessage(), -1), HttpStatus.INTERNAL_SERVER_ERROR);  // Возвращаем ошибку
        }
    }
}
