package com.example;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import xfnt.LoggerFactory;
import xfnt.LoggerLevel;

import static com.example.rest.LoanController.readLoanUpdate;
import static java.lang.String.format;
import static xfnt.LoggerFactory.step;

public class TestBase {

    @BeforeClass
    public void beforeClass() {
        LoggerFactory.createLogger();
        step("Загружаем переменные окружения");
        String loggerLevel = System.getenv("logger.level");
        LoggerFactory.changeLoggerLevel(LoggerLevel.fromName(loggerLevel));
        step(format("Уровень логирования: %s", loggerLevel));
        step("Создаем займ");
        step("Вычитываем loanUpdateMessage");
        readLoanUpdate("{\"requestBody\":\"19823954\"}");
    }

    @AfterMethod
    public void afterMethod() {
        step("Finished test");
    }
}
