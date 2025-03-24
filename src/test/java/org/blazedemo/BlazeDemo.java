package org.blazedemo;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pompages.BasePage;
import org.pompages.CartPage;
import org.pompages.LaptopPages;
import org.pompages.MonitorPages;
import org.pompages.PhonePages;
import org.pompages.PurchaseIdPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BlazeDemo {
	public static WebDriver driver;
	int phonePrice;
	int laptopPrice;
	int monitorPrice;

	@BeforeClass
	public void browserSetup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@Test(priority = 0)
	public void launchApplication() {

		driver.get("https://www.demoblaze.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 1)

	// Select any phone and get its Price
	public void selectPhoneAndAddToCart() {
		PhonePages p = new PhonePages();
		p.getPhones().click();
		// Choose any phone to Buy
		p.getRandomPhone().click();
		String phonePrice1 = p.getPhoneprice().getText();
		String[] split = phonePrice1.split(" ");
		String substring = split[0].substring(1);
		phonePrice = Integer.parseInt(substring);
		System.out.println("Phone Price is $" + phonePrice);
		// add phone to cart
		p.getAddToCart().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		if (wait.until(ExpectedConditions.alertIsPresent()) != null) {
			Alert alert = driver.switchTo().alert();
			System.out.println("Phone " + alert.getText());
			alert.accept();
		}
	}

	@Test(priority = 2)
	// Select any Laptop and get its Price
	public void selectLaptopAndAddToCart() {

		// navigate to home
		BasePage b = new BasePage();
		b.getHome().click();
		// Choose laptop category
		LaptopPages l = new LaptopPages();
		l.getLaptops().click();
		// Choose any Laptop to Buy
		l.getRandomLaptop().click();
		String laptopPrice1 = l.getLaptopprice().getText();
		String[] split = laptopPrice1.split(" ");
		String substring = split[0].substring(1);
		laptopPrice = Integer.parseInt(substring);
		System.out.println("Laptop Price is $" + laptopPrice);
		// add laptop to cart
		l.getAddToCart().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		if (wait.until(ExpectedConditions.alertIsPresent()) != null) {
			Alert alert = driver.switchTo().alert();
			System.out.println("Laptop " + alert.getText());
			alert.accept();
		}

	}

	@Test(priority = 3)
	// Select any monitor and get its Price
	public void selectMonitorAndAddToCart() {

		// navigate to home
		BasePage b = new BasePage();
		b.getHome().click();
		// Choose monitor category
		MonitorPages m = new MonitorPages();
		m.getMonitors().click();
		// Choose any monitor to Buy
		m.getRandomMonitor().click();
		String monitorPrice1 = m.getMonitorprice().getText();
		String[] split = monitorPrice1.split(" ");
		String substring = split[0].substring(1);
		monitorPrice = Integer.parseInt(substring);
		System.out.println("Monitor Price is $" + monitorPrice);
		// add monitor to cart
		m.getAddToCart().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		if (wait.until(ExpectedConditions.alertIsPresent()) != null) {
			Alert alert = driver.switchTo().alert();
			System.out.println("Monitor " + alert.getText());
			alert.accept();
		}

	}

	@Test(priority = 4)
	// select phone item and remove it and place order in cart page
	public void removePhoneAndPlaceOrder() throws InterruptedException {
		CartPage c = new CartPage();
		// navigate to cart page
		c.getCart().click();
		// remove phone
		c.getRemovePhone().click();
		Thread.sleep(5000);
		System.out.println("Phone is removed from cart");
		// purchase the order

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", c.getPlaceOrder());
		js.executeScript("arguments[0].setAttribute('value','Balaguru')", c.getName());
		js.executeScript("arguments[0].setAttribute('value','India')", c.getCountry());
		js.executeScript("arguments[0].setAttribute('value','Chennai')", c.getCity());
		js.executeScript("arguments[0].setAttribute('value','1234567890098765')", c.getCreditCard());
		js.executeScript("arguments[0].setAttribute('value','12')", c.getMonth());
		js.executeScript("arguments[0].setAttribute('value','2027')", c.getYear());
		js.executeScript("arguments[0].click();", c.getPurchaseBtn());

	}

	@Test(priority = 5)
	// verifying succesfull message with correct amount and purchase id
	public void verifySuccesfullMessage() {
		// verifying succesfull message
		String actual = "Thank you for your purchase!";
		PurchaseIdPage p = new PurchaseIdPage();
		String expected = p.getSuccessfulMessage().getText();
		Assert.assertEquals(expected, actual, "order placing is failed");
		System.out.println("Order succesfully placed");
		String purchaseInfo = p.getPurchaseInfo().getText();
		// to get purchase id
		String id = purchaseInfo.split("/n")[0].split(":")[1].trim().substring(0, 6);
		System.out.println("Purchase ID is " + id);
		// to get total amount
		String amount = purchaseInfo.split("/n")[0].split(":")[2].trim().split(" ")[0];
		int expectedAmount = Integer.parseInt(amount);
		System.out.println("Total amount is $" + expectedAmount);
		int actualAmount = laptopPrice + monitorPrice;
		Assert.assertEquals(actualAmount, expectedAmount, "Total amount mismatched");
		System.out.println("Total amount matches with added product");

	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
	}

}
