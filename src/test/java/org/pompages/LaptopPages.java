package org.pompages;

import org.blazedemo.BlazeDemo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaptopPages extends BlazeDemo{
	public LaptopPages() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Laptops']")
	private WebElement laptops;
	public WebElement getLaptops() {
		return laptops;
	}

	
	@FindBy(xpath="//a[text()='Sony vaio i5']")
	private WebElement randomLaptop;
	public WebElement getRandomLaptop() {
		return randomLaptop;
	}
	
	@FindBy(xpath="//h2[text()='Sony vaio i5']//following-sibling::h3[@class='price-container']")
	private WebElement laptopprice;
	public WebElement getLaptopprice() {
		return laptopprice;
	}
	
	@FindBy(xpath="//a[text()='Add to cart']")
	private WebElement addToCart;
	public WebElement getAddToCart() {
		return addToCart;
	}

	
	

	

	
	
	

}
