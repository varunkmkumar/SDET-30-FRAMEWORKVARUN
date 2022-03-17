package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateOrganisationPage extends WebDriverUtility {
     //Declaration
	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement IndustryDropDown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//initialization
	public CreateOrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	//Business Library
	public void createNewOrg(String orgName)
	{
		OrgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	 
	public void createNewOrg(String orgName,String indtype)
	{
		OrgNameEdt.sendKeys(orgName);
		select(indtype, IndustryDropDown);
		saveBtn.click();
	}
	
	public void createNewOrg(String orgName,String indtype,String type)
	{
		OrgNameEdt.sendKeys(orgName);
		select(indtype, IndustryDropDown);
		select(type, typeDropDown);
		saveBtn.click();
	}
	
}
