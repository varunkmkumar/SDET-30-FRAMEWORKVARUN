package com.crm.PRACTICE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class PrintLastName extends BaseClass{
	@Test
	public void printLastName() {
		
		
		HomePage hp=new HomePage(driver);
		hp.ClickOncontactLnk();
		
		List<WebElement> ele = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[4]//a[@title='Contacts']"));
		
		for(WebElement sh: ele)
		{
			String text = sh.getText();
			System.out.println(text);
		}
		
	}

}
