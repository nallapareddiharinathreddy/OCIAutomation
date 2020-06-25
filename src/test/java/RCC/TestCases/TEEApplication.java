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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(RCC.utils.ExtentReport.class)
public class TEEApplication extends TestBase {

    ZoneRunningStatus zone=new ZoneRunningStatus();
    ActionStatus rcc_action=new ActionStatus();


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
    @Test(priority = 2)
    public void deployRestartAllApps() {
        try {
            loggerextent= ExtentReport.extent.createTest("TEE Application redeploy with all application restart and webcluster");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("TEE Application deploy operation started");
            Application_Container_Operations tee = PageFactory.initElements(driver, Application_Container_Operations.class);
            tee.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tee.Deploy_Application).click().perform();
            loggerextent.info("deploy operation selected");
            tee.next_button.click();
            tee.next_button.click();
            tee.restart_allapps.click();
            loggerextent.info("Restart all applications after deploy option selected");
            tee.gracefully_restart_webcluster.click();
            loggerextent.info("gracefully restart webcluster option selected");
            tee.next_button.click();
            tee.next_button.click();
            if (zone.maintainance())
            {
                tee.yes_option.click();
                tee.next_button.click();

            }
            String current_status = tee.action_status.getText();
            loggerextent.info("Current  status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("deploy  operation executed ");
                String status=tee.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("deploy operation execution status as Success");
                    tee.close_button.click();
                    tee.actions.click();
                    ac.moveToElement(tee.get_status_tee_appcontainer).click().perform();
                    if(rcc_action.actionStatusSuccess())
                    {
                        if (tee.tee_app_start_status.isDisplayed()) {
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
                    loggerextent.log(Status.FAIL,"Deploy operation execution status as Failed");
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

    @Test(priority = 1)
    public void deployForceReInstallofApps() {
        try {
            loggerextent= ExtentReport.extent.createTest("TEE Application redeploy with Forcefull resintall of all applicaitons");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("TEE Application deploy operation started");
            Application_Container_Operations tee = PageFactory.initElements(driver, Application_Container_Operations.class);
            tee.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tee.Deploy_Application).click().perform();
            loggerextent.info("deploy operation selected");
            tee.next_button.click();
            tee.next_button.click();
            tee.force_reinstall_of_apps.click();
            loggerextent.info("Forcefull resintall of all applicaitons option selected");
            tee.next_button.click();
            tee.next_button.click();
            if (zone.maintainance())
            {
                tee.yes_option.click();
                tee.next_button.click();

            }
            String current_status = tee.action_status.getText();
            loggerextent.info("Current  status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("deploy  operation executed ");
                String status=tee.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("deploy operation execution status as Success");
                    tee.close_button.click();
                    tee.actions.click();
                    ac.moveToElement(tee.get_status_tee_appcontainer).click().perform();
                    if(rcc_action.actionStatusSuccess())
                    {
                        if (tee.tee_app_stop_status.isDisplayed()) {
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
                    loggerextent.log(Status.FAIL,"Deploy operation execution status as Failed");
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
