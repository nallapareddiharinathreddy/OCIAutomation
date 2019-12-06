package com.OCI.utils;
import com.OCI.testBase.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class Take_Screen_Shot extends TestBase {

    WebDriver driver ;

    public static void take_screenshot(WebDriver driver,String Name) throws Exception
    {
        TakesScreenshot scrnShot =((TakesScreenshot)driver);
        File fp=scrnShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File("D:\\OCIAutomation\\src\\Screenshots\\"+Name+"_"+timestamp()+".jpg");
        FileUtils.copyFile(fp,DestFile);

        System.out.println(DestFile.toString());
        //Reporter.log("<a href="+ DestFile.getAbsolutePath() + "> <img src="+ DestFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
        Reporter.log("<img src="+DestFile+" height='100' width='100'/>");
    }

    public static String timestamp()
    {
        return new SimpleDateFormat("MM-dd-yyyy HH-mm-ss").format(new Date());
    }


    public static void fullScreenShot(WebDriver driver,String Name) throws Exception
    {
        TakesScreenshot full_Screen_shot=((TakesScreenshot)driver);
        JavascriptExecutor js=((JavascriptExecutor)driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        File fp=full_Screen_shot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File("D:\\OCIAutomation\\src\\Screenshots\\"+Name+"_"+timestamp()+"full_scren"+".jpg");
        FileUtils.copyFile(fp,DestFile);
        System.out.println(DestFile.toString());
        String yes="yes";
        //Reporter.log("<a href="+ DestFile.getAbsolutePath() + "> <img src="+ DestFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
        Reporter.log("<img src="+DestFile+" alt="+yes+" height='100' width='100'/>");
    }




}
