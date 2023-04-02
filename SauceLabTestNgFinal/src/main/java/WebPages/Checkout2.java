package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout2 {
	WebDriver driver;
	public Checkout2(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//button[@id='finish']")
	WebElement finishBtn;
	
	public FinalPage clickonFinish()
	{
		finishBtn.click();
		return new FinalPage(driver);
	}
}
