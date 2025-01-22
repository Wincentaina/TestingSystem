package ru.wincentaina.TestingSystem.dto;

public class CodeRequestDto {
    private String code;
    private int taskId;
    private int timeout; // Тайм-аут в секундах

    public CodeRequestDto(String code, int taskId, int timeout) {
        this.code = code;
        this.taskId = taskId;
        this.timeout = timeout;
    }

    public String getCode() {
        return code;
    }

    public int getTaskId() {
        return taskId;
    }

    public int getTimeout() {
        return timeout;
    }
}
