package ru.wincentaina.TestingSystem.service;

import org.springframework.stereotype.Service;
import ru.wincentaina.TestingSystem.model.Task;
import ru.wincentaina.TestingSystem.model.Test;
import ru.wincentaina.TestingSystem.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> allTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> taskById(int id) {
        return taskRepository.findById((long) id);
    }

    // Создать задачу с тестами
    public Task createTask(String description) {
        Task task = new Task();
        task.setDescription(description);

        return taskRepository.save(task);
    }
}