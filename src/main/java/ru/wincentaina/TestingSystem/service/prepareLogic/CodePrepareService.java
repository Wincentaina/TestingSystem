package ru.wincentaina.TestingSystem.service.prepareLogic;

import java.util.List;

public class CodePrepareService {
    private List<TestCase> testSuit;
    private String code;
    private String lang;

    public CodePrepareService(List<TestCase> testSuit, String code, String lang) {
        this.testSuit = testSuit;
        this.code = code;
        this.lang = lang;
    }

    public List<TestCase> getTestSuit() {
        return testSuit;
    }



}
