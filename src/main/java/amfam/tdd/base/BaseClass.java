package amfam.tdd.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import static amfam.tdd.utils.IConstant.*;
import java.time.Duration;
import amfam.tdd.objects.AddressPage;
import amfam.tdd.objects.GetAQuotePage;
import amfam.tdd.objects.LandingPage;
import amfam.tdd.utils.Constant;
import amfam.tdd.utils.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	protected WebDriver driver;
	protected LandingPage landingPage;
	protected GetAQuotePage getAQuotePage;
	protected AddressPage addressPage;
	ReadProperties envVar = new ReadProperties();
	
	@Parameters("browser")
	@BeforeMethod
	public void setUpDriver(String browserName) {
		//Enum example
		//String browserName = envVar.getProperty(getString(browser));
		//String browserName = envVar.getProperty(browser.name());
		
		//IConstant interface example
		//String browserName = envVar.getProperty(BROWSER);
		String url = envVar.getProperty(URL);
		long pageLoadWait = envVar.getNumProperty(PAGELOAD_WAIT);
		long implicitWait = envVar.getNumProperty(IMPLECIT_WAIT);
		
		initDriver(browserName);
		initClasses(driver);
		driver.get(url);
		driver.manage().window().maximize()	;
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadWait));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
	}
	
	private void initClasses(WebDriver driver) {
		landingPage = new LandingPage(driver);
		getAQuotePage = new GetAQuotePage(driver);
		addressPage = new AddressPage(driver);
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
	
	@AfterMethod
	public void tearUp() {
		driver.quit();
	}
	
	@SuppressWarnings("unused")
	private String getString(Constant constant) {
		return constant.name();
	}
}
