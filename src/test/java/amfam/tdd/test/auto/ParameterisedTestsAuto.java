package amfam.tdd.test.auto;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import amfam.tdd.base.BaseClass;
import amfam.tdd.utils.AutoData;

public class ParameterisedTestsAuto extends BaseClass{

	@Parameters({"expectedTitle1", "getAQtTitle1", "zipCode1", "addressTitle"})
	@Test(enabled = false, groups = "auto")
	public void create_AutoQuoteTest(String expectedTitle, String getAQtTitle, String zipCode, String addressTitle) {
		landingPage.validateLandingPageTitle(expectedTitle);
		landingPage.clickStartNewQuoteBtn();
		getAQuotePage.validateGetAQuotePageTitle(getAQtTitle);
		getAQuotePage.insertZipCodeField(zipCode);
		getAQuotePage.clickCarLobBtn();
		getAQuotePage.clickLetsGoBtn();
		addressPage.verifyAddressPageTitle(addressTitle);
	}
	
	@Parameters({"expectedTitle1", "getAQtTitle1", "zipCode1", "addressTitle"})
	@Test(enabled = true, groups = "auto")
	public void create_AutoQuoteTest_AutoData(String expectedTitle, String getAQtTitle, String zipCode, String addressTitle) {
		AutoData autoData = new AutoData(expectedTitle, getAQtTitle, zipCode, addressTitle);
		landingPage.validateLandingPageTitle(autoData.getLandingPageTitle());
		landingPage.clickStartNewQuoteBtn();
		getAQuotePage.validateGetAQuotePageTitle(autoData.getGetAQtPageTitle());
		getAQuotePage.insertZipCodeField(autoData.getZipCode());
		getAQuotePage.clickCarLobBtn();
		getAQuotePage.clickLetsGoBtn();
		addressPage.verifyAddressPageTitle(autoData.getAddressPageTitle());
	}
	
}
