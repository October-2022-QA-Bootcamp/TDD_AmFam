package amfam.tdd.test.auto;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import amfam.tdd.base.BaseClass;
import amfam.tdd.utils.AutoData;
import amfam.tdd.utils.ExcelUtils;
import static amfam.tdd.utils.IConstant.*;

public class AutoQuoteDataDriven extends BaseClass{

	@DataProvider(name = "data2D")
	public Object[][] getData(){
		Object[][] objects = new Object[2][4];
		
		objects[0][0] = "Insurance designed with you in mind";
		objects[0][1] = "Get a Quote";
		objects[0][2] = "54115";
		objects[0][3] = "Verify your city and state";
		
		objects[1][0] = "Insurance designed with you in mind";
		objects[1][1] = "Get a Quote";
		objects[1][2] = "54114";
		objects[1][3] = "Verify your city and state";
		
		return objects;
	}
	
	@DataProvider(name = "excel2D")
	public Object[][] get2D_Excel(){
		String filePath = envVar.getProperty(EXCEL_PATH);
		String sheetName = envVar.getProperty(EXCEL_SHEET);
		ExcelUtils utils = new ExcelUtils(filePath, sheetName);
		Object[][] objects = utils.get2DData();
		return objects;
	}
	
	@Test(dataProvider = "excel2D")
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
