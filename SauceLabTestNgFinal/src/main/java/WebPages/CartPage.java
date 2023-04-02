package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.UtitlityClass;

public class CartPage extends UtitlityClass{

	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//button[@id='checkout']")
	WebElement checkoutbtn;
	public String getCartUrl()
	{
		return driver.getCurrentUrl();
	}
	public Checkout1 clickOnCheckOut() 
	{
		checkoutbtn.click();
		return new Checkout1(driver);
	}
}
