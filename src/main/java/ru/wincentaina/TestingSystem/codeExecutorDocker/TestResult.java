package ru.wincentaina.TestingSystem.codeExecutorDocker;

public class TestResult {
    private String status;
    private String output;
    private int timeoutMs;

    public TestResult(String status, String output, int timeoutMs) {
        this.status = status;
        this.output = output;
        this.timeoutMs = timeoutMs;
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
