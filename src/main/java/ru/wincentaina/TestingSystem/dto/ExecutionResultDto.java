package ru.wincentaina.TestingSystem.dto;

public class ExecutionResultDto {
    private String output;
    private String error;
    private int exitCode;

    public ExecutionResultDto(String output, String error, int exitCode) {
        this.output = output;
        this.error = error;
        this.exitCode = exitCode;
    }
}
