package org.pompages;

import org.blazedemo.BlazeDemo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BlazeDemo{
	public CartPage() {
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//a[text()='Cart']")
	private WebElement cart;
	public WebElement getCart() {
		return cart;
	}
	
	
	@FindBy(xpath="//td[text()='Samsung galaxy s6']//following-sibling::td//child::a[text()='Delete']")
	private WebElement removePhone;
	public WebElement getRemovePhone() {
		return removePhone;
	}
	
	@FindBy(xpath="//button[text()='Place Order']")
	private WebElement placeOrder;
	public WebElement getPlaceOrder() {
		return placeOrder;
	}
	
	@FindBy(id="name")
	private WebElement name;
	public WebElement getName() {
		return name;
	}
	
	@FindBy(id="country")
	private WebElement country;
	public WebElement getCountry() {
		return country;
	}
	
	@FindBy(id="city")
	private WebElement city;
	public WebElement getCity() {
		return city;
	}
	
	@FindBy(id="card")
	private WebElement creditCard;

	public WebElement getCreditCard() {
		return creditCard;
	}
	
	@FindBy(id="month")
	private WebElement month;

	public WebElement getMonth() {
		return month;
	}
	
	@FindBy(id="year")
	private WebElement year;
	public WebElement getYear() {
		return year;
	}
	
	@FindBy(xpath="//button[text()='Purchase']")
	private WebElement purchaseBtn;
	public WebElement getPurchaseBtn() {
		return purchaseBtn;
	}

	

	

	

	

	

	



	

	
	
	
	
	

}
