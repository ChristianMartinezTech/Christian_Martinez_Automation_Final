package com.globant.tests.web;

import org.testng.Assert;
import org.testng.annotations.*;

/***
 * Class: LogOutTest
 * Tests the logout automation
 */
public class LogOutTest extends BaseTest{

    /***
     * Method to test the log-out automation
     * @param email email to login
     * @param password password to login
     */
    @Parameters({"email", "password"})
    @Test
    public void LogOut(String email, String password){
        // Logging In
        home.loginMethods(email, password);

        // Logging out
        home.refreshPage();
        home.hoverOverUsrIcon();
        home.clickLogOutButton();

        // Checking there's no Account Name
        home.refreshPage();
        home.hoverOverUsrIcon();
        Assert.assertFalse(home.containsAccountName());
    }
}
