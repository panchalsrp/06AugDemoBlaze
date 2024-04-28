package com.db.testBase;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.db.pageLayer.CartPage;
import com.db.pageLayer.HomePage;
import com.db.pageLayer.LoginPage;
import com.db.utilities.ExcelHandling;
import com.db.utilities.ExtentReportGenerator;
import com.db.utilities.ReadConfigFile;
import com.db.utilities.UtilClass;

public class TestBase {
	
	public static WebDriver driver;
	public static Logger logger;
	public HomePage home;
	public LoginPage login;
	public CartPage cart;
	public UtilClass util;
	public ReadConfigFile read_config;
	public ExcelHandling excel;
	public ExtentReports report = ExtentReportGenerator.getExtentReport();
	public ExtentTest eTest = null;
	
	@BeforeTest
	public void start()
	{
		logger = Logger.getLogger("DemoBlaze Automation Framework");
		PropertyConfigurator.configure("Log4jfile.properties");
		logger.info("Framework Execution started");
	}
	
	@AfterTest
	public void end()
	{
		logger.info("Framework execution stopped");
	}
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String br)
	{	
		if(br.equalsIgnoreCase("Chrome"))
		{
//			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("Firefox"))
		{
//			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(br.equalsIgnoreCase("Edge"))
		{
//			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Please provide correct browser name");
		}
		
		read_config = new ReadConfigFile();
		
		driver.get(read_config.getApplicationUrl());
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("Browser launches, url, maximize");
		driver.manage().window().maximize();
		driver.get(read_config.getApplicationUrl());
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//It not exist in Selenium Version-3.141.59
		
		//------------------- Object Creation ----------------------------
		home = new HomePage();
		login = new LoginPage();
		cart = new CartPage();
		util = new UtilClass();
		excel = new ExcelHandling();
		
		
		//------------------- Login Steps --------------------------------
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
