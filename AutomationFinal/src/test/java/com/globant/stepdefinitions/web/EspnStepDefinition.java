package com.globant.stepdefinitions.web;

import com.globant.configuration.web.Driver;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class EspnStepDefinition {

    @Given("ESPN website is loaded")
    public void espn_is_loaded() {
        Driver driverReference = WebReference.getDriver();
        Driver homeReference = WebReference.getDriver();

        Assert.assertNotNull(driverReference);
        Assert.assertNotNull(homeReference);
    }

    @When("click Sign Up button")
    public void click_sign_up_button() {
        
    }

    @Then("Sign Up with {string} {string} {string} and {string}")
    public void sign_up_with_and(String firstName, String lastName, String email, String password) {
    }

    @Then("user is logged in")
    public void user_is_logged_in() {
    }

    @When("click Watch button")
    public void click_watch_button() {
    }

    @Then("Check carousel have title and description")
    public void check_carousel_have_title_and_description() {
    }

    @Then("go back to main screen")
    public void go_back_to_main_screen() {
    }

    @When("hover over user icon")
    public void hover_over_user_icon() {
    }

    @Then("confirm {string}")
    public void confirm(String firstName) {
    }
}
