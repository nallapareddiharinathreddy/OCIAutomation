package com.OCI.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Application_Container_Operations {

    WebDriver driver;

    @FindBy(how= How.CLASS_NAME,using="actionMenuPopup")
    public WebElement actions;

    @FindBy(how=How.XPATH,using="/html/body/table[2]/tbody/tr/td/table/tbody/tr/td[2]/div/div[2]/div[3]/a")
    public WebElement application_container_operations;

    @FindBy(how=How.ID,using="label_for_value_operation_stop")
    public   WebElement stop;

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

    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'has a status of (stopped)')]")
    public WebElement tss_app_stop_status;

    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'has a status of (running)')]")
    public WebElement tss_app_start_status;

    @FindBy(how=How.XPATH,using="//*[@type='text' and @id='userstomail']")
    public WebElement dump_thread_email;

    @FindBy(how=How.XPATH,using="//*[@type='text' and @id='nbthreads']")
    public WebElement dump_thread_number;

    @FindBy(how=How.XPATH,using="//*[@type='text' and @id='interval']")
    public WebElement dump_thread_interval_in_seconds;

    @FindBy(how=How.XPATH,using="//*[@id=\"scroll3\"]//*[contains(text(),'Send email to')]")
    public WebElement tss_dump_thread_success;

    @FindBy(how=How.XPATH,using="/html/body/table[2]/tbody/tr/td/table/tbody/tr/td[2]/div/div[2]/div[2]/a")
    public WebElement movepod_action;



   public Application_Container_Operations(WebDriver driver)
   {
       this.driver=driver;
   }


}