package com.globant.runners.web;


import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.globant.configuration.web.Driver;
import com.globant.pages.web.HomePage;
import com.globant.reporting.Reporter;
import static java.lang.String.format;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/web/SignUp.feature",
        glue = "com.globant.stepdefinitions.web",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true
)

public class SignUp extends AbstractTestNGCucumberTests{
    private Driver driver;
    protected HomePage home;

    /***
     * SetUp methods executes multiple operations before the creation of the new session
     * @param browser browser name (either Chrome or Firefox)
     * @param url Homepage URL
     */
    @Parameters({"browser", "url"})
    @BeforeTest
    public void setUp(String browser, String url){
        driver = new Driver(browser);
        Reporter.info("Deleting cookies");
        driver.getDriver().manage().deleteAllCookies();

        Reporter.info(format("Navigating to %s", url));
        driver.getDriver().get(url);
        driver.getDriver().manage().window().maximize();

        home = new HomePage(driver.getDriver());
    }

    /***
     * Ends the session
     */
    @AfterTest
    public void endSession(){
        driver.getDriver().quit();
    }

}
