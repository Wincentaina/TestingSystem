package ru.wincentaina.TestingSystem.codeExecutorDocker;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class MainTestingTool {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        DynamicCompiler dk = new DynamicCompiler();
        dk.compile();
        Class<?> userCompiledClass = dk.getDynamicClass();
        Method mainMethod = userCompiledClass.getMethod("main", String[].class);
        mainMethod.invoke(null, (Object) new String[]{});
    }
}
