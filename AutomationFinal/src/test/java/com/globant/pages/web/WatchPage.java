package com.globant.pages.web;

import com.globant.reporting.Reporter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

public class WatchPage extends BasePage {
    public WatchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = "#fittPageContainer > section > div:nth-child(1) > section > div.Carousel__Wrapper.relative.Carousel__Wrapper--canScrollRight > div > div > ul > li:nth-child(2) > a")
    private WebElement secondCarouselItem;

    @FindBy (id = "bucket-40653")
    private WebElement tennisCarousel;

    @FindBy(className = "lightboxTitle")
    private WebElement providerBanner;

    @FindBy(className = "lightbox__closebtn")
    private WebElement closeButton;


    /***
     * Clicks the second Watch Carousel
     */
    public void clickSecondCarouselItem(){
        super.waitForVisibility(secondCarouselItem);
        super.clickElement(secondCarouselItem);
    }

    /***
     * Goes to HomePage
     */
    public void goHomepage(){
        getDriver().get("https://www.espnqa.com/?src=com&_adblock=true&espn=cloud");
    }

    /***
     * Checks if the Tennis Carousel is displayed
     * @return true if the Tennis Carousel is displayed
     */
    public boolean containsTennisCarousel(){
        super.waitForVisibility(tennisCarousel);
        return tennisCarousel.isDisplayed();
    }

    /***
     * Checks if the tv provider banner is displayed
     * @return true if its displayed
     */
    public boolean isCloseButtonDisplayed(){
        super.waitForClickable(closeButton);
        return closeButton.isDisplayed();
    }

    /***
     * Click the Close Button (X)
     */
    public void clickCloseButton(){
        super.clickElement(closeButton);
    }
}
