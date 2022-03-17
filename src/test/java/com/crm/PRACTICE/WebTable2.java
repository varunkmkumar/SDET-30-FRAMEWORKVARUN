package com.crm.PRACTICE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class WebTable2 extends BaseClass {
	
	@Test
	public void webTable2() throws InterruptedException {
		
		
		HomePage hp=new HomePage(driver);
		hp.ClickOncontactLnk();
		
	//	driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@id='77']")).click();
		//	driver.findElement(By.xpath("//a[contains(.,'Kumar')]/parent::td/preceding-sibling::td[3]")).click();
	
		List<WebElement> ele = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]"));
		for(int i=ele.size()-1; i>=0; i--)
		{
		WebElement we = ele.get(i);
		we.click();
		break;
		
		}
	
		Thread.sleep(2000);
		
		
		
	}

}
