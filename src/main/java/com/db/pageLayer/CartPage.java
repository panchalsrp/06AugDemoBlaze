package com.db.pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.db.testBase.TestBase;

//========= this project imported from github ==============
public class CartPage extends TestBase {
	
	public CartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//----------------- Obj Repo -------------------
	@FindBy(xpath="//a[contains(text(),'Add to cart')]")
	private WebElement add_to_cart_button;
	
	@FindBy(xpath="//button[contains(text(),'Place Order')]")
	private WebElement place_order_button;
	
	@FindBy(xpath="//input[@id='name']")
	private WebElement username_txtbox;
	
	@FindBy(xpath="//input[@id='country']")
	private WebElement country_txtbox;
	
	@FindBy(xpath="//input[@id='city']")
	private WebElement city_txtbox;
	
	@FindBy(xpath="//input[@id='card']")
	private WebElement credit_card_txtbox;
	
	@FindBy(xpath="//input[@id='year']")
	private WebElement year_txtbox;
	
	@FindBy(xpath="//input[@id='month']")
	private WebElement month_txtbox;
	
	@FindBy(xpath="//button[contains(text(),'Purchase')]")
	private WebElement purchase_btn;
		
	@FindBy(xpath="//h2[text()='Thank you for your purchase!']")
	private WebElement status_msg;
	
	//------------------ Action method --------------

	public void clickOnAddToCartButton()
	{
		add_to_cart_button.click();
	}
	
	public void clickOnPlaceOrderButton()
	{
		place_order_button.click();
	}
	
	public void enterAddressInfo()
	{
		username_txtbox.sendKeys("testacc");
		country_txtbox.sendKeys("India");
		city_txtbox.sendKeys("Pune");
		credit_card_txtbox.sendKeys("425464");
		month_txtbox.sendKeys("10");
		year_txtbox.sendKeys("2023");
	}
	
	public void clickOnPurchaseButton()
	{
		purchase_btn.click();
	}
	
	public String getStatusInfo()
	{
		return status_msg.getText();
	}
	
	
	

}
