package ru.wincentaina.TestingSystem.dto;

public class TestInputDTO {
    private int id;
    private String input;
    private int timeoutMs;

    public TestInputDTO() {}

    public TestInputDTO(int id, String input, int timeoutMs) {
        this.id = id;
        this.input = input;
        this.timeoutMs = timeoutMs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public int getTimeoutMs() {
        return timeoutMs;
    }

    public void setTimeoutMs(int timeoutMs) {
        this.timeoutMs = timeoutMs;
    }

    @Override
    public String toString() {
        return "TestInputDTO{" +
                "id=" + id +
                ", input='" + input + '\'' +
                ", timeoutMs=" + timeoutMs +
                '}';
    }
}