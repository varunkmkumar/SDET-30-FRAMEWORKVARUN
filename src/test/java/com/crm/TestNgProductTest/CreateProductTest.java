package com.crm.TestNgProductTest;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.ProductInfoPage;
import com.crm.ObjectRepository.ProductPage;

public class CreateProductTest extends BaseClass {

	
	
	@Test
	public void createProductTest() throws Throwable {
		String prdtName = eLib.readDataFromExcel("Product", 1, 2)+jLib.getrandomnumber();
		
		
		HomePage hp=new HomePage(driver);
		hp.ClickOnProductLink();
		
		//click product img
		ProductPage pp=new ProductPage(driver);
		pp.ClickOnCreatePrdImg();
		
		//create product
		CreateProductPage cpp=new CreateProductPage(driver);
		cpp.CreatePrdtPage(prdtName);
		
		//verification
		ProductInfoPage cip=new ProductInfoPage(driver);
		String actName = cip.PrdtNameInfo();
		if(actName.contains(prdtName))
		{
			System.out.println("data verified");
		}
		else {
			System.out.println("data not verified");
		}
		
		
		
	}
}
