package TestBase;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.github.dockerjava.api.model.Driver;

import WebPages.LoginPage;

public class TestBase {
	public WebDriver driver;
	public static Properties prop;
	public LoginPage login;
	
	public static Properties getProp()
	{
		prop=new Properties();
		String path=System.getProperty("user.dir")+"\\src\\main\\java\\configFile\\config.properties";
		FileInputStream fis;
try {
			fis = new FileInputStream(path);
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	public WebDriver driverInit(String browser) //Driver initialization
	{
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
	
		}
		else
		{
			System.out.println("Invalid Driver.....");
		}
		return driver;
	}
	
	
	
	@BeforeClass(alwaysRun=true)
	@Parameters({"browser"})
	public LoginPage getUrl(String browser)   ///GET url......
	{
		String url=getProp().getProperty("Url");
		driver=driverInit(browser);
		login=new LoginPage(driver);
		driver.manage().window().maximize();
				driver.get(url);
		return login;
	}
	
	@AfterClass(alwaysRun=true)
	public void close()
	{
		driver.close();
	}
	
	public String getScreenshot(WebDriver driver,String Name) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"\\Screenshot\\"+Name+".png";
		File dest=new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}

}
