package com.bestbuy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.base.BestBuy_Base;
import com.runnerclass.BestBuy_Runner;
import com.web.pom.Account_BB;
import com.web.pom.BottomLink_BB;
import com.web.pom.CartPage_BB;
import com.web.pom.Country_BB;
import com.web.pom.Menu_BB;
import com.web.pom.ProductPage_BB;

public class BestBuy_Test01 extends BestBuy_Runner {

	public String site = "https://www.bestbuy.com/";
	String expTitle = "Best Buy: Create an Account";
	String menuTitle = "Best Buy | Official Online Store | Shop Now & Save";
	String[] menus = { "Deals", "Support & Services", "Brands", "Appliances", "TV & Home Theater",
			"Computers & Tablets", "Cell Phones", "Audio", "Video Games", "Cameras, Camcorders & Drones",
			"Home, Furniture & Office", "Smart Home, Security & Wi-Fi", "Car Electronics & GPS", "Movies & Music",
			"Wearable Technology", "Health, Wellness & Fitness", "Outdoor Living", "Toys, Games & Collectibles",
			"Electric Transportation", "New & Featured" };

	@Test(priority = 0)
	public void navigatingToWebsite() {
		try {
			launchUrl(site);
			implicitlyWait();
			Country_BB home = new Country_BB();
			clickOnElement(home.selectCountry());
			String actTitle = BestBuy_Base.getTitle();
			String expTitle = "Best Buy International: Select your Country - Best Buy";
			softAssert(actTitle, expTitle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 1, enabled = false)
	public void createAccountAndLogin() throws InterruptedException {
		// SignUp Functionality
		sleep();
		Account_BB ac = new Account_BB();
		clickOnElement(ac.accBtn());

		// commented after creating account

		/*
		 * clickOnElement(ac.createAccBtn()); userInput(ac.fName(), "Hariharan");
		 * userInput(ac.lName(), "R"); userInput(ac.eMail(), "mprharan@gmail.com");
		 * userInput(ac.pass(), "Harirmnm@123"); userInput(ac.rePass(), "Harirmnm@123");
		 * userInput(ac.mob(), "8754331535"); clickOnElement(ac.btnCrAcc());
		 */

		// Login Functionality
		clickOnElement(ac.signInBtn());
		userInput(ac.userName(), "mprharan@gmail.com");
		userInput(ac.loginPass(), "Harirmnm@123");
		jsClick(ac.login());
		String actTitle = getTitle();
		softAssert(actTitle, expTitle);

	}

	@Test(priority = 2)
	public void validateTitleOfAllMenu() {

		try {
			Menu_BB menu = new Menu_BB();
			jsClick(menu.menuBtn());
			List<WebElement> allMenu = driver.findElements(By.xpath("//li[@class='liDropdownList ']"));
			for (WebElement menuTitle : allMenu) {
				String text = menuTitle.getText();
				for (String exp : menus) {
					exp.contains(text);
				}
			}
			jsClick(menu.menuBtn());
			capture("validateTitleOfAllMenu");
			sleep();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 3)
	public void validateBottomLinks() {

		try {
			BottomLink_BB bl = new BottomLink_BB();
			String actTitle = bl.validateTermsAndCondtionLink();
			String expTitle = "BestBuy.com Terms and Conditions";
			softAssert(actTitle, expTitle);
			capture("validateBottomLinks");
			sleep();
			navigateBack();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 4, enabled = false)
	public void shopByDeptMenu() {

		try {
			Menu_BB hp = new Menu_BB();
			hp.selectTvMenuInHomePage();
			ProductPage_BB pp = new ProductPage_BB();
			String sony75TitleAtProdPage = pp.addSony75InchTVInProdPageM2();// pp.addSony75InchTVInProdPage()
			hp.goToCartPage();
			CartPage_BB cp = new CartPage_BB();
			String sony75TitleAtCartPage = cp.validateSonyTvInCart();
			softAssert(sony75TitleAtCartPage, sony75TitleAtProdPage);
			capture("shopByDeptMenu");
			sleep();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 5)
	public void shopByBrandMenu() {

		try {
			Menu_BB hp = new Menu_BB();
			hp.selectLenovoBrand();
			ProductPage_BB pp = new ProductPage_BB();
			String lenovoThinkPadTitleAtProdPage = pp.addLenovoThinkPadInProdPage();
			hp.goToCartPage();
			CartPage_BB cp = new CartPage_BB();
			String lenovoThinkPadTitleAtCartPage = cp.validateLenovoThinkPadInCart();
			softAssert(lenovoThinkPadTitleAtCartPage, lenovoThinkPadTitleAtProdPage);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 6)
	public void searchItemBar() throws Exception {

		try {
			Menu_BB hp = new Menu_BB();
			hp.searchProduct("Mouse");
			ProductPage_BB pp = new ProductPage_BB();
			String prodTitleAtProductPage = pp.addLogitechMouse();
			CartPage_BB cp = new CartPage_BB();
			String prodTitleAtCartPage = cp.validateLogitechMouseInCart();
			softAssert(prodTitleAtProductPage, prodTitleAtCartPage);
			capture("searchItemBar");
			sleep();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 7)
	public void checkoutForm() throws Exception {

		try {
			Menu_BB hp = new Menu_BB();
			hp.searchProduct("Mouse");
			sleep();
			ProductPage_BB pp = new ProductPage_BB();
			pp.addLogitechMouse();
			sleep();
			CartPage_BB cp = new CartPage_BB();
			cp.goToCheckOutPage();
			capture("checkoutForm");
			sleep();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
