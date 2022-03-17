package com.crm.TestNgCampaignTest;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CampaignInfoPage;
import com.crm.ObjectRepository.CampaignsPage;
import com.crm.ObjectRepository.CreateCampaignPage;
import com.crm.ObjectRepository.HomePage;

public class CraeteCampaignTest extends BaseClass {
	@Test
	public void craeteCampaignTest() throws Throwable {
		String campName = eLib.readDataFromExcel("Campaign", 1, 2)+jLib.getrandomnumber();
		
		
		//Step3: navigaye to campaignlink
		HomePage hp=new HomePage(driver);
		hp.camplinksearch(driver);
		
		//Step4:click on Imaage
		CampaignsPage cp=new CampaignsPage(driver);
		cp.clickOnCreateCampImg();
		
	    //Send data to webelements
		CreateCampaignPage ccp=new CreateCampaignPage(driver);
		ccp.createCampaign(campName);
		
		//verification
		CampaignInfoPage cip=new CampaignInfoPage(driver);
		String actName = cip.campNameInfo();
		if(actName.contains(campName))
		{
			System.out.println("data verified");
		}
		else {
			System.out.println("data not verified");
		}
	}

}
