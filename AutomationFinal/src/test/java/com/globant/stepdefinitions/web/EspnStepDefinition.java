package com.globant.stepdefinitions.web;

import com.globant.configuration.web.Driver;
import com.globant.pages.web.HomePage;
import com.globant.pages.web.WatchPage;
import com.globant.reporting.Reporter;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class EspnStepDefinition {

    @Given("ESPN website is loaded")
    public void espn_is_loaded() {
        Reporter.info("");
        Driver driver = WebDriverReference.getDriver();
        HomePage home = WebDriverReference.getHome();

        // Checking the drivers have been properly initialized
        Assert.assertNotNull(driver);
        Assert.assertNotNull(home);
    }

    @When("click Sign Up button")
    public void click_sign_up_button() {
        HomePage home = WebDriverReference.getHome();
        Assert.assertNotNull(home);

        home.hoverOverUsrIcon();
        home.clickContainerLogIn();
        home.goToLogInIframe();
        Assert.assertTrue(home.containsEspnPlusLogo());
        Assert.assertTrue(home.containsSignUp());
        Assert.assertTrue(home.containsLogIn());
        home.clickSignUp();
    }

    @Then("Sign Up with {string} {string} {string} and {string}")
    public void sign_up_with_and(String firstName, String lastName, String email, String password) {
        HomePage home = WebDriverReference.getHome();
        Assert.assertNotNull(home);

        Assert.assertTrue(home.firstNameExists());
        Assert.assertTrue(home.lastNameExists());
        Assert.assertTrue(home.emailExists());
        Assert.assertTrue(home.passwordExists());
        Assert.assertTrue(home.submitSubmitExists());
        Assert.assertTrue(home.checkSignUpCloseButton());

        home.inputFirstName(firstName);
        home.inputLastName(lastName);
        home.inputEmail(email);
        home.inputPassword(password);
        home.clickSubmitSignUpButton();
    }

    @When("click Watch button")
    public void click_watch_button() {
        HomePage home = WebDriverReference.getHome();
        Assert.assertNotNull(home);

        home.refreshPage();
        home.clickWatchButton();
    }

    @Then("Check carousel have title and description")
    public void check_carousel_have_title_and_description() {
        Driver driver = WebDriverReference.getDriver();
        WatchPage watch = new WatchPage(driver.getDriver());

        Assert.assertTrue(watch.containsTennisCarousel());
        watch.clickSecondCarouselItem();

        // Waiting to load providers
        watch.waitFor();

        Assert.assertTrue(watch.isCloseButtonDisplayed());
        watch.clickCloseButton();
    }

    @Then("go back to main screen")
    public void go_back_to_main_screen() {
        HomePage home = WebDriverReference.getHome();
        home.goHomepage();
    }

    @When("users logs in with {string} and {string}")
    public void users_logs_in_with_and(String email, String password) {
        HomePage home = WebDriverReference.getHome();
        Assert.assertNotNull(home);

        // Logging in
        home.loginMethods(email, password);
        home.refreshPage();
    }

    @Then("hover over user icon and confirm {string}")
    public void hover_over_user_icon_and_confirm(String firstName) {
        HomePage home = WebDriverReference.getHome();
        Assert.assertNotNull(home);

        home.hoverOverUsrIcon();
        Assert.assertTrue(home.containsAccountName());
        Assert.assertTrue(home.checkAccountName(firstName));
    }

}
