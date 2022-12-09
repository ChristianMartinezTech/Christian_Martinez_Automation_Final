package com.globant.configuration.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public class WebOperations {
    private final WebDriver driver;
    protected final WebDriverWait wait;

    public WebOperations(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void clickElement(WebElement element){
        waitForClickable(element);
        element.click();
    }

    public void typeOnInput(WebElement element, String text){
        this.waitForVisibility(element);
        element.sendKeys(text);
    }

    public void waitForVisibility(WebElement element){
        this.wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickable(WebElement element){
        this.wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void hoverOver(WebElement element) {
        this.waitForVisibility(element);
        new Actions(getDriver()).moveToElement(element).perform();
    }

    public void refreshPage(){
        this.driver.navigate().refresh();
    }

    public void waitFor(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
    }
}
