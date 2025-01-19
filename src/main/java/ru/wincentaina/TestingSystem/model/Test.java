package ru.wincentaina.TestingSystem.model;

import jakarta.persistence.*;

@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false) // Внешний ключ task_id
    private Task task;

    private String input;
    private String output;
    private int timeoutMs;

    public Test() {}

    public Test(int testId, Task task, String input, String output, int timeoutMs) {
        this.id = testId;
        this.task = task;
        this.input = input;
        this.output = output;
        this.timeoutMs = timeoutMs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public int getTimeoutMs() {
        return timeoutMs;
    }

    public void setTimeoutMs(int timeoutMs) {
        this.timeoutMs = timeoutMs;
    }
}