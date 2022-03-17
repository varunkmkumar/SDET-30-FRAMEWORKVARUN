package com.crm.GenericOppertunitiesTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;

public class CreateOpportunitiesTest {
	@Test
	public void createOpportunitiesTest() throws Throwable {

		WebDriverUtility wLib=new WebDriverUtility();
		ExcelUtility eLib=new ExcelUtility();
		PropertyFileUtility pLib=new PropertyFileUtility();
		JavaUtility jLib=new JavaUtility();
		
		//read all necessary data
		//read data from property file
		String BROWSER=pLib.readDataFromPropertyFile("browser");
		String URL =pLib.readDataFromPropertyFile("url");
		String USERNAME=pLib.readDataFromPropertyFile("username");
		String PASSWORD =pLib.readDataFromPropertyFile("password");
		
		//read data From excel
		String ContName = eLib.readDataFromExcel("Oppertunities", 1, 0);
		String CampName = eLib.readDataFromExcel("Oppertunities", 1, 1);
		String OppName = eLib.readDataFromExcel("Oppertunities", 1, 2);
		String ContDrpDown = eLib.readDataFromExcel("Oppertunities", 1, 3);
		String LdSource = eLib.readDataFromExcel("Oppertunities", 1, 4);
		
		
		//launch the browser
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("browser not found");
		}
		wLib.maximizewindow(driver);
		wLib.waitforpageload(driver);
		driver.get(URL);
		
		
		//login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		
		//create contact
		//1.navigate to contact link
		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		//2.click on conatct Imag
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		//3.send data to lastanme textfield
		driver.findElement(By.name("lastname")).sendKeys(ContName);
		//4.click on save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//create campaign
		//1.navigate to more link
		  WebElement dr = driver.findElement(By.xpath("//a[.='More']"));
		  wLib.mouseHover(driver, dr);
		   //2.click on campaign link
		   driver.findElement(By.name("Campaigns")).click();
		   //3.click on comppaign img
		   driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		   //4.semd data to campaignname text field
		   driver.findElement(By.name("campaignname")).sendKeys(CampName);
		   //5.click on save
		   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		   
		   //opportunities
		   //click on opportunities linlk
		   driver.findElement(By.xpath("//a[@href='index.php?module=Potentials&action=index']")).click();
		   
		   //click on img
		   driver.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click();
		   
		   //send data into text field
		   driver.findElement(By.xpath("//input[@name='potentialname']")).sendKeys(OppName);
		   
		   //select contacts in dropdown
		   WebElement drop = driver.findElement(By.xpath("//select[@id='related_to_type']"));
		   wLib.select(ContDrpDown, drop);
		   
		   //click on img
		   driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif' and @alt='Select']")).click();
		   
		   //switch to child window
		   wLib.switchToWindow(driver, "Contacts&action");
		   
		   //send data into text field
		   driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(ContName);
		   
		   //cick on search button
		   driver.findElement(By.name("search")).click();
		   
		   //select the select the contact name
		   driver.findElement(By.xpath("//a[.=' Kumar']")).click();
		   
		   //switch the window
		   wLib.switchToWindow(driver, "Potentials&action");
		   Thread.sleep(2000);
		   
		   //select lead source drop down
		   WebElement dro = driver.findElement(By.name("leadsource"));
		   wLib.select(LdSource, dro);
		  
		   
		   //click on image
		   driver.findElement(By.xpath("(//img[@alt='Select'])[2]")).click();
		  
		   //switch the window
		   wLib.switchToWindow(driver, "Campaigns&action=Popup&html");
		   
		   //send data into text field
		   driver.findElement(By.name("search_text")).sendKeys(CampName);
		   
		   //click on search
		   driver.findElement(By.name("search")).click();
		   
		   //select the campaign
		   driver.findElement(By.xpath("//a[.='Trail']")).click();
		   
		   //switch the window
		   wLib.switchToWindow(driver, "Potentials&action=EditView&return_action=DetailView&parenttab=Sales");
		   
		   //click on save
		   driver.findElement(By.xpath("(//input[@value='  Save  ' and @type='submit'])[2]")).click();
		   
			
			//logout of application
			WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wLib.mouseHover(driver, signout);
			
			//click on signout link
			//driver.findElement(By.xpath("//a[.='Sign Out']")).click();
			
			
		   
		   
		   
		   
	}
	
	

}
