package ru.wincentaina.TestingSystem.dto;

public class TestDTO {
    private String status;
    private String output;
    private int timeoutMs;

    public TestDTO() {}

    public TestDTO(String status, String output, int timeoutMs) {
        this.status = status;
        this.output = output;
        this.timeoutMs = timeoutMs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "TestDTO{" +
                "status='" + status + '\'' +
                ", output='" + output + '\'' +
                ", timeoutMs=" + timeoutMs +
                '}';
    }
}