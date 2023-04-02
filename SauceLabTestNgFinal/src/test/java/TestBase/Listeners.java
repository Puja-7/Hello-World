package TestBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utilities.ExtentReportUtility;

public class Listeners extends TestBase implements ITestListener {
	WebDriver driver;
	ExtentReports extent=ExtentReportUtility.getextentObje();
	ExtentTest test;
	ThreadLocal<ExtentTest> threadTest=new ThreadLocal<>();
	
	@Override
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
		threadTest.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		threadTest.get().log(Status.PASS,"PASS");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		threadTest.get().fail(result.getThrowable());
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String Path;
		try {
			Path = getScreenshot(driver, result.getMethod().getMethodName());
			threadTest.get().addScreenCaptureFromPath(Path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		threadTest.get().log(Status.SKIP,"SKIPPED");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
