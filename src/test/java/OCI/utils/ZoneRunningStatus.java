package OCI.utils;

import OCI.pagefactory.ZoneStatus;
import OCI.testBase.TestBase;
import com.sun.jna.platform.win32.OaIdl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ZoneRunningStatus extends TestBase {
    public ArrayList<String> tabs;
    ZoneStatus zone_status = PageFactory.initElements(driver, ZoneStatus.class);


    public boolean zoneStop(String zoneurl) {
        ZoneStatus zone_status = PageFactory.initElements(driver, ZoneStatus.class);
        String mainwindow = driver.getWindowHandle();
        String a = "window.open('about:blank','_blank');";
        ((JavascriptExecutor) driver).executeScript(a);
        tabs = new ArrayList<String>(driver.getWindowHandles());
        boolean enabled = false;
        driver.switchTo().window(tabs.get(1));
        driver.get(zoneurl);
        //Thread.sleep(2000);
        //System.out.println("new tab opened");

        //System.out.println(zone_status.zone_not_running.isEnabled());
        if (zone_status.zone_not_running.isEnabled()) {

            enabled = true;
            //System.out.println(enabled);
        }
        driver.close();
        driver.switchTo().window(mainwindow);
        //switchToTab();

        return enabled;

    }

    public boolean tssZoneStart(String zoneurl) {
        String mainwindow = driver.getWindowHandle();
        ZoneStatus zone_status = PageFactory.initElements(driver, ZoneStatus.class);
        String a = "window.open('about:blank','_blank');";
        ((JavascriptExecutor) driver).executeScript(a);
        tabs = new ArrayList<String>(driver.getWindowHandles());
        boolean enabled = false;
        driver.switchTo().window(tabs.get(1));
        driver.get(zoneurl);
        //Thread.sleep(2000);
        //System.out.println("new tab opened");

        //System.out.println(zone_status.zone_not_running.isEnabled());
        if (zone_status.tss_zone_signin.isEnabled()) {

            enabled = true;

            //System.out.println(enabled);
        }
        driver.close();
        driver.switchTo().window(mainwindow);
        switchToTab();

        return enabled;

    }

    public boolean teeZoneStart(String zoneurl) {
        boolean enabled = true;
        String mainwindow = driver.getWindowHandle();


        ZoneStatus zone_status = PageFactory.initElements(driver, ZoneStatus.class);
        String a = "window.open('about:blank','_blank');";
        ((JavascriptExecutor) driver).executeScript(a);
        tabs = new ArrayList<String>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));

        //Thread.sleep(2000);
        //System.out.println("new tab opened");
        //enabled=zone_status.zone_not_running.isEnabled();
        //System.out.println(zone_status.zone_not_running.isEnabled());
        WebDriverWait wait = new WebDriverWait(driver, 300);
        for (int i = 0; i < 8; i++) {
            driver.get(zoneurl);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/font[1]/a/img")));
        }
        if (zone_status.zone_not_running.isEnabled()) {

            enabled = false;
            //System.out.println(enabled);
        } else {
            enabled = true;
        }


        driver.close();
        driver.switchTo().window(mainwindow);
        switchToTab();

        return enabled;

    }

    public   boolean teezonestatus (String zoneurl) throws Exception {

        String mainwindow = driver.getWindowHandle();


        ZoneStatus zone_status = PageFactory.initElements(driver, ZoneStatus.class);
        String a = "window.open('about:blank','_blank');";
        ((JavascriptExecutor) driver).executeScript(a);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));
        boolean enabled = false;
        //Thread.sleep(2000);
        //System.out.println("new tab opened");
        //enabled=zone_status.zone_not_running.isEnabled();
        //System.out.println(zone_status.zone_not_running.isEnabled());
        WebDriverWait wait = new WebDriverWait(driver, 300);
        int i=0;
        try {
            do {
                driver.get(zoneurl);
                boolean available = zone_status.zone_not_running.isDisplayed();
                if (available) {
                    enabled = false;
                } else {
                    enabled = true;
                }
                //System.out.println(enabled+" ");
                //System.out.print(LocalDateTime.now().getHour()+" "+LocalDateTime.now().getMinute());
                Thread.sleep(180000);


            } while (enabled == false);

            return enabled;

        } catch (Exception NoSuchElementException) {
            driver.close();
            driver.switchTo().window(mainwindow);
            //System.out.println("its catched");
            //System.out.println(enabled);
            enabled=true;
            return enabled;

        }

    }


    public void switchToTab() {

        driver.switchTo().defaultContent();
    }
}
