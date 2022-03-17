package com.crm.GenericOraganisationTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;

public class CreateOragnisationTest {
	@Test
	public void createOrganisationTest()
	{
		
		WebDriverUtility wLib=new WebDriverUtility();
		ExcelUtility eLib=new ExcelUtility();
		PropertyFileUtility pLib=new PropertyFileUtility();
		JavaUtility jLib=new JavaUtility();
		
		//Step1:launch the browser
		WebDriver driver=new ChromeDriver();
		wLib.maximizewindow(driver);
		wLib.waitforpageload(driver);
		driver.get("http://localhost:8888");
		
		//Step2:login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		
		//Step3: navigaye to organisation link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step4:click on create oragniastion link
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step5:create organisation with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("ALL STATES");
		
		//TEP6:SAVE
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.quit();
		
		
	}

}
