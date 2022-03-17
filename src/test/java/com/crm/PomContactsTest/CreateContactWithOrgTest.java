package com.crm.PomContactsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateOrganisationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganisationInfoPage;
import com.crm.ObjectRepository.OrganisationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrgTest {
	@Test
	public void createContactWithOrgTest () throws Throwable {
		WebDriverUtility wLib=new WebDriverUtility();
		ExcelUtility eLib=new ExcelUtility();
		PropertyFileUtility pLib=new PropertyFileUtility();
		JavaUtility jLib=new JavaUtility();
		
		//read data from property file
			String BROWSER=pLib.readDataFromPropertyFile("browser");
			String URL =pLib.readDataFromPropertyFile("url");
			String USERNAME=pLib.readDataFromPropertyFile("username");
			String PASSWORD =pLib.readDataFromPropertyFile("password");
		
			//read Neccessary data FRom EXcel
			String lastname = eLib.readDataFromExcel("Contact", 4, 2);
			String Orgname = eLib.readDataFromExcel("Contact", 4, 3)+jLib.getrandomnumber();
			
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
			hp.ClickOnOrgLnk();
			
			
			//Step4:click on create oragniastion link
			OrganisationPage op=new OrganisationPage(driver);
			op.ClickOnCreateOrgImg();
			
			//Step5:create organisation with mandatory fields
			CreateOrganisationPage cop=new CreateOrganisationPage(driver);
			cop.createNewOrg(Orgname);
			
			OrganisationInfoPage oip=new OrganisationInfoPage(driver);
			String actName = oip.OrgNameInfo();
			if(actName.contains(Orgname))
			{
				System.out.println("data verified");
			}
			else {
				System.out.println("data not verified");
			}
	
			
			hp.ClickOncontactLnk();
			
			
			//2.click on conatct Imag
			ContactPage cp=new ContactPage(driver);
			cp.ClickOnCreateContImg();
			
			
			//send data 
			CreateContactPage ccp=new CreateContactPage(driver);
			ccp.createNewCont(driver, Orgname, lastname);
			
			//logout
			hp.signOutOfApp(driver);
		
	}
}
