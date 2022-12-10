package com.globant.pages.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Class: TutorialScreen
 * Object of the first screen that appears when we open the application.
 * @author Arley.Bolivar, Hans.Marquez
 */

public class TutorialScreen extends BaseScreen {

    /**
     * Constructor method.
     *
     * @param driver the driver
     * @author Arley.Bolivar
     */
    public TutorialScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"com.disney.wdpro.dlr:id/permission_primary_btn\")")
    private AndroidElement getStartedButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"com.disney.wdpro.dlr:id/permission_primary_btn\")")
    private AndroidElement shareLocationButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"android:id/button1\")")
    private AndroidElement allowLocationButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\")")
    private AndroidElement allowButton;

    /**
     * Start permissions process.
     * @author Hans.Marquez
     */
    public void startPermissionsProcess() {
        click(getStartedButton);
    }

    /**
     * Share Location permissions process.
     * @author Hans.Marquez
     */
    public DashBoardScreen shareLocationPermissions() {
        click(shareLocationButton);
        click(allowLocationButton);
        click(allowButton);
        return new DashBoardScreen(driver);
    }

    /**
     * return SignUpOrLogInScreen after close the alerts.
     * @return SignUpOrLogInScreen
     * @author Arley.Bolivar
     */
    public DashBoardScreen loadDashBoardScreen() {
        this.startPermissionsProcess();
        return this.shareLocationPermissions();
    }
}
