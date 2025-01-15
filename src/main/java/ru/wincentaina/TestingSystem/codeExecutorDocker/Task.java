package ru.wincentaina.TestingSystem.codeExecutorDocker;

public class Task {
    private int taskId;
    private String descrption;

    public Task(int taskId, String descrption) {
        this.taskId = taskId;
        this.descrption = descrption;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getDescrption() {
        return descrption;
    }
}
