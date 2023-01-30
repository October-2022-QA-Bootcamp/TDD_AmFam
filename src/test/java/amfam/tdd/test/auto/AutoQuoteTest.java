package amfam.tdd.test.auto;

import org.testng.annotations.Test;

import amfam.tdd.base.BaseClass;

public class AutoQuoteTest extends BaseClass{

	@Test
	public void createAQuoteTest() {
		landingPage.validateLandingPageTitle("Insurance designed with you in mind");
		landingPage.clickStartNewQuote();
	}
}
