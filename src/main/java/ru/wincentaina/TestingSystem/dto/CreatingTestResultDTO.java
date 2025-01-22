package ru.wincentaina.TestingSystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Service;

public class CreatingTestResultDTO {
    @JsonProperty("error")
    private String error;
    @JsonProperty("id")
    private int id;
    @JsonProperty("input")
    private String input;
    @JsonProperty("output")
    private String output;
    @JsonProperty("task_id")
    private int taskId;

    public CreatingTestResultDTO(String error, int id, String input, String output, int taskId) {
        this.error = error;
        this.id = id;
        this.input = input;
        this.output = output;
        this.taskId = taskId;
    }
}
