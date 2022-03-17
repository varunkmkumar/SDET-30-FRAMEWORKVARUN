package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	//declarisation
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement CreateContLookUpImg;
	
	
	//initialisation
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//Utilisation
	public WebElement getCreateContLookUpImg() {
		return CreateContLookUpImg;
	}
	
	
	//Business Libarary
	public void ClickOnCreateContImg() {
		CreateContLookUpImg.click();
	}

}
