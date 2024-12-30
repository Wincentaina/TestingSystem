package ru.wincentaina.TestingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.wincentaina.TestingSystem.model.Result;
import ru.wincentaina.TestingSystem.service.ResultService;

@RestController
@RequestMapping("/api/v1/result")
public class ResultController {

    private ResultService service;

    @Autowired
    public ResultController(ResultService service) {
        this.service = service;
    }

    @GetMapping
    public Result result() {
        return service.result();
    }
}
