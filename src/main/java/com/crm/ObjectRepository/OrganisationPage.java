package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class OrganisationPage extends WebDriverUtility {
	//Declaration
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement CreateOrgLookUpImg;
	
	
	//initialization
	public  OrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

	
	//utilization
	public WebElement getCreateOrgLookUpImg() {
		return CreateOrgLookUpImg;
	}

	//Business Library
	public void ClickOnCreateOrgImg()
	{
		CreateOrgLookUpImg.click();
	}
	
	
	
	
}
