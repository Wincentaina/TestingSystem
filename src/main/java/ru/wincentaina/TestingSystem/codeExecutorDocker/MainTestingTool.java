package ru.wincentaina.TestingSystem.codeExecutorDocker;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class MainTestingTool {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        DynamicCompiler dk = new DynamicCompiler();
        dk.compile();
        Class<?> userCompiledClass = dk.getDynamicClass();

        // MOCK DATA
        Task task = new Task(1, "firstTask");
        List<Test> suit = new ArrayList<>();

        Test test1 = new Test(2, "inp", "inp", 100);
        suit.add(test1);
        Test test2 = new Test(4, "inp", "out", 100);
        suit.add(test2);
        Test test3 = new Test(7, "inp2", "inp", 100);
        suit.add(test3);
        Test test4 = new Test(7, "inp", "inp", 100);
        suit.add(test4);
        // ----

        TestSuitRunner suitRunner = new TestSuitRunner(task, suit, userCompiledClass);
        TestSuitResults results = suitRunner.runSuit();
        System.out.println(results.getAllTests() + " / " + results.getPassedTests() + " / " + results.getFailedTests());

        File compiledFile = new File("./src/main/java/ru/wincentaina/TestingSystem/codeExecutorDocker/Main.class");
        compiledFile.delete();
    }
}
