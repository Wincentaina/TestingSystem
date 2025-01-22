package ru.wincentaina.TestingSystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.wincentaina.TestingSystem.dto.CreateTestRequestDTO;
import ru.wincentaina.TestingSystem.dto.CreatingTestResultDTO;
import ru.wincentaina.TestingSystem.dto.UniversalResponseDTO;
import ru.wincentaina.TestingSystem.model.Test;
import ru.wincentaina.TestingSystem.service.TestService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreatingTestResultDTO> createTest(@RequestBody CreateTestRequestDTO request) {
        try {
            Test test = testService.createTest(request.getTask_id(), request.getInput(), request.getOutput(), request.getTimeoutMs());
            return new ResponseEntity<>(new CreatingTestResultDTO("ok", test.getId(), test.getInput(), test.getOutput(), test.getTask().getId()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new CreatingTestResultDTO(e.getMessage(), 0, null, null, 0), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<UniversalResponseDTO> deleteTestById(@RequestParam int id) {
        Optional<Test> testOptional = testService.testById(id);
        if (testOptional.isPresent()) {
            // Удаление записи
            testService.removeTestById(id);
            return new ResponseEntity<>(new UniversalResponseDTO("ok", "Test с ID " + id + " удален"), HttpStatus.OK);
        } else {
            // Если запись не найдена
            return new ResponseEntity<>(new UniversalResponseDTO("ok", "Test с ID " + id + " не найден"), HttpStatus.NOT_FOUND);
        }
    }


}
