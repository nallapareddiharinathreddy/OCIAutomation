package RCC.pagefactory;
import RCC.testBase.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(how= How.ID,using="footer")
    public WebElement BuildValue;





    public LoginPage(WebDriver driver)
    {
        this.driver=driver;

    }

    public   String buildversion()
    {
        String build=null;

        LoginPage login_page= PageFactory.initElements(driver,LoginPage.class);
        String k=login_page.BuildValue.getText();
        String text[]=k.split("RCC");
        for (String s:text)
        {
            if(s.contains("Server")) {
                 String version[]= s.split("Server");
                build=version[0];
            }
        }

        //System.out.println(k);
        //System.out.println(build);


        return  build;

    }



}
