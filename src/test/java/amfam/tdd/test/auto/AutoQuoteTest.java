package amfam.tdd.test.auto;

import org.testng.annotations.Test;
import amfam.tdd.base.BaseClass;
import amfam.tdd.reporting.Logs;

public class AutoQuoteTest extends BaseClass{

	@Test(groups = "auto")
	public void create_AutoQuoteTest() {
		landingPage.validateLandingPageTitle("Insurance designed with you in mind");
		landingPage.clickStartNewQuoteBtn();
		getAQuotePage.validateGetAQuotePageTitle("Get a Quote");
		getAQuotePage.insertZipCodeField("54115");
		getAQuotePage.clickCarLobBtn();
		getAQuotePage.clickLetsGoBtn();
		addressPage.verifyAddressPageTitle("Verify your city and state");
	}
	
	@Test(priority = 0, groups = {"auto", "non-func"})
	public void test1() {
		Logs.log("Test1");
	}
	
	@Test(priority = 1, groups = {"auto", "non-func"})
	public void test2() {
		Logs.log("Test2");
	}
}
