package ru.wincentaina.TestingSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.wincentaina.TestingSystem.docker.DockerService;

@SpringBootApplication
public class TestingSystemApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TestingSystemApplication.class, args);
	}

}
