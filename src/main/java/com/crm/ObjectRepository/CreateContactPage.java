package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility {
	
	//Declaration
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement ContNameEdt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement OrgNameLookImg;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropDown;
	

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtnn;
	
	
	//Initialisation
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//Utilisation
	public WebElement getContNameEdt() {
		return ContNameEdt;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	

	public WebElement getOrgNameLookImg() {
		return OrgNameLookImg;
	}


	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}
	
	
	
	public WebElement getSearchEdt() {
		return searchEdt;
	}


	public WebElement getSaveBtnn() {
		return searchBtnn;
	}


	//Business Library
	/**
	 * this method will create contact 
	 * @param Contname
	 */
	public void createNewCont(String Contname)
	{
		ContNameEdt.sendKeys(Contname);
		saveBtn.click();
	}
	
	public void createNewCont(WebDriver driver,String orgname,String contname)
	{
		ContNameEdt.sendKeys(contname);
		OrgNameLookImg.click();
		switchToWindow(driver, "Accounts");
		searchEdt.sendKeys(orgname);
		searchBtnn.click();
		driver.findElement(By.xpath("//a[text()='"+ orgname +"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();
		
		
	}
	
	
}
