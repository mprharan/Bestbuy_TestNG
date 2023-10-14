package com.web.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BestBuy_Base;

public class BottomLink_BB extends BestBuy_Base {
	
	public BottomLink_BB() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Terms & Conditions']")
	WebElement termsAndCondLink;
	
	public String validateTermsAndCondtionLink() {
		jsScrollUntillElement(termsAndCondLink);
		clickOnElement(termsAndCondLink);
		String actTitle = getTitle();
		return actTitle;
	}

}
