package amfam.tdd.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static amfam.tdd.common.CommonActions.*;

public class GetAQuotePage {

	public GetAQuotePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "h1")
	WebElement getAQuotePageTitle;
	@FindBy(id = "uid_61")
	WebElement zipCoddInput;
	@FindBy(xpath = "//div[@value='Car']")
	WebElement carLobBtn;
	@FindBy(xpath = "//div[@value='Home']")
	WebElement homeLobBtn;
	@FindBy(className = "LoadingButton__content")
	WebElement letsGoBtn;
	
	public void validateGetAQuotePageTitle(String expected) {
		validate(getAQuotePageTitle, expected);
	}
	
	public void insertZipCodeField(String zip) {
		insert(zipCoddInput, zip);
	}
	
	public void clickCarLobBtn() {
		click(carLobBtn);
	}
	
	public void clickHomeLobBtn() {
		click(homeLobBtn);
	}
	
	public void clickLetsGoBtn() {
		click(letsGoBtn);
	}

}
