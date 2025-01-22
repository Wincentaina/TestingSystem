package ru.wincentaina.TestingSystem.codeExecutorDocker;

public class TestResult {
    private int id;
    private String status;
    private String output;
    private int timeoutMs;

    public TestResult(int id, String status, String output, int timeoutMs) {
        this.id = id;
        this.status = status;
        this.output = output;
        this.timeoutMs = timeoutMs;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getOutput() {
        return output;
    }

    public int getTimeoutMs() {
        return timeoutMs;
    }
}
