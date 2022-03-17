package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SelectAnydateFromCalender {
 
	
	@Test
	public void calender() {
		
		String date="12";
		String monthandYear="May 2022";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		
		Actions action=new Actions(driver);
		action.moveByOffset(10, 10).click().perform();
		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
	    String arrowxpath = "//span[@aria-label='Next Month']";
	    String dateXpath = "//div[text()='"+monthandYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		
		for(;;) {
	
		try {
			driver.findElement(By.xpath(dateXpath)).click();
			break;
		} catch (Exception e) {
			// TODO: handle exception
			driver.findElement(By.xpath(arrowxpath)).click();
			
			
		}
		}
	}
}
