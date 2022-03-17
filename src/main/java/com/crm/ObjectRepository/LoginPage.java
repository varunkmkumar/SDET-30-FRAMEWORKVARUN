package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//Step1: Declaration  -use FindBy annotation
    @FindBy(name="user_name")
    private WebElement userNameEdt;
    
    @FindBy(name="user_password")
    private WebElement passwordEdt;
    
    @FindBy(id="submitButton")
    private WebElement submitBtn;
    
    //Step2: Initialization  -use constaructor
    public LoginPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }

    
    //Step3:Utilization provide gettors 
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	//Business Library
	public void loginToApp(String username,String password)
	{
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		submitBtn.click();
	}
    
    
}
