package org.pompages;

import org.blazedemo.BlazeDemo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends BlazeDemo {
	public BasePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Home ']")
	private WebElement home;
	public WebElement getHome() {
	return home;
	}
	
	
}
