package com.globant.stepdefinitions.mobile;

import com.globant.stepdefinitions.web.WebDriverReference;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.internal.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.globant.pages.mobile.TutorialScreen;
import com.globant.configuration.mobile.ConfigCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class Hook {

    protected TutorialScreen tutorialScreen;
    public static AndroidDriver<AndroidElement> driver;
    public Logger log = Logger.getLogger(Hook.class);

    public void setUpStartApp() {
        tutorialScreen = new TutorialScreen(getDriver());
        MobileDriverReference.setTutorialScreen(tutorialScreen);
    }

    /**
     * SetUp before to run suite of test.
     * @author Arley.Bolivar
     */
    @Before
    public void environmentSetUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ConfigCapabilities.deviceSetUp(capabilities);
        ConfigCapabilities.applicationSetUp(capabilities);
        try {
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            MobileDriverReference.setDriver(driver);
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }
        setUpStartApp();
    }

    /**
     * Close the application after completing the test.
     * @author Arley.Bolivar
     */
    @After
    public void mobileApplicationEnd() {
        driver.quit();
    }

    /**
     * return the driver.
     * @return driver
     * @author Arley.Bolivar
     */
    public AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }
}
