package com.globant.pages.web;

import com.globant.reporting.Reporter;
import org.openqa.selenium.*;
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


    // New WebElements
    @FindBy (id = "BtnCreateAccount")
    private WebElement signUpButton;

    @FindBy (id = "InputFirstName")
    private WebElement firstNameField;

    @FindBy (id = "InputLastName")
    private WebElement lastNameField;

    @FindBy (id = "InputEmail")
    private WebElement emailField;

    @FindBy (id = "password-new")
    private WebElement passwordField;

    @FindBy (id = "BtnSubmit")
    private WebElement submitSignUpButton;

    @FindBy (id = "close")
    private WebElement signUpCloseButton;


    // Methods
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
        Reporter.info("1");
        Reporter.info(nameFixed);
        StringBuffer sb = new StringBuffer(nameFixed);
        sb.deleteCharAt(sb.length()-1);

        Reporter.info("2");
        Reporter.info(String.valueOf(sb));
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


    // New Methods
    /***
     * Clicks the Sign-Up button
     */
    public void clickSignUp() {
        super.waitForVisibility(signUpButton);
        super.clickElement(signUpButton);
    }

    /***
     * Inputs the first name
     * @param firstName first name
     */
    public void inputFirstName(String firstName) {
        super.waitForVisibility(firstNameField);
        super.typeOnInput(firstNameField, firstName);
    }

    /***
     * Checks if first name exists
     * @return true if element exists
     */
    public boolean firstNameExists() {
        try {
            return firstNameField.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /***
     * Inputs Last Name
     * @param lastName last name
     */
    public void inputLastName(String lastName) {
        super.waitForVisibility(lastNameField);
        super.typeOnInput(lastNameField, lastName);
    }

    /***
     * Checks if last name exists
     * @return true if element exists
     */
    public boolean lastNameExists() {
        try {
            return lastNameField.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /***
     * Inputs the email
     * @param email email
     */
    public void inputSignUpEmail(String email) {
        super.waitForVisibility(emailField);
        super.typeOnInput(emailField, email);
    }

    /***
     * Check that the email field exists
     * @return true if exists
     */
    public boolean emailExists() {
        try {
            return emailField.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /***
     * Intpus the password
     * @param password to type
     */
    public void inputSignUpPassword(String password) {
        super.waitForVisibility(passwordField);
        super.typeOnInput(passwordField, password);
    }

    /***
     * Checks the password field exists
     * @return true if exists
     */
    public boolean passwordExists() {
        try {
            return passwordField.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /***
     * Clicks the submit button
     */
    public void clickSubmitSignUpButton() {
        super.waitForVisibility(submitSignUpButton);
        super.clickElement(submitSignUpButton);
    }

    /***
     * Checks the Sign-Up button exists
     * @return true if button exists
     */
    public boolean submitSubmitExists() {
        try {
            return submitSignUpButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /***
     * Checks if the cloe button exists
     * @return true if exists
     */
    public boolean checkSignUpCloseButton(){
        try {
            return signUpCloseButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /***
     * Goes to HomePage
     */
    public void goHomepage(){
        getDriver().get("https://www.espnqa.com/?src=com&_adblock=true&espn=cloud");
    }

}
