package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

public class DataProviderPractice2 {
	
	@Test(dataProvider = "getData")
	public void sampleDataProvider(int rollno,String name)
	{
		System.out.println(rollno+"--"+name);
			
	}
	
	@DataProvider
	public Object[][] getData()
	{
		
		Object[][] obj=new Object[6][2];
		

		obj[0][0]=01;
		obj[0][1]="varun";
		 
		
		obj[1][0]=02;
		obj[1][1]="vicky";
		
		obj[2][0]=03;
		obj[2][1]="latha";
		
		obj[3][0]=04;
		obj[3][1]="dhanu";
		
		obj[4][0]=05;
		obj[4][1]="thippu";
		
		obj[5][0]=06;
		obj[5][1]="anu";
		
		
		return obj;
		
		
		
		
	}

}
