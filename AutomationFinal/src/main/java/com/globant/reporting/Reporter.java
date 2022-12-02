package com.globant.reporting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * Class: Reporter
 * This class is used by the Listener Class. It establishes Info, Error or Warning logs.
 */
public class Reporter {
    public Reporter() {};

    /***
     * Gets a logger
     * @return Logger data type
     */
    private static Logger getLogger(){
        return LoggerFactory.getLogger((Reporter.class));
    }

    /***
     * Used to Log info messages
     * @param text to log
     */
    public static void info(String text){
        getLogger().info(text);
    }

    /***
     * Used to Log error messages
     * @param text to log
     */
    public static void error(String text){
        getLogger().error(text);
    }

    /***
     * Used to Log warning messages
     * @param text to log
     */
    public static void warning(String text){
        getLogger().warn(text);
    }
}