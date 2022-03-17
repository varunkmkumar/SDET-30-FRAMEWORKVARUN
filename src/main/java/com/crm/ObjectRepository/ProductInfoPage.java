package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class ProductInfoPage extends WebDriverUtility{
	//Decalaration
		@FindBy(xpath = "//span[@class='lvtHeaderText']")
		private WebElement headerText;
		
		//initialization
		public ProductInfoPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		
		//Utilization
		public WebElement getHeaderText() {
			return headerText;
		}

		 //Business library
		public String PrdtNameInfo()
		{
			String PrdtInfo = headerText.getText();
			return PrdtInfo;
		}
		
}
