package ru.wincentaina.TestingSystem.codeExecutorDocker;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

// TODO: прописать команду в контейнере echo "$USER_CODE" | base64 -d > UserCode.java
// компилирует код
public class DynamicCompiler {
    private Class<?> dynamicClass;

    public void setDynamicClass(Class<?> dynamicClass) {
        this.dynamicClass = dynamicClass;
    }

    public Class<?> getDynamicClass() {
        return dynamicClass;
    }

    public void compile() throws ClassNotFoundException, MalformedURLException {
        File sourceFile = new File("./src/main/java/ru/wincentaina/TestingSystem/codeExecutorDocker/Main.java");
        // Компиляция кода
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int compilationResult = compiler.run(null, null, null, sourceFile.getPath());
        if (compilationResult != 0) {
            throw new RuntimeException("Ошибка компиляции");
        }

        // Создание временной директории для хранения скомпилированного класса
        File tempDir = new File("temp");
        if (!tempDir.exists()) {
            tempDir.mkdir();
        }

        // Загрузка скомпилированного класса
        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{tempDir.toURI().toURL()});
        Class<?> clazz = Class.forName("Main", true, classLoader);
        setDynamicClass(clazz);
    }

}
