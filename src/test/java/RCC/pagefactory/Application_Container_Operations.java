package RCC.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class Application_Container_Operations {

    WebDriver driver;

    @FindBy(how= How.CLASS_NAME,using="actionMenuPopup")
    public WebElement actions;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Application container operations')]")
    public WebElement application_container_operations;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Add Schema')]")
    public WebElement add_schema;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Deploy Domain')]")
    public WebElement deploy_domain;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Stop WebLogic Cluster')]")
    public WebElement stop_WebLogic_Cluster;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Start WebLogic Cluster')]")
    public WebElement start_WebLogic_Cluster;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Restart WebLogic Cluster')]")
    public WebElement restart_WebLogic_Cluster;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Stop Admin Server')]")
    public WebElement stop_Admin_Server;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Start Admin Server')]")
    public WebElement start_Admin_Server;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Restart Admin Server')]")
    public WebElement restart_Admin_Server;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Deploy Application')]")
    public WebElement Deploy_Application;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Schedule update config / graceful restart of webcluster')]")
    public WebElement Schedule_update_config_graceful_restart_of_webcluster;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Stop Node Manager')]")
    public WebElement stop_weblogic_node_manager;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Restart Node Manager')]")
    public WebElement restart_weblogic_node_manager;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Start Node Manager')]")
    public WebElement start_weblogic_node_manager;

    @FindBy(how=How.ID,using="label_for_value_operation_stop")
    public   WebElement stop;

    @FindBy(how=How.ID,using="label_for_value_operation_suspend")
    public   WebElement Suspend;

    @FindBy(how=How.ID,using="label_for_value_operation_resume")
    public   WebElement Resume;


    @FindBy(how=How.XPATH,using="//*[@id=\"value___ctw_validate_yes\"]")
    public WebElement yes_option;

    @FindBy(how=How.ID,using="label_for_value_operation_start")
    public WebElement start;

    @FindBy(how=How.ID,using="label_for_value_operation_restart")
    public WebElement restart;


    @FindBy(how=How.ID,using="label_for_value_operation_dumpkill")
    public WebElement dump_threads;

    @FindBy(how=How.ID,using="label_for_value_operation_rollingrestart")
    public WebElement rolling_restart;

    @FindBy(how=How.ID,using="label_for_value_operation_kill")
    public WebElement hard_Stop;

    @FindBy(how=How.ID,using="label_for_value_additionaloperation_applicationsrestart")
    public WebElement restart_allapps;

    @FindBy(how=How.ID,using="label_for_value_additionaloperation_webdeployrestart")
    public WebElement gracefully_restart_webcluster;


    @FindBy(how=How.ID,using="label_for_value_additionaloperation_forceinstallallapplications")
    public WebElement force_reinstall_of_apps;




    @FindBy(how=How.ID,using="btNextTop")
    public WebElement next_button;

    @FindBy(how=How.ID,using="__status")
    public WebElement action_status;

    @FindBy(how=How.CLASS_NAME,using="Running...")
    public WebElement running_status;

    @FindBy(how=How.ID,using="btClose")
    public WebElement close_button;

    @FindBy(how=How.XPATH,using="/html/body/table[2]/tbody/tr/td/table/tbody/tr/td[2]/div/div[2]/div[9]/a")
    public WebElement get_Status_tomcat;

    @FindBy(how=How.XPATH,using="//*[@id=\"menuId260564\"]/div[2]/div[11]/a")
    public WebElement get_tomcat_status_new_old;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Get Status (Application Container)')]")
    public WebElement get_status_tee_appcontainer;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Add / Remove containers')]")
    public WebElement add_remove_containers;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Get Status')]")
    public WebElement weblogic_managed_server_status;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Get Status')]")
    public WebElement weblogic_admin_server_status;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Get Status')]")
    public WebElement weblogic_node_manager_status;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'JVM Dump Heap')]")
    public WebElement jvm_heap_dump;

    //*[@id="menuId257564"]/div[2]/div[11]/a

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Get Status (Tomcat)')]")
    public WebElement get_tomcat_status_new;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Get Status (Apache)')]")
    public WebElement get_apache_status;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Delete WebLogic status file')]")
    public WebElement delete_WebLogic_status_file;

    @FindBy(how=How.XPATH,using="//*[@class=\"dropmenudiv\"]/div/child::div/a[contains(text(),'Delete WebLogic lok file')]")
    public WebElement delete_WebLogic_lok_file;

    @FindBy(how=How.XPATH,using="//*[@id=\"__ctw_validate\"]/tbody/tr/td/strong/text()")
    public WebElement maintainance_window;

    @FindBy(how=How.ID,using="label_for_value___ctw_validate_yes")
    public WebElement manwindow;

    @FindBy(how=How.ID,using="label_for_value_operation_add")
    public WebElement add_container;

    @FindBy(how=How.ID,using="label_for_value_operation_remove")
    public WebElement remove_container;

    @FindBy(how=How.ID,using="value_nongcore_no")
    public WebElement nongcore_no_option;
    //*[@id="__ctw_validate"]/tbody/tr/td/strong/text()

    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'has a status of (stopped)')]")
    public WebElement tss_app_stop_status;

    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'is STOPPED (SHUTDOWN)')]")
    public WebElement tee_app_stop_status;

    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'schema imported')]")
    public WebElement db_add_schema_success;

    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'Commiting transaction')]")
    public WebElement deploy_domain_success;

    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'Admin server is down, Please start the admin server')]")
    public WebElement admin_server_stop_status;

    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'Current state of \"AdminServer\" : RUNNING')]")
    public WebElement admin_server_start_status;


    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'has a status of (running)')]")
    public WebElement tss_app_start_status;

    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'has a status of RUNNING')]")
    public WebElement tee_app_start_status;

    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'is RUNNING ')]")
    public WebElement weblogic_node_manager_ruuning;

    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'apache processes running')]")
    public WebElement apache_running_status;

    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'Files deleted successfully')]")
    public WebElement delete_weblogic_status_success;

    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'File deleted successfully')]")
    public WebElement delete_weblogic_lok_success;


    //*[@id="__content_277"]/text()

    @FindBy(how=How.XPATH,using="//*[@type='text' and @id='userstomail']")
    public WebElement dump_thread_email;

    @FindBy(how=How.XPATH,using="//*[@type='text' and @id='containernumber']")
    public WebElement container_number;

    @FindBy(how=How.XPATH,using="//*[@type='text' and @id='filter_servers']")
    public WebElement server_name;

    @FindBy(how=How.XPATH,using="//*[@type='checkbox']")
    public WebElement container_checkbox;

    @FindBy(how=How.XPATH,using="//*[@type='text' and @id='nbthreads']")
    public WebElement dump_thread_number;

    @FindBy(how=How.XPATH,using="//*[@type='text' and @id='interval']")
    public WebElement dump_thread_interval_in_seconds;

    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'Send email to')]")
    public WebElement tss_dump_thread_success;

    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'Heap dump file created')]")
    public WebElement jvm_heap_dump_created;

    @FindBy(how=How.XPATH,using="/html/body/table[2]/tbody/tr/td/table/tbody/tr/td[2]/div/div[2]/div[2]/a")
    public WebElement movepod_action;

    @FindBy(how=How.XPATH,using="/html/body/table[1]/tbody/tr[2]/td/table/tbody/tr/td[1]/div/a/span")
    public WebElement componet_close;

    @FindBy(how=How.XPATH,using="//*[@type='text' and @id='waitingtime']")
    public WebElement waiting_time;


    @FindBy(how=How.XPATH,using="//*[@type='text' and @id='databaseusername']")
    public WebElement databaseusername;

    @FindBy(how=How.XPATH,using="//*[@type='text' and @id='filter_dump_file']")
    public WebElement dump_file;

    @FindBy(how=How.ID,using="label_for_value_dump_file_")
    public   WebElement dump_file_select;

    @FindBy(how=How.XPATH,using="//*[@type='text' and @id='comments']")
    public WebElement comments;

    @FindBy(how=How.NAME,using="dump_file")
    public WebElement radio_button;


    @FindBy(how=How.XPATH,using="//*[@id=\"__status\"]")
    public WebElement action_execution_status;



    public int apacheRunning()
    {
        List<WebElement> wl=driver.findElements(By.xpath("//*[@id=\"scroll3\"]//*[contains(text(),'Starting solr ... SOLR IS STARTING IN BACKGROUND with PID:')]"));
        int k=wl.size();
        return  k;

    }

    public int weblogicNodeManagerStatus () throws Exception
    {
        int k=0,i=0;
        //WebDriverWait wait=new WebDriverWait(driver,90);
        while(k<1&&i<5) {
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"scroll3\"]//*[contains(text(),'responseHeader\":{\"status\":0')]")));
            List<WebElement> wl = driver.findElements(By.xpath("//*[@id=\"scroll3\"]//*[contains(text(),'is RUNNING')]"));
            //System.out.println("Waiting for one minute");
            k= wl.size();
            //System.out.println("Waiting for one minute");
            Thread.sleep(60000);
            driver.findElement(By.xpath("//*[@id=\"__reexecuteadmin\"]/input")).click();
            i++;
        }
        return k;

    }

   public Application_Container_Operations(WebDriver driver)
   {
       this.driver=driver;
   }


}