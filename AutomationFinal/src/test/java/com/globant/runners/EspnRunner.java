package com.globant.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Espn.feature",
        glue = "com.globant.stepdefinitions.web",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true
)

public class EspnRunner extends AbstractTestNGCucumberTests{
}

