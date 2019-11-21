package com.OCI.pagefactory;

import com.OCI.testBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Component_Search extends TestBase {

    WebDriver driver;

    @FindBy(how= How.ID,using="components")
    public WebElement components;

    @FindBy(how= How.NAME,using="typeNo")
    public WebElement Component_type;

    @FindBy(how=How.ID,using="contains")
    public WebElement searchfield;

    @FindBy(how=How.ID,using="containsType")
    public WebElement search_type;

    @FindBy(how=How.ID,using="btn_search")
    public WebElement search_button;

    @FindBy(how=How.CLASS_NAME,using="label_nothing")
    public WebElement component_detail;

    @FindBy(how=How.XPATH,using="//*[@class='label_nothing' and contains()]")
    public WebElement componentnew;

    @FindBy(how=How.XPATH,using="//*[@cl/ass='rowdark' or @class='rowlight']//*[@class='label_nothing']")
    public WebElement componentcount;

    @FindBy(how=How.XPATH,using="//*[@class='items']//span[@class='label_nothing']")
    public WebElement component;

    @FindBy(how=How.ID,using="cancel")
    public WebElement componentclose;

    public Component_Search(WebDriver driver)

    {
        this.driver=driver;

    }




}
