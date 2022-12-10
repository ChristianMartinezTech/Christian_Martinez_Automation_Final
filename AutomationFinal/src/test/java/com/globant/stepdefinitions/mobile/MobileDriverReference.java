package com.globant.stepdefinitions.mobile;

import com.globant.pages.mobile.DashBoardScreen;
import com.globant.pages.mobile.MapScreen;
import com.globant.pages.mobile.PrivacyScreen;
import com.globant.pages.mobile.TutorialScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MobileDriverReference {
    private static AndroidDriver<AndroidElement> driver;
    protected static DashBoardScreen dashBoardScreen;
    protected static MapScreen mapScreen;
    protected static PrivacyScreen privacyScreen;
    protected static TutorialScreen tutorialScreen;


    public MobileDriverReference(){
        driver = null;
        tutorialScreen = null;
        dashBoardScreen = null;
        mapScreen = null;
        privacyScreen = null;

    }

    // Getter
    public static AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }
    public static TutorialScreen getTutorialScreen() {
        return tutorialScreen;
    }
    public static DashBoardScreen getDashBoardScreen() {
        return dashBoardScreen;
    }
    public static MapScreen getMapScreen() {
        return mapScreen;
    }
    public static PrivacyScreen getPrivacyScreen() {
        return privacyScreen;
    }

    //Setter
    public static void setDriver(AndroidDriver<AndroidElement> driver) {
        MobileDriverReference.driver = driver;
    }
    public static void setTutorialScreen(TutorialScreen tutorialScreen) {
        MobileDriverReference.tutorialScreen = tutorialScreen;
    }
    public static void setDashBoardScreen(DashBoardScreen dashBoardScreen) {
        MobileDriverReference.dashBoardScreen = dashBoardScreen;
    }
    public static void setMapScreen(MapScreen mapScreen) {
        MobileDriverReference.mapScreen = mapScreen;
    }
    public static void setPrivacyScreen(PrivacyScreen privacyScreen) {
        MobileDriverReference.privacyScreen = privacyScreen;
    }
}
