package com.web.pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.base.BestBuy_Base;

public class Menu_BB extends BestBuy_Base {

	public Menu_BB() {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[normalize-space()='Menu']")
	private WebElement menuBtn;

	public WebElement menuBtn() {
		return menuBtn;
	}

	@FindBy(xpath = "//li[@class='liDropdownList ']/button")
	private WebElement menuLst;

	public WebElement menuLst() {
		return menuLst;
	}
	

	@FindBys(@FindBy(xpath = "//li[@class='liDropdownList ']"))
	private List<WebElement> allMenu;
	
	public WebElement allMenu() {
		return (WebElement) allMenu;
	}
	
	@FindBy(xpath = "//a[text()='Lenovo']")
	WebElement lenovoInBrandsMenu;
	
	@FindBy(xpath = "//button[text()='Brands']")
	WebElement brandsInMenu;
	
	@FindBy(xpath = "//button[@data-lid='ubr_tv']")
	WebElement tvInMenu;

	@FindBy(xpath = "//button[text()='TVs by Brand']")
	WebElement tvsByBrandInnerMenu;

	@FindBy(xpath = "//a[text()='Sony TVs']")
	WebElement sonyTvsInnerMenu2;
	
	@FindBy(id = "gh-search-input")
	WebElement searchBox;
	
	@FindBy(xpath = "//span[text()='Cart']")
	WebElement cartButton;
	
	@FindBy(xpath = "//button[@title='submit search']")
	WebElement searchButton;
	
	public void goToCartPage() {
		jsClick(cartButton);
	}
	
	public void selectTvMenuInHomePage() {
		clickOnElement(menuBtn);
		clickOnElement(tvInMenu);
		clickOnElement(tvsByBrandInnerMenu);
		clickOnElement(sonyTvsInnerMenu2);
	}
	
	public void selectLenovoBrand() {
		clickOnElement(menuBtn);
		clickOnElement(brandsInMenu);
		clickOnElement(lenovoInBrandsMenu);
	}
	
	public void searchProduct(String productName) {
		userInput(searchBox, productName);
		clickOnElement(searchButton);
	}

}
