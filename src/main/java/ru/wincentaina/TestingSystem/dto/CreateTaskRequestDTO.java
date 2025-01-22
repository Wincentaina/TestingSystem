package ru.wincentaina.TestingSystem.dto;

public class CreateTaskRequestDTO {
    private String description;

    public CreateTaskRequestDTO(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
