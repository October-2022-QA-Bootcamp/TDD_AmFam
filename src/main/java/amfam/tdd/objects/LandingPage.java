package amfam.tdd.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import amfam.tdd.common.CommonActions;

public class LandingPage {

	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName = "h1")
	WebElement landingPageTitle;
	@FindBy(xpath = "//button[normalize-space(text())='Start a New Quote']")
	WebElement startNewQuoteBtn;
	
	public void validateLandingPageTitle(String expectedTitle) {
		CommonActions.validate(landingPageTitle, expectedTitle);
	}
	
	public void clickStartNewQuote() {
		CommonActions.click(startNewQuoteBtn);
	}
}
