package com.crm.GenericLibrary;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ListnersImplementaionClass implements ITestListener {  
	
	ExtentReports report;
     ExtentTest test;

	public void onTestStart(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		//Reporter.log(MethodName+"testscript exceution started");
                       test=report.createTest(MethodName);	
	 	
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		//Reporter.log(MethodName+"testscript exceution succesfull-----pass");
		test.log(Status.PASS, MethodName+"---------passed");
		
		
	}

	public void onTestFailure(ITestResult result) {
		
		String path=null;
		
		String MethodName = result.getMethod().getMethodName();
		//Reporter.log(MethodName+"testscript failed",true);
		
		//Step1: configure the Screenshot name
		String screenshotName = MethodName+new JavaUtility().getSystemDateInFormat();
		System.out.println(screenshotName);
		
		//Step2:using screenshot method frome webdriver utility
		try {
			path=new WebDriverUtility().getScreenshot(BaseClass.sDriver, screenshotName);
			
		//	EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
			//File src = eDriver.getScreenshotAs(OutputType.FILE);
			//String pa = Sysďtem.getProperty("user.dir")+"/ScreenShots/"+screenshotName+".PNG";
			// path = ".\\Screenshots\\"+screenshotName+".png";
			//File dst = new File(path);
			//Files.copy(src, dst);
			
			
			
		}  catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(Status.FAIL, MethodName+"============failed");
		//it will capture the exception and log it in the report
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(path);
		
		
		
		
	}

	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		//Reporter.log(MethodName+"testscript skipped");
		
		test.log(Status.SKIP, MethodName+"--------------skipeed");
		//it will capture the exception and log it in the report
				test.log(Status.SKIP, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
		//exceution will start
		/* configure the report
		 * 
		 */
		ExtentSparkReporter HtmlReport = new ExtentSparkReporter("./ExtentReports/Report"+new JavaUtility().getSystemDateInFormat()+".html");
		HtmlReport.config().setDocumentTitle("SDET-30 Excecution report");
		HtmlReport.config().setTheme(Theme.DARK);
		HtmlReport.config().setReportName("selenium excecution report");
		
		report = new ExtentReports();
		report.attachReporter(HtmlReport);
		report.setSystemInfo("Base-Brwoser", "Chrome");
		report.setSystemInfo("os", "Windows");
		report.setSystemInfo("base-url", "https://localhost:8888");
		report.setSystemInfo("Reportername", "Varun");
		
		
		
	}

	public void onFinish(ITestContext context) {
		//consolidate all the parameter and generate the report
		report.flush();
		
	}

}
