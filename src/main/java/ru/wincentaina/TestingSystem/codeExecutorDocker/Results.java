package ru.wincentaina.TestingSystem.codeExecutorDocker;

import java.util.List;

public class Results {
    private String error;
    private List<TestResult> results;

    public Results(String error, List<TestResult> results) {
        this.error = error;
        this.results = results;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<TestResult> getResults() {
        return results;
    }

    public void setResults(List<TestResult> results) {
        this.results = results;
    }
}
