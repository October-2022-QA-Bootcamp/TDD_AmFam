package amfam.tdd.practice;

import org.testng.annotations.Test;

public class DefaultValue {

	String string;
	int a;
	char c;
	boolean b;
	
	@Test(enabled = true)
	public void defaultValueTesting() {
		System.out.println(string);
		System.out.println(a);
		System.out.println((int)c);
		System.out.println(b);
		System.out.printf("%s Name is : %s Ibne Hussain /n", 2, "Nasir");
	}
	
	@Test(enabled = false)
	public void parseLongValidation() {
		String aString = " 123*kskfnk12fakjfvna;kjn ";
		String bString = aString.trim().replaceAll("[^0-9]", "");
		System.out.println(Long.parseLong(bString));
	}
}
