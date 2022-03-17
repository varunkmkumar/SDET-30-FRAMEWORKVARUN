package com.crm.OrganisationTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CreateOrganisationWithPrropertyFileTest {
@Test
public void createOrganisationWithPrropertyFile() throws Throwable
{
	//Step1: read data from proeprty file
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata");
	Properties pObj =new Properties();
	pObj.load(fis);
	String BROWSER=pObj.getProperty("browser");
	String URL =pObj.getProperty("url");
	String USERNAME=pObj.getProperty("username");
	String PASSWORD =pObj.getProperty("password");
	
	
	//Step2:launch the browser
	WebDriver driver =null;
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		driver=new FirefoxDriver();
	}
	else {
		System.out.println("invalid browser");
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(URL);
	
	//Step3:login to application
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			
			
			//Step4: navigaye to organisation link
			driver.findElement(By.linkText("Organizations")).click();
			
			//Step5:click on create oragniastion link
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			
			//Step6:create organisation with mandatory fields
			driver.findElement(By.name("accountname")).sendKeys("ALL STATES");
			
			//sTEP7:SAVE
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			driver.quit();
	
	
}

}
