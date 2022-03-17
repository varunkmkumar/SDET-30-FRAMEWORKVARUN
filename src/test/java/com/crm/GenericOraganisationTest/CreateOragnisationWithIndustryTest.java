package com.crm.GenericOraganisationTest;

import java.io.FileInputStream;
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

import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;

public class CreateOragnisationWithIndustryTest {
	@Test
	public void createOrgNameWithIndustryTest() throws Throwable {

		WebDriverUtility wLib=new WebDriverUtility();
		ExcelUtility eLib=new ExcelUtility();
		PropertyFileUtility pLib=new PropertyFileUtility();
		JavaUtility jLib=new JavaUtility();
		
		
		
		
		
	
		String BROWSER=pLib.readDataFromPropertyFile("browser");
		String URL =pLib.readDataFromPropertyFile("url");
		String USERNAME=pLib.readDataFromPropertyFile("username");
		String PASSWORD =pLib.readDataFromPropertyFile("password");
		
		
		
		String Orgname = eLib.readDataFromExcel("Org", 4, 2);
		String Ind = eLib.readDataFromExcel("Org", 4, 3);
		
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
		wLib.maximizewindow(driver);
		wLib.waitforpageload(driver);
		driver.get(URL);
		
		
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		
		driver.findElement(By.linkText("Organizations")).click();
		
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		
		
		driver.findElement(By.name("accountname")).sendKeys(Orgname+" "+ jLib.getrandomnumber());
		WebElement we = driver.findElement(By.name("industry"));
		wLib.select(Ind, we);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	
		
	}

}
