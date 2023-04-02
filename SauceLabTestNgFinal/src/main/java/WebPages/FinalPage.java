package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinalPage {
	WebDriver driver;
	public FinalPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h2")
	WebElement thanksmsg;
	public String ThanksMsg()
	{
		return thanksmsg.getText();
	}
	
}
