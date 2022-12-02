package com.globant.tests.web;

import com.globant.configuration.web.Driver;
import com.globant.pages.web.HomePage;
import com.globant.reporting.Reporter;
import org.testng.annotations.*;
import static java.lang.String.format;

/***
 * BaseTest Class
 * This class is used to store the methods that will be used before and after the test
 */
public class BaseTest {
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
