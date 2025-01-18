package ru.wincentaina.TestingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.wincentaina.TestingSystem.model.Test;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
    public List<Test> findByTaskId(int taskId);
}
