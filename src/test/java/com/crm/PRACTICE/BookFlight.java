package com.crm.PRACTICE;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class BookFlight {
	
	@Test
	public void bookflight() {
		
		Date date=new Date();
        String actdate = date.toString();
        System.out.println(actdate);
        
		String[] date1 = actdate.split(" ");
		String day=date1[0];
		String month=date1[1];
		String dat=date1[2];
		String year=date1[5];
		 String dateformate = day+" "+month+" "+dat+" "+year;
		  System.out.println(dateformate);
		  
		  WebDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         driver.get("https://www.makemytrip.com");
         
         Actions action =new Actions(driver);
         action.moveByOffset(10, 10);
         
         driver.findElement(By.xpath("//span[text()='From']")).click();
         driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("bengaluru");
         driver.findElement(By.xpath("//p[text()='Bengaluru, India']")).click();     
        		 
		  
		  
		

		
		
		
		
		
		
		
	}

}
