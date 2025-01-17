package ru.wincentaina.TestingSystem.storage.postgres;

import ru.wincentaina.TestingSystem.model.Task;

public class Tasks {

    public static Task taskById(int id) {
        return new Task(2, "my description", Tests.testsByTaskId());
    }
}
