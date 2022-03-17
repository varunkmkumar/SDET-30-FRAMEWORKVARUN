package com.crm.LeadTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

public class EditLeadByMasseditTest {
	@Test
	public void editLeadByMasseditTest() throws Throwable {
		//read all neccesssary data
		//read data from property data
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\Commondata");
		Properties pObj=new Properties();
		pObj.load(fis);
		String BROWSER= pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		  
		
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
			
			Alert a = driver.switchTo().alert();
			a.accept();
			
			//logout the application
            
			
			
			
			
			
		
	}

}
