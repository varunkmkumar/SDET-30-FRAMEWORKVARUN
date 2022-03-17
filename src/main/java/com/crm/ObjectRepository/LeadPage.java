package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class LeadPage extends WebDriverUtility {

	//Declaration
	@FindBy(xpath ="//img[@title='Create Lead...']" )
	private WebElement leadLookUpImg;
	
	
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search_field")
	private WebElement searchDropDown;
	
	@FindBy(name = "submit")
    private WebElement submiBtn;	
	
	
	
	
	
	//Initialization
	
	public LeadPage(WebDriver driver)
{
		
		PageFactory.initElements(driver, this);
		
		}

	
	
	
	//Utilization
	
	public WebElement getLeadLookUpImg() {
		return leadLookUpImg;
	}
	
	public WebElement getSearchEdt() {
		return searchEdt;
	}




	public WebElement getSearchDropDown() {
		return searchDropDown;
	}




	public WebElement getSubmiBtn() {
		return submiBtn;
	}


	
	
	
	
	
	
	
	
	


	//Business library
	public void clickOnLeadImg() {
		
		leadLookUpImg.click();
		
	}
	
	public void searchLead(String searchfor,String in)
	{
		searchEdt.sendKeys(searchfor);
		select(in, searchDropDown);
		submiBtn.click();
	}
}
