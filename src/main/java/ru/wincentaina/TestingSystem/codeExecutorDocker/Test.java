package ru.wincentaina.TestingSystem.codeExecutorDocker;

public class Test {
    private int testId;
    private String input;
    private int timeoutMs;

    public Test(){}

    public Test(int testId, String input, int timeoutMs) {
        this.testId = testId;
        this.input = input;
        this.timeoutMs = timeoutMs;
    }

    // Геттеры и сеттеры
    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public int getTimeoutMs() {
        return timeoutMs;
    }

    public void setTimeoutMs(int timeoutMs) {
        this.timeoutMs = timeoutMs;
    }

    @Override
    public String toString() {
        return "Test{" +
                "testId=" + testId +
                ", input='" + input + '\'' +
                ", timeoutMs=" + timeoutMs +
                '}';
    }
}
