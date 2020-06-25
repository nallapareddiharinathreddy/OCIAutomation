package RCC.pagefactory;

import RCC.testBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SolrClusterPage extends TestBase {



    @FindBy(how= How.CLASS_NAME,using="actionMenuPopup")
    public WebElement actions;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'List all Solr Cores')]")
    public WebElement ListSolrCores;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'File Viewer (SOLR)')]")
    public WebElement FileViewer;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'SOLR Control Operations')]")
    public WebElement SOLR_Control_Operations;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Get Status')]")
    public WebElement get_status;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Deploy SOLR Cluster')]")
    public WebElement deploy;

    @FindBy(how= How.XPATH,using="//*[@id=\"menuId233742\"]")
    public WebElement actionsmenu;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'ZooKeeper Node Operations')]")
    public WebElement ZooKeeper_Node_Operations;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'ZooKeeper Commands')]")
    public WebElement ZooKeeper_Commands;

    @FindBy(how= How.XPATH,using="/html/body/table[3]/tbody/tr[2]/td/table/tbody/tr/td/div/table[2]/tbody/tr/td/b[1]")
    public WebElement Staticcores;

    @FindBy(how= How.XPATH,using="/html/body/table[3]/tbody/tr[2]/td/table/tbody/tr/td/div/table[2]/tbody/tr/td/text()[]")
    public WebElement Staticoresname;

    @FindBy(how=How.ID,using="__status")
    public WebElement action_status;

    @FindBy(how=How.ID,using="label_for_value_operation_start")
    public WebElement start;

    @FindBy(how=How.ID,using="label_for_value_operation_stop")
    public WebElement stop;

    @FindBy(how=How.ID,using="label_for_value_command_dump")
    public WebElement dump;

    @FindBy(how=How.ID,using="label_for_value_command_envi")
    public WebElement envi;

    @FindBy(how=How.ID,using="label_for_value_command_srvr")
    public WebElement srvr;


    @FindBy(how=How.ID,using="label_for_value_operation_restart")
    public WebElement restart;

    @FindBy(how=How.ID,using="label_for_value_operation_status")
    public WebElement status;


    @FindBy(how=How.ID,using="label_for_value_operation_info")
    public WebElement solrinfo;

    @FindBy(how=How.ID,using="label_for_value_operation_print-cmd")
    public WebElement solr_Command;

    @FindBy(how=How.ID,using="label_for_value_operation_clusterstate")
    public WebElement clusterState;

    @FindBy(how=How.ID,using="btNextTop")
    public WebElement next_button;

    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'Stopping solr ... STOPPED')]")
    public WebElement solr_stop_status;

    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'Mode: leader')]")
    public WebElement zookeper_leader;

    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'Mode: follower')]")
    public WebElement zookeper_follower;

    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'Stopping zookeeper ... STOPPED')]")
    public WebElement zookeper_stop;

    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'Starting zookeeper ... STARTED')]")
    public WebElement zookeper_start;

    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'Result for command dump:')]")
    public WebElement zookeper_dump;

    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'Result for command envi:')]")
    public WebElement zookeper_envi;

    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'Result for command srvr:')]")
    public WebElement zookeper_srvr;

    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'Starting solr ... SOLR IS STARTING IN BACKGROUND with PID:')]")
    public WebElement solr_start_status;


   public int Stop()
   {
       List<WebElement> wl=driver.findElements(By.xpath("//*[@id=\"scroll3\"]//*[contains(text(),'Stopping solr ... STOPPED')]"));
       int k=wl.size();
       return  k;

   }

    public int Start()
    {
        List<WebElement> wl=driver.findElements(By.xpath("//*[@id=\"scroll3\"]//*[contains(text(),'Starting solr ... SOLR IS STARTING IN BACKGROUND with PID:')]"));
        int k=wl.size();
        return  k;

    }
    public int zookperfollower()
    {
        List<WebElement> wl=driver.findElements(By.xpath("//*[@id=\"scroll3\"]//*[contains(text(),'Mode: follower')]"));
        int k=wl.size();
        return  k;

    }
    public int zookperNodeStop()
    {
        List<WebElement> wl=driver.findElements(By.xpath("//*[@id=\"scroll3\"]//*[contains(text(),'Stopping zookeeper ... STOPPED')]"));
        int k=wl.size();
        return  k;

    }
    public int zookperNodeStart()
    {
        List<WebElement> wl=driver.findElements(By.xpath("//*[@id=\"scroll3\"]//*[contains(text(),'Starting zookeeper ... STARTED')]"));
        int k=wl.size();
        return  k;

    }
    public boolean zookeeprStatus()
    {
        boolean available = false;
        try {

            if (zookeper_leader.isDisplayed()) {
                available = true;

            } else {
                if (zookeper_follower.isDisplayed()) {
                    available = true;
                }

            }
            return available;
        }
        catch (Exception e)
        {
            if (zookeper_follower.isDisplayed()) {
                available = true;
                return  available;
            }

        }
        return available;
    }
    public int Status () throws Exception
    {
        int k=0,i=0;
        //WebDriverWait wait=new WebDriverWait(driver,90);
        while(k<2&&i<5) {
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"scroll3\"]//*[contains(text(),'responseHeader\":{\"status\":0')]")));
            List<WebElement> wl = driver.findElements(By.xpath("//*[@id=\"scroll3\"]//*[contains(text(),'Solr is alive')]"));
            //System.out.println("Waiting for one minute");
             k= wl.size();
            //System.out.println("Waiting for one minute");
            Thread.sleep(60000);
            driver.findElement(By.xpath("//*[@id=\"__reexecuteadmin\"]/input")).click();
            i++;
        }
        return k;

    }
    public int info ()
    {



            List<WebElement> wl=driver.findElements(By.xpath("//*[@id=\"scroll3\"]//*[contains(text(),'responseHeader\":{\"status\":0')]"));
            int k=wl.size();

        return k;
    }
    public int ClusterState()
    {
        List<WebElement> wl=driver.findElements(By.xpath("//*[@id=\"scroll3\"]//*[contains(text(),'znode')]"));
        int k=wl.size();
        return k;
    }
    public int printSolrCommand()
    {
        List<WebElement> wl=driver.findElements(By.xpath("//*[@id=\"scroll3\"]//*[contains(text(),'/mnt/')]"));
        int k=wl.size();
        return k;
    }

    public boolean dump()
    {
        boolean k = false;
        try {

            if (zookeper_dump.isDisplayed()) {
                k = true;
            }
        }
        catch (Exception e)
        {
            return k;
        }

        return k;
    }
    public boolean envi()
    {
        boolean k = false;
        try {

            if (zookeper_envi.isDisplayed()) {
                k = true;
            }
        }
        catch (Exception e)
        {
            return k;
        }

        return k;
    }
    public boolean srvr()
    {
        boolean k = false;
        try {

            if (zookeper_srvr.isDisplayed()) {
                k = true;
            }
        }
        catch (Exception e)
        {
            return k;
        }

        return k;
    }



    public void SolrCluster(WebDriver driver)
    {
        this.driver=driver;
    }
}
