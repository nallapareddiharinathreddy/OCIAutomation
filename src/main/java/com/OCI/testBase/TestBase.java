package com.OCI.testBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    public static String browser;
    public  static  WebDriver driver;
    public static Properties prop;
    public static FileInputStream fp;
    public static WebDriverWait wait;


    @BeforeSuite
        public static void openBrowser() throws Exception{

            fp = new FileInputStream("D:\\OCIAutomation\\OCI.properties");
            prop = new Properties();
            prop.load(fp);

        String browser = prop.getProperty("BrowserType");
        if (null != browser) {

            if(browser.equalsIgnoreCase("chrome")) {

                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                 driver = new ChromeDriver();
            }
            else if (browser.equalsIgnoreCase("firefox"))
            {

                    System.setProperty("webdriver.firefox.marionette", "geckodriver.exe");
                    driver = new FirefoxDriver();


            }

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver,1800);
    }
    @AfterSuite

        public   void closeBrowser()
    {
         driver.close();
    }
    /*public static boolean checkStatus(int MAXIMUM_WAIT_TIME){

        String actionStatus = null;

        WebDriverWait wait= new WebDriverWait(driver, MAXIMUM_WAIT_TIME);
        int retries = 0;
            try {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='__status']/span"))).isDisplayed();

                wait.until(ExpectedConditions.or(ExpectedConditions.attributeToBe(By.xpath(".//*[@id='__status']/span"), "innerHTML", " Success"), ExpectedConditions.attributeToBe(By.xpath(".//*[@id='__status']/span"), "innerHTML", " Failed")));

                actionStatus = driver.findElement(By.xpath(".//*[@id='__status']/span")).getAttribute("innerHTML");

                //System.out.println("Status: " + actionStatus);


            } catch (Exception e) {
                    System.out.println(e);
                }
            return true;
        }

    public static String  Name(Method method)
        {
            String name=method.getName();
            //System.out.println(name);
            return name;
        } */
    }


