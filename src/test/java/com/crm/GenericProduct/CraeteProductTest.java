package com.crm.GenericProduct;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CraeteProductTest {
	@Test
	public void createProductTest() throws IOException {
		//genearte Random number
		Random ran =new Random();
		int random = ran.nextInt(500);
		
		//read neccessary data
		//read data from property file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData");
		Properties pObj = new Properties();
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
	//read data from excel
		FileInputStream fs=new FileInputStream(".\\src\\test\\resources\\Assignment.xlsx");
		Workbook wb =WorkbookFactory.create(fs);
	    org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet("Product");
	   Row ro = sh.getRow(1);
	   Cell ce = ro.getCell(2);
	   String PrdNam = ce.getStringCellValue();
	   
	  Row row = sh.getRow(4);
	  Cell cel = row.getCell(2);
	 String Campname = cel.getStringCellValue();
	   
		
		/*Step 2: launch the browser*/
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		
		/*Step 3: login to application*/
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to product link
		driver.findElement(By.linkText("Products")).click();
		
		//click on create product link
	    driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	    
	    //enter madatory fields and save
	    driver.findElement(By.name("productname")).sendKeys(PrdNam+" "+random);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
	   WebElement dr = driver.findElement(By.xpath("//a[.='More']"));
	   Actions acttion=new Actions(driver);
	   acttion.moveToElement(dr).perform();
	   
	   
	   driver.findElement(By.name("Campaigns")).click();
	   
	   driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
	   
	   driver.findElement(By.name("campaignname")).sendKeys(Campname);
	   
	   
	   driver.findElement(By.xpath("//img[@alt='Select']")).click();
	   Set<String> all = driver.getWindowHandles();
	   for (String wh: all) {
		   driver.switchTo().window(wh);	
	}
	   
	   driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(PrdNam+" "+random);
	   
	   driver.findElement(By.name("search")).click();
	   
	 Set<String> bll = driver.getWindowHandles();
	 for (String wbb:bll)
	 {
		 driver.switchTo().window(wbb);
	 }
	  
	   driver.findElement(By.id("14")).click();
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	   
	   
	   
	   
	   
	   
	   
		
		
		
		
		
	}

}
