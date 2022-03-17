package com.crm.OrganisationTests;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateOrgNameWithIndustryTest {
	@Test
	public void createOrgNameWithIndustryTest() throws Throwable {
		
		Random rand=new Random();
		int random = rand.nextInt();
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata");
		Properties pObj =new Properties();
		pObj.load(fis);
		String BROWSER=pObj.getProperty("browser");
		String URL =pObj.getProperty("url");
		String USERNAME=pObj.getProperty("username");
		String PASSWORD =pObj.getProperty("password");
		
		
		
		FileInputStream fs =new FileInputStream(".\\src\\test\\resources\\Assignment.xlsx");
		Workbook wb=WorkbookFactory.create(fs);
		Sheet sh = wb.getSheet("Org");
		Row ro = sh.getRow(4);
		Cell ce = ro.getCell(2);
		String Orgname = ce.getStringCellValue();
		Cell ce1 = ro.getCell(3);
		String Ind = ce1.getStringCellValue();
		
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
		
		
		driver.findElement(By.linkText("Organizations")).click();
		
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		
		
		driver.findElement(By.name("accountname")).sendKeys(Orgname+" "+random);
		WebElement we = driver.findElement(By.name("industry"));
		Select s=new Select(we);
		s.selectByValue(Ind);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	
		
	}

}
