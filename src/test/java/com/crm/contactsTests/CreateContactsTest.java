package com.crm.contactsTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

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

public class CreateContactsTest {
@Test
public void createContactsTest() throws Throwable 
{
	Random rand=new Random();
	int random=rand.nextInt(500);

	//Step1:read data
	//read data from propertryfile
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata");
	Properties pObj =new Properties();
	pObj.load(fis);
	String BROWSER=pObj.getProperty("browser");
	String URL =pObj.getProperty("url");
	String USERNAME=pObj.getProperty("username");
	String PASSWORD =pObj.getProperty("password");
	
	//read data from excel
	FileInputStream fs =new FileInputStream(".\\src\\test\\resources\\Assignment.xlsx");
	Workbook wb=WorkbookFactory.create(fs);
	Sheet sh = wb.getSheet("Sheet1");
	Row ro = sh.getRow(0);
	Cell ce = ro.getCell(1);
	String Orgname = ce.getStringCellValue();
	

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
	driver.get(URL);
	
	
	
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
	
	
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	
	driver.findElement(By.name("lastname")).sendKeys(Orgname+" "+random);
	driver.findElement(By.name("button")).click();
	
}
}
