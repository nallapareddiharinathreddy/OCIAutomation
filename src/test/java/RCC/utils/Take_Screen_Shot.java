package RCC.utils;
import RCC.testBase.*;
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
        File DestFile=new File(System.getProperty("user.dir")+"/Reports/Screenshots/"+Name+"_"+timestamp()+"full_scren"+".jpg");
        FileUtils.copyFile(fp,DestFile);
        System.out.println(DestFile.toString());
        String yes="yes";
        //Reporter.log("<a href="+ DestFile.getAbsolutePath() + "> <img src="+ DestFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
        Reporter.log("<img src="+DestFile+" alt="+yes+" height='100' width='100'/>");
    }
    public  static String   take_screenshot(WebDriver driver,String Name) throws Exception
    {
        TakesScreenshot scrnShot =((TakesScreenshot)driver);
        File fp=scrnShot.getScreenshotAs(OutputType.FILE);
        String path="./Reports/Screenshots/"+Name+"_"+timestamp()+".jpg";
        String pp=Name+"_"+timestamp();
        File DestFile=new File(path);
        FileUtils.copyFile(fp,DestFile);

        //System.out.println("screenshot path is :"+path);
        return pp ;

    }




}
