#!/bin/bash

if [ -z "$USER_CODE" ]; then
  echo "Ошибка: Переменная среды $USER_CODE не установлена!"
  exit 1
fi

echo "$USER_CODE" > Main.java

javac MainTestingTool.java

# Проверяем, успешно ли скомпилировался файл
if [ $? -ne 0 ]; then
  echo "Ошибка: Компиляция не удалась!"
  exit 1
fi

if [ ! -f "/app/TestingSystem.jar" ]; then
  echo "Ошибка: файл TestingSystem.jar не найден!"
  exit 1
fi

# Запускаем .jar файл
java -jar /app/TestingSystem.jar