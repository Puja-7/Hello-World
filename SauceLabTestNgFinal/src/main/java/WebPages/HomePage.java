package WebPages;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.UtitlityClass;

public class HomePage extends UtitlityClass{
	WebDriver driver;
	public HomePage(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	@FindBy(className="product_sort_container")
	WebElement dropdown;
	Select select=new Select(dropdown);
	public void sortpriceLowTohigh()
	{
		select.selectByValue("lohi");
		System.out.println("sorted by: "+select.getFirstSelectedOption().getText());
	}
	@FindBy(className="inventory_item_name")
	List<WebElement> items;
//	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10))
	public CartPage selectCorrectItem(String itemName)
	{
		System.out.println("Product added is: "+itemName);
		WebElement correctItem=items.stream().filter(s->s.getText().equals(itemName)).findFirst().orElse(null);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		correctItem.findElement(By.xpath("//following::div[2]/button[@class='btn btn_primary btn_small btn_inventory']")).click();
		CartPage cart=GoToCart();
			return cart;
		
	}
	
	//Do Like Rahul Shetty Add to cart button should be get from item name
	
	
	
	public String getHomeUrl()
	{
		return driver.getCurrentUrl();
	}

}
