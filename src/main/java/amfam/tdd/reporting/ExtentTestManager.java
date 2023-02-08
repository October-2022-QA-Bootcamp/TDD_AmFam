package amfam.tdd.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentTestManager {

	public static ExtentReports extentReports;

	public static synchronized ExtentReports initialExtentReport() {
		try {
			if (extentReports == null) {
				extentReports = new ExtentReports();
				ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
				spark.config().setReportName("AmFam QA Automation");
				spark.config().setTheme(Theme.DARK);
				extentReports.attachReporter(spark);
				extentReports.setSystemInfo("Testing", "Regression");
				extentReports.setSystemInfo("Team", "QA - Avengers");
				extentReports.setSystemInfo("OS", System.getProperty("os.name"));
				extentReports.setSystemInfo("OS Version", System.getProperty("os.version"));
				extentReports.setSystemInfo("Host", System.getProperty("user.name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return extentReports;
	}
}
