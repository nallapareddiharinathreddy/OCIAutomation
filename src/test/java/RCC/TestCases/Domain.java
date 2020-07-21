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
public class Domain extends TestBase {
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
            sc.selectByVisibleText("Domain");
            //System.out.println(prop.getProperty("TSSApplication") + " Selected successfully");
            search.searchfield.clear();
            search.searchfield.sendKeys(prop.getProperty("Domain"));
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
    public void deployDomain() {
        try {
            loggerextent= ExtentReport.extent.createTest("Deploy domain operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("deploy domain operation started");
            Application_Container_Operations domain = PageFactory.initElements(driver, Application_Container_Operations.class);
            domain.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(domain.deploy_domain).click().perform();
            loggerextent.info("deploy domain selected");
            domain.next_button.click();
            domain.restart_allapps.click();
            domain.next_button.click();
            domain.next_button.click();
            if (zone.maintainance())
            {
                domain.yes_option.click();
                domain.next_button.click();
            }
            String current_status = domain.action_status.getText();
            loggerextent.info("Current  status :" + current_status);
            if(rcc_action.dbActionStatusNotRunning())
            {
                loggerextent.info("Deploy domain operation executed ");
                String status=domain.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("deploy domain operation execution status as Success");

                    if (domain.deploy_domain_success.isDisplayed()) {
                        loggerextent.info("Deploy domain is successful");
                    } else {
                        loggerextent.log(Status.FAIL,"Deploy domain is failed");
                        Assert.fail("Deploy domain is failed");
                    }
                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"Deploy domain operation execution status as Failed");
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
