package RCC.utils;

import RCC.pagefactory.Application_Container_Operations;
import RCC.testBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionStatus extends TestBase {


    public boolean actionStatusNotRunning()
    {
        //WebDriverWait wait=new WebDriverWait(driver,7800);
        boolean running=false;

            if(wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("__status"),"Running...")))
            {
                running=true;
            }



        return running;
    }
    public boolean actionStatusSuccess()
    {
        Application_Container_Operations app= PageFactory.initElements(driver,Application_Container_Operations.class);
        WebDriverWait wait=new WebDriverWait(driver,600);
        boolean running=false;

            if(wait.until(ExpectedConditions.textToBePresentInElement(app.action_status, "Success")))
            {
                //System.out.println("before");
                running=true;
                //System.out.println("after");
            }




        return running;

    }
    public boolean newactionStatusNotRunning() throws Exception
    {
        //WebDriverWait wait=new WebDriverWait(driver,7800);
        boolean running=false;

        while(running==false)
        {
            String current_status = driver.findElement(By.id("__status")).getText();
            if(current_status!="Running...") {
                running=true;

            }
            Thread.sleep(300000);
            driver.navigate().refresh();

        }




        return running;
    }

    public void actionWait() throws Exception
    {
        Thread.sleep(6000);
    }

}
