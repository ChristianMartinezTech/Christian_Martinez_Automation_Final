package com.globant.pages.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Class: DashBoardScreen
 * Class used to gather the Dashboard screen methods and locators
 * @author Hans.Marquez, cf.martinez
 */
public class DashBoardScreen extends BaseScreen {

    /**
     * Constructor method.
     * @param driver : AndroidDriver
     * @author Hans.Marquez
     */
    public DashBoardScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"android:id/button2\")")
    private AndroidElement dismissPreferenceUpdateButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"dismiss-icon\")")
    private AndroidElement dismissWelcome;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"com.disney.wdpro.dlr:id/tab_icon\").description(\"Map, Tab, 2of5\")")
    private AndroidElement mapButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"com.disney.wdpro.dlr:id/tab_icon\").description(\"More Options, Tab, 5of5\")")
    private AndroidElement moreOptionsButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Privacy & Legal button\")")
    private AndroidElement privacyAndLegalButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Tickets and Passes\")")
    private AndroidElement ticketsButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Buy tickets, Reserve Dining, Tab, 3of5\")")
    private AndroidElement addButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Check Dining Availability\")")
    private AndroidElement checkDinningButton;

    /**
     * Method that navigates to Login Screen from DashBoard Screen.
     * @author Hans.Marquez
     */
    public void mainMenuCheck() {
        if (this.isElementAvailable(dismissWelcome, 25)) {
            click(dismissWelcome);
        }
        if (this.isElementAvailable(dismissPreferenceUpdateButton, 25)) {
            click(dismissPreferenceUpdateButton);
        }
    }

    /***
     * Method that checks if the map button is available and instantiates a new MapScreen class
     * @return new MapScreen instance
     * @author cf.martinez
     */
    public MapScreen clickMapButton() {
        if (this.isElementAvailable(mapButton, 25)) {
            click(mapButton);
        }
        return new MapScreen(driver);
    }

    /***
     * Method that checks if the moreOptionsButton is available and clicks it
     * @author cf.martinez
     */
    public void clickMoreOptions() {
        if (this.isElementAvailable(moreOptionsButton, 25)){
            click(moreOptionsButton);
        }
    }

    /***
     * Method that checks if the privacyAndLegalButton is available and instantiates a new PrivacyScreen class
     * @return new PrivacyScreen instance
     * @author cf.martinez
     */
    public PrivacyScreen clickPrivacy() {
        if (this.isElementAvailable(privacyAndLegalButton, 25)){
            click(privacyAndLegalButton);
        }
        return new PrivacyScreen(driver);
    }

    /***
     * Method that checks if the ticketsButton element is available
     * @return true is the ticketsButton element is available
     * @author cf.martinez
     */
    public boolean ticketsIsDisplayed() {
        return isElementAvailable(ticketsButton);
    }

    /***
     * Method that looks for the availability of privacyAndLegalButton
     * If the button is not available it will execute swipeToBottom() to swipe down
     * @author cf.martinez
     */
    public void scrollingToBottom(){
        do {
            swipeToBottom();
        } while (!isElementAvailable(privacyAndLegalButton));
    }

    /***
     * Method that checks for the addButton element availability and clicks it
     * @author cf.martinez
     */
    public void clickAddButton() {
        if (this.isElementAvailable(addButton, 25)){
            click(addButton);
        }
    }

    /***
     * Method that checks if checkDinningButton is available
     * @return true if the checkDinningButton element is available
     * @author cf.martinez
     */
    public boolean checkDinningIsDisplayed() {
        return isElementAvailable(checkDinningButton);
    }
}
