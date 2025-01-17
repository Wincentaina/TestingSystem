#!/bin/bash

# Проверяем наличие переменной USER_CODE
if [ -z "$USER_CODE" ]; then
  echo "Ошибка: Переменная среды USER_CODE не установлена!"
  exit 1
fi

# Записываем код пользователя в Main.java
echo "$USER_CODE" > UserClass.java

javac -cp .:/app/libs/jackson-core-2.18.2.jar:/app/libs/jackson-databind-2.18.2.jar:/app/libs/jackson-annotations-2.18.2.jar -d . *.java

# Проверяем, был ли успешный компиляции
if [ $? -ne 0 ]; then
  echo "Ошибка компиляции!"
  exit 1
fi

java -cp /app/out:.:/app/libs/jackson-core-2.18.2.jar:/app/libs/jackson-databind-2.18.2.jar:/app/libs/jackson-annotations-2.18.2.jar ru.wincentaina.TestingSystem.codeExecutorDocker.Main