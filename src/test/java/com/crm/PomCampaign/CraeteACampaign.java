package com.crm.PomCampaign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CampaignsPage;
import com.crm.ObjectRepository.CreateCampaignPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class CraeteACampaign {
	
	@Test
	public void craeteACampaign() throws Throwable {
		WebDriverUtility wLib=new WebDriverUtility();
		ExcelUtility eLib=new ExcelUtility();
		PropertyFileUtility pLib=new PropertyFileUtility();
		JavaUtility jLib=new JavaUtility();
		
		String BROWSER=pLib.readDataFromPropertyFile("browser");
		String URL =pLib.readDataFromPropertyFile("url");
		String USERNAME=pLib.readDataFromPropertyFile("username");
		String PASSWORD =pLib.readDataFromPropertyFile("password");
		
		String campName = eLib.readDataFromExcel("Campaign", 1, 2)+jLib.getrandomnumber();
		
		//Step1:launch the browser
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("browser not found");
		}
		wLib.maximizewindow(driver);
		wLib.waitforpageload(driver);
		driver.get(URL);
		
		
		//Step2:login to application
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		
		//Step3: navigaye to campaignlink
		HomePage hp=new HomePage(driver);
		hp.camplinksearch(driver);
		
		//Step4:click on Imaage
		CampaignsPage cp=new CampaignsPage(driver);
		cp.clickOnCreateCampImg();
		
	    //Send data to webelements
		CreateCampaignPage ccp=new CreateCampaignPage(driver);
		ccp.createCampaign(campName);
		
		//Logout 
		hp.signOutOfApp(driver);
		
		
	}

}
