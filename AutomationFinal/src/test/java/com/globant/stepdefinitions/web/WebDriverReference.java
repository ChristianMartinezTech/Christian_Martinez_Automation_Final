package com.globant.stepdefinitions.web;

import com.globant.configuration.web.Driver;
import com.globant.pages.web.HomePage;
import com.globant.pages.web.WatchPage;

public class WebDriverReference {
    private static Driver driver;
    protected static HomePage home;
    protected static WatchPage watch;

    public WebDriverReference(){
        driver = null;
        home = null;
        watch = null;
    }

    // Getters
    public static Driver getDriver() {
        return driver;
    }
    public static HomePage getHome() {
        return home;
    }
    public static WatchPage getWatch() {
        return watch;
    }

    // Setters
    public static void setDriver(Driver driver) {
        WebDriverReference.driver = driver;
    }
    public static void setHome(HomePage home) {
        WebDriverReference.home = home;
    }
    public static void setWatch(WatchPage watch) {
        WebDriverReference.watch = watch;
    }
}
