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
public class WeblogicNodeManager extends TestBase {
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
            sc.selectByVisibleText("WebLogic Node Manager");
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
    public void weblogicNodeManagerStop() {
        try {
            loggerextent= ExtentReport.extent.createTest("Weblogic node manager Stop operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Weblogic node manager Stop operation started");
            Application_Container_Operations weblogicnodemanager = PageFactory.initElements(driver, Application_Container_Operations.class);
            weblogicnodemanager.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(weblogicnodemanager.stop_weblogic_node_manager).click().perform();
            loggerextent.info("Weblogic node manager Stop operation selected");
            weblogicnodemanager.next_button.click();
            if (zone.maintainance())
            {
                weblogicnodemanager.yes_option.click();
                weblogicnodemanager.next_button.click();

            }
            String current_status = weblogicnodemanager.action_status.getText();
            loggerextent.info("Current  status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Stop operation executed ");
                String status=weblogicnodemanager.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Stop operation execution status as Success");
                    weblogicnodemanager.close_button.click();
                    weblogicnodemanager.actions.click();
                    ac.moveToElement(weblogicnodemanager.weblogic_node_manager_status).click().perform();
                    weblogicnodemanager.next_button.click();
                    int k=weblogicnodemanager.weblogicNodeManagerStatus();
                    if(k==1)
                    {
                        loggerextent.info("NodeManager  is running");
                    }
                    else {
                        loggerextent.log(Status.FAIL,"manageed server is not running");
                        Assert.fail("NodeManager  is not running");
                    }

                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"Weblogic node manager Stop operation execution status as Failed");
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
    public void weblogicNodeManagerReStart() {
        try {
            loggerextent= ExtentReport.extent.createTest("Weblogic node manager Restart operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Weblogic node manager Restart operation started");
            Application_Container_Operations weblogicnodemanager = PageFactory.initElements(driver, Application_Container_Operations.class);
            weblogicnodemanager.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(weblogicnodemanager.restart_weblogic_node_manager).click().perform();
            loggerextent.info("Weblogic node manager Restart operation selected");
            weblogicnodemanager.next_button.click();
            if (zone.maintainance())
            {
                weblogicnodemanager.yes_option.click();
                weblogicnodemanager.next_button.click();

            }
            String current_status = weblogicnodemanager.action_status.getText();
            loggerextent.info("Current  status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Restart operation executed ");
                String status=weblogicnodemanager.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("restart operation execution status as Success");
                    weblogicnodemanager.close_button.click();
                    weblogicnodemanager.actions.click();
                    ac.moveToElement(weblogicnodemanager.weblogic_node_manager_status).click().perform();
                    weblogicnodemanager.next_button.click();
                    int k=weblogicnodemanager.weblogicNodeManagerStatus();
                    if(k==1)
                    {
                        loggerextent.info("NodeManager  is running");
                    }
                    else {
                        loggerextent.log(Status.FAIL,"manageed server is not running");
                        Assert.fail("NodeManager  is not running");
                    }

                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"Weblogic node manager restart operation execution status as Failed");
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
    @Test(priority = 3)
    public void weblogicNodeManagerStart() {
        try {
            loggerextent= ExtentReport.extent.createTest("Weblogic node manager start operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Weblogic node manager start operation started");
            Application_Container_Operations weblogicnodemanager = PageFactory.initElements(driver, Application_Container_Operations.class);
            weblogicnodemanager.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(weblogicnodemanager.restart_weblogic_node_manager).click().perform();
            loggerextent.info("Weblogic node manager start operation selected");
            weblogicnodemanager.next_button.click();
            if (zone.maintainance())
            {
                weblogicnodemanager.yes_option.click();
                weblogicnodemanager.next_button.click();

            }
            String current_status = weblogicnodemanager.action_status.getText();
            loggerextent.info("Current  status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("start operation executed ");
                String status=weblogicnodemanager.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("start operation execution status as Success");
                    weblogicnodemanager.close_button.click();
                    weblogicnodemanager.actions.click();
                    ac.moveToElement(weblogicnodemanager.weblogic_node_manager_status).click().perform();
                    weblogicnodemanager.next_button.click();
                    int k=weblogicnodemanager.weblogicNodeManagerStatus();
                    if(k==1)
                    {
                        loggerextent.info("NodeManager  is running");
                    }
                    else {
                        loggerextent.log(Status.FAIL,"manageed server is not running");
                        Assert.fail("NodeManager  is not running");
                    }

                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"Weblogic node manager start operation execution status as Failed");
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
