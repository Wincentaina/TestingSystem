package ru.wincentaina.TestingSystem.codeExecutorDocker;

public class Test {
    private int id;
    private String input;
    private int timeoutMs;

    public Test(){}

    public Test(int id, String input, int timeoutMs) {
        this.id = id;
        this.input = input;
        this.timeoutMs = timeoutMs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
