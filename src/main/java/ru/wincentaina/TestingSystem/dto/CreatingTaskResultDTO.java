package ru.wincentaina.TestingSystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreatingTaskResultDTO {
    @JsonProperty("error")
    private String error;
    @JsonProperty("id")
    private int id;
    @JsonProperty("description")
    private String description;

    public CreatingTaskResultDTO(String error, int id, String description) {
        this.error = error;
        this.id = id;
        this.description = description;
    }
}
