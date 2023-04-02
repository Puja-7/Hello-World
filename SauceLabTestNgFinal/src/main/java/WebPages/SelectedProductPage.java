package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.UtitlityClass;

public class SelectedProductPage extends UtitlityClass{
	WebDriver driver;
	public SelectedProductPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	private WebElement addcartbtn;
	public CartPage addToCartGoToCart()
	{
		addcartbtn.click();
		CartPage cart=GoToCart();
		return cart;
		
		
	}
	
	
	

}
