package com.crm.TestNGLeadsTest;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LeadPage;

public class SearchLeadByPhoneTest extends BaseClass {
	
	@Test
	public void searchLeadByPhoneTest() throws Throwable {
		  //read data from excel
				String lead = eLib.readDataFromExcel("Lead", 2, 0);
				String led = eLib.readDataFromExcel("Lead", 2, 1);
					
				
				HomePage hp=new HomePage(driver);
				hp.clickOnLeadLink();
				
				LeadPage lp=new LeadPage(driver);
				lp.searchLead(lead, led);
	}
	
	

}
