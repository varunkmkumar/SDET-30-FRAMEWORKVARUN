package com.crm.PRACTICE;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class WebTableDelete extends BaseClass {
	
	@Test
	public void webTableDelete() {
		
		HomePage hp=new HomePage(driver);
		hp.ClickOncontactLnk();
		
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[7]/td[1]")).click();
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[7]/td[1]/following-sibling::td[9]/a[2]")).click();
		wLib.acceptAlert(driver);
		
	
		
		
	}

}
