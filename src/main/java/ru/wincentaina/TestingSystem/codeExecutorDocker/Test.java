package ru.wincentaina.TestingSystem.codeExecutorDocker;

public class Test {
    private int testId;
    private String input;
    private String output;
    private int timeoutMs;

    public Test(int testId, String input, String output, int timeoutMs) {
        this.testId = testId;
        this.input = input;
        this.output = output;
        this.timeoutMs = timeoutMs;
    }

    public String getInput() {
        return input;
    }

    public String getOutput() {
        return output;
    }

    public int getTimeoutMs() {
        return timeoutMs;
    }

    public int getTestId() {
        return testId;
    }
}
