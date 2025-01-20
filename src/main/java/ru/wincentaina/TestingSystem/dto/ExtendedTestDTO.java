package ru.wincentaina.TestingSystem.dto;

import java.util.List;

public class ExtendedTestDTO {
    private String error;
    private List<TestDTO> results;

    public ExtendedTestDTO() {
    }

    public ExtendedTestDTO(String error, List<TestDTO> results) {
        this.error = error;
        this.results = results;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<TestDTO> getResults() {
        return results;
    }

    public void setResults(List<TestDTO> results) {
        this.results = results;
    }
}
