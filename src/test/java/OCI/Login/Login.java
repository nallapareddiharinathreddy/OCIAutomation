package OCI.Login;
import OCI.testBase.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import OCI.pagefactory.*;


public class Login extends TestBase {


    public static void login(){
        System.out.println(prop.getProperty("URL"));
        driver.get(prop.getProperty("URL"));
        String Actualtitle=driver.getTitle();
        System.out.println(Actualtitle);
        String Expectedtilte=prop.getProperty("PageTitle");
        Assert.assertEquals(Actualtitle,Expectedtilte);
        LoginPage login_page= PageFactory.initElements(driver,LoginPage.class);
        login_page.username.sendKeys(prop.getProperty("Username"));
        login_page.password.sendKeys(prop.getProperty("Password"));
        login_page.login.click();
        String logout =driver.findElement(By.id("logout")).getText();
        if(logout.equalsIgnoreCase("logout"))
        {
            System.out.println("User logined successfully.");
            Assert.assertEquals(logout,"Logout");
        }
        else
        {

            Assert.fail("login failed ");
        }
    }
    public static void logout()
    {
        LoginPage login_page= PageFactory.initElements(driver,LoginPage.class);
        login_page.logout.click();

        System.out.println("User logged out successfully");
    }

}


