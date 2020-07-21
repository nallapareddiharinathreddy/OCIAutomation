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
public class DataBase extends TestBase {

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
            sc.selectByVisibleText("Database");
            //System.out.println(prop.getProperty("TSSApplication") + " Selected successfully");
            search.searchfield.clear();
            search.searchfield.sendKeys(prop.getProperty("Database"));
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
    public void addSchema() {
        try {
            loggerextent= ExtentReport.extent.createTest("DataBase add schema operation");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("DataBase add schema operation started");
            Application_Container_Operations databse = PageFactory.initElements(driver, Application_Container_Operations.class);
            databse.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(databse.add_schema).click().perform();
            loggerextent.info("add schema selected");
            databse.databaseusername.clear();
            databse.databaseusername.sendKeys(prop.getProperty("Schemaname"));
            databse.next_button.click();
            databse.next_button.click();
            databse.next_button.click();
            databse.dump_file.clear();
            databse.dump_file.sendKeys(prop.getProperty("dumpfile"));
            rcc_action.actionWait();
            databse.radio_button.click();
            databse.next_button.click();
            databse.next_button.click();
            if (zone.maintainance())
            {
                databse.yes_option.click();
                databse.next_button.click();

            }
            String current_status = databse.action_status.getText();
            loggerextent.info("Current  status :" + current_status);
            if(rcc_action.dbActionStatusNotRunning())
            {
                loggerextent.info("Add schema operation executed ");
                String status=databse.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("Add schema operation execution status as Success");

                        if (databse.db_add_schema_success.isDisplayed()) {
                            loggerextent.info("Add schema is successful");
                        } else {
                            loggerextent.log(Status.FAIL,"Add schema is failed");
                            Assert.fail("Add schema is failed");
                        }


                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"Add schema operation execution status as Failed");
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
