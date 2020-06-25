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
public class ZookeeperCluster extends TestBase {
    ActionStatus rcc_action=new ActionStatus();

    @BeforeClass
    public void SolrClusterSearch()
    {
        WebDriverWait wait=new WebDriverWait(driver,600);

        try {
            Component_Search search = PageFactory.initElements(driver, Component_Search.class);
            search.components.click();
            Select sc = new Select(search.Component_type);
            sc.selectByVisibleText("ZooKeeper Cluster");
            //System.out.println(prop.getProperty("ZooKeeperCluster") + " Selected successfully");
            search.searchfield.clear();
            search.searchfield.sendKeys(prop.getProperty("ZooKeeperCluster"));
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
            loggerextent = ExtentReport.extent.createTest("ZooKeeper Cluster status  operation ");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("ZooKeeper Cluster  Status  operation started");
            SolrClusterPage Zookeepr = PageFactory.initElements(driver, SolrClusterPage.class);
            Zookeepr.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(Zookeepr.get_status).click().perform();
            loggerextent.info("ZooKeeper Cluster Status  operation selected");
            Zookeepr.next_button.click();
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("ZooKeeper Cluster Status operation executed");
                String status=Zookeepr.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {

                        if(Zookeepr.zookeper_leader.isDisplayed())
                        {
                            int n=Zookeepr.zookperfollower();
                            if(n==2)
                            {
                                loggerextent.info("ZooKeeper Cluster status    operation is successful");
                            }
                        }




                    else
                    {
                        loggerextent.log(Status.FAIL,"ZooKeeper Cluster status operation execution  failed");
                        Assert.fail("Action is failed");
                    }
                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"ZooKeeper Cluster Status  execution status as failed");
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
            loggerextent = ExtentReport.extent.createTest("ZooKeeper Cluster node Stop  operation ");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("ZooKeeper Cluster  node stop  operation started");
            SolrClusterPage Zookeepr = PageFactory.initElements(driver, SolrClusterPage.class);
            Zookeepr.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(Zookeepr.ZooKeeper_Node_Operations).click().perform();
            Zookeepr.stop.click();
            loggerextent.info("ZooKeeper Cluster node stop  operation selected");
            Zookeepr.next_button.click();
            Zookeepr.next_button.click();
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("ZooKeeper Cluster node Stop operation executed");
                String status=Zookeepr.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {

                       int n=Zookeepr.zookperNodeStop();
                        if(n==3)
                        {
                            loggerextent.info("ZooKeeper Cluster node stop  operation is successful");
                        }





                    else
                    {
                        loggerextent.log(Status.FAIL,"ZooKeeper Cluster node stop operation execution  failed");
                        Assert.fail("Action is failed");
                    }
                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"ZooKeeper Cluster node stop   execution status as failed");
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
            loggerextent = ExtentReport.extent.createTest("ZooKeeper Cluster node Start  operation ");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("ZooKeeper Cluster  node Start  operation started");
            SolrClusterPage Zookeepr = PageFactory.initElements(driver, SolrClusterPage.class);
            Zookeepr.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(Zookeepr.ZooKeeper_Node_Operations).click().perform();
            Zookeepr.start.click();
            loggerextent.info("ZooKeeper Cluster node Start  operation selected");
            Zookeepr.next_button.click();
            Zookeepr.next_button.click();
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("ZooKeeper Cluster node Start operation executed");
                String status=Zookeepr.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {

                    int n=Zookeepr.zookperNodeStart();
                    if(n==3)
                    {
                        loggerextent.info("ZooKeeper Cluster node Start  operation is successful");
                    }





                    else
                    {
                        loggerextent.log(Status.FAIL,"ZooKeeper Cluster node Start operation execution  failed");
                        Assert.fail("Action is failed");
                    }
                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"ZooKeeper Cluster node Start   execution status as failed");
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
            loggerextent = ExtentReport.extent.createTest("ZooKeeper Cluster node restart  operation ");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("ZooKeeper Cluster  node restart  operation started");
            SolrClusterPage Zookeepr = PageFactory.initElements(driver, SolrClusterPage.class);
            Zookeepr.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(Zookeepr.ZooKeeper_Node_Operations).click().perform();
            Zookeepr.restart.click();
            loggerextent.info("ZooKeeper Cluster node restart  operation selected");
            Zookeepr.next_button.click();
            Zookeepr.next_button.click();
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("ZooKeeper Cluster node restart operation executed");
                String status=Zookeepr.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    int c=Zookeepr.zookperNodeStop();
                    if(c==3)
                    {
                        int n=Zookeepr.zookperNodeStart();
                        if(n==3)
                        {
                            loggerextent.info("ZooKeeper Cluster node restart  operation is successful");
                        }
                    }

                    else
                    {
                        loggerextent.log(Status.FAIL,"ZooKeeper Cluster node restart operation execution  failed");
                        Assert.fail("Action is failed");
                    }
                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"ZooKeeper Cluster node restart   execution status as failed");
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
