package com.globant.pages.web;

import com.globant.reporting.Reporter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

/***
 * Class: Home Page
 * Extends from BasePage
 * This class is used to store the HomePage web elements and methods to interact with it.
 */
public class HomePage extends BasePage {
    /***
     * HomePage Constructor
     * @param driver current WebDriver
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Web Elements
    @FindBy(css = "title")
    private WebElement websiteTitle;

    @FindBy (id = "global-user-trigger")
    private WebElement globalUserTrigger;

    @FindBy (className = "global-user")
    private WebElement userContainer;

    @FindBy (css = "#global-header > div.container > ul > li.user > div > div > ul.account-management > li:nth-child(7) > a")
    private WebElement globalUserContainerLogin;

    @FindBy (id = "oneid-iframe")
    private WebElement loginIframe;

    @FindBy (id = "InputLoginValue")
    private WebElement LogInEmail;

    @FindBy (id = "InputPassword")
    private WebElement LogInPassword;

    @FindBy (id = "BtnSubmit")
    private WebElement LogInButton;

    @FindBy (css = "div.global-user:last-child ul.account-management > li:last-child > a")
    private WebElement LogOutButton;

    @FindBy (css = "#global-header > div.container > ul > li.user > div > div > ul.account-management > li.display-user > span")
    private WebElement accountName;

    @FindBy (linkText = "ESPN Profile")
    private WebElement espnProfile;

    @FindBy (id = "AccountDeleteLink")
    private WebElement deleteAccountButton;

    @FindBy (css = "#TextBlock + #BtnSubmit")
    private WebElement deleteAccountSubmit;

    @FindBy (id = "logo")
    private WebElement espnLoginLogo;

    @FindBy (id = "BtnCreateAccount")
    private WebElement signUp;

    @FindBy (linkText = "Watch")
    private WebElement watchButton;

    @FindBy (id = "bucket-40653")
    private WebElement tennisCarousel;

    @FindBy (css = "#fittPageContainer > section > div:nth-child(1) > section > div.Carousel__Wrapper.relative.Carousel__Wrapper--canScrollRight > div > div > ul > li:nth-child(2) > a")
    private WebElement secondCarouselItem;

    @FindBy (css = ".lightbox__closebtn")
    private WebElement closeButton;

    @FindBy (css = "#Title > span")
    private WebElement accountDeactivated;


    // Methods

    public HomePage getHomePage(){
        return HomePage.this;
    }

    /***
     * Method that hover over the user icon to enable Login, Logout, Account Settings, etc.
     */
    public void hoverOverUsrIcon() {
        super.hoverOver(globalUserTrigger);
        waitForVisibility(userContainer);
    }

    /***
     * Clicks on the Login button
     */
    public void clickContainerLogIn() {
        super.clickElement(globalUserContainerLogin);
    }

    /***
     * Clicks to input an email
     */
    public void clickEmailLogIn() {
        super.clickElement(LogInEmail);
    }

    /***
     * clicks to input a password
     */
    public void clickPasswordLogIn() {
        super.clickElement(LogInPassword);
    }

    /***
     * Inputs the email
     * @param email to type
     */
    public void inputEmail(String email) {
        super.waitForVisibility(LogInEmail);
        super.typeOnInput(LogInEmail, email);
    }

    /***
     * Intpus the password
     * @param password to type
     */
    public void inputPassword(String password) {
        super.waitForVisibility(LogInPassword);
        super.typeOnInput(LogInPassword, password);
    }

    /***
     * LogIn iFrame
     */
    public void goToLogInIframe() {
        super.getDriver().switchTo().frame(loginIframe);
    }

    /***
     * Button lo log in
     */
    public void logInButton() {
        super.waitForVisibility(LogInButton);
        super.clickElement(LogInButton);
    }

    /***
     * Button to log out
     */
    public void clickLogOutButton() {
        super.clickElement(LogOutButton);
    }

