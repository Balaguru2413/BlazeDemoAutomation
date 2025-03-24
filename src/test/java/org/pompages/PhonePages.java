package org.pompages;

import org.blazedemo.BlazeDemo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhonePages extends BlazeDemo {
	public PhonePages() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='Phones']")
	private WebElement phones;
	public WebElement getPhones() {
		return phones;
	}
	
	@FindBy(xpath="//a[text()='Samsung galaxy s6']")
	private WebElement randomPhone;
	public WebElement getRandomPhone() {
		return randomPhone;
	}
	
	@FindBy(xpath="//h2[text()='Samsung galaxy s6']//following-sibling::h3[@class='price-container']")
	private WebElement phoneprice;
	public WebElement getPhoneprice() {
		return phoneprice;
	}
	
	@FindBy(xpath="//a[text()='Add to cart']")
	private WebElement addToCart;
	public WebElement getAddToCart() {
		return addToCart;
	}

	

	

	

	
	
}
