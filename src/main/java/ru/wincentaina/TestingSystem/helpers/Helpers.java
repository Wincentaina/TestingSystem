package ru.wincentaina.TestingSystem.helpers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helpers {
    public static boolean createDir(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            boolean created = dir.mkdirs();  // создает директорию, если она не существует
            if (!created) {
                return false;
            }
        }
        return true;
    }

    public static boolean deleteDirectory(String path) {
        File dir = new File(path);
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    deleteDirectory(file.getPath());
                }
            }
        }
        if (dir.delete()) {
            return true;
        } else {
           return false;
        }
    }

    public static void createFile(String pathToFile) {
        Path path = Paths.get(pathToFile);
        try {
            // Создание файла, если он не существует
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String pathToFile, String content) {
        Path path = Paths.get(pathToFile);
        try {
            Files.write(path, content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
