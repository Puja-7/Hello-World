package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

	public static ExtentReports getextentObje()
	{
		String file=System.getProperty("user.dir")+"\\ExtentReportByPuja";
		ExtentSparkReporter reporter=new ExtentSparkReporter(file);
		reporter.config().setDocumentTitle("SauceLab ExtentReport");
		reporter.config().setReportName("Extent Report by Puja Mitkari");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Platform","Windows11");
		return extent;
	}
}
