package com.globant.stepdefinitions.mobile;

import com.globant.reporting.Reporter;
import com.globant.pages.mobile.MapScreen;
import com.globant.pages.mobile.TutorialScreen;
import com.globant.pages.mobile.PrivacyScreen;
import com.globant.pages.mobile.DashBoardScreen;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class DisneylandStepDefinition {

    @Given("Disneyland app is loaded")
    public void disneyland_app_is_loaded() {
        Reporter.info("Opening App");

        TutorialScreen tutorialScreen = MobileDriverReference.getTutorialScreen();
        Assert.assertNotNull(tutorialScreen);
    }

    @When("Tap Map button")
    public void tap_map_button() {
        Reporter.info("Navigating to Map Screen");
        TutorialScreen tutorialScreen = MobileDriverReference.getTutorialScreen();

        DashBoardScreen dashBoard = tutorialScreen.loadDashBoardScreen();
        MobileDriverReference.setDashBoardScreen(dashBoard);
        Assert.assertNotNull(dashBoard);

        Reporter.info("Exiting the Main Menu Pop-ups");
        dashBoard.mainMenuCheck();


        Reporter.info("Clicking the Map button");
        MapScreen map = dashBoard.clickMapButton();
        MobileDriverReference.setMapScreen(map);
        Assert.assertNotNull(map);

        Reporter.info("Validate Show List Button");
        Assert.assertTrue(map.showListIsDisplayed(), "Show List not displayed");

        Reporter.info("Validate Category Button");
        Assert.assertTrue(map.categoryIsDisplayed(), "Category not displayed");

        Reporter.info("Validate Filter Button");
        Assert.assertTrue(map.filterIsDisplayed(), "Filter not displayed");
    }

    @Then("Check if the Hotels Option is available")
    public void check_if_the_hotels_option_is_available() {
        MapScreen map = MobileDriverReference.getMapScreen();

        Reporter.info("Validate Map is an Attraction");
        Assert.assertTrue(map.isHotelAttraction());
    }

    @When("Tap on Menu Button")
    public void tap_on_menu_button() {
        Reporter.info("Loading the App");
        TutorialScreen tutorialScreen = MobileDriverReference.getTutorialScreen();
        DashBoardScreen dashBoard = tutorialScreen.loadDashBoardScreen();

        MobileDriverReference.setDashBoardScreen(dashBoard);
        Assert.assertNotNull(dashBoard);

        Reporter.info("Exiting the Main Menu Pop-ups");
        dashBoard.mainMenuCheck();

        Reporter.info("CLicking More Options button");
        dashBoard.clickMoreOptions();
        MobileDriverReference.setDashBoardScreen(dashBoard);

        Reporter.info("Validate Tickets and Passes Button");
        Assert.assertTrue(dashBoard.ticketsIsDisplayed(), "Tickets and Passes not displayed");
    }

    @When("Scroll down until bottom")
    public void scroll_down_until_bottom() {
        TutorialScreen tutorialScreen = MobileDriverReference.getTutorialScreen();
        DashBoardScreen dashBoard = tutorialScreen.loadDashBoardScreen();

        MobileDriverReference.setDashBoardScreen(dashBoard);
        Assert.assertNotNull(dashBoard);

        Reporter.info("Scrolling to bottom");
        dashBoard.scrollingToBottom();
    }

    @When("Tap on Privacy & legal")
    public void tap_on_privacy_legal() {
        TutorialScreen tutorialScreen = MobileDriverReference.getTutorialScreen();
        DashBoardScreen dashBoard = tutorialScreen.loadDashBoardScreen();

        MobileDriverReference.setDashBoardScreen(dashBoard);
        Assert.assertNotNull(dashBoard);

        Reporter.info("Clicking Privacy button");
        PrivacyScreen privacy = dashBoard.clickPrivacy();
        MobileDriverReference.setPrivacyScreen(privacy);
        Assert.assertNotNull(privacy);
    }

    @Then("User can see Privacy & legal options")
    public void user_can_see_privacy_legal_options() {
        TutorialScreen tutorialScreen = MobileDriverReference.getTutorialScreen();
        PrivacyScreen privacy = MobileDriverReference.getPrivacyScreen();

        Reporter.info("Validate Privacy Policy Button");
        Assert.assertTrue(privacy.privacyPolicyIsDisplayed(), "Privacy Policy not displayed");

        Reporter.info("Validate Terms of Use");
        Assert.assertTrue(privacy.termsOfUseIsDisplayed(), "Terms of Use not displayed");

        Reporter.info("Validate Supplemental Terms and Conditions Button");
        Assert.assertTrue(privacy.supplementalTermsIsDisplayed(), "Supplemental Terms and Conditions not displayed");

        Reporter.info("Validate Legal Notices button");
        Assert.assertTrue(privacy.legalNoticesIsDisplayed(), "Legal Notices not displayed");

        Reporter.info("Validate Property Rules button");
        Assert.assertTrue(privacy.propertyRulesIsDisplayed(), "Property Rules not displayed");

        Reporter.info("Validate Electronic Communication Disclosure button");
        Assert.assertTrue(privacy.disclosureIsDisplayed(), "Electronic Communication Disclosure not displayed");
    }

    @When("Tap Add Plans Button")
    public void tap_add_plans_button() {

        Reporter.info("Open main screen");
        TutorialScreen tutorialScreen = MobileDriverReference.getTutorialScreen();

        DashBoardScreen dashBoard = tutorialScreen.loadDashBoardScreen();
        MobileDriverReference.setDashBoardScreen(dashBoard);

        dashBoard.mainMenuCheck();

        Reporter.info("Clicking Add button");
        dashBoard.clickAddButton();
        MobileDriverReference.setDashBoardScreen(dashBoard);
    }

    @Then("Check Reserve Dining is in the list")
    public void check_reserve_dining_is_in_the_list() {
        TutorialScreen tutorialScreen = MobileDriverReference.getTutorialScreen();

        Reporter.info("Validate Check Dining Availability");
        DashBoardScreen dashBoard = tutorialScreen.loadDashBoardScreen();
        Assert.assertTrue(dashBoard.checkDinningIsDisplayed(), "Check Dining Availability not displayed");
    }
}
