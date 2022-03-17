package com.crm.GenericLibrary;

import java.sql.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	//create object for all the utilities
	public WebDriverUtility wLib=new WebDriverUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public PropertyFileUtility pLib=new PropertyFileUtility();
	public JavaUtility jLib=new JavaUtility();
	public DataBaseUtility dbLib=new DataBaseUtility();
	public WebDriver driver=null;
	public static WebDriver sDriver;
	
	
	@BeforeSuite(groups = {"regressionSuite","smokeSuite"})
	public void connectDataBase() throws Throwable {
		//dbLib.connectToDataBase();
		Reporter.log("DataBase connection succesful",true);
	}
	
	
	@BeforeClass(groups = {"regressionSuite","smokeSuite"})
//	@Parameters("browser")
	//@BeforeTest
	public void launchTheBrowser() throws Throwable {
		//read datafrom property file
	
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		
		//create runtime polymorphism
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		sDriver=driver;
		wLib.maximizewindow(driver);
		wLib.waitforpageload(driver);
		driver.get(URL);
		Reporter.log("browser launch succesfull",true);
		}
	
	
	   @BeforeMethod(groups = {"regressionSuite","smokeSuite"})
	   public void login() throws Throwable {
		   
		   String USERNAME = pLib.readDataFromPropertyFile("username");
			String PASSWORD = pLib.readDataFromPropertyFile("password");
			LoginPage lp=new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			Reporter.log("login succesfull",true);
			   }

	   @AfterMethod(groups = {"regressionSuite","smokeSuite"})
	   public void logout() {
		   HomePage hp=new HomePage(driver);
		   hp.signOutOfApp(driver);
		   Reporter.log("logout succesfull",true);
		  }
	
	
	
	   @AfterClass(groups = {"regressionSuite","smokeSuite"})
       // @AfterTest
	   public void closeBrowser() {
		   driver.quit();
		   Reporter.log("browser close succesful",true);
	   }
	   
	   @AfterSuite(groups = {"regressionSuite","smokeSuite"})
	   public void closeDB() throws Throwable {
		   //dbLib.closeDataBase();
		   Reporter.log("database close",true);
	   }
	   

}
