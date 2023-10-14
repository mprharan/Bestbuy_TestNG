package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BestBuy_Base {

	public static WebDriver driver = null;

	public static WebDriver browserLaunch(String value) {
		try {
			if (value.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (value.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			} else if (value.equalsIgnoreCase("gecko")) {
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			return driver;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	public static void jsClick(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement elements = wait.until(ExpectedConditions.elementToBeClickable(element)); 
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", elements);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String readProperty(String key) throws Exception {
		try {
			String projectPath = System.getProperty("user.dir");
			File file = new File(projectPath + "/configBestBuy.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fileInput);
			return prop.get(key).toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	public static void jsScrollUntillElement(WebElement element) {
		try {
			waitExplicit(element);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void waitExplicit(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void softAssert(String actResult, String menuTitle) {
		try {
			SoftAssert sa = new SoftAssert();
			sa.assertEquals(actResult, menuTitle);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void userInput(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getText(WebElement element) {
		try {
			String text = element.getText();
			return text;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public static void clickOnElement(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void sleep() throws InterruptedException {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close() {
		try {
			driver.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static void implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public static void navigateForward() {
		driver.navigate().forward();
	}

	public static void navigateBack() {
		driver.navigate().back();
	}

	public static void refresh() {
		driver.navigate().refresh();
	}

	public static List<WebElement> dropDownOptions(WebElement element) {
		try {
			Select s1 = new Select(element);
			List<WebElement> options = s1.getOptions();
			return options;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void dropDownSelect(String options, WebElement element, String value) {
		try {
			Select s = new Select(element);
			if (options.equalsIgnoreCase("value")) {
				s.selectByValue(value);
			} else if (options.equalsIgnoreCase("text")) {
				s.selectByVisibleText(value);
			} else if (options.equalsIgnoreCase("index")) {
				int n = Integer.parseInt(value);
				s.deselectByIndex(n);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void popup(String options) {
		try {
			if (options.equalsIgnoreCase("ok")) {
				driver.switchTo().alert().accept();
			} else if (options.equalsIgnoreCase("cancel")) {
				driver.switchTo().alert().dismiss();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void sendKeysAlert(String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public static void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public static void frameSwitch(String element) {
		driver.switchTo().frame(element);
	}

	public static void capture(String name) throws IOException {
		try {
			TakesScreenshot scs = (TakesScreenshot) driver;
			File screenshotAs = scs.getScreenshotAs(OutputType.FILE);
			File destination = new File("D:\\Selenium scs\\" + name + ".png");
			FileHandler.copy(screenshotAs, destination);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
