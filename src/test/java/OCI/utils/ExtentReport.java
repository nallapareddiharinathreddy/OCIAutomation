package OCI.utils;

import OCI.testBase.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestListener;
import org.testng.ITestContext;;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReport extends TestBase implements ITestListener {

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest loggerextent;

    @Override
    public void onTestStart(ITestResult result) {
        loggerextent = extent.createTest(result.getName());


    }

    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            //loggerextent = extent.createTest(result.getName());
            loggerextent.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            //loggerextent = extent.createTest(result.getName());
            loggerextent.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
            String TestName="Failure_"+result.getName();
            String pp = Take_Screen_Shot.take_screenshot(driver, TestName);
            String screenshotPath="./Screenshots/"+pp+".jpg";
            //System.out.println(screenshotPath);
            loggerextent.log(Status.FAIL," " + loggerextent.addScreenCaptureFromPath(screenshotPath));




        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        //loggerextent = extent.createTest(result.getName());
        loggerextent.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //time stamp
        String repName = "Test-Report-"+timeStamp+".html";
        htmlReporter = new ExtentHtmlReporter( System.getProperty("user.dir")+"./Reports/"+repName); //report file location
        htmlReporter.loadConfig(System.getProperty("user.dir")+"/src/test/resources/extent-config.xml");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host name", "localhost");
        extent.setSystemInfo("Environement", "Windows");
        extent.setSystemInfo("user", "hari");


        htmlReporter.config().setDocumentTitle("RCC Automation"); // title of report
        htmlReporter.config().setReportName("Smoke Suite Test Report"); //name of report
        htmlReporter.config().setTheme(Theme.DARK);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }


}
