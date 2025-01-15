package ru.wincentaina.TestingSystem.codeExecutorDocker;

import java.util.List;

public class TestSuitRunner {
    private Task task;
    private List<Test> suit;
    private Class<?> executableClass;

    public TestSuitRunner(Task task, List<Test> suit, Class<?> executableClass) {
        this.task = task;
        this.suit = suit;
        this.executableClass = executableClass;
    }

    public TestSuitResults runSuit() {
        TestSuitResults results = new TestSuitResults();
        for (Test test: suit) {
            RunTest runner = new RunTest(test, executableClass);
            boolean ok = runner.run();
            if (ok) {
                results.pass();
            } else {
                results.fail();
            }
        }
        return results;
    }
}
