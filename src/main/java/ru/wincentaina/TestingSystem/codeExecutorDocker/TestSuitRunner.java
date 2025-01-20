package ru.wincentaina.TestingSystem.codeExecutorDocker;

import java.util.ArrayList;
import java.util.List;

public class TestSuitRunner {
    private List<Test> tests;
    private Class<?> executableClass;

    public TestSuitRunner(List<Test> tests, Class<?> executableClass) {
        this.tests = tests;
        this.executableClass = executableClass;
    }

    public List<TestResult> runSuit() {
        List<TestResult> results = new ArrayList<>();
        for (Test test: tests) {
            RunTest runner = new RunTest(test, executableClass);
            TestResult result = runner.run();
            if (!result.getStatus().equals("ok")) {
                // Если тест не прошел, выбрасываем исключение с подробным сообщением
                throw new RuntimeException("Ошибка теста: " + result.getStatus());
            }
            results.add(result);
        }
        return results;
    }
}