package com.globant.stepdefinitions.web;

import com.globant.configuration.web.Driver;
import com.globant.pages.web.HomePage;
import com.globant.reporting.Reporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import static java.lang.String.format;

/***
 * BaseTest Class
 * This class is used to store the methods that will be used before and after the test
 */
public class Hook {
    private Driver driver;
    protected HomePage home;

    /***
     * SetUp methods executes multiple operations before the creation of the new session
     */
    @Before
    public void setUp(){
        WebDriverReference WebDriverReference = new WebDriverReference();

        driver = new Driver();
        WebDriverReference.setDriver(driver);

        Reporter.info("Deleting cookies");
        driver.getDriver().manage().deleteAllCookies();

        Reporter.info(format("Navigating to %s", "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud"));
        driver.getDriver().get("https://www.espnqa.com/?src=com&_adblock=true&espn=cloud");
        driver.getDriver().manage().window().maximize();

        home = new HomePage(driver.getDriver());
        WebDriverReference.setHome(home);
    }

    /***
     * Ends the session
     */
    @After
    public void endSession(){
        driver.getDriver().quit();
    }
}
