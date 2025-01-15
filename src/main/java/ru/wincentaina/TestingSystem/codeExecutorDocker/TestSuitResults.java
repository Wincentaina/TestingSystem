package ru.wincentaina.TestingSystem.codeExecutorDocker;

public class TestSuitResults {
    private int failedTests;
    private int passedTests;
    private int allTests;

    public TestSuitResults() {
        this.failedTests = 0;
        this.passedTests = 0;
        this.allTests = 0;
    }

    public void fail() {
        this.failedTests += 1;
        this.allTests += 1;
    }

    public void pass() {
        this.passedTests += 1;
        this.allTests += 1;
    }

    public int getFailedTests() {
        return failedTests;
    }

    public int getPassedTests() {
        return passedTests;
    }

    public void setPassedTests(int passedTests) {
        this.passedTests = passedTests;
    }

    public void setFailedTests(int failedTests) {
        this.failedTests = failedTests;
    }

    public int getAllTests() {
        return allTests;
    }

    public void setAllTests(int allTests) {
        this.allTests = allTests;
    }
}
