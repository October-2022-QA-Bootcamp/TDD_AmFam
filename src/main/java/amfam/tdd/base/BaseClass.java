package amfam.tdd.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import static amfam.tdd.utils.IConstant.*;

import java.time.Duration;

import amfam.tdd.utils.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	protected WebDriver driver;
	ReadProperties envVar;
	
	@BeforeSuite
	public void setUpSuite() {
		envVar = new ReadProperties();
	}
	
	@BeforeMethod
	public void setUpDriver() {
		String browser = envVar.getProperty(BROWSER);
		String url = envVar.getProperty(URL);
		long pageLoadWait = envVar.getNumProperty(PAGELOAD_WAIT);
		
		initDriver(browser);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadWait));
	}
	
	private void initDriver(String driverName) {
		switch (driverName) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case SAFARI:
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;
		default:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}
	}
	
	@AfterClass
	public void tearUp() {
		driver.quit();
	}
}
