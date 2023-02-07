package amfam.tdd.practice;

import org.testng.annotations.Test;

import amfam.tdd.utils.AutoData;

public class UnitTests {

	@Test
	public void unitTestAutoDataNull() {
		AutoData data = new AutoData("name", "man", "can", null);
		System.out.println(data.getZipCode());
	}
	
	@Test
	public void unitTestAutoDataZeroLenght() {
		AutoData data = new AutoData("name", "man", "can", "");
		System.out.println(data.getZipCode());
	}
}
