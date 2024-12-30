package ru.wincentaina.TestingSystem.model;

public class Result {
    private String status;
    private Integer runtimeMs;
    private Integer testsPassed;
    private Integer testsTotalAmount;

    public Result(String status, Integer runtimeMs, Integer testsPassed, Integer testsAmount) {
        this.status = status;
        this.runtimeMs = runtimeMs;
        this.testsPassed = testsPassed;
        this.testsTotalAmount = testsAmount;
    }

    public String getStatus() {
        return status;
    }

    public Integer getRuntimeMs() {
        return runtimeMs;
    }

    public Integer getTestsPassed() {
        return testsPassed;
    }

    public Integer getTestsTotalAmount() {
        return testsTotalAmount;
    }

}
