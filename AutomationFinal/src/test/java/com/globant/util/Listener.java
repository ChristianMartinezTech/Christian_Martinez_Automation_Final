package com.globant.util;

import com.globant.reporting.Reporter;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

/***
 * Class Listener
 * Shows any logs of the text based in iTestResult, iTestContext, and the log4j file
 */
public class Listener implements ITestListener{

    @Override
    public void onTestStart(ITestResult result) {
        Reporter.info("Test " + result.getName() + " Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.info("Test " + result.getName() + " [Succeeded]");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.error("Test " + result.getName() + " [Failed]");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Reporter.error("Test " + result.getName() + " [Skipped]");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        Reporter.info("Test " + result.getName() + " [Failed within success percentage]");
    }

    @Override
    public void onStart(ITestContext result) {
        Reporter.info("Test " + result.getName() + " [Test on start]");
    }

    @Override
    public void onFinish(ITestContext result) {
        Reporter.info("Test " + result.getName() + " [Test on finish]");
    }
}

