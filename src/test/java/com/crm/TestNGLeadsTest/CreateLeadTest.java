package com.crm.TestNGLeadsTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateLeadPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LeadPage;
@Listeners(com.crm.GenericLibrary.ListnersImplementaionClass.class)
public class CreateLeadTest extends BaseClass {
	
	@Test//(retryAnalyzer = com.crm.GenericLibrary.RetryAnalyserImplementation.class)
	public void searchleadByWebsiteTest() throws Throwable {
		
		String lastname = eLib.readDataFromExcel("Lead", 1, 2)+jLib.getrandomnumber();
		String company = eLib.readDataFromExcel("Lead", 1, 3)+jLib.getrandomnumber();
		
		HomePage hp=new HomePage(driver);
		hp.clickOnLeadLink();
		
		LeadPage lp=new LeadPage(driver);
		lp.clickOnLeadImg();
		
	
		CreateLeadPage clp=new CreateLeadPage(driver);
		clp.createNewLead(lastname, company);
		Assert.fail();
		
		
		
		
	}
	

 }
