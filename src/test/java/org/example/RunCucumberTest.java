package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.StepDefinitions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

//Конфигурация для запуска сценариев
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/org/example")

public class RunCucumberTest {
    @AfterClass
    public static void finalizeResources() {
        StepDefinitions.webDriver.close();
    }
}