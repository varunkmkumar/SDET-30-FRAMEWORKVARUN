package com.crm.GenericLibrary;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	/**
	 * this method will maximize the window
	 * @param driver
	 */
	public void maximizewindow( WebDriver driver) {
		driver.manage().window().maximize();
		
	}
	/**
	 * this method will wait for 20 sec for the page to load
	 * @param driver
	 */
	public void waitforpageload(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * this method will wait for 10 sec for element to be clickaable
	 * @param driver
	 * @param element
	 */
	public void waitforelementtobecliclickable(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		
	}
	
	
	/**
	 * this method will wait for 20 sec for element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	/**
	 * this method will select data from dropdown using index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	
	/**
	 * this method will select data from dropdoewn using text
	 * @param element
	 * @param text
	 */
	public void select(WebElement element, String text) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	
	
	/**
	 * this method will select data from dropdown usin value
	 * @param value
	 * @param element
	 */
	public void select(String value,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	
	
	/**
	 * this method will perform mousehoveraction
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver, WebElement element)
	{
		Actions  action =new  Actions(driver);
		action.moveToElement(element).perform();
	}
	
	
	/**
	 * this method will perform drag and drop
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement target)
	{
		Actions action =new Actions(driver);
		action.dragAndDrop(src, target).perform();
	}
	
	
	
	/**
	 * this method will double click on element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions action =new Actions(driver);
		action.doubleClick(element);
	}
	
	
	/**
	 * this method will perform double click on webpage
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver) {
		Actions action =new Actions(driver);
		action.doubleClick().perform();;
	}
	
	
	
	/**
	 * this method will perform rihjt click on webpage
	 * @param driver
	 */
	public void rightClick(WebDriver driver)
	{
		Actions action =new Actions(driver);
		action.contextClick().perform();
	}
	
	
	
	/**
	 * this method will perform double click on element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
	
	
	/**
	 * this method will switch the frame  based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * this method will switch the frame based on name Or id
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver,String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	/** 
	 * this method will switch the frame based on address
	 * @param driver
	 * @param address
	 */
	public void switchToFrame(WebDriver driver,WebElement address)
	{
		driver.switchTo().frame(address);
	}
	
	
	/**
	 * this method will press enter key
	 * @param driver
	 */
	
	public void enterKeyPress(WebDriver driver)
	{
		Actions action =new Actions(driver);
		action.sendKeys(Keys.ENTER);
	}
	
	
	public void enterKey(WebDriver driver) throws AWTException
	{
		Robot rob=new Robot();
		rob.keyPress(KeyEvent.VK_ENTER);
	}
	
	
	/**
	 * this method will release enter key
	 * @param driver
	 * @throws AWTException
	 */
	public void releaseKey(WebDriver driver) throws Throwable 
	{
		Robot ro=new Robot();
		ro.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	/**
	 * this method will accept alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	
	/**
	 * this method will dismiss alert popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	
	/**
	 * this mwthod will switch tge window dependinfg on partial window title 
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle)
	{
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> it = windows.iterator();
		while(it.hasNext())
		{
			String winId = it.next();
			String currentTitle = driver.switchTo().window(winId).getTitle();
			if(currentTitle.contains(partialWinTitle))
			{
				break;
			}
		}
		
		

		
	}
	
	
	/**
	 * this method will perfoem screenshot and stroe it folder called screenshot
	 * @param driver
	 * @param screeenshot
	 * @throws Throwable
	 */
	public String getScreenshot(WebDriver driver,String screeenshot) throws Throwable
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = "./Screenshot"+screeenshot+".png";
		File dest=new File(path);
		Files.copy(src, dest);
		return dest.getAbsolutePath();
	}
	
	
	
	
	/** 
	 * this method will perform scroll by
	 */
	public void scrollAcAction(WebDriver driver,WebElement element) 
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scroolBy(0,500)", " ");
	}
	
	
	/**
	 * this method will perform scroll by until specified element is found
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window(0,"+y+")", element);
		
	}
	
	
	
}
