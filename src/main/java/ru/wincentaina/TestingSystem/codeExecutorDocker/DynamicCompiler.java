package ru.wincentaina.TestingSystem.codeExecutorDocker;

import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class DynamicCompiler {
    private Class<?> dynamicClass;

    public void setDynamicClass(Class<?> dynamicClass) {
        this.dynamicClass = dynamicClass;
    }

    public Class<?> getDynamicClass() {
        return dynamicClass;
    }

    public void compile() throws ClassNotFoundException, IOException {
        File sourceFile = new File("Main.java");

        // Компиляция кода
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        // Поток для захвата ошибок компиляции
        ByteArrayOutputStream errorOutput = new ByteArrayOutputStream();
        PrintStream errorStream = new PrintStream(errorOutput);

        // Запуск компилятора, передавая потоки
        int compilationResult = compiler.run(
                System.in,                   // Ввод
                System.out,                  // Вывод
                errorStream,                 // Поток ошибок
                sourceFile.getPath()         // Путь к исходному файлу
        );

        // Если компиляция не удалась, выбрасываем исключение с ошибками компиляции
        if (compilationResult != 0) {
            String errors = errorOutput.toString();
            throw new CompilationException("Ошибка компиляции: " + errors);
        }

        // Создание временной директории для хранения скомпилированного класса
        File tempDir = new File("temp");
        if (!tempDir.exists()) {
            tempDir.mkdir();
        }

        // Загрузка скомпилированного класса
        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{tempDir.toURI().toURL()});
        Class<?> clazz = Class.forName("Main", true, classLoader);
        if (clazz == null) {
            throw new LoadException("У исполняемого класса должно быть имя Main");
        }
        setDynamicClass(clazz);
    }
}