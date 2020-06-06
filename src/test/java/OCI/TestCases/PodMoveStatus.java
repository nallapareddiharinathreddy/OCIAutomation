package OCI.TestCases;

import OCI.Login.Login;
import OCI.pagefactory.Application_Container_Operations;
import OCI.pagefactory.Component_Search;
import OCI.testBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;



@Listeners(OCI.utils.Listener.class)
public class PodMoveStatus extends TestBase {

    @BeforeClass
    public void podMoveStatus_Login()
    {
        try {
            Login.login();
            Component_Search search = PageFactory.initElements(driver, Component_Search.class);
            search.components.click();
            Select sc = new Select(search.Component_type);
            sc.selectByVisibleText("Pod Move Status");
            System.out.println(prop.getProperty("podmovestatus") + " Selected successfully");
            search.searchfield.clear();
            search.searchfield.sendKeys(prop.getProperty("podmovestatus"));
            Select sc1 = new Select(search.search_type);
            sc1.selectByVisibleText("All of these words");
            search.search_button.click();
            List<WebElement> webElements=driver.findElements(By.xpath("//a[@class='label_nothing']"));
            System.out.println(webElements.size());
            for(WebElement w:webElements)
            {

                if(prop.getProperty("podmovestatus").equalsIgnoreCase(w.getText()))
                {
                    System.out.println(w.getText());
                    w.click();
                    return;

                }
            }


        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    @Test
    public void podMove()
    {
        try {

            wait = new WebDriverWait(driver, 200);
            Application_Container_Operations tss_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
            wait.until(ExpectedConditions.elementToBeClickable(tss_app_operations.actions));
            tss_app_operations.actions.click();
            Actions ac = new Actions(driver);
            ac.moveToElement(tss_app_operations.movepod_action).click().perform();
            tss_app_operations.next_button.click();
            //wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("__status"),"Running..."));
            String status=tss_app_operations.action_status.getText();
            System.out.println(status);
            if (status.equalsIgnoreCase("Running...")) {
                System.out.println("pod move status action is running on " + prop.getProperty("podmovestatus"));
                Assert.assertTrue(true);
            }
                else if (status.equalsIgnoreCase("Success"))
                    {
                        System.out.println("pod move status action is executed successfully on "+ prop.getProperty("podmovestatus"));

                } else if (status.equalsIgnoreCase("Failed"))
            {
                System.out.println("pod move status action is failed on "+prop.getProperty("podmovestatus"));
                Assert.assertTrue(false);
            }
        }
        catch (Exception e)
        {
            Assert.assertTrue(false);
        }

    }
}
