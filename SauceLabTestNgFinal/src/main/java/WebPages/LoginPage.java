package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.UtitlityClass;

public class LoginPage extends UtitlityClass{
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-name")
	private WebElement username;
	@FindBy(id="password")
	private WebElement password;
	@FindBy(id="login-button")
	private WebElement loginbtn;

	public void EnterLoginDetails(String uname,String pwd)
	{
		username.sendKeys(uname);
		password.sendKeys(pwd);
	}
	public HomePage clickOnValidLoginBtn()
	{
		loginbtn.click();
		return new HomePage(driver);
	}
	public void clickonInvalidLogin()
	{
		loginbtn.click();
	}
	public String getLoginUrl()
	{
		return driver.getCurrentUrl();
	}
	
}
