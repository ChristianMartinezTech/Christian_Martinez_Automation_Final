package com.globant.stepdefinitions.web;

import com.globant.configuration.web.Driver;
import com.globant.pages.web.HomePage;

public class WebReference {
    private static Driver driver;
    protected static HomePage home;

    public WebReference(){
        driver = null;
        home = null;
    }

    // Getters
    public static Driver getDriver() {
        return driver;
    }
    public static HomePage getHome() {
        return home;
    }

    // Setters
    public void setDriver(Driver driver) {
        WebReference.driver = driver;
    }
    public void setHome(HomePage home) {
        WebReference.home = home;
    }
}
