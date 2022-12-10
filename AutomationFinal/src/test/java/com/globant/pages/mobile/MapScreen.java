package com.globant.pages.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

/**
 * Class: MapScreen
 * Class used to gather the MapScreen screen methods and locators
 * @author Hans.Marquez, cf.martinez
 */
public class MapScreen extends BaseScreen {

    /**
     * Constructor method.
     * @param driver the driver
     * @author Hans.Marquez
     */
    public MapScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*categoryTitle\")")
    private AndroidElement categoryList;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*filterTitle.*\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Filter\")")
    private AndroidElement filterButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*toggleTitle.*\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Show List\")")
    private AndroidElement showListButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"com.disney.wdpro.dlr:id/categoryTitle\")")
    private AndroidElement attractionsList;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"com.disney.wdpro.dlr:id/facilityTypeTitle\").textContains(\"Hotels\")")
    private AndroidElement AttractionsHotels;

    /**
     * Return true if Category List element is displayed in screen, otherwise false.
     * @author Hans.Marquez
     */
    public boolean categoryIsDisplayed() {
        return isElementAvailable(categoryList);
    }

    /**
     * Return true if Filter Button element is displayed in screen, otherwise false.
     * @author Hans.Marquez
     */
    public boolean filterIsDisplayed() {
        return isElementAvailable(filterButton);
    }

    /**
     * Return true if Show List Button element is displayed in screen, otherwise false.
     * @author Hans.Marquez
     */
    public boolean showListIsDisplayed() {
        return isElementAvailable(showListButton);
    }

    /***
     * Method that clicks attractionsList and checks if AttractionsHotels element is available
     * @return true if AttractionsHotels element is available
     * @author cf.martinez
     */
    public boolean isHotelAttraction() {
        if (this.isElementAvailable(attractionsList, 25)){
            click(attractionsList);
        }
        return this.isElementAvailable(AttractionsHotels, 25);
    }

}
