package OCI.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class personal {

    public static void main(String args[]) throws  Exception
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 1800);
        driver.get("https://1xbet.in/en/");
        driver.findElement(By.xpath("//*[@id=\"loginout\"]/div[2]/div/div")).click();
        WebElement c=driver.findElement(By.xpath("//*[@id=\"loginout\"]/div[2]/div/div/div[2]/div/form"));
        //*[@id="loginout"]/div[2]/div/div/div[2]/div/form
        Actions ac = new Actions(driver);
        ac.moveToElement(c).perform();
        driver.findElement(By.xpath("//*[@id=\"loginout\"]/div[2]/div/div/div[2]/div/form/div[1]/div/label")).click();

        driver.findElement(By.id("auth_id_email")).sendKeys("vivekkrishnareddy@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"loginout\"]/div[2]/div/div/div[2]/div/form/div[2]/div/label")).click();
        driver.findElement(By.id("auth-form-password")).sendKeys("01ydderhtanirah");
        driver.findElement(By.xpath("//*[@id=\"loginout\"]/div[2]/div/div/div[2]/div/form/button")).click();
        WebElement yes=driver.findElement(By.id("loc_info"));
        if(yes.isEnabled()) {
            System.out.println("logined ");
        }
        else
        {
            driver.findElement(By.id("input_email")).sendKeys("vivekkrishnareddy@gmail.com");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/form/button")).click();
            driver.findElement(By.xpath("/html/body/div[5]/div/div[3]/button[1]")).click();
            String s;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter otp");
            s = sc.next();
            s.trim();

            driver.findElement(By.id("input_otp")).sendKeys(s);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/form/button")).click();
        }
              Thread.sleep(5000);
        WebElement cas=driver.findElement(By.xpath("//*[@id=\"games_top_menu\"]/ul/li[9]/a"));
        ac.moveToElement(cas).perform();
        //driver.findElement(By.xpath("//*[@id=\"games_top_menu\"]/ul/li[9]/div/div/div[1]/a[8]")).click();
        //*[@id="games_top_menu"]/ul/li[9]/div/div/div[1]
        //*[@id="games_top_menu"]/ul/li[9]
        Select scm=new Select(driver.findElement(By.xpath("//*[@id=\"games_top_menu\"]/ul/li[9]/div/div/div[1]")));
        //List<WebElement> ll=driver.findElements(By.xpath("//*[@id=\"games_top_menu\"]/ul/li[9]/div/div/div[1]"));
        System.out.println(scm.getOptions());

        //*[@id="games_top_menu"]/ul/li[9]/div/div/div[1]
        //*[@id="games_top_menu"]/ul/li[9]/div
                //*[@id="banker-label"]
        //*[@id="balance-label"]

    }
}
