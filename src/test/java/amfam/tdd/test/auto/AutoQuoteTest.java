package amfam.tdd.test.auto;

import org.testng.Assert;
import org.testng.annotations.Test;
import amfam.tdd.base.BaseClass;
import amfam.tdd.reporting.Logs;

public class AutoQuoteTest extends BaseClass{

	@Test(enabled = true, groups = {"auto", "csr-23"})
	public void create_AutoQuoteTest() {
		landingPage.validateLandingPageTitle("Insurance designed with you in mind");
		landingPage.clickStartNewQuoteBtn();
		getAQuotePage.validateGetAQuotePageTitle("Get a Quote");
		getAQuotePage.insertZipCodeField("54115");
		getAQuotePage.clickCarLobBtn();
		getAQuotePage.clickLetsGoBtn();
		addressPage.verifyAddressPageTitle("Verify your city and state");
	}
	
	@Test(enabled = true, priority = 0, groups = {"auto", "non-func"}, dependsOnMethods = "test2", ignoreMissingDependencies = true)
	public void test1() {
		Logs.log("Test1");
	}
	
	@Test(enabled = false, priority = 1, groups = {"auto", "non-func"}, invocationCount = 2)
	public void test2() {
		Logs.log("Test2");
	}
	
	@Test(enabled = true, priority = 1, groups = {"auto", "non-func", "regression", "smoke"})
	public void failedTestScenarios() {
		//Step1
		//Step2
		Logs.log("Test3");
		//Assert.fail();
	}
	
	@Test(enabled = false, priority = 1, groups = {"auto", "non-func"}, retryAnalyzer = amfam.tdd.retry.RetryFailedTests.class)
	public void testRetry() {
		Logs.log("Retry Test");
		Assert.fail();
	}
}
