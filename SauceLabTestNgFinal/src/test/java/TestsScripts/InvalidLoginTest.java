package TestsScripts;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import TestBase.TestBase;

public class InvalidLoginTest extends TestBase{

	@Test
	@Parameters({"username","password"})
	public void InvalidLogin(String a,String b)
	{
		login.EnterLoginDetails(a, b);
		login.clickonInvalidLogin();
		String loginurl=login.getLoginUrl();
		System.out.println("************88Login Url: "+loginurl);
		Assert.assertEquals(loginurl,"https://www.saucedemo.com/","LoginUrl Validation Failed");
	}

}
