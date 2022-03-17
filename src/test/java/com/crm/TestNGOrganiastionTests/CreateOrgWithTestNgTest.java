package com.crm.TestNGOrganiastionTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.IAssert;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganisationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganisationInfoPage;
import com.crm.ObjectRepository.OrganisationPage;

public class CreateOrgWithTestNgTest extends BaseClass {
	
	@Test(groups = "regressionSuite")
	public void createOrgWithTestNgTest() throws Throwable {
	
		String orgName = eLib.readDataFromExcel("Org", 1, 2)+jLib.getrandomnumber();
		

		//Step3: navigaye to organisation link
		HomePage hp=new HomePage(driver);
		hp.ClickOnOrgLnk();
		
		
		//Step4:click on create oragniastion link
		OrganisationPage op=new OrganisationPage(driver);
		op.ClickOnCreateOrgImg();
		
		//Step5:create organisation with mandatory fields
		CreateOrganisationPage cop=new CreateOrganisationPage(driver);
		cop.createNewOrg(orgName);
		
		//Step6: verification
				OrganisationInfoPage oip=new OrganisationInfoPage(driver);
				String actName = oip.OrgNameInfo();
				/*
				 * if(actName.contains(orgName)) { System.out.println("data verified"); } else {
				 * System.out.println("data not verified"); }
				 */
	             Assert.assertEquals(orgName, actName);
	             Reporter.log(orgName+"org created",true);
}

	
}
