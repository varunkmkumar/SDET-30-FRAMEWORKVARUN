package com.crm.PRACTICE;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class PractceTest {
	
	@Test
	public void practice() {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/index.php");
		
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		 WebElement ele = driver.findElement(By.name("industry"));
		Select select =new Select(ele);
		select.selectByValue("Biotechnology");
		
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
	           Set<String> pid = driver.getWindowHandles();
		       for(String sh:pid)
		       {
		    	   driver.switchTo().window(sh);
		       }
		
	    driver.findElement(By.name("search_text")).sendKeys("Alvas");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//tr[@class='lvtColData']")).click();
	    
		
		
		
		
		
		
		
	}

}
