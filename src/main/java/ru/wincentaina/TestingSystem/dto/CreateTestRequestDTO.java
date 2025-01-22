package ru.wincentaina.TestingSystem.dto;

public class CreateTestRequestDTO {
    private int task_id;
    private String input;
    private String output;
    private int timeoutMs;

    public CreateTestRequestDTO(int id, int task_id, String input, String output, int timeoutMs) {
        this.task_id = task_id;
        this.input = input;
        this.output = output;
        this.timeoutMs = timeoutMs;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
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
