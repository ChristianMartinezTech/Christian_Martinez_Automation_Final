package com.globant.pages.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/***
 * Class: PrivacyScreen
 * Class used to gather the PrivacyScreen screen methods and locators
 * @author cf.martinez
 */
public class PrivacyScreen extends BaseScreen {

    /**
     * Constructor method for standard screens object.
     * @param driver : AndroidDriver
     * @author Arley.Bolivar, Hans.Marquez
     */
    public PrivacyScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Privacy Policy\").index(0)")
    private AndroidElement privacyPolicyButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Terms of Use\")")
    private AndroidElement termsOfUseButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Supplemental Terms and Conditions\")")
    private AndroidElement supplementalTermsButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Legal Notices\")")
    private AndroidElement legalNoticesButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Property Rules\")")
    private AndroidElement propertyRulesButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Electronic Communications Disclosure\")")
    private AndroidElement disclosureButton;

    /***
     * Checks if privacyPolicyButton element is displayed
     * @return true if privacyPolicyButton element is displayed
     * @author cf.martinez
     */
    public boolean privacyPolicyIsDisplayed() {
        return isElementAvailable(privacyPolicyButton);
    }

    /***
     * Checks if termsOfUseButton element is displayed
     * @return true if termsOfUseButton element is displayed
     * @author cf.martinez
     */
    public boolean termsOfUseIsDisplayed() {
        return isElementAvailable(termsOfUseButton);
    }

    /***
     * Checks if supplementalTermsButton element is displayed
     * @return true if supplementalTermsButton element is displayed
     * @author cf.martinez
     */
    public boolean supplementalTermsIsDisplayed() {
        return isElementAvailable(supplementalTermsButton);
    }

    /***
     * Checks if legalNoticesButton element is displayed
     * @return true if legalNoticesButton element is displayed
     * @author cf.martinez
     */
    public boolean legalNoticesIsDisplayed() {
        return isElementAvailable(legalNoticesButton);
    }

    /***
     * Checks if propertyRulesButton element is displayed
     * @return true if propertyRulesButton element is displayed
     * @author cf.martinez
     */
    public boolean propertyRulesIsDisplayed() {
        return isElementAvailable(propertyRulesButton);
    }

    /***
     * Checks if disclosureButton element is displayed
     * @return true if disclosureButton element is displayed
     * @author cf.martinez
     */
    public boolean disclosureIsDisplayed() {
        return isElementAvailable(disclosureButton);
    }
}
