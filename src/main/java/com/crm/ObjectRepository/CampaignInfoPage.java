package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CampaignInfoPage extends WebDriverUtility{
	
	//Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
    private WebElement headerText;
	
	//Initialisation
	public CampaignInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
  
	
	//Utilisation
	public WebElement getHeaderText() {
		return headerText;
	}
	
	//business libarary
	public String campNameInfo() {
		String compaign = headerText.getText();
		return compaign;
		
	}
	
}
