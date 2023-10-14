package com.web.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BestBuy_Base;

public class ProductPage_BB extends BestBuy_Base{
	
	public ProductPage_BB() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Sony - 75\" Class BRAVIA XR X90K 4K HDR Full Array LED Google TV')]")
	WebElement sony75InchTvHeadingM2;
	
	@FindBy(xpath="//button[@data-sku-id='6499752' and @data-button-state='ADD_TO_CART']")
	WebElement addToCartTv;
	
	@FindBy(xpath="//p[text()='ThinkPad laptops']")
	WebElement thinkPadLaptopsAtLenovoProdPage;
	
	@FindBy(xpath="//li[contains(., 'Logitech - G502 Lightspeed')]//button[@class='c-button c-button-primary c-button-sm c-button-block c-button-icon c-button-icon-leading add-to-cart-button']")
	WebElement addToCartLogitechMouse;
	
	@FindBy(xpath="//a[contains(text(),'Lenovo - ThinkPad E15 Gen 4 15.6\" Notebook - AMD Ryzen 5 5625U - 16GB Memory - 512GB SSD - Gray')]")
	WebElement lenovoThinkPad4TitleAtProdPage;
	
	@FindBy(xpath="//a[contains(text(),'Logitech - G502 Lightspeed Wireless Optical Gaming Mouse with RGB Lighting - Black')]")
	WebElement logitechMouseTextAtProductPage;
	
	@FindBy(xpath="//button[@data-sku-id='6518017' and @data-button-state='ADD_TO_CART']")
	WebElement addToCartLenovoThinkPad;
	
	@FindBy(xpath="//a[text()='Go to Cart']")
	WebElement goToCartButton;
	
	public String addLogitechMouse() throws Exception {
		String logiTechTitleAtProdPage = getText(logitechMouseTextAtProductPage);
		clickOnElement(addToCartLogitechMouse);
		clickOnElement(goToCartButton);
		return logiTechTitleAtProdPage;
	}
	
	public String addSony75InchTVInProdPageM2() {
		String sony75TitleAtProdPage = getText(sony75InchTvHeadingM2);
		clickOnElement(sony75InchTvHeadingM2);
		jsScrollUntillElement(addToCartTv);
		jsClick(addToCartTv);
		return sony75TitleAtProdPage;
	}
	
	public String addLenovoThinkPadInProdPage() {
		clickOnElement(thinkPadLaptopsAtLenovoProdPage);
		String lenovoThinkPadTitleAtProdPage = getText(lenovoThinkPad4TitleAtProdPage);
		jsClick(lenovoThinkPad4TitleAtProdPage);
		jsScrollUntillElement(addToCartLenovoThinkPad);
		jsClick(addToCartLenovoThinkPad);
		return lenovoThinkPadTitleAtProdPage;
	}

}
