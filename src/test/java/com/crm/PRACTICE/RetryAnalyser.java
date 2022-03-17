package com.crm.PRACTICE;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyser {
	
	@Test(retryAnalyzer = com.crm.GenericLibrary.RetryAnalyserImplementation.class)
	public void retryAnalyser() {
		System.out.println("haiiiii");
		Assert.fail();
		System.out.println("helllooo");
	}

}
