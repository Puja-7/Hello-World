package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.UtitlityClass;

public class Checkout1 extends UtitlityClass{
WebDriver driver;
	public Checkout1(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="first-name")
	WebElement fname;
	@FindBy(id="last-name")
	WebElement lname;
	@FindBy(id="postal-code")
	WebElement zipCode;
	@FindBy(id="continue")
	WebElement continuebtn;
	public Checkout2 clickonContinue(String fname1,String lname1,String code1)
	{
		
		fname.sendKeys(fname1);
		lname.sendKeys(lname1);
		zipCode.sendKeys(code1);
		continuebtn.click();
		return new Checkout2(driver);
				
	}
	//add info fname.lname,zipcode
	
}
