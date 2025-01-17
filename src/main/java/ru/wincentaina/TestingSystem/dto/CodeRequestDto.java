package ru.wincentaina.TestingSystem.dto;

public class CodeRequestDto {
    private String code;
    private int taskId;
    private String language;
    private int timeout; // Тайм-аут в секундах

    public CodeRequestDto(String code, int taskId, String language, int timeout) {
        this.code = code;
        this.taskId = taskId;
        this.language = language;
        this.timeout = timeout;
    }

    public String getCode() {
        return code;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getLanguage() {
        return language;
    }

    public int getTimeout() {
        return timeout;
    }
}
