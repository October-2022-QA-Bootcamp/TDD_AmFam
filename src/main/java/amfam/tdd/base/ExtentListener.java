package amfam.tdd.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.google.common.io.Files;
import amfam.tdd.reporting.ExtentReporting;
import amfam.tdd.reporting.ExtentTestManager;
import amfam.tdd.reporting.Logs;

public class ExtentListener {

	ExtentReports extentReports;
	ExtentTest test;
	
	@BeforeSuite
	public void initExtentReport() {
		extentReports = ExtentTestManager.initialExtentReport();
	}
	
	@BeforeMethod
	public void startExtentReport(Method method) {
		test = ExtentReporting.createTest(method.getName());
	}
	
	@AfterSuite
	public void closeReport() {
		extentReports.flush();
	}
	
	String captureScreenShot(WebDriver driver, String testName) {
		TakesScreenshot ss = (TakesScreenshot)driver;
		File folder = new File("screenShots");
		folder.mkdirs();
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM.dd.yyyy_HH.mm.ss");
		String dateTime = dateFormat.format(date);
		File ssLocation = new File(folder+"/"+testName+"_"+dateTime+".png");
		File sourceFile = ss.getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(sourceFile, ssLocation);
			Logs.log("*** Screen shot has been captured successfully ***");
			System.out.println("Find screenshots here : "+ ssLocation.getAbsolutePath());
		}catch (IOException e) {
			Logs.log("---> Failed to capture screenshot" );
			System.out.println("Failed at : "+ ssLocation.getAbsolutePath());
		}
		return ssLocation.getAbsolutePath();
	}
}
