package amfam.tdd.practice;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import org.testng.annotations.Test;
import amfam.tdd.utils.AutoData;

public class UnitTests {

	@Test(enabled = false)
	public void unitTestAutoDataNull() {
		AutoData data = new AutoData("name", "man", "can", null);
		System.out.println(data.getZipCode());
	}
	
	@Test(enabled = false)
	public void unitTestAutoDataZeroLenght() {
		AutoData data = new AutoData("name", "man", "can", "");
		System.out.println(data.getZipCode());
	}
	
	@Test(enabled = false)
	public void system_getPropertyTest() {
		System.out.println(System.getProperty("java.home"));
	}
	
	@Test(enabled = false)
	public void folderOps() {
		File folder = new File("screenShot");
		System.out.println(folder.getAbsolutePath());
		System.out.println(folder.mkdirs());
	}
	
	@Test(enabled = false)
	public void timeUnitTest() {
		Date date = new Date();
		System.out.println(date);
		Instant time = Instant.now();
		System.out.println(time);
		
		System.out.println(LocalDateTime.now().plusYears(1).plusMonths(1));
		
		System.out.println("Test1_"+time+".png");
		SimpleDateFormat date_format = new SimpleDateFormat("MM:dd:YYYY_HH:mm:ss");
		System.out.println(date_format.format(date));
	}
	
	@Test
	public void stringPolling() {
		//StringBuilder stringBuilder = new StringBuilder("abc");
		
		//String aString = "abc";
		String bString = new String("abc");
		String cString = bString.intern();
		System.out.println(cString);
		
		//System.out.println(aString.hashCode());
		System.out.println(bString.hashCode());
		System.out.println(cString.hashCode());
		//System.out.println(aString == bString);
		//System.out.println(aString == cString);
		System.out.println(bString == cString);
		
	}
}
