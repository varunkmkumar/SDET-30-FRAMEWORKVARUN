package com.crm.TestNGLeadsTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LeadPage;
@Listeners(com.crm.GenericLibrary.ListnersImplementaionClass.class)
public class SearchLeadByWebsiteTest  extends BaseClass{
	
	@Test
	public void searchLeadByWebsiteTest() throws Throwable {
		
	    //read data from excel
		String lead = eLib.readDataFromExcel("Lead", 1, 0);
		String led = eLib.readDataFromExcel("Lead", 1, 1);
			
		
		HomePage hp=new HomePage(driver);
		hp.clickOnLeadLink();
		
		LeadPage lp=new LeadPage(driver);
		lp.searchLead(lead, led);
		
		
		
	}
	
	


}
