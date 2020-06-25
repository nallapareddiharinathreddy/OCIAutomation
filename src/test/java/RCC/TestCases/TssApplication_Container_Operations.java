package RCC.TestCases;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.*;
import RCC.testBase.*;
import RCC.pagefactory.*;
import RCC.utils.*;


@Listeners(RCC.utils.ExtentReport.class)
public class TssApplication_Container_Operations extends TestBase {
    ZoneRunningStatus zone=new ZoneRunningStatus();
    ActionStatus rcc_action=new ActionStatus();
    //public  static ExtentTest log;







    @BeforeClass
    public void tssComponentSearch()
    {
        WebDriverWait wait=new WebDriverWait(driver,600);

        try {
            Component_Search search = PageFactory.initElements(driver, Component_Search.class);
            search.components.click();
            Select sc = new Select(search.Component_type);
            sc.selectByVisibleText("TSS Application");
            System.out.println(prop.getProperty("TSSApplication") + " Selected successfully");
            search.searchfield.clear();
            search.searchfield.sendKeys(prop.getProperty("TSSApplication"));
            Select sc1 = new Select(search.search_type);
            sc1.selectByVisibleText("All of these words");
            search.search_button.click();
            search.component_detail.click();
            rcc_action.actionWait();

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    @AfterMethod
    public void closeActionWindow()
    {
        try {
            Component_Search search = PageFactory.initElements(driver, Component_Search.class);
            search.components_back.click();
            rcc_action.actionWait();
            search.component_detail.click();
            rcc_action.actionWait();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }


    }
    @AfterClass
    public void Components()
    {
        try {
            Component_Search search = PageFactory.initElements(driver, Component_Search.class);
            search.components_back.click();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    @Test(priority = 1)
    public void Tss_application_Stop() {
        try {
            loggerextent=ExtentReport.extent.createTest("TSS Application container Stop operation");
            loggerextent.info("Tss Application container stop operation started");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            Application_Container_Operations tss_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            tss_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tss_app_operations.application_container_operations).click().perform();
            tss_app_operations.stop.click();
            loggerextent.info("Stop operation selected");
            tss_app_operations.next_button.click();
            tss_app_operations.next_button.click();
            tss_app_operations.waiting_time.clear();
            tss_app_operations.waiting_time.sendKeys("25");
            tss_app_operations.comments.clear();
            tss_app_operations.comments.sendKeys("Rcc execution");
            tss_app_operations.next_button.click();
            String current_status = tss_app_operations.action_status.getText();
            loggerextent.info("Current  status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Stop operation executed ");
                String status=tss_app_operations.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Stop operation execution status as Success");
                    tss_app_operations.close_button.click();
                    tss_app_operations.actions.click();
                    ac.moveToElement(tss_app_operations.get_tomcat_status_new).click().perform();
                    if(rcc_action.actionStatusSuccess())
                    {
                        if (tss_app_operations.tss_app_stop_status.isDisplayed()) {
                            loggerextent.info("tomcat is stopped");

                        } else {

                            loggerextent.log(Status.FAIL,"tomcat is not stopped");
                            Assert.fail("tomcat is not stopped");
                        }
                    }
                    else {
                        loggerextent.log(Status.FAIL,"get status tomcat is failed");
                        Assert.fail("get status tomcat is failed");
                    }

                    if(zone.zoneStop(prop.getProperty("TSSzoneURL")))
                    {
                        loggerextent.info("zone is not accessible");
                    }
                    else
                    {
                        loggerextent.log(Status.FAIL,"Zone is running tomcat stop operation not successfull");
                        Assert.fail("Zone is running tomcat stop operation not successfull");
                    }
                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"Stop operation execution status as Failed");
                    Assert.fail("Action is failed");
                }

            }


        }
        catch (org.openqa.selenium.UnhandledAlertException e)
        {

            driver.switchTo().alert().accept();
            loggerextent.log(Status.FAIL,e);
            Assert.assertTrue(false,"e");


        }

        catch (Exception e) {
            loggerextent.log(Status.FAIL,e);
            Assert.assertTrue(false,"e");


        }



    }

