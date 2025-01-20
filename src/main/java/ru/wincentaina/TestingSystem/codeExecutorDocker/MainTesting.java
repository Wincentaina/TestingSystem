package ru.wincentaina.TestingSystem.codeExecutorDocker;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public class MainTesting {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
        File outFile = new File("/app/output_data/out.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        DynamicCompiler dk = new DynamicCompiler();
        try {
            dk.compile();
        } catch (CompilationException | LoadException | IOException e) {
            // Ошибка компиляции будет записана в out.json
            Results results = new Results(e.getMessage(), null);
            try {
                objectMapper.writeValue(outFile, results);
            } catch (IOException err) {
                err.printStackTrace();
            }
            return; // Выход, так как произошла ошибка
        }

        // Парсим входные тесты, если компиляция прошла успешно
        Class<?> userCompiledClass = dk.getDynamicClass();

        File inFile = new File("/app/input_data/inp.json");

        List<Test> tests = null;
        try {
            tests = objectMapper.readValue(inFile, new TypeReference<List<Test>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Выполняем тесты, если они есть
        if (tests != null) {
            try {
                TestSuitRunner suitRunner = new TestSuitRunner(tests, userCompiledClass);
                List<TestResult> results = suitRunner.runSuit();
                Results resultsToOut = new Results("ok", results);
                try {
                    objectMapper.writeValue(outFile, resultsToOut);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (RuntimeException e) {
                Results results = new Results(e.getMessage(), null);
                try {
                    objectMapper.writeValue(outFile, results);
                } catch (IOException err) {
                    err.printStackTrace();
                }
            }
        } else {
            Results results = new Results("проблема с загрузкой тестов", null);
            try {
                objectMapper.writeValue(outFile, results);
            } catch (IOException err) {
                err.printStackTrace();
            }
        }
    }
}