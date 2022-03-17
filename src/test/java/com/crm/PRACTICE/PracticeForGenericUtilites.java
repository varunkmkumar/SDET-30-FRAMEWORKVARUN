package com.crm.PRACTICE;


import org.apache.commons.collections4.Put;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;

public class PracticeForGenericUtilites {
	@Test
	public void practiceForGenericUtilites() throws Throwable {
		JavaUtility jLib=new JavaUtility();
		int ran = jLib.getrandomnumber();
		String dat = jLib.getSystemDateInFormat();
		String date = jLib.getsystemDate();
		System.out.println(ran+date);
		System.err.println(ran+dat);
		
	PropertyFileUtility pro=new PropertyFileUtility();
	String br = pro.readDataFromPropertyFile("browser");
	System.out.println(br);
		
		
		
		
	}
	
	
	
	
	
	
	
	

}
