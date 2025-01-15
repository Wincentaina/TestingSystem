package ru.wincentaina.TestingSystem.helpers;

import java.io.File;

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

}
