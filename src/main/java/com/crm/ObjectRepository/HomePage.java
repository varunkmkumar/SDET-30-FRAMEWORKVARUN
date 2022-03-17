package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	//Step1:Declaration
	@FindBy(linkText = "Organizations")
	private WebElement organisationlink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactlink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunities;
	
	@FindBy(linkText = "Products")
	private WebElement products;
	
	@FindBy(linkText = "More")
	private WebElement morelink;
	
	@FindBy(linkText = "Leads")
	private WebElement leadlink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignlink;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement administratorimg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutlink;
	
	
	//Step2: initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	
	}


	public WebElement getOrganisationlink() {
		return organisationlink;
	}


	public WebElement getContactlink() {
		return contactlink;
	}


	public WebElement getOpportunities() {
		return opportunities;
	}


	public WebElement getProducts() {
		return products;
	}


	public WebElement getMorelink() {
		return morelink;
	}
	
	public WebElement getLeadLink() {
		return leadlink;
	}


	public WebElement getCampaignlink() {
		return campaignlink;
	}


	public WebElement getAdministratorimg() {
		return administratorimg;
	}


	public WebElement getSignoutlink() {
		return signoutlink;
	}


	
	//business library
	public void ClickOnOrgLnk() {
		organisationlink.click();
	}
	
	public void ClickOncontactLnk() {
		contactlink.click();
	}
	
	public void ClickOnProductLink() {
		products.click();
	}
	
	
	public void clickOnLeadLink() {
		leadlink.click();
	}
	
	
	public void signOutOfApp(WebDriver driver)
          {    
		mouseHover(driver, administratorimg);
		signoutlink.click();
		}
	
	public void camplinksearch(WebDriver driver)
	{
		mouseHover(driver, morelink);
		campaignlink.click();
		
	}
}
