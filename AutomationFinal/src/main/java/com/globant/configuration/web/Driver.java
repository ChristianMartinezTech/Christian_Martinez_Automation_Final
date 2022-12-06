package com.globant.configuration.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.globant.reporting.Reporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.String.format;

/***
 * Class: Driver
 * This class determines whether the browser is Chrome or Firefox and initializes the driver
 */
public class Driver {
    private WebDriver driver;

    /***
     * Driver Constructor.
     */
    public Driver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    /***
     *  Method that returns a reference to the WebDriver initialized.
     * @return WebDriver for the subclasses to reference the driver intialized
     */
    public WebDriver getDriver() {
        return driver;
    }
}

