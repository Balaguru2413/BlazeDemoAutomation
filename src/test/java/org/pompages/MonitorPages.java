package org.pompages;

import org.blazedemo.BlazeDemo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MonitorPages extends BlazeDemo {
 public MonitorPages() {
	PageFactory.initElements(driver, this);
}
 @FindBy(xpath="//a[text()='Monitors']")
	private WebElement monitors;
 public WebElement getMonitors() {
		return monitors;
	}

	

	
	@FindBy(xpath="//a[text()='Apple monitor 24']")
	private WebElement randomMonitor;
	public WebElement getRandomMonitor() {
		return randomMonitor;
	}
	
	
	@FindBy(xpath="//h2[text()='Apple monitor 24']//following-sibling::h3[@class='price-container']")
	private WebElement monitorprice;
	public WebElement getMonitorprice() {
		return monitorprice;
	}
	
	
	@FindBy(xpath="//a[text()='Add to cart']")
	private WebElement addToCart;
	public WebElement getAddToCart() {
		return addToCart;
	}


	

	


	


	
	
	
}
