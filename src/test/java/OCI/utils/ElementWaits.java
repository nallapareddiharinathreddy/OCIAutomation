package OCI.utils;

import OCI.testBase.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ElementWaits extends TestBase {

    public static boolean textToBePresentInElement(WebElement element,  String value){
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
        return true;
    }
}
