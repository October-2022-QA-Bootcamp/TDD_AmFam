package amfam.tdd.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static amfam.tdd.common.CommonActions.*;

public class AddressPage {

	public AddressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "prefill-city-state-dialog-title")
	WebElement titleVerifyCity;
	WebElement option1stBtn;
	WebElement continueBtn;
	WebElement titleAddressPage;
	WebElement addressInput;
	WebElement address2Input;
	WebElement sameAsPolicyAddressBtn_Y;
	WebElement sameAsPolicyAddressBtn_N;
	WebElement sameAddress5YrsBtn_Y;
	WebElement sameAddress5YrsBtn_N;
	WebElement startQuoteBtn;
	
	public void verifyAddressPageTitle(String expected) {
		validate(titleVerifyCity, expected);
	}
}
