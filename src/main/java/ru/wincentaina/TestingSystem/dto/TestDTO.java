package ru.wincentaina.TestingSystem.dto;

public class TestDTO {
    private int id;
    private String status;
    private String output;
    private int timeoutMs;

    public TestDTO() {}

    public TestDTO(int id, String status, String output, int timeoutMs) {
        this.id = id;
        this.status = status;
        this.output = output;
        this.timeoutMs = timeoutMs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", status='" + status + '\'' +
                ", output='" + output + '\'' +
                ", timeoutMs=" + timeoutMs +
                '}';
    }
}