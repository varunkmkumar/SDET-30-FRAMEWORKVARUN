package com.crm.PRACTICE;



import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class DataProviderPractice {

	
	@Test(dataProvider = "getdata")
	public void sampleDataPRovider(String name, String model, int qty) {
		System.out.println(name+ "  "+model+"  "+qty);
	}
	
	
	@DataProvider
	public Object[][] getdata(){
		
		Object[][] obj=new Object[4][3];
		
		obj[0][0]="Mi";
		obj[0][1]="13 pro max";
		obj[0][2]=25;
				
		
		obj[1][0]="iphone";
		obj[1][1]="11 max";
		obj[1][2]=12;
				
		obj[2][0]="vivo";
		obj[2][1]="17 max";
		obj[2][2]=20;
		
		obj[3][0]="nokia";
		obj[3][1]="keyboard";
		obj[3][2]=15;
		
		
		return obj;
				
		}
	
	

	
}
