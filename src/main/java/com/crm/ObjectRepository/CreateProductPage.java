package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateProductPage extends WebDriverUtility{
    //Decalaration
	@FindBy(name = "productname")
	private WebElement PrdtNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;	
	
	
	//Initialisation
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

   //utilisation
	public WebElement getPrdtNameEdt() {
		return PrdtNameEdt;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Libarary
	public void CreatePrdtPage(String prdtanme)
	{
		PrdtNameEdt.sendKeys(prdtanme);
		saveBtn.click();
	}
	
	
}
