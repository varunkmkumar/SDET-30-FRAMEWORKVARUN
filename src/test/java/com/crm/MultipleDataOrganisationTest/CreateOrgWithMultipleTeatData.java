package com.crm.MultipleDataOrganisationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrganisationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganisationInfoPage;
import com.crm.ObjectRepository.OrganisationPage;

public class CreateOrgWithMultipleTeatData {
	
	//create object for all utilities
	PropertyFileUtility pLib=new PropertyFileUtility();
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib=new JavaUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	
	@Test(dataProvider = "OrgTestdata")
	public void createOrgWithMultipleTeatData(String orgName, String indType) throws Throwable {
		
		//read data from propert file
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		
		 String orgname = orgName+jLib.getrandomnumber();
		
			//launch the application
			WebDriver driver = null;
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("FIREFOX"))
			{
				driver = new FirefoxDriver();
			}
			else
			{
				System.out.println("invalid browser");
			}
			
			wLib.maximizewindow(driver);
			wLib.waitforpageload(driver);
			driver.get(URL);
			
			
			//login to application
			LoginPage lp=new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			Reporter.log("login succesfull",true);
		
			//navigate to organisation link
			HomePage hp=new HomePage(driver);
			hp.ClickOnOrgLnk();
			Reporter.log("navigated to org link",true);
			
			
			//click org image
			OrganisationPage op=new OrganisationPage(driver);
			op.ClickOnCreateOrgImg();
			Reporter.log("click on create org link",true);
			
			
			//create new organisation
			CreateOrganisationPage cop=new CreateOrganisationPage(driver);
			cop.createNewOrg(orgname, indType);
			Reporter.log("create org with insustry type",true);
			
			
			//validation
			OrganisationInfoPage oip=new OrganisationInfoPage(driver);
			String actheader = oip.OrgNameInfo();
			if(actheader.contains(orgname))
			{
				System.out.println("passed");
			}
			else
			{
				System.out.println("failed");
			}
			Reporter.log("verification successful",true);		
			
			//logout
			hp.signOutOfApp(driver);
			
			
			
			
		
	}
	
	
	@DataProvider(name="OrgTestdata")
	public Object[][] getData() throws Throwable
	{
		
	Object[][] data1 = eLib.readMultipleDataFromExcel("OrgMultipleData");
	return data1;
	}
}

		
		
	


