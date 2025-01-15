package ru.wincentaina.TestingSystem.codeExecutorDocker;

import java.util.ArrayList;
import java.util.List;

public class TestSuitRunner {
    private Task task;
    private Class<?> executableClass;

    public TestSuitRunner(Task task, Class<?> executableClass) {
        this.task = task;
        this.executableClass = executableClass;
    }

    public List<TestResult> runSuit() {
        List<TestResult> results = new ArrayList<>();
        for (Test test: task.getTests()) {
            RunTest runner = new RunTest(test, executableClass);
            TestResult result = runner.run();
            results.add(result);
        }
        return results;
    }
}
