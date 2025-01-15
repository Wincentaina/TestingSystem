package ru.wincentaina.TestingSystem.model;

import java.util.List;

public class Task {
    private int taskId;
    private String description;
    private List<Test> tests;

    public Task(int taskId, String description, List<Test> tests) {
        this.taskId = taskId;
        this.description = description;
        this.tests = tests;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }
}
