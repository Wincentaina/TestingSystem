package ru.wincentaina.TestingSystem.model;

public class Test {
    private int testId;
    private int taskId; // связь с таблицей task
    private String input;
    private String output;
    private int timeoutMs;

    public Test(){}

    public Test(int testId, int taskId, String input, String output, int timeoutMs) {
        this.testId = testId;
        this.taskId = taskId;
        this.input = input;
        this.output = output;
        this.timeoutMs = timeoutMs;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public int getTimeoutMs() {
        return timeoutMs;
    }

    public void setTimeoutMs(int timeoutMs) {
        this.timeoutMs = timeoutMs;
    }
}
