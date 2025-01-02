package ru.wincentaina.TestingSystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExecutionResultDto {
    @JsonProperty("output")
    private String output;

    @JsonProperty("error")
    private String error;

    @JsonProperty("exitCode")
    private int exitCode;

    public ExecutionResultDto(String output, String error, int exitCode) {
        this.output = output;
        this.error = error;
        this.exitCode = exitCode;
    }
}