    /***
     * Click on the ESPN profile button
     */
    public void clickEspnProfile(){
        super.waitForVisibility(espnProfile);
        super.clickElement(espnProfile);
    }

    /***
     * Clicks on the Watch button
     */
    public void clickWatchButton(){
        super.waitForVisibility(watchButton);
        super.clickElement(watchButton);
    }

    /***
     * Clicks the second Watch Carousel
     */
    public void clickSecondCarouselItem(){
        super.waitForVisibility(secondCarouselItem);
        super.clickElement(secondCarouselItem);
    }

    /***
     * Click the Close Button (X)
     */
    public void clickCloseButton(){
        super.waitForVisibility(closeButton);
        super.clickElement(closeButton);
    }

    /***
     * Goes to HomePage
     * @param url url of the HomePage given in suite.xml
     */
    public void goHomepage(String url){
        getDriver().get(url);
    }

    /***
     * Clicks on Delete Account
     */
    public void clickDeleteAccount(){
        super.waitForVisibility(deleteAccountButton);
        ((JavascriptExecutor) super.getDriver()).executeScript("arguments[0].click();", deleteAccountButton);
    }

    /***
     * Clicks on Submit Delete Account
     */
    public void clickDeleteAccountSubmit(){
        super.waitForVisibility(deleteAccountSubmit);
        super.clickElement(deleteAccountSubmit);
    }

    /***
     * Moves to the Delete button
     */
    public void moveToDelete(){
        super.waitForVisibility(deleteAccountButton);
        super.hoverOver(deleteAccountButton);
    }

    /***
     * Interface of login methods
     * @param email email for log in given in the suite.xml file
     * @param password email for log in given in the suite.xml file
     */
    public void loginMethods(String email, String password){
        hoverOverUsrIcon();
        clickContainerLogIn();
        goToLogInIframe();
        clickEmailLogIn();
        inputEmail(email);
        clickPasswordLogIn();
        inputPassword(password);
        logInButton();
    }

    /***
     * Name equal determines whether the WebObject text and given name match
     * @param websiteObject Name in the WebObject
     * @param name Name
     * @return Returns true in case the given name and name in the WebObject match
     */
    public boolean nameEqual(String websiteObject, String name) {
        boolean nameMatch = false;

        if (Objects.equals(websiteObject, name)) {
            Reporter.info("Name matches!");
            nameMatch = true;
        } else {
            Reporter.error("Name does NOT match!");
        }
        return nameMatch;
    }

    /***
     * Gets the Account name and deletes the last "!" character
     * @param name Name
     * @return Returns true in case the given name and name in the WebObject match
     */
    public boolean checkAccountName(String name) {
        String nameFixed = accountName.getText();
        StringBuffer sb = new StringBuffer(nameFixed);
        sb.deleteCharAt(sb.length()-1);

        return nameEqual(String.valueOf(sb), name);
    }

    /***
     * Checks it there's any account name
     * @return true if any account name is found
     */
    public boolean containsAccountName(){
        try {
            return accountName.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /***
     * Checks if the ESPN logo is displayed
     * @return true if the ESPN logo is displayed
     */
    public boolean containsEspnPlusLogo(){
        super.waitForVisibility(espnLoginLogo);
        return espnLoginLogo.isDisplayed();
    }

    /***
     * Checks if the sign-up button is displayed
     * @return true if the button is displayed
     */
    public boolean containsSignUp(){
        super.waitForVisibility(signUp);
        return signUp.isDisplayed();
    }

    /***
     * Checks if the Login button is displayed
     * @return true if the Login button is displayed
     */
    public boolean containsLogIn(){
        super.waitForVisibility(LogInButton);
        return LogInButton.isDisplayed();
    }

    /***
     * Checks if the Tennis Carousel is displayed
     * @return true if the Tennis Carousel is displayed
     */
    public boolean containsTennisCarousel(){
        super.waitForVisibility(tennisCarousel);
        return tennisCarousel.isDisplayed();
    }
}
