package RCC.pagefactory;

import  RCC.testBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ZoneStatus extends TestBase{

    @FindBy(how=How.XPATH,using="/html/body/font[1]/a/img")
    public WebElement zone_not_running;

    @FindBy(how=How.XPATH,using="//*[@id=\"jLoginPopoverBtn\"]/span")
    public WebElement tss_zone_signin;



    @FindBy(how=How.XPATH,using="//*[@id=\"dialogTemplate-dialogForm-content-login-defaultCmd\"]/span/span/span/span")
    public WebElement tee_zone_signin;


    //*[@id="jLoginPopoverBtn"]/span



    public ZoneStatus(WebDriver driver)

    {
        this.driver=driver;

    }

}
