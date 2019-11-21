package com.OCI.TestCases;

import com.OCI.Login.Login;
import com.OCI.pagefactory.Application_Container_Operations;
import com.OCI.pagefactory.Component_Search;
import com.OCI.testBase.TestBase;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import com.OCI.utils.*;


import java.util.List;
@Listeners(com.OCI.utils.Listener.class)

public class NewPodMoveStatus extends TestBase {

    @BeforeClass
    public void podMoveStatus_Login() {

        Login.login();
    }
    @Test(dataProvider="PodmoveData",dataProviderClass = ExcelDataReader.class)
            public void podMOveSelection(String sno,String podmovecomponentName)
    {
        try {
            System.out.println(podmovecomponentName);
            Component_Search search = PageFactory.initElements(driver, Component_Search.class);
            search.components.click();
            Select sc = new Select(search.Component_type);
            sc.selectByVisibleText("Pod Move Status");
            System.out.println("Pod Move Status" + " Selected successfully");
            search.searchfield.clear();
            search.searchfield.sendKeys(podmovecomponentName);
            Select sc1 = new Select(search.search_type);
            sc1.selectByVisibleText("All of these words");
            search.search_button.click();
            List<WebElement> webElements = driver.findElements(By.xpath("//a[@class='label_nothing']"));
            //System.out.println(webElements.size());
            if(webElements.isEmpty())
            {
                System.out.println(podmovecomponentName+ " is not  retunring no results In Search page");
                Assert.assertTrue(false);
            }
            else
            {
            for (WebElement w : webElements) {
                System.out.println(" the data from Excel is " + podmovecomponentName);
                String element = w.getText();
                System.out.println("compoent from rcc is " + element);
                {
                    if (podmovecomponentName.equalsIgnoreCase(w.getText())) {
                        //System.out.println(w.getText());
                        w.click();
                        wait = new WebDriverWait(driver, 200);
                        Application_Container_Operations tss_app_operations = PageFactory.initElements(driver, Application_Container_Operations.class);
                        wait.until(ExpectedConditions.elementToBeClickable(tss_app_operations.actions));
                        tss_app_operations.actions.click();
                        Actions ac = new Actions(driver);
                        ac.moveToElement(tss_app_operations.movepod_action).click().perform();
                        tss_app_operations.next_button.click();
                        //wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("__status"),"Running..."));
                        String status = tss_app_operations.action_status.getText();
                        System.out.println(status);
                        if (status.equalsIgnoreCase("Running...")) {
                            System.out.println("pod move status action is running on " + podmovecomponentName);

                            tss_app_operations.close_button.click();
                            search.componentclose.click();
                            System.out.println("component closed successfully");
                            //Assert.assertTrue(true);

                        } else if (status.equalsIgnoreCase("Success")) {
                            System.out.println("pod move status action is executed successfully on " + podmovecomponentName);

                        } else if (status.equalsIgnoreCase("Failed")) {
                            System.out.println("pod move status action is failed on " + podmovecomponentName);
                            //Assert.assertTrue(false);
                        }


                        return;

                    }
                }
            }}




        }

        catch (Exception e)
        {
            System.out.println(e);
            //Assert.assertTrue(false);
        }

    }

    @AfterClass
    public void tss_Logout()
    {
        Login.logout();
    }

}
