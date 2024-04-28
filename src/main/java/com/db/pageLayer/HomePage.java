package com.db.pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.db.testBase.TestBase;

public class HomePage extends TestBase {

	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//----------------- Obj Repo -------------------
	@FindBy(xpath="//a[@id='login2']")
	private WebElement login_link;
	
	@FindBy(xpath="//a[@id='nameofuser']")
	private WebElement status_msg;
	
	@FindBy(xpath="//a[contains(text(),'Phones')]")
	private WebElement phones_link;
	
	@FindBy(xpath="//a[contains(text(),'Samsung galaxy s6')]")
	private WebElement product_samsung_galaxy_s6_link;
	
	@FindBy(xpath="//a[contains(text(),'Nokia lumia 1520')]")
	private WebElement Nokia_lumia_1520_link;
	
	@FindBy(xpath="//a[contains(text(),'Cart')]")
	private WebElement cart_link;
	
	//------------------ Action method --------------
	public void clickOnLoginLink()
	{
		login_link.click();
	}
	
	public String getStatus()
	{
		String sta = status_msg.getText();
		return sta;
	}
	
	public void clickOnPhonesLink()
	{
		phones_link.click();
	}
	public void clickOnSamsungGalaxyS6Link()
	{
		product_samsung_galaxy_s6_link.click();
	}
	
	public void clickOnNokialumiai1520_link()
	{
		Nokia_lumia_1520_link.click();
	}
	
	public void clickOnCartLink()
	{
		cart_link.click();
	}
}
