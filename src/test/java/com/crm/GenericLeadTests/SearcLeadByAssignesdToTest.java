package com.crm.GenericLeadTests;

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

public class SearcLeadByAssignesdToTest {
	@Test
	public void searchLeadByPhoneTest() throws Throwable {

		WebDriverUtility wLib=new WebDriverUtility();
		ExcelUtility eLib=new ExcelUtility();
		PropertyFileUtility pLib=new PropertyFileUtility();
		JavaUtility jLib=new JavaUtility();
		
		//read all necessary data
		//read data from property file
		String BROWSER=pLib.readDataFromPropertyFile("browser");
		String URL =pLib.readDataFromPropertyFile("url");
		String USERNAME=pLib.readDataFromPropertyFile("username");
		String PASSWORD =pLib.readDataFromPropertyFile("password");
		
		
		        //read data from excel
		String lead = eLib.readDataFromExcel("Lead", 4, 0);
		String led = eLib.readDataFromExcel("Lead", 4, 1);
				
				//launch the browser
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
				
				//login to application

				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				//navigate to lead
				driver.findElement(By.linkText("Leads")).click();
				
				//enter value into search for
				driver.findElement(By.name("search_text")).sendKeys(lead);
				
				//select website drop down
				WebElement ele = driver.findElement(By.id("bas_searchfield"));
				wLib.select(led, ele);
				
				
				//click on search button
				driver.findElement(By.name("submit")).click();
				
				//logout of application
				WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wLib.mouseHover(driver, signout);
				
				//click on signout link
				driver.findElement(By.xpath("//a[.='Sign Out']")).click();
				
				
				
				
				
				
	}

}
