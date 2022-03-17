package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class GoiboBook {
	@Test
	public void book() {
		

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20 ,TimeUnit.SECONDS);
        driver.get("https://www.goibibo.com/");
        
        Actions action=new Actions(driver);
        action.moveByOffset(10, 10).click().perform();
        
        
        driver.findElement(By.xpath("//span[text()='From']")).click();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("benagluru");
        driver.findElement(By.xpath("//span[text()='Bengaluru, India']")).click();
        
      
        driver.findElement(By.xpath("//div[@class='sc-cidDSM dOEpbS']")).click();
      //  driver.findElement(By.xpath("//span[text()='To']")).click();
       driver.findElement(By.xpath("//input[@type='text']")).sendKeys("hubli");
       driver.findElement(By.xpath("//span[text()='Hubli, India']")).click();
       
       
       driver.findElement(By.xpath("//span[text()='Done']")).click();
       
       driver.findElement(By.xpath("//span[text()='SEARCH FLIGHTS']")).click();
       
		
		
	}

}
