package ru.wincentaina.TestingSystem.storage.postgres;

import ru.wincentaina.TestingSystem.model.Test;

import java.util.ArrayList;
import java.util.List;

public class Tests {

    public static List<Test> testsByTaskId() {
        List<Test> tests = new ArrayList<>();
        tests.add(new Test(3, 2, "inp3", "out3", 100));
        tests.add(new Test(6, 2, "inp6", "out6", 20));
        return tests;
    }
}
