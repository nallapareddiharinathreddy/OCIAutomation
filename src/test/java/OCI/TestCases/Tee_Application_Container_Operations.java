package OCI.TestCases;

import OCI.pagefactory.Application_Container_Operations;
import OCI.pagefactory.Component_Search;
import OCI.testBase.TestBase;
import OCI.utils.Listener;
import OCI.utils.ZoneRunningStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


@Listeners(Listener.class)

public class Tee_Application_Container_Operations extends TestBase {

    Application_Container_Operations tee_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
    ZoneRunningStatus zone=new ZoneRunningStatus();


    @BeforeClass
    public void teeComponentSearch()
    {
        WebDriverWait wait=new WebDriverWait(driver,600);

        try {
            //Login.login();
            Component_Search search = PageFactory.initElements(driver, Component_Search.class);
            search.components.click();
            Select sc = new Select(search.Component_type);
            sc.selectByVisibleText("TEE Application");
            System.out.println(prop.getProperty("TSSApplication") + " Selected successfully");
            search.searchfield.clear();
            search.searchfield.sendKeys(prop.getProperty("TEEApplication"));
            Select sc1 = new Select(search.search_type);
            sc1.selectByVisibleText("All of these words");
            search.search_button.click();
            search.component_detail.click();

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
            search.component_detail.click();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }


    }
    @Test(priority = 1)
    public void Tee_application_Stop() {
        try {
            Application_Container_Operations tee_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            tee_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tee_app_operations.application_container_operations).click().perform();
            tee_app_operations.stop.click();
            tee_app_operations.next_button.click();
            tee_app_operations.next_button.click();
            tee_app_operations.waiting_time.clear();
            tee_app_operations.waiting_time.sendKeys("25");
            tee_app_operations.comments.clear();
            tee_app_operations.comments.sendKeys("Rcc execution");
            tee_app_operations.next_button.click();
            /*if(tee_app_operations.yes_option.isDisplayed())
            {
                tee_app_operations.yes_option.click();
                tee_app_operations.next_button.click();

            } */
            String current_status = tee_app_operations.action_status.getText();
            System.out.println("Current  status :" + current_status);
            if(wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("__status"),"Running...")))
            {
                String Status=tee_app_operations.action_status.getText();
                if(Status.equalsIgnoreCase("Success"))
                {
                    System.out.println("Stop operation executed successfully");
                    tee_app_operations.close_button.click();
                    tee_app_operations.actions.click();
                    ac.moveToElement(tee_app_operations.get_status_tee_appcontainer).click().perform();
                    if(wait.until(ExpectedConditions.textToBePresentInElement(tee_app_operations.action_status, "Success")))
                    {
                        if (tee_app_operations.tee_app_stop_status.isDisplayed()) {
                            System.out.println("manageed server is stopped");
                            Assert.assertTrue(true);
                        } else {

                            Assert.fail("manageed server is not stopped");
                        }
                    }
                    else {

                        Assert.fail("get status application container operation failed");
                    }

                    //zone.zoneStop(prop.getProperty("TEEzoneURL"));
                    if(zone.zoneStop(prop.getProperty("TEEzoneURL")))
                    {
                        System.out.println("zone is not accessible");
                        //Assert.assertTrue(true);
                    }
                    else
                    {
                        Assert.fail("Zone is running tomcat stop operation not successfull");
                    }
                    //Assert.assertEquals("Success",Status);
                }
                if (Status.equalsIgnoreCase("Failed"))
                {
                    System.out.println("Stop operation execution failed");
                    Assert.fail("Action is failed");


                }

            }
        } catch (Exception e) {
            System.out.println("Exception is " + e);
            Assert.assertTrue(false);


        }



    }

    @Test(priority =6)
    public void Tee_application_Start()
    {
        try {
            Application_Container_Operations tee_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            tee_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tee_app_operations.application_container_operations).click().perform();
            tee_app_operations.start.click();
            tee_app_operations.next_button.click();
            tee_app_operations.next_button.click();
            tee_app_operations.waiting_time.clear();
            tee_app_operations.waiting_time.sendKeys("25");
            tee_app_operations.comments.clear();
            tee_app_operations.comments.sendKeys("Rcc execution");
            tee_app_operations.next_button.click();
            /*if(tee_app_operations.yes_option.isDisplayed())
            {
                tee_app_operations.yes_option.click();
                tee_app_operations.next_button.click();

            }*/
            String current_status = tee_app_operations.action_status.getText();
            System.out.println("Current status :" + current_status);
            if(wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("__status"),"Running...")))
            {
                String Status=tee_app_operations.action_status.getText();
                if(Status.equalsIgnoreCase("Success"))
                {
                    System.out.println("Start operation executed successfully");
                    tee_app_operations.close_button.click();
                    tee_app_operations.actions.click();
                    ac.moveToElement(tee_app_operations.get_status_tee_appcontainer).click().perform();
                    if(wait.until(ExpectedConditions.textToBePresentInElement(tee_app_operations.action_status, "Success"))) {
                        if (tee_app_operations.tee_app_start_status.isDisplayed()) {
                            System.out.println("node manager is running");
                            Assert.assertTrue(true);
                        }
                        if (zone.teezonestatus(prop.getProperty("TEEzoneURL"))) {
                            System.out.println("zone is  accessible");
                        } else {
                            Assert.fail("Zone is not running node manager start  operation not successfull");
                        }
                    }

                }
                if (Status.equalsIgnoreCase("Failed"))
                {
                    System.out.println("Start operation execution failed");
                    Assert.fail("Action is failed");

                }

            }

        }
        catch (Exception e) {
            System.out.println("Exception is " + e);
            Assert.assertTrue(false);
        }


    }

    @Test (priority = 2)
    public void Tee_application_reStart()
    {
        try
        {
            Application_Container_Operations tee_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            tee_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tee_app_operations.application_container_operations).click().perform();
            tee_app_operations.restart.click();
            tee_app_operations.next_button.click();
            tee_app_operations.next_button.click();
            tee_app_operations.waiting_time.clear();
            tee_app_operations.waiting_time.sendKeys("25");
            tee_app_operations.comments.clear();
            tee_app_operations.comments.sendKeys("Rcc execution");
            tee_app_operations.next_button.click();
            /*if(tee_app_operations.yes_option.isDisplayed())
            {
                tee_app_operations.yes_option.click();
                tee_app_operations.next_button.click();

            }*/
            String current_status = tee_app_operations.action_status.getText();
            System.out.println("Current status :" + current_status);
            if(wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("__status"),"Running...")))
            {
                String Status=tee_app_operations.action_status.getText();
                if(Status.equalsIgnoreCase("Success"))
                {
                    System.out.println("Restart operation executed successfully");
                    tee_app_operations.close_button.click();
                    tee_app_operations.actions.click();
                    ac.moveToElement(tee_app_operations.get_status_tee_appcontainer).click().perform();
                    if(wait.until(ExpectedConditions.textToBePresentInElement(tee_app_operations.action_status, "Success"))) {
                        if (tee_app_operations.tee_app_start_status.isDisplayed()) {
                            System.out.println("node manager  is restarted");
                            Assert.assertTrue(true);
                        }
                        if (zone.teezonestatus(prop.getProperty("TEEzoneURL"))) {
                            System.out.println("zone is  accessible");
                        } else {
                            Assert.fail("Zone is not running node manager restart  operation not successfull");
                        }
                    }

                }
                if (Status.equalsIgnoreCase("Failed"))
                {
                    System.out.println("Restart operation execution failed");
                    Assert.fail("Restart action is failed");

                }

            }
        }
        catch (Exception e) {
            System.out.println("Exception is " + e);
            Assert.assertTrue(false);

        }

    }

    @Test (priority = 3)
    public void Tee_application_dump_Threads() {
        try
        {
            Application_Container_Operations tee_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            tee_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tee_app_operations.application_container_operations).click().perform();
            tee_app_operations.dump_threads.click();
            tee_app_operations.next_button.click();
            tee_app_operations.dump_thread_number.clear();
            tee_app_operations.dump_thread_number.sendKeys(prop.getProperty("dumpthreadscount"));
            tee_app_operations.dump_thread_interval_in_seconds.clear();
            tee_app_operations.dump_thread_interval_in_seconds.sendKeys(prop.getProperty("TimeIntervalbetweeneachdump"));
            tee_app_operations.dump_thread_email.clear();
            tee_app_operations.dump_thread_email.sendKeys(prop.getProperty("Email"));
            tee_app_operations.next_button.click();
            tee_app_operations.next_button.click();
            tee_app_operations.waiting_time.clear();
            tee_app_operations.waiting_time.sendKeys("25");
            tee_app_operations.comments.clear();
            tee_app_operations.comments.sendKeys("Rcc execution");
            tee_app_operations.next_button.click();
            /*if(tee_app_operations.yes_option.isDisplayed())
            {
                tee_app_operations.yes_option.click();
                tee_app_operations.next_button.click();

            }*/
            String current_status = tee_app_operations.action_status.getText();
            System.out.println("Current status :" + current_status);
            if(wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("__status"),"Running...")))
            {
                String Status=tee_app_operations.action_status.getText();
                if(Status.equalsIgnoreCase("Success"))
                {
                    System.out.println("dump thread operation executed successfully");
                    wait.until(ExpectedConditions.textToBePresentInElement(tee_app_operations.action_status, "Success"));
                    if (tee_app_operations.tss_dump_thread_success.isDisplayed()) {
                        System.out.println("dump thread is executed successfully and dump is sent to :" + prop.getProperty("Email"));

                    }

                }
                if (Status.equalsIgnoreCase("Failed"))
                {
                    System.out.println("Dump threads operation execution failed");
                    Assert.fail("Dump threads operation execution failed");
                }

            }
        }
        catch (Exception e) {
            System.out.println("Exception is " + e);
            Assert.assertTrue(false);
        }

    }

    @Test(priority = 4)
    public void Tee_application_rolling_Restart()
    {
        try
        {
            Application_Container_Operations tee_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            tee_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tee_app_operations.application_container_operations).click().perform();
            tee_app_operations.rolling_restart.click();
            tee_app_operations.next_button.click();
            tee_app_operations.next_button.click();
            tee_app_operations.waiting_time.clear();
            tee_app_operations.waiting_time.sendKeys("25");
            tee_app_operations.comments.clear();
            tee_app_operations.comments.sendKeys("Rcc execution");
            tee_app_operations.next_button.click();
            /*if(tee_app_operations.yes_option.isDisplayed())
            {
                tee_app_operations.yes_option.click();
                tee_app_operations.next_button.click();

            }*/
            String current_status = tee_app_operations.action_status.getText();
            System.out.println("Current status :" + current_status);
            if(wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("__status"),"Running...")))
            {
                String Status=tee_app_operations.action_status.getText();
                if(Status.equalsIgnoreCase("Success"))
                {
                    System.out.println("Rolling restart operation executed successfully");
                    tee_app_operations.close_button.click();

                    tee_app_operations.actions.click();
                    ac.moveToElement(tee_app_operations.get_status_tee_appcontainer).click().perform();
                    if(wait.until(ExpectedConditions.textToBePresentInElement(tee_app_operations.action_status, "Success"))) {
                        if (tee_app_operations.tee_app_start_status.isDisplayed()) {
                            System.out.println("node manager  is restarted ");

                        }

                        if (zone.teezonestatus(prop.getProperty("TEEzoneURL"))) {
                            System.out.println("zone is  accessible");
                        } else {
                            Assert.fail("Zone is not running  rolling restart  operation not successfull");
                        }
                    }

                }
                if (Status.equalsIgnoreCase("Failed"))
                {
                    System.out.println("Rolling restart operation execution failed");
                    Assert.assertTrue(false);

                }
            }
        }
        catch (Exception e) {
            System.out.println("Exception is " + e);
            Assert.assertTrue(false);

        }
    }

 @Test(priority = 5)
    public void Tee_application_hard_Stop()
 {
     try
     {
         Application_Container_Operations tee_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
         tee_app_operations.actions.click();
         Actions ac = new Actions(driver);
         ac.moveToElement(tee_app_operations.application_container_operations).click().perform();
         tee_app_operations.hard_Stop.click();
         tee_app_operations.next_button.click();
         tee_app_operations.next_button.click();
         tee_app_operations.waiting_time.clear();
         tee_app_operations.waiting_time.sendKeys("25");
         tee_app_operations.comments.clear();
         tee_app_operations.comments.sendKeys("Rcc execution");
         tee_app_operations.next_button.click();
         /*if(tee_app_operations.yes_option.isDisplayed())
         {
             tee_app_operations.yes_option.click();
             tee_app_operations.next_button.click();

         }*/
         String current_status = tee_app_operations.action_status.getText();
         System.out.println("Current status :" + current_status);
         if(wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("__status"),"Running..."))) {
             String Status = tee_app_operations.action_status.getText();
             if (Status.equalsIgnoreCase("Success")) {
                 System.out.println("Hard Stop operation executed successfully");
                 tee_app_operations.close_button.click();
                 tee_app_operations.actions.click();
                 ac.moveToElement(tee_app_operations.get_status_tee_appcontainer).click().perform();
                 if(wait.until(ExpectedConditions.textToBePresentInElement(tee_app_operations.action_status, "Success"))) {
                     if (tee_app_operations.tee_app_stop_status.isDisplayed()) {
                         System.out.println("node manager is stopped");
                     }
                     if (zone.zoneStop(prop.getProperty("TEEzoneURL"))) {
                         System.out.println("zone is not accessible");

                     } else {
                         Assert.fail("Zone is running node manager hardstop operation not successfull");

                     }

                 }
             }
             if (Status.equalsIgnoreCase("Failed")) {
                 System.out.println("Hard Stop operation execution failed");
                 Assert.fail("Hard Stop operation execution failed");
             }
         }

     }
     catch (Exception e) {
         System.out.println("Exception is " + e);
         Assert.fail("Hard Stop operation execution failed");

     }

 }
 @Test(priority = 7)
    public void Tee_application_Suspend() {
        try {
            Application_Container_Operations tee_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            tee_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tee_app_operations.application_container_operations).click().perform();
            tee_app_operations.Suspend.click();
            tee_app_operations.next_button.click();
            tee_app_operations.next_button.click();
            tee_app_operations.waiting_time.clear();
            tee_app_operations.waiting_time.sendKeys("25");
            tee_app_operations.comments.clear();
            tee_app_operations.comments.sendKeys("Rcc execution");
            tee_app_operations.next_button.click();
            /*if(tee_app_operations.yes_option.isDisplayed())
            {
                tee_app_operations.yes_option.click();
                tee_app_operations.next_button.click();

            }*/
            String current_status = tee_app_operations.action_status.getText();
            System.out.println("Current  status :" + current_status);
            if(wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("__status"),"Running...")))
            {
                String Status=tee_app_operations.action_status.getText();
                if(Status.equalsIgnoreCase("Success"))
                {
                    System.out.println("Suspend operation executed successfully");
                    tee_app_operations.close_button.click();
                    /* tee_app_operations.actions.click();
                    ac.moveToElement(tee_app_operations.get_status_tee_appcontainer).click().perform();
                    if(wait.until(ExpectedConditions.textToBePresentInElement(tee_app_operations.action_status, "Success")))
                    {
                        if (tee_app_operations.tee_app_stop_status.isDisplayed()) {
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
                        System.out.println("zone is not accessible: Suspend operation is succesful");
                        //Assert.assertTrue(true);
                    }
                    else
                    {
                        Assert.fail("Zone is running suspend operation not successfull");
                    }
                    //Assert.assertEquals("Success",Status);
                }
                if (Status.equalsIgnoreCase("Failed"))
                {
                    System.out.println("Suspend operation execution failed");
                    Assert.fail("Action is failed");


                }

            }
        } catch (Exception e) {
            System.out.println("Exception is " + e);
            Assert.assertTrue(false);


        }



    }
    @Test(priority =8)
    public void Tee_application_Resume()
    {
        try {
            Application_Container_Operations tee_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            tee_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tee_app_operations.application_container_operations).click().perform();
            tee_app_operations.Resume.click();
            tee_app_operations.next_button.click();
            tee_app_operations.next_button.click();
            tee_app_operations.waiting_time.clear();
            tee_app_operations.waiting_time.sendKeys("25");
            tee_app_operations.comments.clear();
            tee_app_operations.comments.sendKeys("Rcc execution");
            tee_app_operations.next_button.click();
            /*if(tee_app_operations.yes_option.isDisplayed())
            {
                tee_app_operations.yes_option.click();
                tee_app_operations.next_button.click();

            }*/
            String current_status = tee_app_operations.action_status.getText();
            System.out.println("Current status :" + current_status);
            if(wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("__status"),"Running...")))
            {
                String Status=tee_app_operations.action_status.getText();
                if(Status.equalsIgnoreCase("Success"))
                {
                    System.out.println("Resume operation executed successfully");
                    tee_app_operations.close_button.click();
                    /* tee_app_operations.actions.click();
                    ac.moveToElement(tee_app_operations.get_tomcat_status_new).click().perform();
                    if(wait.until(ExpectedConditions.textToBePresentInElement(tee_app_operations.action_status, "Success"))) {
                        if (tee_app_operations.tss_app_start_status.isDisplayed()) {
                            System.out.println("tomcat is running");
                            Assert.assertTrue(true);
                        } */
                        if (zone.teezonestatus(prop.getProperty("TEEzoneURL"))) {
                            System.out.println("zone is  accessible : Resume operation is successful");
                        } else {
                            Assert.fail("Zone is not running resume   operation not successfull");
                        }


                }
                if (Status.equalsIgnoreCase("Failed"))
                {
                    System.out.println("Resume operation execution failed");
                    Assert.fail("Action is failed");

                }

            }

        }
        catch (Exception e) {
            System.out.println("Exception is " + e);
            Assert.assertTrue(false);
        }


    }





}
