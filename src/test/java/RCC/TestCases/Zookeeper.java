package RCC.TestCases;

import RCC.pagefactory.Component_Search;
import RCC.pagefactory.SolrClusterPage;
import RCC.testBase.TestBase;
import RCC.utils.ActionStatus;
import RCC.utils.ExtentReport;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(RCC.utils.ExtentReport.class)
public class Zookeeper extends TestBase {
    ActionStatus rcc_action=new ActionStatus();

    @BeforeClass
    public void SolrClusterSearch()
    {
        WebDriverWait wait=new WebDriverWait(driver,600);

        try {
            Component_Search search = PageFactory.initElements(driver, Component_Search.class);
            search.components.click();
            Select sc = new Select(search.Component_type);
            sc.selectByVisibleText("ZooKeeper");
            //System.out.println(prop.getProperty("ZooKeeperCluster") + " Selected successfully");
            search.searchfield.clear();
            search.searchfield.sendKeys(prop.getProperty("ZooKeeper"));
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
    @Test(priority = 1)
    public void Status()  {
        try {
            loggerextent = ExtentReport.extent.createTest("ZooKeeper  status  operation ");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("ZooKeeper   Status  operation started");
            SolrClusterPage Zookeepr = PageFactory.initElements(driver, SolrClusterPage.class);
            Zookeepr.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(Zookeepr.get_status).click().perform();
            loggerextent.info("ZooKeeper  Status  operation selected");
            Zookeepr.next_button.click();
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("ZooKeeper  Status operation executed");
                String status=Zookeepr.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {

                    if(Zookeepr.zookeeprStatus()) {

                        loggerextent.info("ZooKeeper  status    operation is successful");

                    }


                    else
                    {
                            loggerextent.log(Status.FAIL, "ZooKeeper  status operation execution  failed");
                            Assert.fail("Action is failed");
                    }
                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"ZooKeeper  Status  execution status as failed");
                    Assert.fail("Action is failed");

                }


            }



        } catch (org.openqa.selenium.UnhandledAlertException e) {

            driver.switchTo().alert().accept();
            loggerextent.log(Status.FAIL, e);
            Assert.assertTrue(false, "e");


        } catch (Exception e) {
            loggerextent.log(Status.FAIL, e);
            Assert.assertTrue(false, "e");


        }


    }
    @Test(priority = 2)
    public void nodeStop()  {
        try {
            loggerextent = ExtentReport.extent.createTest("ZooKeeper  node Stop  operation ");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("ZooKeeper   node stop  operation started");
            SolrClusterPage Zookeepr = PageFactory.initElements(driver, SolrClusterPage.class);
            Zookeepr.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(Zookeepr.ZooKeeper_Node_Operations).click().perform();
            Zookeepr.stop.click();
            loggerextent.info("ZooKeeper  node stop  operation selected");
            Zookeepr.next_button.click();
            Zookeepr.next_button.click();
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("ZooKeeper  node Stop operation executed");
                String status=Zookeepr.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {

                    if(Zookeepr.zookeper_stop.isDisplayed())
                    {
                        loggerextent.info("ZooKeeper  node stop  operation is successful");
                    }





                    else
                    {
                        loggerextent.log(Status.FAIL,"ZooKeeper  node stop operation execution  failed");
                        Assert.fail("Action is failed");
                    }
                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"ZooKeeper  node stop   execution status as failed");
                    Assert.fail("Action is failed");

                }


            }



        } catch (org.openqa.selenium.UnhandledAlertException e) {

            driver.switchTo().alert().accept();
            loggerextent.log(Status.FAIL, e);
            Assert.assertTrue(false, "e");


        } catch (Exception e) {
            loggerextent.log(Status.FAIL, e);
            Assert.assertTrue(false, "e");


        }


    }
    @Test(priority = 3)
    public void nodeStart()  {
        try {
            loggerextent = ExtentReport.extent.createTest("ZooKeeper  node Start  operation ");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("ZooKeeper   node Start  operation started");
            SolrClusterPage Zookeepr = PageFactory.initElements(driver, SolrClusterPage.class);
            Zookeepr.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(Zookeepr.ZooKeeper_Node_Operations).click().perform();
            Zookeepr.start.click();
            loggerextent.info("ZooKeeper  node Start  operation selected");
            Zookeepr.next_button.click();
            Zookeepr.next_button.click();
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("ZooKeeper  node Start operation executed");
                String status=Zookeepr.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    if(Zookeepr.zookeper_start.isDisplayed())
                    {
                        loggerextent.info("ZooKeeper  node Start  operation is successful");
                    }





                    else
                    {
                        loggerextent.log(Status.FAIL,"ZooKeeper  node Start operation execution  failed");
                        Assert.fail("Action is failed");
                    }
                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"ZooKeeper  node Start   execution status as failed");
                    Assert.fail("Action is failed");

                }


            }



        } catch (org.openqa.selenium.UnhandledAlertException e) {

            driver.switchTo().alert().accept();
            loggerextent.log(Status.FAIL, e);
            Assert.assertTrue(false, "e");


        } catch (Exception e) {
            loggerextent.log(Status.FAIL, e);
            Assert.assertTrue(false, "e");


        }


    }
    @Test(priority = 4)
    public void nodeRestart()  {
        try {
            loggerextent = ExtentReport.extent.createTest("ZooKeeper  node restart  operation ");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("ZooKeeper   node restart  operation started");
            SolrClusterPage Zookeepr = PageFactory.initElements(driver, SolrClusterPage.class);
            Zookeepr.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(Zookeepr.ZooKeeper_Node_Operations).click().perform();
            Zookeepr.restart.click();
            loggerextent.info("ZooKeeper  node restart  operation selected");
            Zookeepr.next_button.click();
            Zookeepr.next_button.click();
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("ZooKeeper  node restart operation executed");
                String status=Zookeepr.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {


                        if(Zookeepr.zookeper_stop.isDisplayed()&&Zookeepr.zookeper_start.isDisplayed())
                        {
                            loggerextent.info("ZooKeeper  node restart  operation is successful");
                        }


                    else
                    {
                        loggerextent.log(Status.FAIL,"ZooKeeper  node restart operation execution  failed");
                        Assert.fail("Action is failed");
                    }
                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"ZooKeeper  node restart   execution status as failed");
                    Assert.fail("Action is failed");

                }


            }



        } catch (org.openqa.selenium.UnhandledAlertException e) {

            driver.switchTo().alert().accept();
            loggerextent.log(Status.FAIL, e);
            Assert.assertTrue(false, "e");


        } catch (Exception e) {
            loggerextent.log(Status.FAIL, e);
            Assert.assertTrue(false, "e");


        }


    }
    @Test(priority = 5)
    public void zooKeeperCommandsDump()  {
        try {
            loggerextent = ExtentReport.extent.createTest("ZooKeeper Commands dump operation ");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("ZooKeeper Commands dump  operation started");
            SolrClusterPage Zookeepr = PageFactory.initElements(driver, SolrClusterPage.class);
            Zookeepr.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(Zookeepr.ZooKeeper_Commands).click().perform();
            Zookeepr.dump.click();
            loggerextent.info("ZooKeeper Commands dump  operation selected");
            Zookeepr.next_button.click();
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("ZooKeeper Commands dump operation executed");
                String status=Zookeepr.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    if(Zookeepr.dump())
                    {
                        loggerextent.info("ZooKeeper Commands dump  operation is successful");
                    }


                    else
                    {
                        loggerextent.log(Status.FAIL,"ZooKeeper Commands dump operation execution  failed");
                        Assert.fail("Action is failed");
                    }
                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"ZooKeeper Commands dump  execution status as failed");
                    Assert.fail("Action is failed");

                }


            }



        } catch (org.openqa.selenium.UnhandledAlertException e) {

            driver.switchTo().alert().accept();
            loggerextent.log(Status.FAIL, e);
            Assert.assertTrue(false, "e");


        } catch (Exception e) {
            loggerextent.log(Status.FAIL, e);
            Assert.assertTrue(false, "e");


        }


    }
    @Test(priority = 6)
    public void zooKeeperCommandsEnvi()  {
        try {
            loggerextent = ExtentReport.extent.createTest("ZooKeeper Commands environment operation ");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("ZooKeeper Commands environment  operation started");
            SolrClusterPage Zookeepr = PageFactory.initElements(driver, SolrClusterPage.class);
            Zookeepr.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(Zookeepr.ZooKeeper_Commands).click().perform();
            Zookeepr.envi.click();
            loggerextent.info("ZooKeeper Commands environment  operation selected");
            Zookeepr.next_button.click();
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("ZooKeeper Commands environment operation executed");
                String status=Zookeepr.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    if(Zookeepr.envi())
                    {
                        loggerextent.info("ZooKeeper Commands environment  operation is successful");
                    }


                    else
                    {
                        loggerextent.log(Status.FAIL,"ZooKeeper Commands environment operation execution  failed");
                        Assert.fail("Action is failed");
                    }
                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"ZooKeeper Commands environment  execution status as failed");
                    Assert.fail("Action is failed");

                }


            }



        } catch (org.openqa.selenium.UnhandledAlertException e) {

            driver.switchTo().alert().accept();
            loggerextent.log(Status.FAIL, e);
            Assert.assertTrue(false, "e");


        } catch (Exception e) {
            loggerextent.log(Status.FAIL, e);
            Assert.assertTrue(false, "e");


        }


    }
    @Test(priority = 7)
    public void zooKeeperCommandsSrvr()  {
        try {
            loggerextent = ExtentReport.extent.createTest("ZooKeeper Commands  Lists full details for the server operation ");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("ZooKeeper Commands server  operation started");
            SolrClusterPage Zookeepr = PageFactory.initElements(driver, SolrClusterPage.class);
            Zookeepr.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(Zookeepr.ZooKeeper_Commands).click().perform();
            Zookeepr.srvr.click();
            loggerextent.info("ZooKeeper Commands server  operation selected");
            Zookeepr.next_button.click();
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("ZooKeeper Commands server operation executed");
                String status=Zookeepr.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    if(Zookeepr.srvr())
                    {
                        loggerextent.info("ZooKeeper Commands server  operation is successful");
                    }


                    else
                    {
                        loggerextent.log(Status.FAIL,"ZooKeeper Commands server operation execution  failed");
                        Assert.fail("Action is failed");
                    }
                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"ZooKeeper Commands server  execution status as failed");
                    Assert.fail("Action is failed");

                }


            }



        } catch (org.openqa.selenium.UnhandledAlertException e) {

            driver.switchTo().alert().accept();
            loggerextent.log(Status.FAIL, e);
            Assert.assertTrue(false, "e");


        } catch (Exception e) {
            loggerextent.log(Status.FAIL, e);
            Assert.assertTrue(false, "e");


        }


    }
}
