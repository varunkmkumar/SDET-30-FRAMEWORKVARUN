package com.crmPomProduct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ProductInfoPage;
import com.crm.ObjectRepository.ProductPage;

public class CraeteProductTest {
  
	@Test
	public void craeteProductTest() throws Throwable {

		WebDriverUtility wLib=new WebDriverUtility();
		ExcelUtility eLib=new ExcelUtility();
		PropertyFileUtility pLib=new PropertyFileUtility();
		JavaUtility jLib=new JavaUtility();
		
		String BROWSER=pLib.readDataFromPropertyFile("browser");
		String URL =pLib.readDataFromPropertyFile("url");
		String USERNAME=pLib.readDataFromPropertyFile("username");
		String PASSWORD =pLib.readDataFromPropertyFile("password");
		
		String prdtName = eLib.readDataFromExcel("Product", 1, 2)+jLib.getrandomnumber();
		
		//Step1:launch the browser
		WebDriver driver=new ChromeDriver();
		wLib.maximizewindow(driver);
		wLib.waitforpageload(driver);
		driver.get(URL);
		
		//Step2:login to application
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		
		
		//Step3: navigaye to organisation link
		HomePage hp=new HomePage(driver);
		hp.ClickOnProductLink();
		
		//click product img
		ProductPage pp=new ProductPage(driver);
		pp.ClickOnCreatePrdImg();
		
		//create product
		CreateProductPage cpp=new CreateProductPage(driver);
		cpp.CreatePrdtPage(prdtName);
		
		//verification
		ProductInfoPage cip=new ProductInfoPage(driver);
		String actName = cip.PrdtNameInfo();
		if(actName.contains(prdtName))
		{
			System.out.println("data verified");
		}
		else {
			System.out.println("data not verified");
		}
		
		//logout 
		hp.signOutOfApp(driver);
				
		
		
		
	}
	
}
