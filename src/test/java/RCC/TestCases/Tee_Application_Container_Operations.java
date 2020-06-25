package RCC.TestCases;

import RCC.pagefactory.Application_Container_Operations;
import RCC.pagefactory.Component_Search;
import RCC.testBase.TestBase;
import RCC.utils.ZoneRunningStatus;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;
import RCC.utils.*;


@Listeners(RCC.utils.ExtentReport.class)
public class Tee_Application_Container_Operations extends TestBase {

    ZoneRunningStatus zone=new ZoneRunningStatus();
    ActionStatus rcc_action=new ActionStatus();
    //public ExtentTest log;


    @BeforeClass
    public void teeComponentSearch()
    {
        WebDriverWait wait=new WebDriverWait(driver,600);

        try {
            Component_Search search = PageFactory.initElements(driver, Component_Search.class);
            search.components.click();
            Select sc = new Select(search.Component_type);
            sc.selectByVisibleText("TEE Application");
            System.out.println(prop.getProperty("TEEApplication") + " Selected successfully");
            search.searchfield.clear();
            search.searchfield.sendKeys(prop.getProperty("TEEApplication"));
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
    public void Tee_application_Stop() {
        try {
            loggerextent=ExtentReport.extent.createTest("TEE Application container Stop operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("TEE Application container stop operation started");
            Application_Container_Operations tee_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            tee_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tee_app_operations.application_container_operations).click().perform();
            tee_app_operations.stop.click();
            loggerextent.info("Stop operation selected");
            tee_app_operations.next_button.click();
            tee_app_operations.next_button.click();
            tee_app_operations.waiting_time.clear();
            tee_app_operations.waiting_time.sendKeys("25");
            tee_app_operations.comments.clear();
            tee_app_operations.comments.sendKeys("Rcc execution");
            tee_app_operations.next_button.click();
            if (zone.maintainance())
            {
                tee_app_operations.yes_option.click();
                tee_app_operations.next_button.click();

            }
            String current_status = tee_app_operations.action_status.getText();
            loggerextent.info("Current  status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Stop operation executed ");
                String status=tee_app_operations.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Stop operation execution status as Success");
                    tee_app_operations.close_button.click();
                    tee_app_operations.actions.click();
                    ac.moveToElement(tee_app_operations.get_status_tee_appcontainer).click().perform();
                    if(rcc_action.actionStatusSuccess())
                    {
                        if (tee_app_operations.tee_app_stop_status.isDisplayed()) {
                            loggerextent.info("manageed server is stopped");
                        } else {
                            loggerextent.log(Status.FAIL,"manageed server is not stopped");
                            Assert.fail("manageed server is not stopped");
                        }
                    }

                    if(zone.zoneStop(prop.getProperty("TEEzoneURL")))
                    {
                        loggerextent.info("zone is not accessible");
                    }
                    else
                    {
                        loggerextent.log(Status.FAIL,"Zone is running  stop operation not successfull");
                        Assert.fail("Zone is running  stop operation not successfull");
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

    @Test(priority =6)
    public void Tee_application_Start()
    {
        try {
            //gerextent=ExtentReport.loggerextent;
            loggerextent=ExtentReport.extent.createTest("TEE Application container Start operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("TEE Application container Start operation started");
            Application_Container_Operations tee_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            tee_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tee_app_operations.application_container_operations).click().perform();
            tee_app_operations.start.click();
            loggerextent.info("Start operation selected");
            tee_app_operations.next_button.click();
            tee_app_operations.next_button.click();
            tee_app_operations.waiting_time.clear();
            tee_app_operations.waiting_time.sendKeys("25");
            tee_app_operations.comments.clear();
            tee_app_operations.comments.sendKeys("Rcc execution");
            tee_app_operations.next_button.click();
            if(zone.maintainance()) {
                tee_app_operations.yes_option.click();
                tee_app_operations.next_button.click();
            }
            String current_status = tee_app_operations.action_status.getText();
            loggerextent.info("Current status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Start operation executed");
                String status=tee_app_operations.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Start operation execution status as Success");
                    tee_app_operations.close_button.click();
                    tee_app_operations.actions.click();
                    ac.moveToElement(tee_app_operations.get_status_tee_appcontainer).click().perform();
                    if(rcc_action.actionStatusSuccess())
                    {
                        if (tee_app_operations.tee_app_start_status.isDisplayed()) {
                            loggerextent.info("node manager is running");
                        }
                        if (zone.teezonestatus(prop.getProperty("TEEzoneURL"))) {
                            loggerextent.info("zone is  accessible");
                        } else {
                            loggerextent.log(Status.FAIL,"Zone is not running n start  operation not successfull");
                            Assert.fail("Zone is not running node manager start  operation not successfull");
                        }
                    }
                    else {
                        loggerextent.log(Status.FAIL,"get status application container operation failed");
                        Assert.fail("get status application container operation failed");
                    }


                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"Start operation execution status as Failed");
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

    @Test (priority = 2)
    public void Tee_application_reStart()
    {
        try
        {
            loggerextent=ExtentReport.extent.createTest("TEE Application container Restart operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("TEE Application container Restart operation started");
            Application_Container_Operations tee_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            tee_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tee_app_operations.application_container_operations).click().perform();
            tee_app_operations.restart.click();
            loggerextent.info("Restart operation selected");
            tee_app_operations.next_button.click();
            tee_app_operations.next_button.click();
            tee_app_operations.waiting_time.clear();
            tee_app_operations.waiting_time.sendKeys("25");
            tee_app_operations.comments.clear();
            tee_app_operations.comments.sendKeys("Rcc execution");
            tee_app_operations.next_button.click();
            if(zone.maintainance())
            {
                tee_app_operations.yes_option.click();
                tee_app_operations.next_button.click();

            }
            String current_status = tee_app_operations.action_status.getText();
            loggerextent.info("Current status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Restart operation executed");
                String status=tee_app_operations.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Restart operation execution status as Success");
                    tee_app_operations.close_button.click();
                    tee_app_operations.actions.click();
                    ac.moveToElement(tee_app_operations.get_status_tee_appcontainer).click().perform();
                    if(rcc_action.actionStatusSuccess())
                    {
                        if (tee_app_operations.tee_app_start_status.isDisplayed()) {
                           loggerextent.info("node manager  is restarted");
                        }
                        if (zone.teezonestatus(prop.getProperty("TEEzoneURL"))) {
                            loggerextent.info("zone is  accessible");
                        } else {
                            loggerextent.log(Status.FAIL,"Zone is not running  restart  operation not successfull");
                            Assert.fail("Zone is not running  restart  operation not successfull");
                        }
                    }
                    else {
                        loggerextent.log(Status.FAIL,"get status application container operation failed");
                        Assert.fail("get status application container operation failed");
                    }

                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"Restart operation execution status as Failed");
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

    @Test (priority = 3)
    public void Tee_application_dump_Threads() {
        try
        {
            loggerextent=ExtentReport.extent.createTest("TEE Application container DumpThreads operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("TEE Application container Dump Threads operation started");
            Application_Container_Operations tee_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            tee_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tee_app_operations.application_container_operations).click().perform();
            tee_app_operations.dump_threads.click();
            loggerextent.info("Dump Threads operation selected");
            tee_app_operations.next_button.click();
            tee_app_operations.dump_thread_number.clear();
            tee_app_operations.dump_thread_number.sendKeys(prop.getProperty("dumpthreadscount"));
            tee_app_operations.dump_thread_interval_in_seconds.clear();
            tee_app_operations.dump_thread_interval_in_seconds.sendKeys(prop.getProperty("TimeIntervalbetweeneachdump"));
            tee_app_operations.dump_thread_email.clear();
            tee_app_operations.dump_thread_email.sendKeys(prop.getProperty("Email"));
            tee_app_operations.next_button.click();
            tee_app_operations.next_button.click();
            tee_app_operations.waiting_time.clear();
            tee_app_operations.waiting_time.sendKeys("25");
            tee_app_operations.comments.clear();
            tee_app_operations.comments.sendKeys("Rcc execution");
            tee_app_operations.next_button.click();
            if(zone.maintainance())
            {
                tee_app_operations.yes_option.click();
                tee_app_operations.next_button.click();

            }
            String current_status = tee_app_operations.action_status.getText();
            loggerextent.info("Current status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Dump Threads operation executed");
                String status=tee_app_operations.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Dump Threads operation execution status as Success");
                    wait.until(ExpectedConditions.textToBePresentInElement(tee_app_operations.action_status, "Success"));
                    if (tee_app_operations.tss_dump_thread_success.isDisplayed()) {
                        loggerextent.info("dump thread is executed successfully and dump is sent to :" + prop.getProperty("Email"));

                    }

                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"Dump Threads operation execution status as Failed");
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
    public void Tee_application_rolling_Restart()
    {
        wait=new WebDriverWait(driver,3600);
        try
        {
            loggerextent=ExtentReport.extent.createTest("TEE Application container rolling restart operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("TEE Application container rolling restart operation started");
            Application_Container_Operations tee_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            tee_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tee_app_operations.application_container_operations).click().perform();
            tee_app_operations.rolling_restart.click();
            loggerextent.info("Rolling restart operation selected");
            tee_app_operations.next_button.click();
            tee_app_operations.next_button.click();
            tee_app_operations.waiting_time.clear();
            tee_app_operations.waiting_time.sendKeys("25");
            tee_app_operations.comments.clear();
            tee_app_operations.comments.sendKeys("Rcc execution");
            tee_app_operations.next_button.click();
            if(zone.maintainance())
            {
                tee_app_operations.yes_option.click();
                tee_app_operations.next_button.click();

            }
            String current_status = tee_app_operations.action_status.getText();
            loggerextent.info("Current status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("rolling restart operation executed");
                String status=tee_app_operations.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Rolling Restart operation execution status as Success");
                    tee_app_operations.close_button.click();
                    tee_app_operations.actions.click();
                    ac.moveToElement(tee_app_operations.get_status_tee_appcontainer).click().perform();
                    if(rcc_action.actionStatusSuccess()) {
                        if (tee_app_operations.tee_app_start_status.isDisplayed()) {
                            loggerextent.info("node manager  is restarted ");

                        }

                        if (zone.teezonestatus(prop.getProperty("TEEzoneURL"))) {
                           loggerextent.info("zone is  accessible");
                        } else {
                            loggerextent.log(Status.FAIL,"Zone is not running  rolling restart  operation not successfull");
                            Assert.fail("Zone is not running  rolling restart  operation not successfull");
                        }
                    }
                    else {
                        loggerextent.log(Status.FAIL,"get status application container operation failed");
                        Assert.fail("get status application container operation failed");
                    }

                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"Rolling restart operation execution status as Failed");
                    Assert.assertTrue(false);

                }
            }
            else
            {
                loggerextent.log(Status.FAIL,"Rolling restart operation is taking more time");
                Assert.assertTrue(false);
            }

        }
        catch (org.openqa.selenium.UnhandledAlertException e)
        {

            driver.switchTo().alert().accept();
            loggerextent.log(Status.FAIL,e);
            Assert.assertTrue(false,"e");


        }
        catch (Exception e) {
            System.out.println("Exception is " + e);
            loggerextent.log(Status.FAIL,e);
            Assert.assertTrue(false,"e");

        }
    }

 @Test(priority = 5)
    public void Tee_application_hard_Stop()
 {
     try
     {
         loggerextent=ExtentReport.extent.createTest("TEE Application container HardStop operation");
         loggerextent.assignCategory("SmokeTesting");
         loggerextent.assignAuthor("Harinathreddy");
         loggerextent.info("TEE Application container HardStop operation started");
         Application_Container_Operations tee_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
         tee_app_operations.actions.click();
         Actions ac = new Actions(driver);
         ac.moveToElement(tee_app_operations.application_container_operations).click().perform();
         tee_app_operations.hard_Stop.click();
         loggerextent.info("Hard Stop operation selected");
         tee_app_operations.next_button.click();
         tee_app_operations.next_button.click();
         tee_app_operations.waiting_time.clear();
         tee_app_operations.waiting_time.sendKeys("25");
         tee_app_operations.comments.clear();
         tee_app_operations.comments.sendKeys("Rcc execution");
         tee_app_operations.next_button.click();
         if(zone.maintainance())
         {
             tee_app_operations.yes_option.click();
             tee_app_operations.next_button.click();

         }
         String current_status = tee_app_operations.action_status.getText();
         loggerextent.info("Current status :" + current_status);
         if(rcc_action.actionStatusNotRunning())
         {
             loggerextent.info("HardStop operation executed");
             String status = tee_app_operations.action_status.getText();
             if (status.equalsIgnoreCase("Success"))
             {
                 loggerextent.info("Hard stop operation execution status as Success");
                 tee_app_operations.close_button.click();
                 tee_app_operations.actions.click();
                 ac.moveToElement(tee_app_operations.get_status_tee_appcontainer).click().perform();
                 if(rcc_action.actionStatusSuccess()) {
                     if (tee_app_operations.tee_app_stop_status.isDisplayed()) {
                         loggerextent.info("node manager is stopped");
                     }
                     if (zone.zoneStop(prop.getProperty("TEEzoneURL"))) {
                         loggerextent.info("zone is not accessible");

                     } else {
                         loggerextent.log(Status.FAIL,"Zone is running hardstop operation not successfull");
                         Assert.fail("Zone is running node manager hardstop operation not successfull");

                     }

                 }
                 else {
                     loggerextent.log(Status.FAIL,"get status application container operation failed");
                     Assert.fail("get status application container operation failed");
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
    public void Tee_application_Suspend() {
        try {
            loggerextent=ExtentReport.extent.createTest("TEE Application container Suspend operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("TEE Application container Suspend operation started");
            Application_Container_Operations tee_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            tee_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tee_app_operations.application_container_operations).click().perform();
            tee_app_operations.Suspend.click();
            loggerextent.info("Suspend operation selected");
            tee_app_operations.next_button.click();
            tee_app_operations.next_button.click();
            tee_app_operations.waiting_time.clear();
            tee_app_operations.waiting_time.sendKeys("25");
            tee_app_operations.comments.clear();
            tee_app_operations.comments.sendKeys("Rcc execution");
            tee_app_operations.next_button.click();
            if(zone.maintainance())
            {
                tee_app_operations.yes_option.click();
                tee_app_operations.next_button.click();

            }
            String current_status = tee_app_operations.action_status.getText();
           loggerextent.info("Current  status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Suspend operation executed");
                String status=tee_app_operations.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Suspend operation execution status as Success");
                    tee_app_operations.close_button.click();
                    /* tee_app_operations.actions.click();
                    ac.moveToElement(tee_app_operations.get_status_tee_appcontainer).click().perform();
                    if(wait.until(ExpectedConditions.textToBePresentInElement(tee_app_operations.action_status, "Success")))
                    {
                        if (tee_app_operations.tee_app_stop_status.isDisplayed()) {
                            System.out.println("manageed server is stopped");
                            Assert.assertTrue(true);
                        } else {

                            Assert.fail("manageed server is not stopped");
                        }
                    }
                    else {

                        Assert.fail("get status application container operation failed");
                    }
            */
                    //zone.zoneStop(prop.getProperty("TEEzoneURL"));
                    if(zone.zoneStop(prop.getProperty("TEEzoneURL")))
                    {
                        loggerextent.info("zone is not accessible: Suspend operation is succesful");
                        //Assert.assertTrue(true);
                    }
                    else
                    {
                        loggerextent.log(Status.FAIL,"one is running suspend operation not successfull");
                        Assert.fail("Zone is running suspend operation not successfull");
                    }
                    //Assert.assertEquals("Success",Status);
                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"Suspend operation execution status as Failed");
                    Assert.fail("Action is failed");


                }

            }
        }
        catch (org.openqa.selenium.UnhandledAlertException e)
        {

            driver.switchTo().alert().accept();
            loggerextent.log(Status.FAIL,e);
            Assert.assertTrue(false,"e");


        }catch (Exception e) {
            loggerextent.log(Status.FAIL,e);
            Assert.assertTrue(false,"e");


        }



    }
    @Test(priority =8)
    public void Tee_application_Resume()
    {
        try {
            loggerextent=ExtentReport.extent.createTest("TEE Application container Resume operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("TEE Application container Resume operation started");
            Application_Container_Operations tee_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            tee_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tee_app_operations.application_container_operations).click().perform();
            tee_app_operations.Resume.click();
            loggerextent.info("Resume operation selected");
            tee_app_operations.next_button.click();
            tee_app_operations.next_button.click();
            tee_app_operations.waiting_time.clear();
            tee_app_operations.waiting_time.sendKeys("25");
            tee_app_operations.comments.clear();
            tee_app_operations.comments.sendKeys("Rcc execution");
            tee_app_operations.next_button.click();
            if(zone.maintainance())
            {
                tee_app_operations.yes_option.click();
                tee_app_operations.next_button.click();

            }
            String current_status = tee_app_operations.action_status.getText();
            loggerextent.info("Current status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Resume operation executed");
                String status=tee_app_operations.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Resume operation execution status as Success");
                    tee_app_operations.close_button.click();
                    /* tee_app_operations.actions.click();
                    ac.moveToElement(tee_app_operations.get_tomcat_status_new).click().perform();
                    if(wait.until(ExpectedConditions.textToBePresentInElement(tee_app_operations.action_status, "Success"))) {
                        if (tee_app_operations.tss_app_start_status.isDisplayed()) {
                            System.out.println("tomcat is running");
                            Assert.assertTrue(true);
                        } */
                        if (zone.teezonestatus(prop.getProperty("TEEzoneURL"))) {
                            loggerextent.info("zone is  accessible : Resume operation is successful");
                        } else {
                            loggerextent.log(Status.FAIL,"Zone is not running resume   operation not successfull");
                            Assert.fail("Zone is not running resume   operation not successfull");
                        }


                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"Resume operation execution status as Failed");
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
