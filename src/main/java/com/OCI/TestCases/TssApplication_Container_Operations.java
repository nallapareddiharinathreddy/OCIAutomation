package com.OCI.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.OCI.testBase.*;
import com.OCI.Login.*;
import com.OCI.pagefactory.*;
import com.OCI.utils.*;

import java.util.*;
import java.util.concurrent.TimeUnit;


@Listeners(com.OCI.utils.Listener.class)

public class TssApplication_Container_Operations extends TestBase {


    @BeforeClass
    public void tss_Login()
    {
        try {
            Login.login();
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

    @AfterClass
    public void tss_Logout()
    {
        Login.logout();
    }
    @Test(priority = 1)
    public void Stop() {
        try {
            //String name=TestBase.Name(test()));
            Application_Container_Operations tss_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            tss_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tss_app_operations.application_container_operations).click().perform();
            //Take_Screen_Shot.take_screenshot(driver, "D:\\OCIAutomation\\test.png");
            tss_app_operations.stop.click();
            tss_app_operations.next_button.click();
            tss_app_operations.next_button.click();
            tss_app_operations.next_button.click();
            String current_status = tss_app_operations.action_status.getText();
            System.out.println("Current  status :" + current_status);
            WebDriverWait wait=new WebDriverWait(driver,600);
            //if (TestBase.checkStatus(600))
            if(wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("__status"),"Running...")))
            {
                String Status=tss_app_operations.action_status.getText();
                if(Status.equalsIgnoreCase("Success"))
                {
                    System.out.println("Stop operation executed successfully");
                    Assert.assertTrue(true);
                    tss_app_operations.close_button.click();
                    tss_app_operations.actions.click();
                    ac.moveToElement(tss_app_operations.get_Status_tomcat).click().perform();
                    wait.until(ExpectedConditions.textToBePresentInElement(tss_app_operations.action_status, "Success"));
                    if (tss_app_operations.tss_app_stop_status.isDisplayed()) {
                        System.out.println("tomcat is stopped");
                        tss_app_operations.close_button.click();
                    }
                    Assert.assertEquals("Success",Status);
                }
                if (Status.equalsIgnoreCase("Failed"))
                {
                    System.out.println("Stop operation execution failed");
                    Assert.fail("Action is failed");

                    tss_app_operations.close_button.click();

                }

            }
        } catch (Exception e) {
            System.out.println("Exception is " + e);
            Assert.assertTrue(false);
        }

    }

    @Test(priority =6)
    public void Start()
    {
        try {
            Application_Container_Operations tss_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            tss_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tss_app_operations.application_container_operations).click().perform();
            tss_app_operations.start.click();
            tss_app_operations.next_button.click();
            tss_app_operations.next_button.click();
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
                    ac.moveToElement(tss_app_operations.get_Status_tomcat).click().perform();
                    wait.until(ExpectedConditions.textToBePresentInElement(tss_app_operations.action_status, "Success"));
                    if (tss_app_operations.tss_app_start_status.isDisplayed()) {
                        System.out.println("tomcat is running");
                        tss_app_operations.close_button.click();
                    }

                }
                if (Status.equalsIgnoreCase("Failed"))
                {
                    //Take_Screen_Shot.take_screenshot(driver,"Start");
                    System.out.println("Start operation execution failed");
                    Assert.fail("Action is failed");
                    Assert.assertTrue(false);
                    tss_app_operations.close_button.click();
                }

            }
            /*if (wait.until(ExpectedConditions.textToBePresentInElement(tss_app_operations.action_status, "Success"))) {
                System.out.println("start operation executed successfully");

                tss_app_operations.close_button.click();
                tss_app_operations.actions.click();
                ac.moveToElement(tss_app_operations.get_Status_tomcat).click().perform();
                wait.until(ExpectedConditions.textToBePresentInElement(tss_app_operations.action_status, "Success"));
                if (tss_app_operations.tss_app_start_status.isDisplayed()) {
                    System.out.println("tomcat is running ");
                    tss_app_operations.close_button.click();
                }


            }*/
        }
        catch (Exception e) {
            //driver.switchTo().alert().accept();
            System.out.println("Exception is " + e);
            Assert.assertTrue(false);
        }


    }

    @Test (priority = 2)
    public void reStart()
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
                    ac.moveToElement(tss_app_operations.get_Status_tomcat).click().perform();
                    wait.until(ExpectedConditions.textToBePresentInElement(tss_app_operations.action_status, "Success"));
                    if (tss_app_operations.tss_app_start_status.isDisplayed()) {
                        System.out.println("tomcat is started");
                        tss_app_operations.close_button.click();
                    }

                }
                if (Status.equalsIgnoreCase("Failed"))
                {
                    System.out.println("Restart operation execution failed");
                    tss_app_operations.close_button.click();
                }

            }
            /* if (wait.until(ExpectedConditions.textToBePresentInElement(tss_app_operations.action_status, "Success"))) {
                System.out.println("restart operation executed successfully");

                tss_app_operations.close_button.click();
                tss_app_operations.actions.click();
                ac.moveToElement(tss_app_operations.get_Status_tomcat).click().perform();
                wait.until(ExpectedConditions.or(ExpectedConditions.textToBePresentInElement(tss_app_operations.action_status, " Success"), ExpectedConditions.textToBePresentInElement(tss_app_operations.action_status, " Failed")));

                //wait.until(ExpectedConditions.textToBePresentInElement(tss_app_operations.action_status, "Success"));
                if (tss_app_operations.tss_app_start_status.isDisplayed()) {
                    System.out.println("tomcat is running ");
                    tss_app_operations.close_button.click();
                }
            } */
        }
        catch (Exception e) {
            System.out.println("Exception is " + e);
            Assert.assertTrue(false);
        }
    }

    @Test (priority = 3)
    public void dump_Threads() {
        try
        {
            Application_Container_Operations tss_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            tss_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tss_app_operations.application_container_operations).click().perform();
            tss_app_operations.dump_threads.click();
            tss_app_operations.next_button.click();
            tss_app_operations.dump_thread_number.clear();
            tss_app_operations.dump_thread_number.sendKeys("3");
            tss_app_operations.dump_thread_interval_in_seconds.clear();
            tss_app_operations.dump_thread_interval_in_seconds.sendKeys("20");
            tss_app_operations.dump_thread_email.clear();
            tss_app_operations.dump_thread_email.sendKeys(prop.getProperty("Email"));
            tss_app_operations.next_button.click();
            tss_app_operations.next_button.click();
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
                        tss_app_operations.close_button.click();
                    }

                }
                if (Status.equalsIgnoreCase("Failed"))
                {
                    System.out.println("Dump threads operation execution failed");
                    tss_app_operations.close_button.click();
                }

            }
            /*if (wait.until(ExpectedConditions.textToBePresentInElement(tss_app_operations.action_status, "Success"))) {
                System.out.println("dump thread operation executed successfully");
                if(tss_app_operations.tss_dump_thread_success.isDisplayed()) {
                    System.out.println("dump thread is executed successfully and dump is sent to :" + prop.getProperty("Email"));
                    tss_app_operations.close_button.click();
                }


            }*/
        }
        catch (Exception e) {
            System.out.println("Exception is " + e);
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 4)
    public void rolling_Restart()
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
                    ac.moveToElement(tss_app_operations.get_Status_tomcat).click().perform();
                    wait.until(ExpectedConditions.textToBePresentInElement(tss_app_operations.action_status, "Success"));
                    if (tss_app_operations.tss_app_start_status.isDisplayed()) {
                        System.out.println("tomcat is started");
                        tss_app_operations.close_button.click();
                    }

                }
                if (Status.equalsIgnoreCase("Failed"))
                {
                    System.out.println("Rolling restart operation execution failed");
                    tss_app_operations.close_button.click();
                }

            }
            /* if (wait.until(ExpectedConditions.textToBePresentInElement(tss_app_operations.action_status, "Success"))) {
                System.out.println("rolling restart operation executed successfully");

                tss_app_operations.close_button.click();
                tss_app_operations.actions.click();
                ac.moveToElement(tss_app_operations.get_Status_tomcat).click().perform();
                wait.until(ExpectedConditions.textToBePresentInElement(tss_app_operations.action_status, "Success"));
                if (tss_app_operations.tss_app_start_status.isDisplayed()) {
                    System.out.println("tomcat is running ");
                    tss_app_operations.close_button.click();
                }
            } */
        }
        catch (Exception e) {
            System.out.println("Exception is " + e);
            Assert.assertTrue(false);
        }
    }

 @Test(priority = 5)
    public void hard_Stop()
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
         tss_app_operations.next_button.click();
         String current_status = tss_app_operations.action_status.getText();
         System.out.println("Current status :" + current_status);
         if(wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("__status"),"Running...")))
         {
             String Status=tss_app_operations.action_status.getText();
             if(Status.equalsIgnoreCase("Success"))
             {
                 System.out.println("Hard Stop operation executed successfully");
                 tss_app_operations.close_button.click();
                 tss_app_operations.actions.click();
                 ac.moveToElement(tss_app_operations.get_Status_tomcat).click().perform();
                 wait.until(ExpectedConditions.textToBePresentInElement(tss_app_operations.action_status, "Success"));
                 if (tss_app_operations.tss_app_stop_status.isDisplayed()) {
                     System.out.println("tomcat is stopped");
                     tss_app_operations.close_button.click();
                 }

             }
             if (Status.equalsIgnoreCase("Failed"))
             {
                 System.out.println("Hard Stop operation execution failed");
                 tss_app_operations.close_button.click();
             }

         }
         /*if (wait.until(ExpectedConditions.textToBePresentInElement(tss_app_operations.action_status, "Success"))) {
             System.out.println("hard stop operation executed successfully");

             tss_app_operations.close_button.click();
             tss_app_operations.actions.click();
             ac.moveToElement(tss_app_operations.get_Status_tomcat).click().perform();
             wait.until(ExpectedConditions.textToBePresentInElement(tss_app_operations.action_status, "Success"));
             if (tss_app_operations.tss_app_stop_status.isDisplayed()) {
                 System.out.println("tomcat is stopped ");
                 tss_app_operations.close_button.click();
             }
         } */

     }
     catch (Exception e) {
         System.out.println("Exception is " + e);
         Assert.assertTrue(false);
     }
 }


 public  void test()
    {
     Wait wait= new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5,TimeUnit.MICROSECONDS).ignoring(NoSuchElementException.class) ;
    }


}
