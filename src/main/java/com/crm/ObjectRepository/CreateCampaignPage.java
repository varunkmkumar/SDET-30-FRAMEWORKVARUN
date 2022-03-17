package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateCampaignPage extends WebDriverUtility{
	//Declaration
	@FindBy(name = "campaignname")
	private WebElement campNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
     private WebElement saveBtn;
	
	//Initialisation
	public  CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampNameEdt() {
		return campNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Library
	public void createCampaign(String campname)
	{
		campNameEdt.sendKeys(campname);
		saveBtn.click();
	}
	
}
