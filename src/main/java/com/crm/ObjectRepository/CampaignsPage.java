package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CampaignsPage extends WebDriverUtility {
	//Declaration
	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement CreateCampLookUpImg;
	
	

	//Initialization
	public CampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Utilisation
	public WebElement getCreateCampLookUpImg() {
		return CreateCampLookUpImg;
	}
	
	
	//business library
	
	public void clickOnCreateCampImg() {
		CreateCampLookUpImg.click();
		
	}

}
