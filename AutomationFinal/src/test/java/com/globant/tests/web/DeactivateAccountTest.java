package com.globant.tests.web;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/***
 * Class: DeactivateAccountTest
 * Test the user deactivation account
 */
public class DeactivateAccountTest extends BaseTest{

    /***
     * Method to deactivate the Account
     * @param email email to log in
     * @param password password to log in
     * @param url HomePage url
     */
    @Parameters({"email", "password", "url"})
    @Test
    public void DeactivateAccount(String email, String password, String url) {
        // Logging In
        home.loginMethods(email, password);

        // Deactivate Account
        home.hoverOverUsrIcon();
        home.clickEspnProfile();
        home.goToLogInIframe();
        home.moveToDelete();
        home.clickDeleteAccount();
        home.clickDeleteAccountSubmit();
        home.goHomepage(url);
    }
}
