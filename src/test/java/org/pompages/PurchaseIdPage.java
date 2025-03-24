package org.pompages;

import org.blazedemo.BlazeDemo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseIdPage extends BlazeDemo {
	public PurchaseIdPage() {
     PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[text()='Thank you for your purchase!']")
	private WebElement successfulMessage;
	public WebElement getSuccessfulMessage() {
		return successfulMessage;
	}
	
	@FindBy(xpath="//p[@class='lead text-muted ']")
	private WebElement purchaseInfo;
	public WebElement getPurchaseInfo() {
		return purchaseInfo;
	}
	

	

	
	

}
