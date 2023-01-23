package amfam.tdd.practice;

import org.testng.annotations.Test;

public class DefaultValue {

	String string;
	int a;
	char c;
	boolean b;
	
	@Test(enabled = false)
	public void defaultValueTesting() {
		System.out.println(string);
		System.out.println(a);
		System.out.println((int)c);
		System.out.println(b);
	}
	
	@Test
	public void parseLongValidation() {
		String aString = " 123*kskfnk12fakjfvna;kjn ";
		String bString = aString.trim().replaceAll("[^0-9]", "");
		System.out.println(Long.parseLong(bString));
	}
}
