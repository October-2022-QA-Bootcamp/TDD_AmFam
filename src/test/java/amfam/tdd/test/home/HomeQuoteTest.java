package amfam.tdd.test.home;

import org.testng.annotations.Test;
import amfam.tdd.base.BaseClass;

public class HomeQuoteTest extends BaseClass{

	@Test(priority = 2, groups = "home")
	public void createA_HomeQuoteTest() {
		landingPage.validateLandingPageTitle("Insurance designed with you in mind");
		landingPage.clickStartNewQuoteBtn();
		getAQuotePage.validateGetAQuotePageTitle("Get a Quote");
		getAQuotePage.insertZipCodeField("54115");
		getAQuotePage.clickHomeLobBtn();
		getAQuotePage.clickLetsGoBtn();
		addressPage.verifyAddressPageTitle("Verify your city and state");
	}
}
