package com.web.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BestBuy_Base;

public class Account_BB extends BestBuy_Base {

	@FindBy(id = "account-menu-account-button")
	private WebElement accBtn;

	public WebElement accBtn() {
		return accBtn;
	}

	@FindBy(xpath = "//a[normalize-space()='Create Account']")
	private WebElement createAccBtn;

	public WebElement createAccBtn() {
		return createAccBtn;
	}

	@FindBy(id = "firstName")
	private WebElement fName;

	public WebElement fName() {
		return fName;
	}

	@FindBy(id = "lastName")
	private WebElement lName;

	public WebElement lName() {
		return lName;
	}

	@FindBy(id = "email")
	private WebElement eMail;

	public WebElement eMail() {
		return eMail;
	}

	@FindBy(id = "fld-p1")
	private WebElement pass;

	public WebElement pass() {
		return pass;
	}

	@FindBy(id = "reenterPassword")
	private WebElement rePass;

	public WebElement rePass() {
		return rePass;
	}

	@FindBy(id = "phone")
	private WebElement mob;

	public WebElement mob() {
		return mob;
	}

	@FindBy(xpath = "//button[normalize-space()='Create an Account']")
	private WebElement btnCrAcc;

	public WebElement btnCrAcc() {
		return btnCrAcc;
	}

	@FindBy(xpath = "//a[normalize-space()='Sign In']")
	private WebElement signInBtn;

	public WebElement signInBtn() {
		return signInBtn;
	}
	
	@FindBy(id = "fld-e")
	private WebElement userName;
	
	public WebElement userName() {
		return userName;
	}
	
	@FindBy(id = "fld-p1")
	private WebElement loginPass;
	
	public WebElement loginPass() {
		return loginPass;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Sign In']")
	private WebElement login;
	
	public WebElement login() {
		return login;
	}

	public Account_BB() {
		PageFactory.initElements(driver, this);
	}
}
