package WebPages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	
	public SelectedProductPage selectCorrectItem(String itemName)
	{
		WebElement correctItem=items.stream().filter(s->s.getText().equals(itemName)).findFirst().orElse(null);
		correctItem.click();
			//boolean flag=itemList.stream().anyMatch(s->s.equalsIgnoreCase("Sauce Labs Backpack"));
		return new SelectedProductPage(driver);
	}
	
	
	
	
	
	public String getHomeUrl()
	{
		return driver.getCurrentUrl();
	}

}
