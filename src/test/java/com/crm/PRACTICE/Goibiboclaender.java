package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Goibiboclaender {
	
	@Test
	public void calender() {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20 ,TimeUnit.SECONDS);
        driver.get("https://www.goibibo.com/");
        
        Actions action=new Actions(driver);
        action.moveByOffset(10, 10).click().perform();
        
		
		 
       
		   
		

       
       driver.findElement(By.xpath("//span[text()='Departure']")).click(); 
		  String dateXpath = "//div[text()='March 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='12']";
		   driver.findElement(By.xpath(dateXpath)).click();
		   driver.findElement(By.xpath("//span[text()='Done']")).click();
		   
        
        
	}

}
