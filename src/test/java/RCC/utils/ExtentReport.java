package RCC.utils;

import RCC.pagefactory.LoginPage;
import RCC.testBase.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentHtmlReporterConfiguration;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReport extends TestBase implements ITestListener {

    public static ExtentSparkReporter  htmlReporter;
    public static ExtentReports extent;
    //public static ExtentTest loggerextent;
    //public  static ExtentTest log;
    public static ExtentHtmlReporterConfiguration configuration;


    @Override
    public void onTestStart(ITestResult result) {
        //loggerextent = extent.createTest(result.getName());


    }

    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            //loggerextent = extent.createTest(result.getName());
            loggerextent.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"Test case Passed", ExtentColor.GREEN));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            //loggerextent = extent.createTest(result.getName());
            //loggerextent.assignCategory();
            loggerextent.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test case Failed", ExtentColor.RED));
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
        loggerextent.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"Test case Skipped", ExtentColor.ORANGE));

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //time stamp
        String repName = "Test-Report-"+timeStamp+".html";
        htmlReporter = new ExtentSparkReporter( System.getProperty("user.dir")+"./Reports/"+repName); //report file location
        extent = new ExtentReports();
        LoginPage login=new LoginPage(driver);
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("OS  ", System.getProperty("os.name"));
        //extent.setSystemInfo("OS Architecture  ", System.getProperty("os.arch"));
        //extent.setSystemInfo("Java Version  ", System.getProperty("java.version"));
        extent.setSystemInfo("User Name  ", System.getProperty("user.name"));
        extent.setSystemInfo("Machine Name  ", System.getProperty("machine.name"));
        extent.setSystemInfo("Browser ", prop.getProperty("BrowserType"));
        extent.setSystemInfo("Build Number ", login.buildversion());



        htmlReporter.config().setTimeStampFormat("MMM dd, yyyy hh:mm:ss");
        htmlReporter.config().enableTimeline(false);
        htmlReporter.config().setDocumentTitle(prop.getProperty("DocumentTitle")); // title of report
        htmlReporter.config().setReportName(prop.getProperty("ReportName"));
        htmlReporter.config().setTheme(Theme.DARK);


    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }


}
