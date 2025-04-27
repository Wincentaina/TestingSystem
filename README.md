# TestingSystem

**TestingSystem** — это серверное приложение на базе Spring Boot для создания, хранения и автоматической проверки задач с тестами, а также для безопасного выполнения пользовательского кода в изолированной среде (Docker).

## Возможности

- Создание и удаление задач через REST API
- Добавление и удаление тестов к задачам
- Выполнение пользовательского кода с автоматической проверкой на тестах
- Использование Docker для изоляции выполнения кода
- Хранение данных в PostgreSQL

## Быстрый старт

### Требования

- Java 17+
- Maven
- Docker
- PostgreSQL

### Сборка и запуск

1. Склонируйте репозиторий:
   ```bash
   git clone <ваш-репозиторий>
   cd TestingSystem
   ```

2. Установите зависимости и соберите проект:
   ```bash
   mvn clean install
   ```

3. Настройте подключение к базе данных в `src/main/resources/application.yaml`:
   ```yaml
   spring:
     datasource:
       url: jdbc:postgresql://localhost:5432/postgres
       username: postgres
       password: mysecretpassword
   ```

4. Запустите приложение:
   ```bash
   mvn spring-boot:run
   ```

### Использование Docker для выполнения кода

В проекте есть Dockerfile для изоляции выполнения пользовательского кода:

- Путь: `src/main/java/ru/wincentaina/TestingSystem/codeExecutorDocker/Dockerfile`
- Скрипт запуска: `start.sh` (ожидает переменную среды `USER_CODE` с кодом пользователя)

Пример запуска контейнера:
```bash
docker build -t code-executor ./src/main/java/ru/wincentaina/TestingSystem/codeExecutorDocker
docker run --rm -e USER_CODE="$(cat Main.java)" code-executor
```

## API

### Задачи

- `POST /api/v1/task/create` — создать задачу
- `DELETE /api/v1/task/delete?id={id}` — удалить задачу

### Тесты

- `POST /api/v1/test/create` — добавить тест к задаче
- `DELETE /api/v1/test/delete?id={id}` — удалить тест

### Выполнение кода

- `POST /api/v1/execute` — выполнить код пользователя (ожидает JSON с кодом и параметрами)
