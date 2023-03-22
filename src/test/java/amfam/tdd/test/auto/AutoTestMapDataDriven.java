package amfam.tdd.test.auto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import amfam.tdd.base.BaseClass;
import amfam.tdd.utils.AutoData;
import amfam.tdd.utils.ExcelUtils;
import static amfam.tdd.utils.IConstant.*;

public class AutoTestMapDataDriven extends BaseClass{

	@DataProvider(name = "excelMap")
	public Iterator<Map<String, String>> getListData(){
		String file = envVar.getProperty(EXCEL_PATH);
		String sheet = envVar.getProperty(EXCEL_SHEET);
		ExcelUtils utils = new ExcelUtils(file, sheet);
		
		List<Map<String, String>> listOfMap = utils.getMapDataList();
		return listOfMap.iterator();
	}
	
	@Test(dataProvider = "excelMap", enabled = false)
	public void create_AutoQuoteTest_AutoData(Map<String, String> map) {
		AutoData autoData = new AutoData(map.get("Expected Title"), map.get("Get A Quote Title"), map.get("Zip Code"), map.get("Address Title"));
		landingPage.validateLandingPageTitle(autoData.getLandingPageTitle());
		landingPage.clickStartNewQuoteBtn();
		getAQuotePage.validateGetAQuotePageTitle(autoData.getGetAQtPageTitle());
		getAQuotePage.insertZipCodeField(autoData.getZipCode());
		getAQuotePage.clickCarLobBtn();
		getAQuotePage.clickLetsGoBtn();
		addressPage.verifyAddressPageTitle(autoData.getAddressPageTitle());
	}
	
	@DataProvider(name = "lists")
	public Iterator<List<String>> getLists(){
		List<List<String>> lists = new ArrayList<>();
		List<String> list = new ArrayList<>();
		list.add("Insurance designed with you in mind");
		list.add("Get a Quote");
		list.add("54114");
		list.add("Verify your city and state");
		lists.add(list);
		return lists.iterator();
	}
	
	@Test(dataProvider = "lists")
	public void create_AutoQuoteTest_AutoData(List<String>list) {
		AutoData autoData = new AutoData(list.get(0), list.get(1), list.get(2), list.get(3));
		landingPage.validateLandingPageTitle(autoData.getLandingPageTitle());
		landingPage.clickStartNewQuoteBtn();
		getAQuotePage.validateGetAQuotePageTitle(autoData.getGetAQtPageTitle());
		getAQuotePage.insertZipCodeField(autoData.getZipCode());
		getAQuotePage.clickCarLobBtn();
		getAQuotePage.clickLetsGoBtn();
		addressPage.verifyAddressPageTitle(autoData.getAddressPageTitle());
	}
	
	@DataProvider(name = "list")
	public Iterator<Object[]> getList(){
		List<Object[]> list = new ArrayList<>();
		Object[] set1 = new Object[4];
		set1[0] = ("Insurance designed with you in mind");
		set1[1] = ("Get a Quote");
		set1[2] = ("54114");
		set1[3] = ("Verify your city and state");
		list.add(set1);
		
		Object[] set2 = new Object[4];
		set2[0] = ("Insurance designed with you in mind");
		set2[1] = ("Get a Quote");
		set2[2] = ("54115");
		set2[3] = ("Verify your city and state");
		list.add(set2);
		
		return list.iterator();
	}
	
	@Test(dataProvider = "list")
	public void create_AutoQuoteTest_AutoData_List(String expectedTitle, String getAQtTitle, String zipCode, String addressTitle) {
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
