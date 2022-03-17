package com.crm.TestNGOrganiastionTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganisationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganisationInfoPage;
import com.crm.ObjectRepository.OrganisationPage;

public class CraeteOrgWithIndType extends BaseClass{
	
	SoftAssert sa=new SoftAssert();
	@Test(groups ="smokeSuite") 
	public void craeteOrgWithIndType() throws Throwable {
		

		String Orgname = eLib.readDataFromExcel("Org", 4, 2)+jLib.getrandomnumber();
		String Ind = eLib.readDataFromExcel("Org", 4, 3);
		

		
		HomePage hp=new HomePage(driver);
		hp.ClickOnOrgLnk();
		String ExpData="Organizations";
		String ActData = driver.findElement(By.linkText("Organizations")).getText();
		Assert.assertEquals(ActData, ExpData);		
		
		OrganisationPage op=new OrganisationPage(driver);
		op.ClickOnCreateOrgImg();
		String expHeader="Creating New Organization";
		String actHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
         sa.assertEquals(actHeader, expHeader);
		
		CreateOrganisationPage cop =new CreateOrganisationPage(driver);
		cop.createNewOrg(Orgname, Ind);
		
		OrganisationInfoPage oip=new OrganisationInfoPage(driver);
		String actName = oip.OrgNameInfo();
		Reporter.log(actName+"Org created",true);
		sa.assertTrue(actName.contains("abc"));
		
		sa.assertAll("all ok");
		
		
	}

	
	
	
	
}
