package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class ContactInfoPage  extends WebDriverUtility{
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getHeaderText() {
		return headerText;
	}
	
	
	//Business Library
	
	public String ContNameInfo()
	{
		String continfo = headerText.getText();
		return continfo;
	}
			

}
