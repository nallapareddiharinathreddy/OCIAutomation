package OCI.pagefactory;
import OCI.testBase.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends TestBase {

    WebDriver driver;

    @FindBy(how= How.ID,using="j_username")
    public WebElement username;

    @FindBy(how= How.ID,using="j_password")
    public WebElement password;


    @FindBy(how= How.ID,using="btn_login")
    public WebElement login;

    @FindBy(how= How.ID,using="logout")

    public WebElement logout;


    public LoginPage(WebDriver driver)
    {
        this.driver=driver;

    }
      int i=7;
    public  void test()
    {
        System.out.println(i);
    }



}
