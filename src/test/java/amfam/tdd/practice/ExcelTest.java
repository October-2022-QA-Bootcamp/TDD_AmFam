package amfam.tdd.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import amfam.tdd.utils.ExcelUtils;

public class ExcelTest {

	ExcelUtils utils = new ExcelUtils("src/main/resources/AutoTestData.xlsx", "Sheet1");

	@Test
	public void data2D() {
		int totalRows = utils.sheet.getLastRowNum();
		System.out.println("Total Rows : " + totalRows);
		int totalCols = utils.sheet.getRow(0).getLastCellNum();
		System.out.println("Last cell number or total cols : " + totalCols);

		String[][] data2D = new String[totalRows][totalCols];
		// String [][] data2D = new String [3][4];

		for (int row = 1; row <= 3; row++) {
			for (int cell = 0; cell <= 3; cell++) {
				String value = "";
				try {
					value = utils.sheet.getRow(row).getCell(cell).getStringCellValue();
				} catch (NullPointerException e) {

				}
				data2D[row - 1][cell] = value;
			}
		}

		System.out.println(data2D[1][4]);
	}

	public void hardCodedMap() {
		List<Map<String, String>> listOfMaps = new ArrayList<>();

		Map<String, String> map1 = new HashMap<>();
		Map<String, String> map2 = new HashMap<>();
		Map<String, String> map3 = new HashMap<>();

		map1.put("Expected Title", "Insurance designed with you in mind");

		listOfMaps.add(map1);
		listOfMaps.add(map2);
		listOfMaps.add(map3);
	}

	@Test
	public void getMapList() {
		List<Map<String, String>> listOfMaps = new ArrayList<>();

		int totalRows = utils.sheet.getLastRowNum();
		System.out.println("Total Rows : " + totalRows);
		int totalCols = utils.sheet.getRow(0).getLastCellNum();
		System.out.println("Last cell number or total cols : " + totalCols);

		for (int row = 1; row <= totalRows; row++) {
			Map<String, String> map = new HashMap<>();
			for (int cell = 0; cell <= totalCols; cell++) {
				String key = "";
				String value = "";
				try {
					key = utils.sheet.getRow(0).getCell(cell).getStringCellValue();
					value = utils.sheet.getRow(row).getCell(cell).getStringCellValue();
				} catch (NullPointerException e) {

				}
				map.put(key, value);
			}
			listOfMaps.add(map);
		}
		
		System.out.println(listOfMaps.get(1).get("Zip Code"));
		System.out.println(listOfMaps.get(1).get("Get A Quote Title"));
	}
	
	@Test
	public void getSheet2Data() {
		ExcelUtils utils2 = new ExcelUtils("src/main/resources/AutoTestData.xlsx", "Sheet2");
		List<Map<String, String>> data = utils2.getMapDataList();
		System.out.println(data.get(0).get("pass"));
	}
}
