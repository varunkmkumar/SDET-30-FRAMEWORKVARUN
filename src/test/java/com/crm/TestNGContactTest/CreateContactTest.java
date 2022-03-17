package com.crm.TestNGContactTest;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;

public class CreateContactTest extends BaseClass {
	
	@Test(groups = "smokeSuite")
	public void createContactTest() throws Throwable {
		

		//read data from excel
		String contName = eLib.readDataFromExcel("Contact", 1, 2);
		

		//create contact
		//1.navigate to contact link
		HomePage hp=new HomePage(driver);
		hp.ClickOncontactLnk();
		
		
		//2.click on conatct Imag
		ContactPage cp=new ContactPage(driver);
		cp.ClickOnCreateContImg();
		
		//3.send data to lastanme textfield and Save
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createNewCont(contName);
		
		//Step4: verification
		ContactInfoPage cip=new ContactInfoPage(driver);
		String actName = cip.ContNameInfo();
		if(actName.contains(contName))
		{
			System.out.println("data verified");
		}
		else {
			System.out.println("data not verified");
		}
		
		
		
	}

}
