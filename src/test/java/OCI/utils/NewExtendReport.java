package OCI.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class NewExtendReport extends TestListenerAdapter{


    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;

    public void onStart(ITestContext testContext) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //time stamp
        String repName = "Test-Report-"+timeStamp+".html";
        htmlReporter = new ExtentHtmlReporter( System.getProperty("user.dir")+"./Reports/"+repName); //report file location
        htmlReporter.loadConfig(System.getProperty("user.dir")+"/src/test/resources/extent-config.xml");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host name", "localhost");
        extent.setSystemInfo("Environement", "Windows");
        extent.setSystemInfo("user", "hari");

        htmlReporter.config().setDocumentTitle("rcc smoke"); // title of report
        htmlReporter.config().setReportName("Functional testing"); //name of report
        htmlReporter.config().setTheme(Theme.DARK);
    }

    public void onTestSuccess(ITestResult tr) {
        //logger = extent.createTest(tr.getName());
        logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
    }


    public void onTestFailure(ITestResult tr) {
        //logger = extent.createTest(tr.getName());
        logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
        String screenshotPath = "./Screenshots/" + tr.getName()+ ".png";

        File f = new File(screenshotPath);
        if(f.exists()) {
            try {
                logger.fail("Screenshot" + logger.addScreenCaptureFromPath(screenshotPath));

            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void onTestSkipped(ITestResult tr) {
        logger = extent.createTest(tr.getName());
        logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
    }

    public void onFinish(ITestContext testContext) {
        extent.flush();
    }


}
