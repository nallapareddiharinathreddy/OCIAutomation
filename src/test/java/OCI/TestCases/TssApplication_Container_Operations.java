package OCI.TestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;
import OCI.testBase.*;
import OCI.pagefactory.*;
import OCI.utils.*;

import java.util.*;
import java.util.concurrent.TimeUnit;



public class TssApplication_Container_Operations extends TestBase {

    Application_Container_Operations tss_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
    ZoneRunningStatus zone=new ZoneRunningStatus();
    public  ExtentTest log;





    @BeforeClass
    public void tssComponentSearch()
    {
        log=ExtentReport.loggerextent;
        WebDriverWait wait=new WebDriverWait(driver,600);

        try {
            Component_Search search = PageFactory.initElements(driver, Component_Search.class);
            search.components.click();
            Select sc = new Select(search.Component_type);
            sc.selectByVisibleText("TSS Application");
            System.out.println(prop.getProperty("TSSApplication") + " Selected successfully");
            search.searchfield.clear();
            search.searchfield.sendKeys(prop.getProperty("TSSApplication"));
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
    public void Tss_application_Stop() {
        try {
            log=ExtentReport.loggerextent;
            log.info("Tss Application container stop operation started");
            Application_Container_Operations tss_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            tss_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tss_app_operations.application_container_operations).click().perform();
            tss_app_operations.stop.click();
            tss_app_operations.next_button.click();
            tss_app_operations.next_button.click();
            tss_app_operations.waiting_time.clear();
            tss_app_operations.waiting_time.sendKeys("25");
            tss_app_operations.comments.clear();
            tss_app_operations.comments.sendKeys("Rcc execution");
            tss_app_operations.next_button.click();
            String current_status = tss_app_operations.action_status.getText();
            System.out.println("Current  status :" + current_status);
            if(wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("__status"),"Running...")))
            {
                String Status=tss_app_operations.action_status.getText();
                if(Status.equalsIgnoreCase("Success"))
                {
                    log.info("Stop operation executed successfully");
                    tss_app_operations.close_button.click();
                    tss_app_operations.actions.click();
                    ac.moveToElement(tss_app_operations.get_tomcat_status_new).click().perform();
                    if(wait.until(ExpectedConditions.textToBePresentInElement(tss_app_operations.action_status, "Success")))
                    {
                        if (tss_app_operations.tss_app_stop_status.isDisplayed()) {
                            log.info("tomcat is stopped");

                        } else {

                            log.fail("tomcat is not stopped");
                            Assert.fail("tomcat is not stopped");
                        }
                    }
                    else {
                        log.fail("get status tomcat is failed");
                        Assert.fail("get status tomcat is failed");
                    }

                    //zone.zoneStop(prop.getProperty("TSSzoneURL"));
                    if(zone.zoneStop(prop.getProperty("TSSzoneURL")))
                    {
                        log.info("zone is not accessible");
                        //Assert.assertTrue(true);
                    }
                    else
                    {
                        log.fail("Zone is running tomcat stop operation not successfull");
                        Assert.fail("Zone is running tomcat stop operation not successfull");
                    }
                    //Assert.assertEquals("Success",Status);
                }
                if (Status.equalsIgnoreCase("Failed"))
                {
                    log.fail("Stop operation execution failed");
                    Assert.fail("Action is failed");


                }

            }

        }
        catch (org.openqa.selenium.UnhandledAlertException e)
        {

            driver.switchTo().alert().accept();
            Assert.assertTrue(false,"e");


        }
        catch (Exception e) {

            Assert.assertTrue(false,"e");


        }



    }

    @Test(priority = 6)
    public void Tss_application_Start()
    {
        try {
            Application_Container_Operations tss_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            tss_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tss_app_operations.application_container_operations).click().perform();
            tss_app_operations.start.click();
            tss_app_operations.next_button.click();
            tss_app_operations.next_button.click();
            tss_app_operations.waiting_time.clear();
            tss_app_operations.waiting_time.sendKeys("25");
            tss_app_operations.comments.clear();
            tss_app_operations.comments.sendKeys("Rcc execution");
            tss_app_operations.next_button.click();
            String current_status = tss_app_operations.action_status.getText();
            System.out.println("Current status :" + current_status);
            if(wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("__status"),"Running...")))
            {
                String Status=tss_app_operations.action_status.getText();
                if(Status.equalsIgnoreCase("Success"))
                {
                    System.out.println("Start operation executed successfully");
                    tss_app_operations.close_button.click();
                    tss_app_operations.actions.click();
                    ac.moveToElement(tss_app_operations.get_tomcat_status_new).click().perform();
                    if(wait.until(ExpectedConditions.textToBePresentInElement(tss_app_operations.action_status, "Success"))) {
                        if (tss_app_operations.tss_app_start_status.isDisplayed()) {
                            System.out.println("tomcat is running");
                            Assert.assertTrue(true);
                        }
                        if (zone.tssZoneStart(prop.getProperty("TSSzoneURL"))) {
                            System.out.println("zone is  accessible");
                        } else {
                            Assert.fail("Zone is not running tomcat start  operation not successfull");
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
        catch (org.openqa.selenium.UnhandledAlertException e)
        {

            driver.switchTo().alert().accept();
            Assert.assertTrue(false,"e");


        }
        catch (Exception e) {

            Assert.assertTrue(false,"e");


        }


    }

    @Test(priority = 2)
    public void Tss_application_reStart()
    {
        try
        {
            Application_Container_Operations tss_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            tss_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tss_app_operations.application_container_operations).click().perform();
            tss_app_operations.restart.click();
            tss_app_operations.next_button.click();
            tss_app_operations.next_button.click();
            tss_app_operations.waiting_time.clear();
            tss_app_operations.waiting_time.sendKeys("25");
            tss_app_operations.comments.clear();
            tss_app_operations.comments.sendKeys("Rcc execution");
            tss_app_operations.next_button.click();
            String current_status = tss_app_operations.action_status.getText();
            System.out.println("Current status :" + current_status);
            if(wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("__status"),"Running...")))
            {
                String Status=tss_app_operations.action_status.getText();
                if(Status.equalsIgnoreCase("Success"))
                {
                    System.out.println("Restart operation executed successfully");
                    tss_app_operations.close_button.click();
                    tss_app_operations.actions.click();
                    ac.moveToElement(tss_app_operations.get_tomcat_status_new).click().perform();
                    if(wait.until(ExpectedConditions.textToBePresentInElement(tss_app_operations.action_status, "Success"))) {
                        if (tss_app_operations.tss_app_start_status.isDisplayed()) {
                            System.out.println("tomcat is started");
                            Assert.assertTrue(true);
                        }
                        if (zone.tssZoneStart(prop.getProperty("TSSzoneURL"))) {
                            System.out.println("zone is  accessible");
                        } else {
                            Assert.fail("Zone is not running tomcat restart  operation not successfull");
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
        catch (org.openqa.selenium.UnhandledAlertException e)
        {

            driver.switchTo().alert().accept();
            Assert.assertTrue(false,"e");


        }
        catch (Exception e) {

            Assert.assertTrue(false,"e");


        }
    }

    @Test(priority = 3)
    public void Tss_application_dump_Threads() {
        try
        {
            Application_Container_Operations tss_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            tss_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tss_app_operations.application_container_operations).click().perform();
            tss_app_operations.dump_threads.click();
            tss_app_operations.next_button.click();
            tss_app_operations.dump_thread_number.clear();
            tss_app_operations.dump_thread_number.sendKeys(prop.getProperty("dumpthreadscount"));
            tss_app_operations.dump_thread_interval_in_seconds.clear();
            tss_app_operations.dump_thread_interval_in_seconds.sendKeys(prop.getProperty("TimeIntervalbetweeneachdump"));
            tss_app_operations.dump_thread_email.clear();
            tss_app_operations.dump_thread_email.sendKeys(prop.getProperty("Email"));
            tss_app_operations.next_button.click();
            tss_app_operations.next_button.click();
            tss_app_operations.waiting_time.clear();
            tss_app_operations.waiting_time.sendKeys("25");
            tss_app_operations.comments.clear();
            tss_app_operations.comments.sendKeys("Rcc execution");
            tss_app_operations.next_button.click();
            String current_status = tss_app_operations.action_status.getText();
            System.out.println("Current status :" + current_status);
            if(wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("__status"),"Running...")))
            {
                String Status=tss_app_operations.action_status.getText();
                if(Status.equalsIgnoreCase("Success"))
                {
                    System.out.println("dump thread operation executed successfully");
                    wait.until(ExpectedConditions.textToBePresentInElement(tss_app_operations.action_status, "Success"));
                    if (tss_app_operations.tss_dump_thread_success.isDisplayed()) {
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
        catch (org.openqa.selenium.UnhandledAlertException e)
        {

            driver.switchTo().alert().accept();
            Assert.assertTrue(false,"e");


        }
        catch (Exception e) {

            Assert.assertTrue(false,"e");


        }

    }

    @Test(priority = 4)
    public void Tss_application_rolling_Restart()
    {
        try
        {
            Application_Container_Operations tss_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            tss_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tss_app_operations.application_container_operations).click().perform();
            tss_app_operations.rolling_restart.click();
            tss_app_operations.next_button.click();
            tss_app_operations.next_button.click();
            tss_app_operations.waiting_time.clear();
            tss_app_operations.waiting_time.sendKeys("25");
            tss_app_operations.comments.clear();
            tss_app_operations.comments.sendKeys("Rcc execution");
            tss_app_operations.next_button.click();
            String current_status = tss_app_operations.action_status.getText();
            System.out.println("Current status :" + current_status);
            if(wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("__status"),"Running...")))
            {
                String Status=tss_app_operations.action_status.getText();
                if(Status.equalsIgnoreCase("Success"))
                {
                    System.out.println("Rolling restart operation executed successfully");
                    tss_app_operations.close_button.click();

                    tss_app_operations.actions.click();
                    ac.moveToElement(tss_app_operations.get_tomcat_status_new).click().perform();
                    if(wait.until(ExpectedConditions.textToBePresentInElement(tss_app_operations.action_status, "Success"))) {
                        if (tss_app_operations.tss_app_start_status.isDisplayed()) {
                            System.out.println("tomcat is started");

                        }

                        if (zone.tssZoneStart(prop.getProperty("TSSzoneURL"))) {
                            System.out.println("zone is  accessible");
                        } else {
                            Assert.fail("Zone is not running tomcat rolling restart  operation not successfull");
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
        catch (org.openqa.selenium.UnhandledAlertException e)
        {

            driver.switchTo().alert().accept();
            Assert.assertTrue(false,"e");


        }
        catch (Exception e) {

            Assert.assertTrue(false,"e");


        }
    }

 @Test(priority = 5)
    public void Tss_application_hard_Stop()
 {
     try
     {
         Application_Container_Operations tss_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
         tss_app_operations.actions.click();
         Actions ac = new Actions(driver);
         ac.moveToElement(tss_app_operations.application_container_operations).click().perform();
         tss_app_operations.hard_Stop.click();
         tss_app_operations.next_button.click();
         tss_app_operations.next_button.click();
         tss_app_operations.waiting_time.clear();
         tss_app_operations.waiting_time.sendKeys("25");
         tss_app_operations.comments.clear();
         tss_app_operations.comments.sendKeys("Rcc execution");
         tss_app_operations.next_button.click();
         String current_status = tss_app_operations.action_status.getText();
         System.out.println("Current status :" + current_status);
         if(wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("__status"),"Running..."))) {
             String Status = tss_app_operations.action_status.getText();
             if (Status.equalsIgnoreCase("Success")) {
                 System.out.println("Hard Stop operation executed successfully");
                 tss_app_operations.close_button.click();
                 tss_app_operations.actions.click();
                 ac.moveToElement(tss_app_operations.get_tomcat_status_new).click().perform();
                 if(wait.until(ExpectedConditions.textToBePresentInElement(tss_app_operations.action_status, "Success"))) {
                     if (tss_app_operations.tss_app_stop_status.isDisplayed()) {
                         System.out.println("tomcat is stopped");
                     }
                     if (zone.zoneStop(prop.getProperty("TSSzoneURL"))) {
                         System.out.println("zone is not accessible");

                     } else {
                         Assert.fail("Zone is running tomcat hardstop operation not successfull");

                     }

                 }
             }
             if (Status.equalsIgnoreCase("Failed")) {
                 System.out.println("Hard Stop operation execution failed");
                 Assert.fail("Hard Stop operation execution failed");
             }
         }

     }
     catch (org.openqa.selenium.UnhandledAlertException e)
     {

         driver.switchTo().alert().accept();
         Assert.assertTrue(false,"e");


     }
     catch (Exception e) {

         Assert.assertTrue(false,"e");


     }

 }


 public  void test1()
    {
     WebDriverWait wt=new WebDriverWait(driver,20);
        Wait wait= new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5,TimeUnit.MICROSECONDS).ignoring(NoSuchElementException.class) ;
    }


}
