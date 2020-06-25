package RCC.pagefactory;

import RCC.testBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TomcatClusterPage extends TestBase {


    @FindBy(how= How.CLASS_NAME,using="actionMenuPopup")
    public WebElement actions;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Tomcat Operations')]")
    public WebElement tomcat_Operations;

    @FindBy(how=How.ID,using="label_for_value_operation_start")
    public WebElement start;

    @FindBy(how=How.ID,using="label_for_value_operation_restart")
    public WebElement restart;

    @FindBy(how=How.ID,using="label_for_value_operation_dumpkill")
    public WebElement dump_threads;

    @FindBy(how=How.ID,using="label_for_value_operation_stop")
    public   WebElement stop;

    @FindBy(how=How.ID,using="label_for_value_operation_kill")
    public WebElement hard_Stop;

    @FindBy(how=How.ID,using="label_for_value_needthreaddump_no")
    public WebElement need_thread_dump_no;

    @FindBy(how=How.ID,using="label_for_value_additionaloperation_applicationsrestart")
    public WebElement restart_after_deploy;

    @FindBy(how=How.ID,using="label_for_value_additionaloperation_webdeployrestart")
    public WebElement update_gracefully_restart_webcluster;

    @FindBy(how=How.ID,using="label_for_value_additionaloperation_forceinstallallapplications")
    public WebElement force_reinstall_apps;

    @FindBy(how=How.ID,using="btNextTop")
    public WebElement next_button;

    @FindBy(how=How.XPATH,using="//*[@type='text' and @id='waitingtime']")
    public WebElement waiting_time;

    @FindBy(how=How.XPATH,using="//*[@type='text' and @id='comments']")
    public WebElement comments;

    @FindBy(how=How.ID,using="__status")
    public WebElement action_status;

    @FindBy(how=How.ID,using="btClose")
    public WebElement close_button;

    @FindBy(how=How.XPATH,using="//*[@id=\"value___ctw_validate_yes\"]")
    public WebElement yes_option;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Get Status (Tomcat)')]")
    public WebElement get_tomcat_status;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Deploy Tomcat Cluster')]")
    public WebElement deploy_tomcat_cluster;



    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'has a status of (stopped)')]")
    public WebElement tomcat_app_stop_status;

    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'has a status of (running)')]")
    public WebElement tomcat_app_start_status;

    @FindBy(how=How.XPATH,using="//*[@type='text' and @id='userstomail']")
    public WebElement dump_thread_email;

    @FindBy(how=How.XPATH,using="//*[@type='text' and @id='nbthreads']")
    public WebElement dump_thread_number;

    @FindBy(how=How.XPATH,using="//*[@type='text' and @id='interval']")
    public WebElement dump_thread_interval_in_seconds;

    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'Send email to')]")
    public WebElement tomcat_dump_thread_success;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Schedule update config / graceful restart of webcluster')]")
    public WebElement Schedule_update_config_graceful_restart_of_webcluster;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Get Status (Apache)')]")
    public WebElement get_apache_status;

    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'apache processes running')]")
    public WebElement apache_running_status;


    public void SolrCluster(WebDriver driver)
    {
        this.driver=driver;
    }

}
