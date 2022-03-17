package com.crm.TestNGContactTest;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateOrganisationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganisationInfoPage;
import com.crm.ObjectRepository.OrganisationPage;

public class CreateContactWithOrgTest extends BaseClass {
	
	@Test(groups = "regressionSuite")
	public void createContactWithOrgTest() throws Throwable {
		String lastname = eLib.readDataFromExcel("Contact", 4, 2);
		String Orgname = eLib.readDataFromExcel("Contact", 4, 3)+jLib.getrandomnumber();
		
		HomePage hp=new HomePage(driver);
		hp.ClickOnOrgLnk();
		
		
		//Step4:click on create oragniastion link
		OrganisationPage op=new OrganisationPage(driver);
		op.ClickOnCreateOrgImg();
		
		//Step5:create organisation with mandatory fields
		CreateOrganisationPage cop=new CreateOrganisationPage(driver);
		cop.createNewOrg(Orgname);
		
		OrganisationInfoPage oip=new OrganisationInfoPage(driver);
		String actName = oip.OrgNameInfo();
		if(actName.contains(Orgname))
		{
			System.out.println("data verified");
		}
		else {
			System.out.println("data not verified");
		}

		
		hp.ClickOncontactLnk();
		
		
		//2.click on conatct Imag
		ContactPage cp=new ContactPage(driver);
		cp.ClickOnCreateContImg();
		
		
		//send data 
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createNewCont(driver, Orgname, lastname);
		
		//Step4: verification
		ContactInfoPage cip=new ContactInfoPage(driver);
		String actNam = cip.ContNameInfo();
		if(actName.contains(lastname))
		{
			System.out.println("data verified");
		}
		else {
			System.out.println("data not verified");
		}
		
		
		
		
	}

}
