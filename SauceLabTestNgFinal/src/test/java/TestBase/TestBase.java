package TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
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
	
	
	
	@BeforeMethod(alwaysRun=true)
	//@Parameters({"browser"})
	public LoginPage getUrl()   ///GET url......
	{
		String url=getProp().getProperty("Url");
		driver=driverInit("chrome");
		login=new LoginPage(driver);
		driver.manage().window().maximize();
				driver.get(url);
		return login;
	}
	
	@AfterMethod(alwaysRun=true)
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
	
	public Object[][] GetExcelData(String path) throws IOException,FileNotFoundException
	{
		DataFormatter format=new DataFormatter();
		FileInputStream fis=new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet= workbook.getSheet("Sheet1");
		int rowCount=sheet.getPhysicalNumberOfRows();
		XSSFRow row=sheet.getRow(0);
		int colCount=row.getLastCellNum();
		Object[][] data=new Object[rowCount-1][colCount];
		for(int i=0;i<rowCount-1;i++)
		{
			row=sheet.getRow(i+1);
			for(int j=0;j<colCount;j++)
			{
				XSSFCell cell=row.getCell(j);
				data[i][j]=format.formatCellValue(cell);
			}
		}
		return data;
	}

}
