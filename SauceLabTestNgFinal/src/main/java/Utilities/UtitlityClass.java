package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WebPages.CartPage;

public class UtitlityClass {
	WebDriver driver;
	public UtitlityClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="shopping_cart_container")
	private WebElement shoppinCartBtn;
	public CartPage GoToCart()
	{
		shoppinCartBtn.click();
		return new CartPage(driver);
	}
	
	
	
	

}
