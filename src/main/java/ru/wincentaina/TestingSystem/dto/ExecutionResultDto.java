package ru.wincentaina.TestingSystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExecutionResultDto {
    @JsonProperty("total")
    private int total;

    @JsonProperty("passed")
    private int passed;

    @JsonProperty("error")
    private String error;

    public ExecutionResultDto(int total, int passed, String error) {
        this.total = total;
        this.passed = passed;
        this.error = error;
    }
}
