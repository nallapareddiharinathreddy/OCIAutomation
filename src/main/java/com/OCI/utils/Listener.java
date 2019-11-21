package com.OCI.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.OCI.testBase.*;

public class Listener extends TestBase implements ITestListener  {

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            //System.out.println("Test case  :" + result.getName()+" is passed");
            String TestName="Success_"+result.getName();
            Take_Screen_Shot.take_screenshot(driver, TestName);
            Take_Screen_Shot.fullScreenShot(driver,TestName);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //Take_Screen_Shot.take_screenshot(driver,result.getName());
        try {
            System.out.println("Test case :" + result.getName()+" is failed");
            String TestName="Failure_"+result.getName();
            Take_Screen_Shot.take_screenshot(driver, TestName);
            Take_Screen_Shot.fullScreenShot(driver,TestName);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
