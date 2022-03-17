package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class OrganisationInfoPage extends WebDriverUtility {
	
	//Decalaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	//initialization
	public OrganisationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Utilization
	public WebElement getHeaderText() {
		return headerText;
	}

	 //Business library
	public String OrgNameInfo()
	{
		String OrgInfo = headerText.getText();
		return OrgInfo;
	}
	
	
}
