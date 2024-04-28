package com.db.testLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.db.pageLayer.HomePage;
import com.db.pageLayer.LoginPage;
import com.db.testBase.TestBase;
import com.db.utilities.ReadConfigFile;

public class LoginPageTest extends TestBase {
	
	@Test(groups="Regression")
	public void verifyLogin() throws InterruptedException
	{
		String expected_output = excel.readData("loginpage", 0, 0);
		home.clickOnLoginLink();
		login.enterUsername(read_config.getUsername());
		login.enterPassword(read_config.getPassword());
		login.clickOnLoginButton();
		
		Thread.sleep(5000);
		String actual_output = home.getStatus();
		Assert.assertEquals(actual_output, expected_output);
	}

}
