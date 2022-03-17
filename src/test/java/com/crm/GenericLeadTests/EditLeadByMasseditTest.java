package com.crm.GenericLeadTests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
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

public class EditLeadByMasseditTest {
	@Test
	public void editLeadByMasseditTest() throws Throwable {

		WebDriverUtility wLib=new WebDriverUtility();
		ExcelUtility eLib=new ExcelUtility();
		PropertyFileUtility pLib=new PropertyFileUtility();
		JavaUtility jLib=new JavaUtility();
		
		//read all neccesssary data
		//read data from property data
		String BROWSER=pLib.readDataFromPropertyFile("browser");
		String URL =pLib.readDataFromPropertyFile("url");
		String USERNAME=pLib.readDataFromPropertyFile("username");
		String PASSWORD =pLib.readDataFromPropertyFile("password");
		
		
		  
		
		//launch the bowser
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			
		}
		else {
			System.out.println("no browser selected");
		}
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.get(URL);
		
		    
		//login to application
		    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			
			//navigate to lead
			driver.findElement(By.linkText("Leads")).click();
			
			//clic on mass edit
			driver.findElement(By.xpath("//input[@value='Mass Edit']")).click();
			
			//handel popup
			wLib.acceptAlert(driver);
			
			
			
			//logout the application
			WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wLib.mouseHover(driver, signout);
			
			//click on signout link
			driver.findElement(By.xpath("//a[.='Sign Out']")).click();
			
			
			
			
			
			
		
	}


}
