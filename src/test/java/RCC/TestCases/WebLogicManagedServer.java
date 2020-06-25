package RCC.TestCases;

import RCC.pagefactory.Application_Container_Operations;
import RCC.pagefactory.Component_Search;
import RCC.testBase.TestBase;
import RCC.utils.ActionStatus;
import RCC.utils.ExtentReport;
import RCC.utils.ZoneRunningStatus;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(RCC.utils.ExtentReport.class)
public class WebLogicManagedServer extends TestBase {

    ZoneRunningStatus zone=new ZoneRunningStatus();
    ActionStatus rcc_action=new ActionStatus();

    @BeforeClass
    public void tomcatClusterComponentSearch()
    {
        WebDriverWait wait=new WebDriverWait(driver,600);

        try {
            Component_Search search = PageFactory.initElements(driver, Component_Search.class);
            search.components.click();
            Select sc = new Select(search.Component_type);
            sc.selectByVisibleText("WebLogic Managed Server");
            //System.out.println(prop.getProperty("TSSApplication") + " Selected successfully");
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
    public void weblogicManagerServerStop() {
        try {
            loggerextent= ExtentReport.extent.createTest("Weblogic Managed server Application container Stop operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Weblogic Managed server Application container stop operation started");
            Application_Container_Operations weblogicmanagedserver = PageFactory.initElements(driver, Application_Container_Operations.class);
            weblogicmanagedserver.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(weblogicmanagedserver.application_container_operations).click().perform();
            weblogicmanagedserver.stop.click();
            loggerextent.info("Stop operation selected");
            weblogicmanagedserver.next_button.click();
            weblogicmanagedserver.next_button.click();
            weblogicmanagedserver.waiting_time.clear();
            weblogicmanagedserver.waiting_time.sendKeys("25");
            weblogicmanagedserver.comments.clear();
            weblogicmanagedserver.comments.sendKeys("Rcc execution");
            weblogicmanagedserver.next_button.click();
            if (zone.maintainance())
            {
                weblogicmanagedserver.yes_option.click();
                weblogicmanagedserver.next_button.click();

            }
            String current_status = weblogicmanagedserver.action_status.getText();
            loggerextent.info("Current  status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Stop operation executed ");
                String status=weblogicmanagedserver.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Stop operation execution status as Success");
                    weblogicmanagedserver.close_button.click();
                    weblogicmanagedserver.actions.click();
                    ac.moveToElement(weblogicmanagedserver.weblogic_managed_server_status).click().perform();
                    weblogicmanagedserver.next_button.click();
                    if(rcc_action.actionStatusSuccess())
                    {
                        if (weblogicmanagedserver.tee_app_stop_status.isDisplayed()) {
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
    public void weblogicManagerServerStart()
    {
        try {
            //gerextent=ExtentReport.loggerextent;
            loggerextent=ExtentReport.extent.createTest("Weblogic Managed server Application container Start operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Weblogic Managed server Application container Start operation started");
            Application_Container_Operations weblogicmanagedserver = PageFactory.initElements(driver, Application_Container_Operations.class);
            weblogicmanagedserver.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(weblogicmanagedserver.application_container_operations).click().perform();
            weblogicmanagedserver.start.click();
            loggerextent.info("Start operation selected");
            weblogicmanagedserver.next_button.click();
            weblogicmanagedserver.next_button.click();
            weblogicmanagedserver.waiting_time.clear();
            weblogicmanagedserver.waiting_time.sendKeys("25");
            weblogicmanagedserver.comments.clear();
            weblogicmanagedserver.comments.sendKeys("Rcc execution");
            weblogicmanagedserver.next_button.click();
            if(zone.maintainance()) {
                weblogicmanagedserver.yes_option.click();
                weblogicmanagedserver.next_button.click();
            }
            String current_status = weblogicmanagedserver.action_status.getText();
            loggerextent.info("Current status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Start operation executed");
                String status=weblogicmanagedserver.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Start operation execution status as Success");
                    weblogicmanagedserver.close_button.click();
                    weblogicmanagedserver.actions.click();
                    ac.moveToElement(weblogicmanagedserver.weblogic_managed_server_status).click().perform();
                    weblogicmanagedserver.next_button.click();
                    if(rcc_action.actionStatusSuccess())
                    {
                        if (weblogicmanagedserver.tee_app_start_status.isDisplayed()) {
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

    @Test (priority = 3)
    public void weblogicManagerServerreStart()
    {
        try
        {
            loggerextent=ExtentReport.extent.createTest("Weblogic Managed server Application container Restart operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Weblogic Managed server Application container Restart operation started");
            Application_Container_Operations weblogicmanagedserver = PageFactory.initElements(driver, Application_Container_Operations.class);
            weblogicmanagedserver.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(weblogicmanagedserver.application_container_operations).click().perform();
            weblogicmanagedserver.restart.click();
            loggerextent.info("Restart operation selected");
            weblogicmanagedserver.next_button.click();
            weblogicmanagedserver.next_button.click();
            weblogicmanagedserver.waiting_time.clear();
            weblogicmanagedserver.waiting_time.sendKeys("25");
            weblogicmanagedserver.comments.clear();
            weblogicmanagedserver.comments.sendKeys("Rcc execution");
            weblogicmanagedserver.next_button.click();
            if(zone.maintainance())
            {
                weblogicmanagedserver.yes_option.click();
                weblogicmanagedserver.next_button.click();

            }
            String current_status = weblogicmanagedserver.action_status.getText();
            loggerextent.info("Current status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Restart operation executed");
                String status=weblogicmanagedserver.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Restart operation execution status as Success");
                    weblogicmanagedserver.close_button.click();
                    weblogicmanagedserver.actions.click();
                    ac.moveToElement(weblogicmanagedserver.weblogic_managed_server_status).click().perform();
                    weblogicmanagedserver.next_button.click();
                    if(rcc_action.actionStatusSuccess())
                    {
                        if (weblogicmanagedserver.tee_app_start_status.isDisplayed()) {
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

    @Test (priority = 4)
    public void weblogicManagerServerdump_Threads() {
        try
        {
            loggerextent=ExtentReport.extent.createTest("Weblogic Managed server Application container DumpThreads operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Weblogic Managed server Application container Dump Threads operation started");
            Application_Container_Operations weblogicmanagedserver = PageFactory.initElements(driver, Application_Container_Operations.class);
            weblogicmanagedserver.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(weblogicmanagedserver.application_container_operations).click().perform();
            weblogicmanagedserver.dump_threads.click();
            loggerextent.info("Dump Threads operation selected");
            weblogicmanagedserver.next_button.click();
            weblogicmanagedserver.dump_thread_number.clear();
            weblogicmanagedserver.dump_thread_number.sendKeys(prop.getProperty("dumpthreadscount"));
            weblogicmanagedserver.dump_thread_interval_in_seconds.clear();
            weblogicmanagedserver.dump_thread_interval_in_seconds.sendKeys(prop.getProperty("TimeIntervalbetweeneachdump"));
            weblogicmanagedserver.dump_thread_email.clear();
            weblogicmanagedserver.dump_thread_email.sendKeys(prop.getProperty("Email"));
            weblogicmanagedserver.next_button.click();
            weblogicmanagedserver.next_button.click();
            weblogicmanagedserver.waiting_time.clear();
            weblogicmanagedserver.waiting_time.sendKeys("25");
            weblogicmanagedserver.comments.clear();
            weblogicmanagedserver.comments.sendKeys("Rcc execution");
            weblogicmanagedserver.next_button.click();
            if(zone.maintainance())
            {
                weblogicmanagedserver.yes_option.click();
                weblogicmanagedserver.next_button.click();

            }
            String current_status = weblogicmanagedserver.action_status.getText();
            loggerextent.info("Current status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Dump Threads operation executed");
                String status=weblogicmanagedserver.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Dump Threads operation execution status as Success");
                    wait.until(ExpectedConditions.textToBePresentInElement(weblogicmanagedserver.action_status, "Success"));
                    if (weblogicmanagedserver.tss_dump_thread_success.isDisplayed()) {
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



    @Test(priority = 5)
    public void weblogicManagerServerHardStop()
    {
        try
        {
            loggerextent=ExtentReport.extent.createTest("Weblogic Managed server Application container HardStop operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Weblogic Managed server Application container HardStop operation started");
            Application_Container_Operations weblogicmanagedserver = PageFactory.initElements(driver, Application_Container_Operations.class);
            weblogicmanagedserver.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(weblogicmanagedserver.application_container_operations).click().perform();
            weblogicmanagedserver.hard_Stop.click();
            loggerextent.info("Hard Stop operation selected");
            weblogicmanagedserver.next_button.click();
            weblogicmanagedserver.next_button.click();
            weblogicmanagedserver.waiting_time.clear();
            weblogicmanagedserver.waiting_time.sendKeys("25");
            weblogicmanagedserver.comments.clear();
            weblogicmanagedserver.comments.sendKeys("Rcc execution");
            weblogicmanagedserver.next_button.click();
            if(zone.maintainance())
            {
                weblogicmanagedserver.yes_option.click();
                weblogicmanagedserver.next_button.click();

            }
            String current_status = weblogicmanagedserver.action_status.getText();
            loggerextent.info("Current status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("HardStop operation executed");
                String status = weblogicmanagedserver.action_status.getText();
                if (status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Hard stop operation execution status as Success");
                    weblogicmanagedserver.close_button.click();
                    weblogicmanagedserver.actions.click();
                    ac.moveToElement(weblogicmanagedserver.weblogic_managed_server_status).click().perform();
                    weblogicmanagedserver.next_button.click();
                    if(rcc_action.actionStatusSuccess()) {
                        if (weblogicmanagedserver.tee_app_stop_status.isDisplayed()) {
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
    public void weblogicManagerServerSuspend() {
        try {
            loggerextent=ExtentReport.extent.createTest("weblogicManagerServer Application container Suspend operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("weblogicManagerServer Application container Suspend operation started");
            Application_Container_Operations weblogicmanagedserver = PageFactory.initElements(driver, Application_Container_Operations.class);
            weblogicmanagedserver.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(weblogicmanagedserver.application_container_operations).click().perform();
            weblogicmanagedserver.Suspend.click();
            loggerextent.info("Suspend operation selected");
            weblogicmanagedserver.next_button.click();
            weblogicmanagedserver.next_button.click();
            weblogicmanagedserver.waiting_time.clear();
            weblogicmanagedserver.waiting_time.sendKeys("25");
            weblogicmanagedserver.comments.clear();
            weblogicmanagedserver.comments.sendKeys("Rcc execution");
            weblogicmanagedserver.next_button.click();
            if(zone.maintainance())
            {
                weblogicmanagedserver.yes_option.click();
                weblogicmanagedserver.next_button.click();

            }
            String current_status = weblogicmanagedserver.action_status.getText();
            loggerextent.info("Current  status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Suspend operation executed");
                String status=weblogicmanagedserver.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Suspend operation execution status as Success");
                    weblogicmanagedserver.close_button.click();
                    /* weblogicmanagedserver.actions.click();
                    ac.moveToElement(weblogicmanagedserver.weblogic_managed_server_status).click().perform();
                    if(wait.until(ExpectedConditions.textToBePresentInElement(weblogicmanagedserver.action_status, "Success")))
                    {
                        if (weblogicmanagedserver.tee_app_stop_status.isDisplayed()) {
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
    public void weblogicManagerServerResume()
    {
        try {
            loggerextent=ExtentReport.extent.createTest("Weblogic Managed server Application container Resume operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Weblogic Managed server Application container Resume operation started");
            Application_Container_Operations weblogicmanagedserver = PageFactory.initElements(driver, Application_Container_Operations.class);
            weblogicmanagedserver.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(weblogicmanagedserver.application_container_operations).click().perform();
            weblogicmanagedserver.Resume.click();
            loggerextent.info("Resume operation selected");
            weblogicmanagedserver.next_button.click();
            weblogicmanagedserver.next_button.click();
            weblogicmanagedserver.waiting_time.clear();
            weblogicmanagedserver.waiting_time.sendKeys("25");
            weblogicmanagedserver.comments.clear();
            weblogicmanagedserver.comments.sendKeys("Rcc execution");
            weblogicmanagedserver.next_button.click();
            if(zone.maintainance())
            {
                weblogicmanagedserver.yes_option.click();
                weblogicmanagedserver.next_button.click();

            }
            String current_status = weblogicmanagedserver.action_status.getText();
            loggerextent.info("Current status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Resume operation executed");
                String status=weblogicmanagedserver.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Resume operation execution status as Success");
                    weblogicmanagedserver.close_button.click();
                    /* weblogicmanagedserver.actions.click();
                    ac.moveToElement(weblogicmanagedserver.get_tomcat_status_new).click().perform();
                    if(wait.until(ExpectedConditions.textToBePresentInElement(weblogicmanagedserver.action_status, "Success"))) {
                        if (weblogicmanagedserver.tss_app_start_status.isDisplayed()) {
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

    @Test(priority =9)
    public void weblogicManagerServerJVMHeapDump()
    {
        try {
            //gerextent=ExtentReport.loggerextent;
            loggerextent=ExtentReport.extent.createTest("Weblogic Managed server JVM Heap Dump operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Weblogic Managed server JVM Heap Dump operation started");
            Application_Container_Operations weblogicmanagedserver = PageFactory.initElements(driver, Application_Container_Operations.class);
            weblogicmanagedserver.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(weblogicmanagedserver.jvm_heap_dump).click().perform();
            loggerextent.info("JVM Heap Dump operation selected");
            weblogicmanagedserver.next_button.click();
            if(zone.maintainance()) {
                weblogicmanagedserver.yes_option.click();
                weblogicmanagedserver.next_button.click();
            }
            String current_status = weblogicmanagedserver.action_status.getText();
            loggerextent.info("Current status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("JVM Heap Dump operation executed");
                String status=weblogicmanagedserver.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("JVM Heap Dump operation execution status as Success");
                    if(weblogicmanagedserver.jvm_heap_dump_created.isDisplayed())
                    {

                            loggerextent.info("JVM Heap Dump  created successfully");

                    }
                    else {
                        loggerextent.log(Status.FAIL,"JVM Heap Dump operation failed");
                        Assert.fail("JVM Heap Dump operation failed");
                    }


                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"JVM Heap Dump operation execution status as Failed");
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
    @Test(priority =2)
    public void weblogicManagerServerDeleteWlStatusFile()
    {
        try {
            //gerextent=ExtentReport.loggerextent;
            loggerextent=ExtentReport.extent.createTest("Weblogic Managed server delete weblogic status file operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Weblogic Managed server delete weblogic status file operation started");
            Application_Container_Operations weblogicmanagedserver = PageFactory.initElements(driver, Application_Container_Operations.class);
            weblogicmanagedserver.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(weblogicmanagedserver.delete_WebLogic_status_file).click().perform();
            loggerextent.info("delete weblogic status file operation selected");
            weblogicmanagedserver.next_button.click();
            if(zone.maintainance()) {
                weblogicmanagedserver.yes_option.click();
                weblogicmanagedserver.next_button.click();
            }
            String current_status = weblogicmanagedserver.action_status.getText();
            loggerextent.info("Current status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("delete weblogic status file operation executed");
                String status=weblogicmanagedserver.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("delete weblogic status file operation execution status as Success");
                    if(weblogicmanagedserver.delete_weblogic_status_success.isDisplayed())
                    {

                        loggerextent.info(" weblogic status file deleted successfully");

                    }
                    else {
                        loggerextent.log(Status.FAIL,"delete weblogic status file operation failed");
                        Assert.fail("delete weblogic status file operation failed");
                    }


                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"delete weblogic status file operation execution status as Failed");
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
    @Test(priority =9)
    public void weblogicManagerServerDeleteLokFile()
    {
        try {
            //gerextent=ExtentReport.loggerextent;
            loggerextent=ExtentReport.extent.createTest("Weblogic Managed server delete WebLogic lok file operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Weblogic Managed server delete WebLogic lok file operation started");
            Application_Container_Operations weblogicmanagedserver = PageFactory.initElements(driver, Application_Container_Operations.class);
            weblogicmanagedserver.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(weblogicmanagedserver.delete_WebLogic_lok_file).click().perform();
            loggerextent.info("delete WebLogic lok file operation selected");
            weblogicmanagedserver.next_button.click();
            if(zone.maintainance()) {
                weblogicmanagedserver.yes_option.click();
                weblogicmanagedserver.next_button.click();
            }
            String current_status = weblogicmanagedserver.action_status.getText();
            loggerextent.info("Current status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("delete WebLogic lok file operation executed");
                String status=weblogicmanagedserver.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("delete WebLogic lok file operation execution status as Success");
                    if(weblogicmanagedserver.delete_weblogic_lok_success.isDisplayed())
                    {

                        loggerextent.info(" weblogic lok file deleted successfully");

                    }
                    else {
                        loggerextent.log(Status.FAIL,"delete WebLogic lok file operation failed");
                        Assert.fail("delete WebLogic lok file operation failed");
                    }


                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"delete WebLogic lok file operation execution status as Failed");
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
