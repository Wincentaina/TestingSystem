package ru.wincentaina.TestingSystem.helpers;

public class JsonSanitizer {
    public static String sanitizeJsonString(String input) {
        // Убираем лишние экранирующие символы
        return input
                .replace("\\\\\"", "\"")  // Заменяем \\\" на "
                .replace("\\\\n", "\n")  // Заменяем \\n на перенос строки
                .replace("\\\\t", "\t")  // Заменяем \\t на табуляцию
                .replace("\\\\", "\\");  // Убираем лишние слэши
    }
}
