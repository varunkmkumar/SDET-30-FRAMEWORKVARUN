package com.crm.OrganisationTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CreateOrgTest {

	@Test
	public void createOrgTest() throws Throwable {
		
		/* generate random number*/
		Random rand =new Random();
		int random = rand.nextInt(500);
		
		/*Step1: read all necessary data*/
		//read data from property file 
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata");
		Properties pObj=new Properties();
		pObj.load(fis);
		String BROWSER= pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		//read data from Excel
		FileInputStream fs=new FileInputStream(".\\src\\test\\resources\\Assignment.xlsx");
		Workbook wb =WorkbookFactory.create(fs);
		Sheet sh = wb.getSheet("Org");
		Row ro = sh.getRow(1);
		Cell ce = ro.getCell(2);
		String Orgname = ce.getStringCellValue();
		
		
		
		//Step2:launch the browser
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
			System.out.println("invalid browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		
		//Step3:login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to organisation link
		driver.findElement(By.linkText("Organizations")).click();
		
		//click on create organisation button
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//enter mandattory link and save
		driver.findElement(By.name("accountname")).sendKeys(Orgname+" "+random);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		
		
		
	}
}
