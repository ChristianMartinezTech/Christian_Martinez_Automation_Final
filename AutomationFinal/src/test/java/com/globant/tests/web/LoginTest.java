package com.globant.tests.web;

import org.testng.Assert;
import org.testng.annotations.*;

/***
 * Class: LoginTest
 * Tests the login automation
 */
public class LoginTest extends BaseTest{

    /***
     * Method to test the login automation
     * @param url HomePage url
     * @param email email to Login
     * @param password password to Login
     */
    @Parameters({"url", "email", "password"})
    @Test
    public void LogIn(String url, String email, String password){
        // Login in
        home.hoverOverUsrIcon();
        home.clickContainerLogIn();
        home.goToLogInIframe();
        Assert.assertTrue(home.containsEspnPlusLogo());
        Assert.assertTrue(home.containsSignUp());
        Assert.assertTrue(home.containsLogIn());
        home.clickEmailLogIn();
        home.inputEmail(email);
        home.clickPasswordLogIn();
        home.inputPassword(password);
        home.logInButton();

        // Checking Carousel
        home.clickWatchButton();
        Assert.assertTrue(home.containsTennisCarousel());
        home.clickSecondCarouselItem();
        home.clickCloseButton();

        // Checking that the logging was successful
        home.goHomepage(url);
        home.hoverOverUsrIcon();
        Assert.assertTrue(home.checkAccountName("Chris"));
    }
}
