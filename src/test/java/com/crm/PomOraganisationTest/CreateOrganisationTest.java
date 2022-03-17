package com.crm.PomOraganisationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class CreateOrganisationTest {
	
	@Test
	public void createOrganisationTest() throws Throwable
	{
		
		WebDriverUtility wLib=new WebDriverUtility();
		ExcelUtility eLib=new ExcelUtility();
		PropertyFileUtility pLib=new PropertyFileUtility();
		JavaUtility jLib=new JavaUtility();
		
		String BROWSER=pLib.readDataFromPropertyFile("browser");
		String URL =pLib.readDataFromPropertyFile("url");
		String USERNAME=pLib.readDataFromPropertyFile("username");
		String PASSWORD =pLib.readDataFromPropertyFile("password");
		
		String orgName = eLib.readDataFromExcel("Org", 1, 2)+jLib.getrandomnumber();
		
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
		hp.ClickOnOrgLnk();
		
		
		//Step4:click on create oragniastion link
		OrganisationPage op=new OrganisationPage(driver);
		op.ClickOnCreateOrgImg();
		
		//Step5:create organisation with mandatory fields
		CreateOrganisationPage cop=new CreateOrganisationPage(driver);
		cop.createNewOrg(orgName);
		
		//Step6: verification
				OrganisationInfoPage oip=new OrganisationInfoPage(driver);
				String actName = oip.OrgNameInfo();
				if(actName.contains(orgName))
				{
					System.out.println("data verified");
				}
				else {
					System.out.println("data not verified");
				}
		
		driver.quit();
		//close the application
		//hp.signOutOfApp(driver);
		
	}

}
