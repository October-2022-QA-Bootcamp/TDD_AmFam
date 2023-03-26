package amfam.tdd.base;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.Status;
import static amfam.tdd.utils.IConstant.*;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import amfam.tdd.objects.AddressPage;
import amfam.tdd.objects.GetAQuotePage;
import amfam.tdd.objects.LandingPage;
import amfam.tdd.utils.Constant;
import amfam.tdd.utils.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends ExtentListener{
	
	protected WebDriver driver;
	protected LandingPage landingPage;
	protected GetAQuotePage getAQuotePage;
	protected AddressPage addressPage;
	protected ReadProperties envVar = new ReadProperties();
	
	@Parameters({"browser"})
	@BeforeMethod
	public void setUpDriver(String browserName) {
		String givenUrl = envVar.getProperty(URL);
		long pageLoadWait = envVar.getNumProperty(PAGELOAD_WAIT);
		long implicitWait = envVar.getNumProperty(IMPLECIT_WAIT);
		
		initDriver(browserName);
		initClasses(driver);
		driver.manage().window().maximize()	;
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadWait));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		driver.get(givenUrl);
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
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
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
		case REMOTE:
			driver = setBrowserStackCapabilities();
			break;
		default:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}
	}
	
	public WebDriver setBrowserStackCapabilities() {
		ReadProperties bsProperties = new ReadProperties(0);
		
		MutableCapabilities capabilities = new MutableCapabilities();
		capabilities.setCapability(BS_BROWSER_NAME, bsProperties.getProperty(BS_BROWSER_NAME));
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put(BS_OS, bsProperties.getProperty(BS_OS));
		browserstackOptions.put(BS_OS_VER, bsProperties.getProperty(BS_OS_VER));
		browserstackOptions.put(BS_BROWSER_VER, bsProperties.getProperty(BS_BROWSER_VER));
		capabilities.setCapability(BS_OPT, browserstackOptions);

		String urlString = "https://" + bsProperties.getProperty(BS_USER) + ":" + bsProperties.getProperty(BS_PASS)
				+ bsProperties.getProperty(BS_URL);
		URL url = null;
		try {
			url = new URL(urlString);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return new RemoteWebDriver(url,capabilities);
	}
	
	@AfterMethod
	public void tearUp() {
		driver.quit();
	}
	
	@AfterMethod
	public void getResult(ITestResult result, Method method) {
		if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, PASSED);
		}else if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, FAILED);
			test.addScreenCaptureFromPath(captureScreenShot(driver, method.getName()));
		}else if(result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, SKIPPED);
		}
	}
	
	@SuppressWarnings("unused")
	private String getString(Constant constant) {
		return constant.name();
	}
}
