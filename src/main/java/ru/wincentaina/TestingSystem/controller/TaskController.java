package ru.wincentaina.TestingSystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.wincentaina.TestingSystem.dto.*;
import ru.wincentaina.TestingSystem.model.Task;
import ru.wincentaina.TestingSystem.service.TaskService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreatingTaskResultDTO> createTask(@RequestBody CreateTaskRequestDTO request) {
        try {
            Task task = taskService.createTask(request.getDescription());
            return new ResponseEntity<>(new CreatingTaskResultDTO("ok", task.getId(), task.getDescription()), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new CreatingTaskResultDTO(e.getMessage(), 0, null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<UniversalResponseDTO> deleteTaskById(@RequestParam int id) {
        Optional<Task> taskOptional = taskService.taskById(id);
        if (taskOptional.isPresent()) {
            taskService.removeTaskById(id);
            return new ResponseEntity<>(new UniversalResponseDTO("ok", "Задача с id " + id + " удалена"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new UniversalResponseDTO("not found", "Задача с id " + id + " не найдена"), HttpStatus.NOT_FOUND);
        }
    }
}
