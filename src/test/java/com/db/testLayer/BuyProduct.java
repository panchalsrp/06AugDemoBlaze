package com.db.testLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.db.pageLayer.CartPage;
import com.db.pageLayer.HomePage;
import com.db.pageLayer.LoginPage;
import com.db.testBase.TestBase;
import com.db.utilities.UtilClass;

public class BuyProduct extends TestBase {
	
	@Test(groups="Sanity")
	public void verifyBuyProductWithLogin() throws InterruptedException
	{
		String expected_output = excel.readData("loginpage", 1, 0);;
		//--------------------------------
		home.clickOnLoginLink();
		Thread.sleep(3000);
		login.enterUsername(read_config.getUsername());
		login.enterPassword(read_config.getPassword());
		login.clickOnLoginButton();
		Thread.sleep(5000);
		//----------------------------
		home.clickOnPhonesLink();
		home.clickOnSamsungGalaxyS6Link();
		Thread.sleep(3000);
		cart.clickOnAddToCartButton();
		Thread.sleep(3000);
		util.acceptAlertPopup();
		home.clickOnCartLink();
		cart.clickOnPlaceOrderButton();
		Thread.sleep(3000);
		cart.enterAddressInfo();
		Thread.sleep(3000);
		cart.clickOnPurchaseButton();
		Thread.sleep(3000);
		Assert.assertEquals(cart.getStatusInfo(), expected_output);
	}
	
	@Test(groups = {"Smoke","Regression"})
	public void verifyBuyProductWithLogin1() throws InterruptedException
	{
		String expected_output = excel.readData("loginpage", 2, 0);
		//--------------------------------
		home.clickOnLoginLink();
		Thread.sleep(3000);
		login.enterUsername(read_config.getUsername());
		login.enterPassword(read_config.getPassword());
		login.clickOnLoginButton();
		Thread.sleep(5000);
		//----------------------------
		home.clickOnPhonesLink();
		home.clickOnNokialumiai1520_link();
		Thread.sleep(3000);
		cart.clickOnAddToCartButton();
		Thread.sleep(3000);
		util.acceptAlertPopup();
		home.clickOnCartLink();
		cart.clickOnPlaceOrderButton();
		Thread.sleep(3000);
		cart.enterAddressInfo();
		Thread.sleep(3000);
		cart.clickOnPurchaseButton();
		Thread.sleep(3000);
		Assert.assertEquals(cart.getStatusInfo(), expected_output);
	}

}
