package ru.wincentaina.TestingSystem.service;

import org.springframework.stereotype.Service;
import ru.wincentaina.TestingSystem.model.Task;
import ru.wincentaina.TestingSystem.model.Test;
import ru.wincentaina.TestingSystem.repository.TaskRepository;
import ru.wincentaina.TestingSystem.repository.TestRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {
    private final TestRepository testRepository;
    private final TaskRepository taskRepository; // Для получения задач

    public TestService(TestRepository testRepository, TaskRepository taskRepository) {
        this.testRepository = testRepository;
        this.taskRepository = taskRepository;
    }

    // Найти тест по ID
    public Optional<Test> testById(int id) {
        return testRepository.findById((long) id);
    }

    // Найти все тесты, связанные с конкретной задачей
    public List<Test> testsByTaskId(int taskId) {
        return testRepository.findByTaskId(taskId);
    }

    public Test createTest(int taskId, String input, String output, int timeoutMs) {
        // Проверяем, существует ли задача
        Optional<Task> optionalTask = taskRepository.findById((long) taskId);
        if (optionalTask.isEmpty()) {
            throw new IllegalArgumentException("Task with ID " + taskId + " not found");
        }

        Test test = new Test();
        test.setTask(optionalTask.get());
        test.setInput(input);
        test.setOutput(output);
        test.setTimeoutMs(timeoutMs);

        return testRepository.save(test);
    }

    public void removeTestById(int id) {
        Optional<Test> test =  testRepository.findById((long) id);
        if (test.isEmpty()) {
            throw new RuntimeException("Теста с id " + id + " не существует");
        }
        testRepository.delete(test.get());
    }
}