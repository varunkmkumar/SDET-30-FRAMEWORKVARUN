package com.crm.MultipleDataContactTests;

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
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class CreateContactWithMutlipleDataTest {
	
	//create object for all utilities
			PropertyFileUtility pLib=new PropertyFileUtility();
			ExcelUtility eLib=new ExcelUtility();
			JavaUtility jLib=new JavaUtility();
			WebDriverUtility wLib=new WebDriverUtility();
	
	@Test(dataProvider = "ContactTestData")
	public void createContactWithMutlipleDataTest(String lastname ) throws Throwable
	{
		
		//read data from propert file
				String BROWSER = pLib.readDataFromPropertyFile("browser");
				String URL = pLib.readDataFromPropertyFile("url");
				String USERNAME = pLib.readDataFromPropertyFile("username");
				String PASSWORD = pLib.readDataFromPropertyFile("password");
				
				String LastName = lastname+jLib.getrandomnumber();
				
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
			
				//navigate to contact link
				HomePage hp=new HomePage(driver);
				hp.ClickOncontactLnk();
				Reporter.log("navigated to contact link",true);
				
				//clivk on contact image
				ContactPage cp=new ContactPage(driver);
				cp.ClickOnCreateContImg();
				Reporter.log("clicked on contact image",true);
				
				
				//craete contacts 
				CreateContactPage ccp=new CreateContactPage(driver);
				ccp.createNewCont(LastName);
				Reporter.log("contact created",true);
				
				//validation
				ContactInfoPage cip=new ContactInfoPage(driver);
				String actheader = cip.ContNameInfo();
			if(actheader.contains(LastName))
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
	
	@DataProvider(name="ContactTestData")
	public Object[][] getdata() throws Throwable {
		Object[][] data = eLib.readMultipleDataFromExcel("ContactMultipledata");
		return data;
		
		
		
		
	}
	
	

}
