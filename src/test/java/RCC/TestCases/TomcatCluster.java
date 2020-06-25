package RCC.TestCases;

import RCC.pagefactory.Application_Container_Operations;
import RCC.pagefactory.Component_Search;
import RCC.pagefactory.TomcatClusterPage;
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
public class TomcatCluster extends TestBase {
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
            sc.selectByVisibleText("Tomcat Cluster");
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
    public void tomcatStop() {
        try {
            loggerextent= ExtentReport.extent.createTest("Tomcat Cluster:Tomcat Operations Stop ");
            loggerextent.info("Tomcat stop  operation started");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            TomcatClusterPage tomcat = PageFactory.initElements(driver, TomcatClusterPage.class);
            tomcat.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tomcat.tomcat_Operations).click().perform();
            tomcat.stop.click();
            loggerextent.info("Stop operation selected");
            tomcat.next_button.click();
            tomcat.next_button.click();
            tomcat.waiting_time.clear();
            tomcat.waiting_time.sendKeys("25");
            tomcat.comments.clear();
            tomcat.comments.sendKeys("Rcc execution");
            tomcat.next_button.click();
            if (zone.maintainance())
            {
                tomcat.yes_option.click();
                tomcat.next_button.click();

            }
            String current_status = tomcat.action_status.getText();
            loggerextent.info("Current  status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Stop operation executed ");
                String status=tomcat.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Stop operation execution status as Success");
                    tomcat.close_button.click();
                    tomcat.actions.click();
                    ac.moveToElement(tomcat.get_tomcat_status).click().perform();
                    if(rcc_action.actionStatusSuccess())
                    {
                        if (tomcat.tomcat_app_stop_status.isDisplayed()) {
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

    @Test(priority = 5)
    public void tomcatStart()
    {
        try {
            loggerextent=ExtentReport.extent.createTest("Tomcat Cluster:Tomcat Operations Start");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Tomcat Operations Start started");
            TomcatClusterPage tomcat = PageFactory.initElements(driver, TomcatClusterPage.class);
            tomcat.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tomcat.tomcat_Operations).click().perform();
            tomcat.start.click();
            loggerextent.info(" Start operation Selected");
            tomcat.next_button.click();
            tomcat.next_button.click();
            tomcat.next_button.click();
            tomcat.waiting_time.clear();
            tomcat.waiting_time.sendKeys("25");
            tomcat.comments.clear();
            tomcat.comments.sendKeys("Rcc execution");
            tomcat.next_button.click();
            if (zone.maintainance())
            {
                tomcat.yes_option.click();
                tomcat.next_button.click();

            }
            String current_status = tomcat.action_status.getText();
            loggerextent.info("Current  status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Start operation executed");
                String status=tomcat.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Start operation execution status as Success");
                    tomcat.close_button.click();
                    tomcat.actions.click();
                    ac.moveToElement(tomcat.get_tomcat_status).click().perform();
                    if(rcc_action.actionStatusSuccess()) {
                        if (tomcat.tomcat_app_start_status.isDisplayed()) {
                            loggerextent.info("tomcat is running");
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
    public void tomcatreStart()
    {
        try
        {
            loggerextent=ExtentReport.extent.createTest("Tomcat Cluster:Tomcat Operations Restart");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Tomcat Operations Restart started");
            TomcatClusterPage tomcat = PageFactory.initElements(driver, TomcatClusterPage.class);
            tomcat.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tomcat.tomcat_Operations).click().perform();
            tomcat.restart.click();
            loggerextent.info(" Restart operation Selected");
            tomcat.next_button.click();
            tomcat.next_button.click();
            tomcat.next_button.click();
            tomcat.waiting_time.clear();
            tomcat.waiting_time.sendKeys("25");
            tomcat.comments.clear();
            tomcat.comments.sendKeys("Rcc execution");
            tomcat.next_button.click();
            if (zone.maintainance())
            {
                tomcat.yes_option.click();
                tomcat.next_button.click();

            }
            String current_status = tomcat.action_status.getText();
            loggerextent.info("Current  status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("restart operation executed");
                String status=tomcat.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Restart operation execution status as Success");
                    tomcat.close_button.click();
                    tomcat.actions.click();
                    ac.moveToElement(tomcat.get_tomcat_status).click().perform();
                    if(rcc_action.actionStatusSuccess()) {
                        if (tomcat.tomcat_app_start_status.isDisplayed()) {
                            loggerextent.info("tomcat is started");
                        }
                    }
                    else {
                        loggerextent.log(Status.FAIL,"get status tomcat is failed");
                        Assert.fail("get status tomcat is failed");
                    }

                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"ReStart operation execution status as failed");
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
    public void tomcatDumpThreads() {
        try
        {
            loggerextent=ExtentReport.extent.createTest("Tomcat Cluster:Tomcat Operations  DumpThreads ");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Tomcat Operations  DumpThreads started");
            TomcatClusterPage tomcat = PageFactory.initElements(driver, TomcatClusterPage.class);
            tomcat.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tomcat.tomcat_Operations).click().perform();
            tomcat.dump_threads.click();
            loggerextent.info(" Dump threads operation Selected");
            tomcat.next_button.click();
            tomcat.dump_thread_number.clear();
            tomcat.dump_thread_number.sendKeys(prop.getProperty("dumpthreadscount"));
            tomcat.dump_thread_interval_in_seconds.clear();
            tomcat.dump_thread_interval_in_seconds.sendKeys(prop.getProperty("TimeIntervalbetweeneachdump"));
            tomcat.dump_thread_email.clear();
            tomcat.dump_thread_email.sendKeys(prop.getProperty("Email"));
            tomcat.next_button.click();
            tomcat.next_button.click();
            tomcat.waiting_time.clear();
            tomcat.waiting_time.sendKeys("25");
            tomcat.comments.clear();
            tomcat.comments.sendKeys("Rcc execution");
            tomcat.next_button.click();
            if (zone.maintainance())
            {
                tomcat.yes_option.click();
                tomcat.next_button.click();

            }
            String current_status = tomcat.action_status.getText();
            loggerextent.info("Current  status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Dump threads operation executed");
                String status=tomcat.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("dump thread operation executed successfully");
                    if(wait.until(ExpectedConditions.textToBePresentInElement(tomcat.action_status, "Success"))) {
                        if (tomcat.tomcat_dump_thread_success.isDisplayed()) {
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
    public void tomcatHardStop()
    {
        try
        {
            loggerextent=ExtentReport.extent.createTest("Tomcat Cluster:Tomcat Operations HardStop");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Tomcat Operations HardStop started");
            TomcatClusterPage tomcat = PageFactory.initElements(driver, TomcatClusterPage.class);
            tomcat.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tomcat.tomcat_Operations).click().perform();
            tomcat.hard_Stop.click();
            loggerextent.info(" Hardstop operation Selected");
            tomcat.next_button.click();
            tomcat.next_button.click();
            tomcat.waiting_time.clear();
            tomcat.waiting_time.sendKeys("25");
            tomcat.comments.clear();
            tomcat.comments.sendKeys("Rcc execution");
            tomcat.next_button.click();
            String current_status = tomcat.action_status.getText();
            loggerextent.info("Current  status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Hardstop operation executed");
                String status = tomcat.action_status.getText();
                if (status.equalsIgnoreCase("Success")) {
                    loggerextent.info("HardStop operation execution status as Success");
                    tomcat.close_button.click();
                    tomcat.actions.click();
                    ac.moveToElement(tomcat.get_tomcat_status).click().perform();
                    if(rcc_action.actionStatusSuccess()) {
                        if (tomcat.tomcat_app_stop_status.isDisplayed()) {
                            loggerextent.info("tomcat is stopped");
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
    @Test
    public void scheduleUpdateConfig() {
        try {
            loggerextent=ExtentReport.extent.createTest("Tomcat cluster Schedule update config / graceful restart of webcluster ");
            loggerextent.info("Tomcat cluster Schedule update config / graceful restart of webcluster");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            TomcatClusterPage tomcat = PageFactory.initElements(driver, TomcatClusterPage.class);
            tomcat.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tomcat.Schedule_update_config_graceful_restart_of_webcluster).click().perform();
            loggerextent.info("Schedule update config / graceful restart of webcluster operation selected");
            tomcat.next_button.click();
            String current_status = tomcat.action_status.getText();
            loggerextent.info("Current  status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Schedule update config / graceful restart of webcluster operation executed ");
                String status=tomcat.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Schedule update config / graceful restart of webcluster operation execution status as Success");
                    tomcat.close_button.click();
                    tomcat.actions.click();
                    ac.moveToElement(tomcat.get_apache_status).click().perform();
                    if(rcc_action.actionStatusSuccess()) {
                        if (tomcat.apache_running_status.isDisplayed()) {
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
    @Test
    public void deployTomcatCLuster() {
        try {
            loggerextent=ExtentReport.extent.createTest("Deploy tomcat cluster ");
            loggerextent.info("Deploy tomcat cluster");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            TomcatClusterPage tomcat = PageFactory.initElements(driver, TomcatClusterPage.class);
            tomcat.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tomcat.deploy_tomcat_cluster).click().perform();
            loggerextent.info("Deploy tomcat cluster operation selected");
            tomcat.next_button.click();
            tomcat.force_reinstall_apps.click();
            loggerextent.info("Force re-install of all applications (to use when installation is broken) option selected");
            tomcat.restart_after_deploy.click();
            loggerextent.info("Restart tomcat after deploy option selected");
            tomcat.next_button.click();
            if (zone.maintainance())
            {
                tomcat.yes_option.click();
                tomcat.next_button.click();

            }
            String current_status = tomcat.action_status.getText();
            loggerextent.info("Current  status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("tomcat cluster deploy  with Restart all applications and force reinstall  operation executed ");
                String status=tomcat.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("tomcat cluster deploy  with Restart all applications and force reinstall operation execution status as Success");
                    tomcat.close_button.click();
                    tomcat.actions.click();
                    ac.moveToElement(tomcat.get_tomcat_status).click().perform();
                    if(rcc_action.actionStatusSuccess()) {
                        if (tomcat.tomcat_app_start_status.isDisplayed()) {
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
                    loggerextent.log(Status.FAIL,"tomcat cluster deploy  with Restart all applications and force reinstall operation execution status as Failed");
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
