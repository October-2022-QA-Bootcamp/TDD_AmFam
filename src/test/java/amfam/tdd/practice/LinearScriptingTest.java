package amfam.tdd.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LinearScriptingTest {

	WebDriver driver;
	
	@BeforeMethod
	public void init() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amfam.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void linearScripting() {
		
		WebElement startAQuoteBtn = driver.findElement(By.xpath("//button[contains(.,'Start a New Quote')]"));
		
		startAQuoteBtn.click();//Only test is one liner, however rest other steps are repeatable and not exactly testing
	}
	
	@Test
	public void linearScripting1() {
		
		WebElement startAQuoteBtn = driver.findElement(By.xpath("//button[contains(.,'Start a New Quote')]"));
		
		startAQuoteBtn.click();
		
	}
}
