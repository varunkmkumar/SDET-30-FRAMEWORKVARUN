package com.crm.PomOraganisationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrganisationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganisationPage;
import com.crm.OrganisationTests.CreateOrgNameWithIndustryTest;

public class CreateOrganisationWithIndustryTest {
	@Test
	public void createOrgNameWithIndustryTest() throws Throwable {

		WebDriverUtility wLib=new WebDriverUtility();
		ExcelUtility eLib=new ExcelUtility();
		PropertyFileUtility pLib=new PropertyFileUtility();
		JavaUtility jLib=new JavaUtility();
		
		
		
		
		
	
		String BROWSER=pLib.readDataFromPropertyFile("browser");
		String URL =pLib.readDataFromPropertyFile("url");
		String USERNAME=pLib.readDataFromPropertyFile("username");
		String PASSWORD =pLib.readDataFromPropertyFile("password");
		
		
		
		String Orgname = eLib.readDataFromExcel("Org", 4, 2)+jLib.getrandomnumber();
		String Ind = eLib.readDataFromExcel("Org", 4, 3);
		
		WebDriver driver=null;
		if( BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("browser not matchimg");
		}
		wLib.maximizewindow(driver);
		wLib.waitforpageload(driver);
		driver.get(URL);
		
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		
		HomePage hp=new HomePage(driver);
		hp.ClickOnOrgLnk();
		
		OrganisationPage op=new OrganisationPage(driver);
		op.ClickOnCreateOrgImg();
		
		CreateOrganisationPage cop =new CreateOrganisationPage(driver);
		cop.createNewOrg(Orgname, Ind);
		
		//hp.signOutOfApp(driver);
		//driver.quit();
		
	
		
	}


}
