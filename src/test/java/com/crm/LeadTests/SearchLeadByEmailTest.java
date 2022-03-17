package com.crm.LeadTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SearchLeadByEmailTest {
   @Test
   public void searchLeadByEmailTest() throws Throwable {
	   //read necessary data 
	   //read data from excel
	   FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata");
	   Properties pObj=new Properties();
	   pObj.load(fis);
	   String BROWSER= pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		//read data from excel
		FileInputStream fes=new FileInputStream(".\\src\\test\\resources\\Assignment.xlsx");
		Workbook wb=WorkbookFactory.create(fes);
		Sheet sh = wb.getSheet("Lead");
		Row ro = sh.getRow(3);
		Cell ce = ro.getCell(0);
		String lead = ce.getStringCellValue();
		
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
		Select se=new Select(ele);
		se.selectByValue(lead);
		
		//click on search button
		driver.findElement(By.name("submit")).click();
		
		//logout of application
		WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(signout).perform();
		
		//click on signout link
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
		
		
		
		
	   
	   
	   
	   
   }
}
