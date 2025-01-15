package ru.wincentaina.TestingSystem.codeExecutorDocker;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTest {
    private Test test;
    private Class<?> executableClass;

    public RunTest(Test test, Class<?> executableClass) {
        this.test = test;
        this.executableClass = executableClass;
    }

    private static String removeLastNewline(String input) {
        return input.replaceFirst("\\n$", "");
    }

    public TestResult run() {
        ByteArrayInputStream testInput = new ByteArrayInputStream(test.getInput().getBytes());
        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        InputStream originalIn = System.in;
        try {
            System.setIn(testInput);
            System.setOut(new PrintStream(testOutput));

            Method mainMethod = executableClass.getMethod("main", String[].class);
            mainMethod.invoke(null, (Object) new String[]{});
        } catch (InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        // TODO: добавить обработку ошибок и подсчет timeout
        return new TestResult("ok", removeLastNewline(testOutput.toString()), 100);
    }
}
