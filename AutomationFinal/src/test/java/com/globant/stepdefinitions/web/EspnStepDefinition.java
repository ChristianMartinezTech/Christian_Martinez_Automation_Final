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
        Driver driver = WebDriverReference.getDriver();
        HomePage home = WebDriverReference.getHome();

        Reporter.info("Confirming website is loaded");
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

        Reporter.info("Confirming Espn logo and buttons");
        Assert.assertTrue(home.containsEspnPlusLogo());
        Assert.assertTrue(home.containsSignUp());
        Assert.assertTrue(home.containsLogIn());

        Reporter.info("Clicking Sign Up");
        home.clickSignUp();
    }

    @Then("Sign Up with {string} {string} {string} and {string}")
    public void sign_up_with_and(String firstName, String lastName, String email, String password) {
        HomePage home = WebDriverReference.getHome();
        Assert.assertNotNull(home);

        Reporter.info("Confirming Sign Up elements");
        Assert.assertTrue(home.firstNameExists());
        Assert.assertTrue(home.lastNameExists());
        Assert.assertTrue(home.emailExists());
        Assert.assertTrue(home.passwordExists());
        Assert.assertTrue(home.submitSubmitExists());
        Assert.assertTrue(home.checkSignUpCloseButton());

        Reporter.info("Input Sign Up information");
        home.inputFirstName(firstName);
        home.inputLastName(lastName);
        home.inputSignUpEmail(email);
        home.inputSignUpPassword(password);

        Reporter.info("Clicking Sign Up");
        home.clickSubmitSignUpButton();
    }

    @When("click Watch button")
    public void click_watch_button() {
        HomePage home = WebDriverReference.getHome();
        home.goHomepage();

        WebDriverReference.setHome(home);
        Reporter.info("Click Watch button");
        home.clickWatchButton();
    }

    @Then("Check carousel have title and description")
    public void check_carousel_have_title_and_description() {
        Driver driver = WebDriverReference.getDriver();
        WatchPage watch = new WatchPage(driver.getDriver());

        Reporter.info("Assert tennis carousel exists");
        Assert.assertTrue(watch.containsTennisCarousel());

        Reporter.info("clicking tennis carousel item");
        watch.clickSecondCarouselItem();

        Assert.assertTrue(watch.isCloseButtonDisplayed());
        Reporter.info("Closing Carousel");
        watch.clickCloseButton();
    }

    @Then("go back to main screen")
    public void go_back_to_main_screen() {
        HomePage home = WebDriverReference.getHome();
        Reporter.info("Going back to homepage");
        home.goHomepage();

        WebDriverReference.setHome(home);
    }

    @When("users logs in with {string} and {string}")
    public void users_logs_in_with_and(String email, String password) {
        HomePage home = WebDriverReference.getHome();
        Assert.assertNotNull(home);

        Reporter.info("Login In");
        home.loginMethods(email, password);
        home.refreshPage();
    }

    @Then("hover over user icon and confirm {string}")
    public void hover_over_user_icon_and_confirm(String firstName) {
        HomePage home = WebDriverReference.getHome();
        Assert.assertNotNull(home);

        home.waitFor();
        home.hoverOverUsrIcon();

        Reporter.info("Checking Account Name Exists");
        Assert.assertTrue(home.containsAccountName());

        Reporter.info("Checking Account Name is correct");
        // Confirm name is "Chris"
    }

    @Then("Log out")
    public void log_out() {
        HomePage home = WebDriverReference.getHome();
        Assert.assertNotNull(home);

        Reporter.info("Logging Out");
        home.clickLogOutButton();
    }

    @Then("hover over user icon and confirm {string} is not there")
    public void hover_over_user_icon_and_confirm_is_not_there(String string) {
        HomePage home = WebDriverReference.getHome();
        Assert.assertNotNull(home);

        home.waitFor();
        home.hoverOverUsrIcon();

        Reporter.info("Checking Account Name Doesn't Exists");
        Assert.assertFalse(home.containsAccountName());
    }
}
