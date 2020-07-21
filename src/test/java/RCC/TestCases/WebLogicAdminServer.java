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
public class WebLogicAdminServer extends TestBase {
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
            sc.selectByVisibleText("WebLogic Cluster (Admin Server)");
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
    public void stopWebLogicCluster() {
        try {
            loggerextent= ExtentReport.extent.createTest("Stop WebLogic Cluster operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Stop WebLogic Cluster operation started");
            Application_Container_Operations weblogicadminserver = PageFactory.initElements(driver, Application_Container_Operations.class);
            weblogicadminserver.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(weblogicadminserver.stop_WebLogic_Cluster).click().perform();
            loggerextent.info("Stop WebLogic Cluster operation selected");
            weblogicadminserver.next_button.click();
            if (zone.maintainance())
            {
                weblogicadminserver.yes_option.click();
                weblogicadminserver.next_button.click();

            }
            String current_status = weblogicadminserver.action_status.getText();
            loggerextent.info("Current  status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Stop WebLogic Cluster operation executed ");
                String status=weblogicadminserver.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Stop WebLogic Cluster operation execution status as Success");
                    weblogicadminserver.close_button.click();
                    weblogicadminserver.actions.click();
                    ac.moveToElement(weblogicadminserver.weblogic_admin_server_status).click().perform();
                    weblogicadminserver.next_button.click();
                    if(rcc_action.actionStatusSuccess())
                    {
                        if (weblogicadminserver.admin_server_stop_status.isDisplayed()) {
                            loggerextent.info("admin server stopped");
                        } else {
                            loggerextent.log(Status.FAIL,"admin server is not stopped");
                            Assert.fail("admin server is not stopped");
                        }
                    }

                    if(zone.zoneStop(prop.getProperty("TEEzoneURL")))
                    {
                        loggerextent.info("zone is not accessible");
                    }
                    else
                    {
                        loggerextent.log(Status.FAIL,"Zone is running  Stop WebLogic Cluster operation not successfull");
                        Assert.fail("Zone is running  Stop WebLogic Cluster operation not successfull");
                    }

                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"Stop WebLogic Cluster operation execution status as Failed");
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
    public void startWebLogicCluster()
    {
        try {
            //gerextent=ExtentReport.loggerextent;
            loggerextent=ExtentReport.extent.createTest("Start WebLogic Cluster operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Start WebLogic Cluster operation started");
            Application_Container_Operations weblogicadminserver = PageFactory.initElements(driver, Application_Container_Operations.class);
            weblogicadminserver.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(weblogicadminserver.start_WebLogic_Cluster).click().perform();
            loggerextent.info("Start WebLogic Cluster operation selected");
            weblogicadminserver.next_button.click();
            if(zone.maintainance()) {
                weblogicadminserver.yes_option.click();
                weblogicadminserver.next_button.click();
            }
            String current_status = weblogicadminserver.action_status.getText();
            loggerextent.info("Current status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Start WebLogic Cluster operation executed");
                String status=weblogicadminserver.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Start WebLogic Cluster operation execution status as Success");
                    weblogicadminserver.close_button.click();
                    weblogicadminserver.actions.click();
                    ac.moveToElement(weblogicadminserver.weblogic_admin_server_status).click().perform();
                    weblogicadminserver.next_button.click();
                    if(rcc_action.actionStatusSuccess())
                    {
                        if (weblogicadminserver.admin_server_start_status.isDisplayed()) {
                            loggerextent.info("admin server is running");
                        }
                        if (zone.teezonestatus(prop.getProperty("TEEzoneURL"))) {
                            loggerextent.info("zone is  accessible");
                        } else {
                            loggerextent.log(Status.FAIL,"Zone is not running  start WebLogic Cluster  operation not successfull");
                            Assert.fail("Zone is not running  start  operation not successfull");
                        }
                    }
                    else {
                        loggerextent.log(Status.FAIL,"get status  operation failed");
                        Assert.fail("get status  operation failed");
                    }


                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"Start WebLogic Cluster operation execution status as Failed");
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
    public void reStartWebLogicCluster()
    {
        try {
            //gerextent=ExtentReport.loggerextent;
            loggerextent=ExtentReport.extent.createTest("Restart WebLogic Cluster operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Restart WebLogic Cluster operation started");
            Application_Container_Operations weblogicadminserver = PageFactory.initElements(driver, Application_Container_Operations.class);
            weblogicadminserver.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(weblogicadminserver.restart_WebLogic_Cluster).click().perform();
            loggerextent.info("Restart WebLogic Cluster operation selected");
            weblogicadminserver.next_button.click();
            if(zone.maintainance()) {
                weblogicadminserver.yes_option.click();
                weblogicadminserver.next_button.click();
            }
            String current_status = weblogicadminserver.action_status.getText();
            loggerextent.info("Current status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Restart WebLogic Cluster operation executed");
                String status=weblogicadminserver.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Restart WebLogic Cluster operation execution status as Success");
                    weblogicadminserver.close_button.click();
                    weblogicadminserver.actions.click();
                    ac.moveToElement(weblogicadminserver.weblogic_admin_server_status).click().perform();
                    weblogicadminserver.next_button.click();
                    if(rcc_action.actionStatusSuccess())
                    {
                        if (weblogicadminserver.admin_server_start_status.isDisplayed()) {
                            loggerextent.info("admin server is running");
                        }
                        if (zone.teezonestatus(prop.getProperty("TEEzoneURL"))) {
                            loggerextent.info("zone is  accessible");
                        } else {
                            loggerextent.log(Status.FAIL,"Zone is not running  restart  operation not successfull");
                            Assert.fail("Zone is not running  restart  operation not successfull");
                        }
                    }
                    else {
                        loggerextent.log(Status.FAIL,"get status  operation failed");
                        Assert.fail("get status  operation failed");
                    }


                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"Restart WebLogic Cluster operation execution status as Failed");
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
    @Test(priority = 4)
    public void stopAdminServer() {
        try {
            loggerextent= ExtentReport.extent.createTest("Stop Admin Server operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Stop Admin Server operation started");
            Application_Container_Operations weblogicadminserver = PageFactory.initElements(driver, Application_Container_Operations.class);
            weblogicadminserver.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(weblogicadminserver.stop_Admin_Server).click().perform();
            loggerextent.info("Stop Admin Server operation selected");
            weblogicadminserver.next_button.click();
            if (zone.maintainance())
            {
                weblogicadminserver.yes_option.click();
                weblogicadminserver.next_button.click();

            }
            String current_status = weblogicadminserver.action_status.getText();
            loggerextent.info("Current  status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Stop Admin Server operation executed ");
                String status=weblogicadminserver.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Stop Admin Server operation execution status as Success");
                    weblogicadminserver.close_button.click();
                    weblogicadminserver.actions.click();
                    ac.moveToElement(weblogicadminserver.weblogic_admin_server_status).click().perform();
                    weblogicadminserver.next_button.click();
                    if(rcc_action.actionStatusSuccess())
                    {
                        if (weblogicadminserver.admin_server_stop_status.isDisplayed()) {

                            loggerextent.info("admin server stopped");
                        } else {
                            loggerextent.log(Status.FAIL,"admin server is not stopped");
                            Assert.fail("admin server is not stopped");
                        }
                    }
                    else {
                        loggerextent.log(Status.FAIL,"get status  operation failed");
                        Assert.fail("get status  operation failed");
                    }



                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"Stop Admin Server operation execution status as Failed");
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
    public void startAdminServer()
    {
        try {
            //gerextent=ExtentReport.loggerextent;
            loggerextent=ExtentReport.extent.createTest("Start Admin Server operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Start Admin Server operation started");
            Application_Container_Operations weblogicadminserver = PageFactory.initElements(driver, Application_Container_Operations.class);
            weblogicadminserver.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(weblogicadminserver.start_Admin_Server).click().perform();
            loggerextent.info("Start Admin Server operation selected");
            weblogicadminserver.next_button.click();
            if(zone.maintainance()) {
                weblogicadminserver.yes_option.click();
                weblogicadminserver.next_button.click();
            }
            String current_status = weblogicadminserver.action_status.getText();
            loggerextent.info("Current status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Start Admin Server operation executed");
                String status=weblogicadminserver.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Start Admin Server operation execution status as Success");
                    weblogicadminserver.close_button.click();
                    weblogicadminserver.actions.click();
                    ac.moveToElement(weblogicadminserver.weblogic_admin_server_status).click().perform();
                    weblogicadminserver.next_button.click();
                    if(rcc_action.actionStatusSuccess())
                    {
                        if (weblogicadminserver.admin_server_start_status.isDisplayed()) {
                            loggerextent.info("admin server is running");
                        }
                        else {
                            loggerextent.log(Status.FAIL,"admin server is stopped");
                            Assert.fail("admin server is stopped");
                        }
                    }
                    else {
                        loggerextent.log(Status.FAIL,"get status  operation failed");
                        Assert.fail("get status  operation failed");
                    }


                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"Start Admin Server operation execution status as Failed");
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
    public void reStartAdminServer()
    {
        try {
            //gerextent=ExtentReport.loggerextent;
            loggerextent=ExtentReport.extent.createTest("Restart Admin Server operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Restart Admin Server operation started");
            Application_Container_Operations weblogicadminserver = PageFactory.initElements(driver, Application_Container_Operations.class);
            weblogicadminserver.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(weblogicadminserver.restart_Admin_Server).click().perform();
            loggerextent.info("Restart Admin Server operation selected");
            weblogicadminserver.next_button.click();
            if(zone.maintainance()) {
                weblogicadminserver.yes_option.click();
                weblogicadminserver.next_button.click();
            }
            String current_status = weblogicadminserver.action_status.getText();
            loggerextent.info("Current status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Restart Admin Server operation executed");
                String status=weblogicadminserver.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Restart Admin Server operation execution status as Success");
                    weblogicadminserver.close_button.click();
                    weblogicadminserver.actions.click();
                    ac.moveToElement(weblogicadminserver.weblogic_admin_server_status).click().perform();
                    weblogicadminserver.next_button.click();
                    if(rcc_action.actionStatusSuccess())
                    {
                        if (weblogicadminserver.admin_server_start_status.isDisplayed()) {
                            loggerextent.info("admin server is running");
                        }
                         else {
                            loggerextent.log(Status.FAIL,"admin server is stopped");
                            Assert.fail("admin server is stopped");
                        }
                    }
                    else {
                        loggerextent.log(Status.FAIL,"get status  operation failed");
                        Assert.fail("get status  operation failed");
                    }


                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"Restart Admin Server operation execution status as Failed");
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
    @Test(priority = 7)
    public void addContainer()
    {
        try {
            //gerextent=ExtentReport.loggerextent;
            loggerextent=ExtentReport.extent.createTest("weblogic cluster Add container operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Add container operation started");
            Application_Container_Operations weblogicadminserver = PageFactory.initElements(driver, Application_Container_Operations.class);
            weblogicadminserver.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(weblogicadminserver.add_remove_containers).click().perform();
            weblogicadminserver.add_container.click();
            loggerextent.info("Add container operation selected");
            weblogicadminserver.next_button.click();
            weblogicadminserver.container_number.clear();
            weblogicadminserver.container_number.sendKeys("1");
            weblogicadminserver.server_name.clear();
            weblogicadminserver.server_name.sendKeys(prop.getProperty("ContainerServer"));
            weblogicadminserver.container_checkbox.click();
            weblogicadminserver.next_button.click();
            weblogicadminserver.next_button.click();
            if(zone.maintainance()) {
                weblogicadminserver.yes_option.click();
                weblogicadminserver.next_button.click();
            }
            String current_status = weblogicadminserver.action_status.getText();
            loggerextent.info("Current status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Add container operation executed");
                String status=weblogicadminserver.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Add container operation execution status as Success");
                    weblogicadminserver.close_button.click();
                    weblogicadminserver.actions.click();
                    ac.moveToElement(weblogicadminserver.weblogic_admin_server_status).click().perform();
                    weblogicadminserver.next_button.click();
                    if(rcc_action.actionStatusSuccess())
                    {
                        if (weblogicadminserver.admin_server_start_status.isDisplayed()) {
                            loggerextent.info("admin server is running");
                        }
                        else {
                            loggerextent.log(Status.FAIL,"admin server is stopped");
                            Assert.fail("admin server is stopped");
                        }
                    }
                    else {
                        loggerextent.log(Status.FAIL,"get status  operation failed");
                        Assert.fail("get status  operation failed");
                    }


                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"Restart Admin Server operation execution status as Failed");
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
    public void removeContainer()
    {
        try {
            //gerextent=ExtentReport.loggerextent;
            loggerextent=ExtentReport.extent.createTest("weblogic cluster remove container operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Remove container operation started");
            Application_Container_Operations weblogicadminserver = PageFactory.initElements(driver, Application_Container_Operations.class);
            weblogicadminserver.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(weblogicadminserver.add_remove_containers).click().perform();
            weblogicadminserver.remove_container.click();
            loggerextent.info("Remove container operation selected");
            weblogicadminserver.next_button.click();
            weblogicadminserver.container_number.clear();
            weblogicadminserver.container_number.sendKeys("1");
            weblogicadminserver.server_name.clear();
            weblogicadminserver.server_name.sendKeys(prop.getProperty("ContainerServer"));
            weblogicadminserver.container_checkbox.click();
            weblogicadminserver.next_button.click();
            weblogicadminserver.next_button.click();
            if(zone.maintainance()) {
                weblogicadminserver.yes_option.click();
                weblogicadminserver.next_button.click();
            }
            String current_status = weblogicadminserver.action_status.getText();
            loggerextent.info("Current status :" + current_status);
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Add container operation executed");
                String status=weblogicadminserver.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Add container operation execution status as Success");
                    weblogicadminserver.close_button.click();
                    weblogicadminserver.actions.click();
                    ac.moveToElement(weblogicadminserver.weblogic_admin_server_status).click().perform();
                    weblogicadminserver.next_button.click();
                    if(rcc_action.actionStatusSuccess())
                    {
                        if (weblogicadminserver.admin_server_start_status.isDisplayed()) {
                            loggerextent.info("admin server is running");
                        }
                        else {
                            loggerextent.log(Status.FAIL,"admin server is stopped");
                            Assert.fail("admin server is stopped");
                        }
                    }
                    else {
                        loggerextent.log(Status.FAIL,"get status  operation failed");
                        Assert.fail("get status  operation failed");
                    }


                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"Restart Admin Server operation execution status as Failed");
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
