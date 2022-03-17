package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateLeadPage extends WebDriverUtility {
	
	//Declaration
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(name = "company")
	private WebElement companyEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	
	//Initialization
	public CreateLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}



	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}



	public WebElement getCompanyEdt() {
		return companyEdt;
	}



	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	
	//Business library
	public void createNewLead( String lastName,String company) {
		lastNameEdt.sendKeys(lastName);
		companyEdt.sendKeys(company);
		saveBtn.click();
		
		
		
	}

}
