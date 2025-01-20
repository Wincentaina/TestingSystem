package ru.wincentaina.TestingSystem.codeExecutorDocker;

// Кастомное исключение для ошибки компиляции
public class CompilationException extends RuntimeException {
    public CompilationException(String message) {
        super(message);
    }
}
