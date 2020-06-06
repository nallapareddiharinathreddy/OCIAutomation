package OCI.TestCases;

import OCI.testBase.TestBase;
import OCI.utils.ExtentReport;
import OCI.utils.NewExtendReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import OCI.utils.NewExtendReport;

import java.text.SimpleDateFormat;
import java.util.Date;
@Listeners(OCI.utils.NewExtendReport.class)
public class TestA extends TestBase {

    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest logger;

    @Test(priority = 1)
    public void First()
    {
        loggerextent=extent.createTest("test");
        loggerextent.info("test");
        loggerextent.log(Status.PASS,"Test case is paased");
    System.out.println("A : first method+1");
    }
    @Test(priority = 3)
    public void Second()
    {
        System.out.println("A: second method+3");
    }
    @Test(priority = 2)
    public void ElThird()
    {
        System.out.println("A : third method +2");
    }
}
