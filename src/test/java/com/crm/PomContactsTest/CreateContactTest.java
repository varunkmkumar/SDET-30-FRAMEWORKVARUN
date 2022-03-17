package com.crm.PomContactsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
import com.crm.ObjectRepository.OrganisationInfoPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactTest {
	@Test
	public void createContactTest() throws Throwable {
		WebDriverUtility wLib=new WebDriverUtility();
		ExcelUtility eLib=new ExcelUtility();
		PropertyFileUtility pLib=new PropertyFileUtility();
		JavaUtility jLib=new JavaUtility();
		
		
		
	
		
	//read data from property file
		String BROWSER=pLib.readDataFromPropertyFile("browser");
		String URL =pLib.readDataFromPropertyFile("url");
		String USERNAME=pLib.readDataFromPropertyFile("username");
		String PASSWORD =pLib.readDataFromPropertyFile("password");
		
		//read data from excel
		String contName = eLib.readDataFromExcel("Contact", 1, 2);
		
		//open the browser and enter url
		
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.chromedriver().setup();
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
		
		//login to application
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		

		//create contact
		//1.navigate to contact link
		HomePage hp=new HomePage(driver);
		hp.ClickOncontactLnk();
		
		
		//2.click on conatct Imag
		ContactPage cp=new ContactPage(driver);
		cp.ClickOnCreateContImg();
		
		//3.send data to lastanme textfield and Save
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createNewCont(contName);
		
		//Step4: verification
		ContactInfoPage cip=new ContactInfoPage(driver);
		String actName = cip.ContNameInfo();
		if(actName.contains(contName))
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
