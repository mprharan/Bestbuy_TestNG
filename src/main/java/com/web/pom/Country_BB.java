package com.web.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BestBuy_Base;

public class Country_BB extends BestBuy_Base {

	@FindBy(xpath = "//a/h4[contains(text(),'United States')]")
	private WebElement country;

	public WebElement selectCountry() {
		return country;
	}

	public Country_BB() {
		PageFactory.initElements(driver, this);
	}
}
