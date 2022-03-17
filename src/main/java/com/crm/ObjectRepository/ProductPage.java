package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class ProductPage extends WebDriverUtility {
  
	//Declaration
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement CreateProdLookUpImg;
	
	//Initialisation
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

   //Utilization
	public WebElement getCreateProdLookUpImg() {
		return CreateProdLookUpImg;
	}
	
	
	//Business Library
	public void ClickOnCreatePrdImg()
	{
		CreateProdLookUpImg.click();
	}
	
}
