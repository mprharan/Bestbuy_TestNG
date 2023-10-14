package com.runnerclass;

import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.base.BestBuy_Base;

public class BestBuy_Runner extends BestBuy_Base {

	public String url = "https://www.bestbuy.com/";

	@BeforeClass
	// Validating url is not broken
	public void validateUrlIsNotBroken() {
		try {
			URL site = new URL(url);

			// Now we will be creating url connection and getting the response code
			HttpURLConnection httpURLConnect = (HttpURLConnection) site.openConnection();
			httpURLConnect.setConnectTimeout(5000);
			httpURLConnect.connect();
			if (httpURLConnect.getResponseCode() >= 400) {
				System.out.println(site + " - " + httpURLConnect.getResponseMessage() + "is a broken link");
			}

			// Fetching and Printing the response code obtained
			else {
				System.out.println(site + " - " + httpURLConnect.getResponseMessage());
			}
		} catch (Exception e) {
		}
	}

	@BeforeTest
	public static void setUp() {
		browserLaunch("chrome");
	}

	@AfterTest
	public static void tearDown() {
		close();
	}

}
