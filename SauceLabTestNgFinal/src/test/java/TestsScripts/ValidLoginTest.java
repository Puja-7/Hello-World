package TestsScripts;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import TestBase.TestBase;
import Utilities.UtitlityClass;
import WebPages.CartPage;
import WebPages.Checkout1;
import WebPages.Checkout2;
import WebPages.FinalPage;
import WebPages.HomePage;
import WebPages.SelectedProductPage;

public class ValidLoginTest extends TestBase{	
	UtitlityClass util;
	HomePage home;
	SelectedProductPage selectProduct;
	CartPage cart;
	Checkout1 check1;
	Checkout2 check2;
	FinalPage finalpage;
	
	@Test
	
	public void ValidLogin()
	{
		login.EnterLoginDetails("standard_user","secret_sauce");
	home=	login.clickOnValidLoginBtn();
		String currenturl=home.getHomeUrl();
		System.out.println("**************Home Url: "+currenturl);
		Assert.assertEquals(currenturl, "https://www.saucedemo.com/inventory.html","Home Url Validation Failed..");
		
		}
	
	@Test(dependsOnMethods="ValidLogin")
	public void validateThanksMessage()
	{
		selectProduct=home.selectCorrectItem("Sauce Labs Backpack");
	cart=selectProduct.addToCartGoToCart();
	
		check1=cart.clickOnCheckOut();
		check2=check1.clickonContinue("Puja", "Mitkari", "411020");
		finalpage=check2.clickonFinish();
		String Actualmsg=finalpage.ThanksMsg();
		System.out.println("*************Thanks Message is: "+Actualmsg);
		Assert.assertEquals(Actualmsg,"Thank you for your order!", "Thanks message validation Failed....................");
		
	}
	
	
}
