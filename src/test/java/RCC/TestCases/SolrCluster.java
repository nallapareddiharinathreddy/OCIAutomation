package RCC.TestCases;

import RCC.pagefactory.Component_Search;
import RCC.pagefactory.SolrClusterPage;
import RCC.testBase.TestBase;
import RCC.utils.ActionStatus;
import RCC.utils.ExtentReport;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

@Listeners(RCC.utils.ExtentReport.class)
public class SolrCluster extends TestBase {

    ActionStatus rcc_action=new ActionStatus();


    @BeforeClass
    public void SolrClusterSearch()
    {
        WebDriverWait wait=new WebDriverWait(driver,600);

        try {
            Component_Search search = PageFactory.initElements(driver, Component_Search.class);
            search.components.click();
            Select sc = new Select(search.Component_type);
            sc.selectByVisibleText("SOLR Cluster");
            System.out.println(prop.getProperty("SOLR_Cluster") + " Selected successfully");
            search.searchfield.clear();
            search.searchfield.sendKeys(prop.getProperty("SOLR_Cluster"));
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
            Thread.sleep(15000);
            search.component_detail.click();
            Thread.sleep(15000);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }


    }


    @Test(priority = 2)
        public void Start()  {
            try {
                loggerextent = ExtentReport.extent.createTest("Solr Cluster  Start  operation ");
                loggerextent.assignCategory("SmokeTesting");
                loggerextent.assignAuthor("Harinathreddy");
                loggerextent.info("Solr Cluster  Start  operation started");
                SolrClusterPage solr = PageFactory.initElements(driver, SolrClusterPage.class);
                solr.actions.click();
                Actions ac = new Actions(driver);
                ac.moveToElement(solr.SOLR_Control_Operations).click().perform();
                solr.start.click();
                loggerextent.info("start operation selected");
                solr.next_button.click();
                solr.next_button.click();
                if(rcc_action.actionStatusNotRunning())
                {
                    loggerextent.info("start operation executed");
                    String status=solr.action_status.getText();
                    if(status.equalsIgnoreCase("Success"))
                    {
                       int c= solr.Start();
                       if(c==2)
                       {
                           loggerextent.info("start operation is successful");
                       }
                       else
                       {
                           loggerextent.log(Status.FAIL,"Start operation execution  failed");
                           Assert.fail("Action is failed");
                       }
                    }
                    if (status.equalsIgnoreCase("Failed"))
                    {
                        loggerextent.log(Status.FAIL,"Start operation execution status as failed");
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
        @Test(priority = 1)
    public void stop()  {
        try {
            loggerextent = ExtentReport.extent.createTest("Solr Cluster  Stop  operation ");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Solr Cluster  stop  operation started");
            SolrClusterPage solr = PageFactory.initElements(driver, SolrClusterPage.class);
            solr.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(solr.SOLR_Control_Operations).click().perform();
            solr.stop.click();
            loggerextent.info("stop operation selected");
            solr.next_button.click();
            solr.next_button.click();
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("stop operation executed");
                String status=solr.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    int c= solr.Stop();
                    if(c==2)
                    {
                        loggerextent.info("stop operation is successful");
                    }
                    else
                    {
                        loggerextent.log(Status.FAIL,"Start operation execution  failed");
                        Assert.fail("Action is failed");
                    }
                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"Stop operation execution status as failed");
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
    public void reStart()  {
        try {
            loggerextent = ExtentReport.extent.createTest("Solr Cluster  restart  operation ");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Solr Cluster  ReStart  operation started");
            SolrClusterPage solr = PageFactory.initElements(driver, SolrClusterPage.class);
            solr.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(solr.SOLR_Control_Operations).click().perform();
            solr.restart.click();
            loggerextent.info("restart operation selected");
            solr.next_button.click();
            solr.next_button.click();
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("restart operation executed");
                String status=solr.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    int c= solr.Stop();
                    if(c==2)
                    {
                        int k=solr.Start();
                        if(k==2) {

                            loggerextent.info("restart operation is successful");
                        }
                        else
                        {
                            loggerextent.log(Status.FAIL,"restart operation execution  failed");
                            Assert.fail("Action is failed");

                        }
                    }
                    else
                    {
                        loggerextent.log(Status.FAIL,"restart operation execution  failed");
                        Assert.fail("Action is failed");
                    }
                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"restart operation execution status as failed");
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
    public void Status()  {
        try {
            loggerextent = ExtentReport.extent.createTest("Solr Cluster  status  operation ");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Solr Cluster  Status  operation started");
            SolrClusterPage solr = PageFactory.initElements(driver, SolrClusterPage.class);
            solr.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(solr.SOLR_Control_Operations).click().perform();
            solr.status.click();
            loggerextent.info("Status operation selected");
            solr.next_button.click();
            solr.next_button.click();
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Status operation executed");
                String status=solr.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    int c= solr.Status();
                    if(c==2)
                    {
                            loggerextent.info("Status operation is successful");
                    }
                    else
                    {
                        loggerextent.log(Status.FAIL,"Status operation execution  failed");
                        Assert.fail("Action is failed");
                    }
                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"Status operation execution status as failed");
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
    public void clusterState()  {
        try {
            loggerextent = ExtentReport.extent.createTest("Solr Cluster  state  operation ");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Solr Cluster  state  operation started");
            SolrClusterPage solr = PageFactory.initElements(driver, SolrClusterPage.class);
            solr.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(solr.SOLR_Control_Operations).click().perform();
            solr.clusterState.click();
            loggerextent.info("cluster state  operation selected");
            solr.next_button.click();
            solr.next_button.click();
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("cluster state operation executed");
                String status=solr.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    int c= solr.ClusterState();
                    if(c==2)
                    {
                        loggerextent.info("cluster state  operation is successful");
                    }
                    else
                    {
                        loggerextent.log(Status.FAIL,"Cluster state operation execution  failed");
                        Assert.fail("Action is failed");
                    }
                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"Cluster state  operation execution status as failed");
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
    public void solrInfo()  {
        try {
            loggerextent = ExtentReport.extent.createTest("Solr info   operation ");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Solr Cluster info  operation started");
            SolrClusterPage solr = PageFactory.initElements(driver, SolrClusterPage.class);
            solr.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(solr.SOLR_Control_Operations).click().perform();
            solr.solrinfo.click();
            loggerextent.info("solr info operation selected");
            solr.next_button.click();
            solr.next_button.click();
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("solr info operation executed");
                String status=solr.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    int c= solr.info();
                    if(c==2)
                    {
                        loggerextent.info("solr info operation is successful");
                    }
                    else
                    {
                        loggerextent.log(Status.FAIL,"solr info operation execution  failed");
                        Assert.fail("Action is failed");
                    }
                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"solr info operation execution status as failed");
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
    public void printSolrCommand()  {
        try {
            loggerextent = ExtentReport.extent.createTest("Solr Cluster  print solr command  operation ");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Solr Cluster  print solr command  operation started");
            SolrClusterPage solr = PageFactory.initElements(driver, SolrClusterPage.class);
            solr.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(solr.SOLR_Control_Operations).click().perform();
            solr.solr_Command.click();
            loggerextent.info("print solr command operation selected");
            solr.next_button.click();
            solr.next_button.click();
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("print solr command operation executed");
                String status=solr.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    int c= solr.printSolrCommand();
                    if(c==2)
                    {
                        loggerextent.info("print solr command operation is successful");
                    }
                    else
                    {
                        loggerextent.log(Status.FAIL,"print solr command operation execution  failed");
                        Assert.fail("Action is failed");
                    }
                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"print solr command  execution status as failed");
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
    @Test(priority = 9)
    public void SolrStatus()  {
        try {
            loggerextent = ExtentReport.extent.createTest("Solr Cluster  Status  operation ");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Solr Cluster  Status  operation started");
            SolrClusterPage solr = PageFactory.initElements(driver, SolrClusterPage.class);
            solr.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(solr.get_status).click().perform();
            loggerextent.info("Status  operation selected");
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("Status operation executed");
                String status=solr.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    int c= solr.Status();
                    if(c==2)
                    {
                        if(solr.zookeper_leader.isDisplayed())
                        {
                            int n=solr.zookperfollower();
                            if(n==2)
                            {
                                loggerextent.info("Status   operation is successful");
                            }
                        }

                    }
                    else
                    {
                        loggerextent.log(Status.FAIL,"status operation execution  failed");
                        Assert.fail("Action is failed");
                    }
                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"Status solr and zookeper execution status as failed");
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
    @Test(priority = 8)
    public void deployCluster()  {
        try {
            loggerextent = ExtentReport.extent.createTest("Solr Cluster  deploy  operation ");
            loggerextent.assignCategory("SmokeTesting");
            loggerextent.assignAuthor("Harinathreddy");
            loggerextent.info("Solr Cluster  deploy  operation started");
            SolrClusterPage solr = PageFactory.initElements(driver, SolrClusterPage.class);
            solr.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(solr.deploy).click().perform();
            solr.next_button.click();
            loggerextent.info("deploy  operation selected");
            if(rcc_action.actionStatusNotRunning())
            {
                loggerextent.info("deploy operation executed");
                String status=solr.action_status.getText();
                if(status.equalsIgnoreCase("Success"))
                {
                    loggerextent.info("deploy   operation is successful");

                }
                if (status.equalsIgnoreCase("Failed"))
                {
                    loggerextent.log(Status.FAIL,"deploy execution status as failed");
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