    @Test(priority = 6)
    public void Tss_application_Start()
    {
        try {
            loggerextent=ExtentReport.extent.createTest("TSS Application container Start operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Tss Application container Start operation started");
            Application_Container_Operations tss_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            tss_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tss_app_operations.application_container_operations).click().perform();
            tss_app_operations.start.click();
            loggerextent.info(" Start operation Selected");
            tss_app_operations.next_button.click();
            tss_app_operations.next_button.click();
            tss_app_operations.waiting_time.clear();
            tss_app_operations.waiting_time.sendKeys("25");
            tss_app_operations.comments.clear();
            tss_app_operations.comments.sendKeys("Rcc execution");
            tss_app_operations.next_button.click();
            String current_status = tss_app_operations.action_status.getText();
            loggerextent.info("Current  status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Start operation executed");
                String status=tss_app_operations.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Start operation execution status as Success");
                    tss_app_operations.close_button.click();
                    tss_app_operations.actions.click();
                    ac.moveToElement(tss_app_operations.get_tomcat_status_new).click().perform();
                    if(rcc_action.actionStatusSuccess()) {
                        if (tss_app_operations.tss_app_start_status.isDisplayed()) {
                            loggerextent.info("tomcat is running");
                        }


                        if (zone.tssZoneStart(prop.getProperty("TSSzoneURL"))) {
                            loggerextent.info("zone is  accessible");
                        } else {
                            loggerextent.log(Status.FAIL,"Zone is not running tomcat start  operation not successfull");
                            Assert.fail("Zone is not running tomcat start  operation not successfull");
                        }
                    }
                    else {
                        loggerextent.log(Status.FAIL,"get status tomcat is failed");
                        Assert.fail("get status tomcat is failed");
                    }

                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"Start operation execution status as failed");
                    Assert.fail("Action is failed");

                }

            }

        }
        catch (org.openqa.selenium.UnhandledAlertException e)
        {

            driver.switchTo().alert().accept();
            loggerextent.log(Status.FAIL,e);
            Assert.assertTrue(false,"e");


        }
        catch (Exception e) {
            loggerextent.log(Status.FAIL,e);
            Assert.assertTrue(false,"e");


        }


    }

    @Test(priority = 2)
    public void Tss_application_reStart()
    {
        try
        {
            loggerextent=ExtentReport.extent.createTest("TSS Application container Restart operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Tss Application container restart operation started");
            Application_Container_Operations tss_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            tss_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tss_app_operations.application_container_operations).click().perform();
            tss_app_operations.restart.click();
            loggerextent.info(" Restrat operation Selected");
            tss_app_operations.next_button.click();
            tss_app_operations.next_button.click();
            tss_app_operations.waiting_time.clear();
            tss_app_operations.waiting_time.sendKeys("25");
            tss_app_operations.comments.clear();
            tss_app_operations.comments.sendKeys("Rcc execution");
            tss_app_operations.next_button.click();
            String current_status = tss_app_operations.action_status.getText();
            loggerextent.info("Current  status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("restart operation executed");
                String status=tss_app_operations.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Restart operation execution status as Success");
                    tss_app_operations.close_button.click();
                    tss_app_operations.actions.click();
                    ac.moveToElement(tss_app_operations.get_tomcat_status_new).click().perform();
                    if(rcc_action.actionStatusSuccess()) {
                        if (tss_app_operations.tss_app_start_status.isDisplayed()) {
                            loggerextent.info("tomcat is started");
                        }
                        if (zone.tssZoneStart(prop.getProperty("TSSzoneURL"))) {
                            loggerextent.info("zone is  accessible");
                        } else {
                            loggerextent.log(Status.FAIL,"Zone is not running tomcat restart  operation not successfull");
                            Assert.fail("Zone is not running tomcat restart  operation not successfull");
                        }
                    }
                    else {
                        loggerextent.log(Status.FAIL,"get status tomcat is failed");
                        Assert.fail("get status tomcat is failed");
                    }

                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"Start operation execution status as failed");
                    Assert.fail("Restart action is failed");

                }


            }
        }
        catch (org.openqa.selenium.UnhandledAlertException e)
        {

            driver.switchTo().alert().accept();
            loggerextent.log(Status.FAIL,e);
            Assert.assertTrue(false,"e");


        }
        catch (Exception e) {
            loggerextent.log(Status.FAIL,e);
            Assert.assertTrue(false,"e");


        }
    }

    @Test(priority = 3)
    public void Tss_application_dump_Threads() {
        try
        {
            loggerextent=ExtentReport.extent.createTest("TSS Application container DumpThreads operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Tss Application dump threads operation started");
            Application_Container_Operations tss_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            tss_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tss_app_operations.application_container_operations).click().perform();
            tss_app_operations.dump_threads.click();
            loggerextent.info(" Dump threads operation Selected");
            tss_app_operations.next_button.click();
            tss_app_operations.dump_thread_number.clear();
            tss_app_operations.dump_thread_number.sendKeys(prop.getProperty("dumpthreadscount"));
            tss_app_operations.dump_thread_interval_in_seconds.clear();
            tss_app_operations.dump_thread_interval_in_seconds.sendKeys(prop.getProperty("TimeIntervalbetweeneachdump"));
            tss_app_operations.dump_thread_email.clear();
            tss_app_operations.dump_thread_email.sendKeys(prop.getProperty("Email"));
            tss_app_operations.next_button.click();
            tss_app_operations.next_button.click();
            tss_app_operations.waiting_time.clear();
            tss_app_operations.waiting_time.sendKeys("25");
            tss_app_operations.comments.clear();
            tss_app_operations.comments.sendKeys("Rcc execution");
            tss_app_operations.next_button.click();
            String current_status = tss_app_operations.action_status.getText();
            loggerextent.info("Current  status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Dump threads operation executed");
                String status=tss_app_operations.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("dump thread operation executed successfully");
                    if(wait.until(ExpectedConditions.textToBePresentInElement(tss_app_operations.action_status, "Success"))) {
                        if (tss_app_operations.tss_dump_thread_success.isDisplayed()) {
                            loggerextent.info("dump thread is executed successfully and dump is sent to :" + prop.getProperty("Email"));

                        }
                    }

                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"Dump threads operation execution failed");
                    Assert.fail("Dump threads operation execution failed");
                }

            }
        }
        catch (org.openqa.selenium.UnhandledAlertException e)
        {

            driver.switchTo().alert().accept();
            loggerextent.log(Status.FAIL,e);
            Assert.assertTrue(false,"e");


        }
        catch (Exception e) {
            loggerextent.log(Status.FAIL,e);
            Assert.assertTrue(false,"e");


        }

    }

    @Test(priority = 4)
    public void Tss_application_rolling_Restart()
    {
        try
        {
            loggerextent=ExtentReport.extent.createTest("TSS Application container rolling restart operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Tss Application container rolling restart operation started");
            Application_Container_Operations tss_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            tss_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tss_app_operations.application_container_operations).click().perform();
            tss_app_operations.rolling_restart.click();
            loggerextent.info(" rolling restart operation Selected");
            tss_app_operations.next_button.click();
            tss_app_operations.next_button.click();
            tss_app_operations.waiting_time.clear();
            tss_app_operations.waiting_time.sendKeys("25");
            tss_app_operations.comments.clear();
            tss_app_operations.comments.sendKeys("Rcc execution");
            tss_app_operations.next_button.click();
            String current_status = tss_app_operations.action_status.getText();
            loggerextent.info("Current  status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("rolling restart operation executed");
                String status=tss_app_operations.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("rolling restart operation execution status as Success");
                    tss_app_operations.close_button.click();
                    tss_app_operations.actions.click();
                    ac.moveToElement(tss_app_operations.get_tomcat_status_new).click().perform();
                    if(rcc_action.actionStatusSuccess()) {
                        if (tss_app_operations.tss_app_start_status.isDisplayed()) {
                            loggerextent.info("tomcat is started");
                        }
                        if (zone.tssZoneStart(prop.getProperty("TSSzoneURL"))) {
                            loggerextent.info("zone is  accessible");
                        } else {
                            loggerextent.fail("Zone is not running tomcat rolling restart  operation not successfull");
                            Assert.fail("Zone is not running tomcat rolling restart  operation not successfull");
                        }
                    }
                    else {
                        loggerextent.fail("get status tomcat is failed");
                        Assert.fail("get status tomcat is failed");
                    }


                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"rolling retsrat operation execution status as Failed");
                    Assert.assertTrue(false,"rolling retsrat operation execution status as Failed");

                }
            }
        }
        catch (org.openqa.selenium.UnhandledAlertException e)
        {

            driver.switchTo().alert().accept();
            loggerextent.log(Status.FAIL,e);
            Assert.assertTrue(false,"e");


        }
        catch (Exception e) {
            loggerextent.log(Status.FAIL,e);
            Assert.assertTrue(false,"e");


        }
    }

 @Test(priority = 5)
    public void Tss_application_hard_Stop()
 {
     try
     {
         loggerextent=ExtentReport.extent.createTest("TSS Application container HardStop operation");
         loggerextent.assignCategory("SmokeTesting");
         loggerextent.assignAuthor("Harinathreddy");
         loggerextent.info("Tss Application container Hard stop operation started");
         Application_Container_Operations tss_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
         tss_app_operations.actions.click();
         Actions ac = new Actions(driver);
         ac.moveToElement(tss_app_operations.application_container_operations).click().perform();
         tss_app_operations.hard_Stop.click();
         loggerextent.info(" Hardstop operation Selected");
         tss_app_operations.next_button.click();
         tss_app_operations.next_button.click();
         tss_app_operations.waiting_time.clear();
         tss_app_operations.waiting_time.sendKeys("25");
         tss_app_operations.comments.clear();
         tss_app_operations.comments.sendKeys("Rcc execution");
         tss_app_operations.next_button.click();
         String current_status = tss_app_operations.action_status.getText();
         loggerextent.info("Current  status :" + current_status);
         if(rcc_action.actionStatusNotRunning())
         {
             loggerextent.info("Hardstop operation executed");
             String status = tss_app_operations.action_status.getText();
             if (status.equalsIgnoreCase("Success")) {
                 loggerextent.info("HardStop operation execution status as Success");
                 tss_app_operations.close_button.click();
                 tss_app_operations.actions.click();
                 ac.moveToElement(tss_app_operations.get_tomcat_status_new).click().perform();
                 if(rcc_action.actionStatusSuccess()) {
                     if (tss_app_operations.tss_app_stop_status.isDisplayed()) {
                         loggerextent.info("tomcat is stopped");
                     }
                     if (zone.zoneStop(prop.getProperty("TSSzoneURL"))) {
                         loggerextent.info("zone is not accessible");

                     } else {
                         loggerextent.log(Status.FAIL,"Zone is running tomcat hardstop operation not successfull");
                         Assert.fail("Zone is running tomcat hardstop operation not successfull");
                     }

                 }
                 else {
                     loggerextent.log(Status.FAIL,"get status tomcat is failed");
                     Assert.fail("get status tomcat is failed");
                 }

             }
             if (status.equalsIgnoreCase("Failed")) {
                 loggerextent.log(Status.FAIL,"HardStop operation execution status as Failed");
                 Assert.fail("Hard Stop operation execution failed");
             }
         }

     }
     catch (org.openqa.selenium.UnhandledAlertException e)
     {

         driver.switchTo().alert().accept();
         loggerextent.log(Status.FAIL,e);
         Assert.assertTrue(false,"e");


     }
     catch (Exception e) {
         loggerextent.log(Status.FAIL,e);
         Assert.assertTrue(false,"e");


     }

 }
 @Test(priority = 7)
    public void deploywithRestartContainer() {
        try {
            loggerextent=ExtentReport.extent.createTest("TSS Application deploy with restart containers ");
            loggerextent.info("TSS Application deploy with restart containers");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            Application_Container_Operations tss_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            tss_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tss_app_operations.Deploy_Application).click().perform();
            loggerextent.info("Deploy application operation selected");
            tss_app_operations.next_button.click();
            tss_app_operations.next_button.click();
            tss_app_operations.restart_allapps.click();
            loggerextent.info("Restart all applications after deploy option selected");
            tss_app_operations.next_button.click();
            tss_app_operations.next_button.click();
            String current_status = tss_app_operations.action_status.getText();
            loggerextent.info("Current  status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Redeploy with Restart all applications after deploy operation executed ");
                String status=tss_app_operations.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Redeploy with Restart all applications after deploy operation execution status as Success");
                    tss_app_operations.close_button.click();
                    tss_app_operations.actions.click();
                    ac.moveToElement(tss_app_operations.get_tomcat_status_new).click().perform();
                    if(rcc_action.actionStatusSuccess()) {
                        if (tss_app_operations.tss_app_start_status.isDisplayed()) {
                            loggerextent.info("tomcat is running");
                        }

                        if (zone.tssZoneStart(prop.getProperty("TSSzoneURL"))) {
                            loggerextent.info("zone is  accessible");
                        } else {
                            loggerextent.log(Status.FAIL,"Zone is not running deploy  operation not successfull");
                            Assert.fail("Zone is not running deploy  operation not successfull");
                        }
                    }
                    else {
                        loggerextent.log(Status.FAIL,"get status tomcat is failed");
                        Assert.fail("get status tomcat is failed");
                    }

                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"Redeploy with Restart all applications after deploy operation execution status as Failed");
                    Assert.fail("Action is failed");
                }

            }


        }
        catch (org.openqa.selenium.UnhandledAlertException e)
        {

            driver.switchTo().alert().accept();
            loggerextent.log(Status.FAIL,e);
            Assert.assertTrue(false,"e");


        }

        catch (Exception e) {
            loggerextent.log(Status.FAIL,e);
            Assert.assertTrue(false,"e");


        }



    }
    @Test(priority = 8)
    public void scheduleUpdateConfig() {
        try {
            loggerextent=ExtentReport.extent.createTest("TSS Application Schedule update config / graceful restart of webcluster ");
            loggerextent.info("TSS Application Schedule update config / graceful restart of webcluster");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            Application_Container_Operations tss_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            tss_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tss_app_operations.Schedule_update_config_graceful_restart_of_webcluster).click().perform();
            loggerextent.info("Schedule update config / graceful restart of webcluster operation selected");
            tss_app_operations.next_button.click();
            String current_status = tss_app_operations.action_status.getText();
            loggerextent.info("Current  status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Schedule update config / graceful restart of webcluster operation executed ");
                String status=tss_app_operations.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Schedule update config / graceful restart of webcluster operation execution status as Success");
                    tss_app_operations.close_button.click();
                    tss_app_operations.actions.click();
                    ac.moveToElement(tss_app_operations.get_apache_status).click().perform();
                    if(rcc_action.actionStatusSuccess()) {
                        if (tss_app_operations.apache_running_status.isDisplayed()) {
                            loggerextent.info("Apache is running");
                        }

                    }
                    else {
                        loggerextent.log(Status.FAIL,"get status apache is failed");
                        Assert.fail("get status apache is failed");
                    }

                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"Schedule update config / graceful restart of webcluster operation execution status as Failed");
                    Assert.fail("Action is failed");
                }

            }


        }
        catch (org.openqa.selenium.UnhandledAlertException e)
        {

            driver.switchTo().alert().accept();
            loggerextent.log(Status.FAIL,e);
            Assert.assertTrue(false,"e");


        }

        catch (Exception e) {
            loggerextent.log(Status.FAIL,e);
            Assert.assertTrue(false,"e");


        }



    }

}
