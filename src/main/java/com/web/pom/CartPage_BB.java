package com.web.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BestBuy_Base;

public class CartPage_BB extends BestBuy_Base{
	
	public CartPage_BB() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Cart']")
	WebElement cartButton;
	
	public void goToCartPage() {
		jsClick(cartButton);
	}
	
	@FindBy(xpath="//a[normalize-space()='Sony - 55\" Class X75K 4K HDR LED Google TV']")
	WebElement sony75InchTvAddedInCart;
	
	public String validateSonyTvInCart() {
		return getText(sony75InchTvAddedInCart);
	}
	
	@FindBy(xpath="//a[contains(text(),'Lenovo - ThinkPad E15')]")
	WebElement lenovoThinkPadAddedInCart;
	
	public String validateLenovoThinkPadInCart() {
		return getText(lenovoThinkPadAddedInCart);
	}
	
	@FindBy(xpath="//a[contains(text(),'Logitech - G502 Lightspeed Wireless Optical Gaming Mouse with RGB Lighting - Black')]")
	WebElement logitechMouseAddedInCart;
	
	public String validateLogitechMouseInCart() {
		return getText(logitechMouseAddedInCart);
	}
	
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkOutInCart;
	
	public void goToCheckOutPage() {
		clickOnElement(checkOutInCart);
	}

}
