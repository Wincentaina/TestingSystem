package ru.wincentaina.TestingSystem.service.Impl;

import org.springframework.stereotype.Service;
import ru.wincentaina.TestingSystem.model.Result;
import ru.wincentaina.TestingSystem.service.ResultService;

@Service
public class InMemoryResultService implements ResultService {

    @Override
    public Result result() {
        return new Result("ok", 100, 5, 10);
    }
}
