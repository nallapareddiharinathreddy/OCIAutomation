package RCC.testBase;

import RCC.pagefactory.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    public static String browser;
    public  static  WebDriver driver;
    public static Properties prop;
    public static FileInputStream fp;
    public static WebDriverWait wait;
    public static ExtentReports extent;
    public  static ExtentTest loggerextent;


    @BeforeSuite
        public static void openBrowser() throws Exception{



        try {
            fp = new FileInputStream("config.properties");
            prop = new Properties();
            prop.load(fp);

            String browser = prop.getProperty("BrowserType");
            if (null != browser) {

                if (browser.equalsIgnoreCase("chrome")) {

                    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                    driver = new ChromeDriver();
                } else if (browser.equalsIgnoreCase("firefox")) {

                    System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                    driver = new FirefoxDriver();
                }

            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, 12000);
            //WebDriverWait wa=new WebDriverWait(driver,10);
            System.out.println(prop.getProperty("URL"));
            driver.get(prop.getProperty("URL"));
            String Actualtitle = driver.getTitle();
            System.out.println(Actualtitle);
            String Expectedtilte = prop.getProperty("PageTitle");
            Assert.assertEquals(Actualtitle, Expectedtilte);
            LoginPage login_page = PageFactory.initElements(driver, LoginPage.class);
            login_page.username.sendKeys(prop.getProperty("Username"));
            login_page.password.sendKeys(prop.getProperty("Password"));
            login_page.login.click();
            String logout = driver.findElement(By.id("logout")).getText();
            if (logout.equalsIgnoreCase("logout")) {
                System.out.println("User logined successfully.");
                Assert.assertEquals(logout, "Logout");
            } else {

                Assert.fail("login failed ");
            }
        }
        catch (Exception e) {
        }
    }
    @AfterSuite

        public   void closeBrowser()
    {
        try {
            LoginPage login_page = PageFactory.initElements(driver, LoginPage.class);
            login_page.logout.click();

            System.out.println("User logged out successfully");

            driver.close();
        }
        catch (Exception e)
        {

        }
    }


    }


