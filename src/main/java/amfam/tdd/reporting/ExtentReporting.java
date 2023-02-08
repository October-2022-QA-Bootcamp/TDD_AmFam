package amfam.tdd.reporting;

import java.util.HashMap;
import com.aventstack.extentreports.ExtentTest;

public class ExtentReporting {

	public static HashMap<Long, ExtentTest> tests = new HashMap<>();
	public static ExtentTest extentTest;
	
	public static ExtentTest getTest(long processId) {
		return tests.get(processId);
	}
	
	public static ExtentTest createTest(String testName) {
		extentTest = ExtentTestManager.extentReports.createTest(testName);
		tests.put(Thread.currentThread().getId(), extentTest);
		return extentTest;
	}
}
