package ru.wincentaina.TestingSystem.codeExecutorDocker;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
        DynamicCompiler dk = new DynamicCompiler();
        dk.compile();
        Class<?> userCompiledClass = dk.getDynamicClass();

        // парсим прешедший json
        File inFile = new File("/app/input_data/inp.json");

        ObjectMapper objectMapper = new ObjectMapper();

        Task task = null;
        try {
            task = objectMapper.readValue(inFile, Task.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (task != null) {
            try {
                TestSuitRunner suitRunner = new TestSuitRunner(task, userCompiledClass);
                List<TestResult> results = suitRunner.runSuit();
                objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
                File outFile = new File("/app/output_data/out.json");
                try {
                    objectMapper.writeValue(outFile, results);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("проблема с загрузкой тестов");
        }

    }
}
