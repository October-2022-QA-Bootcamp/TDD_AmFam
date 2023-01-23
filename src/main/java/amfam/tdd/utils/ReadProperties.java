package amfam.tdd.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

	Properties properties;
	
	public ReadProperties() {
		loadProperties();
	}
	
	private void loadProperties() {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("environment.properties");
		properties = new Properties();
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getProperty(String key) {
		if(key != null) {
			return properties.getProperty(key);
		}else {
			return null;
		}	
	}
	
	public long getNumProperty(String key) {
		String value = getProperty(key);
		if(value != null) {
			String refinedValue = value.trim().replaceAll("[^0-9]", "");
			return Long.parseLong(refinedValue);
		}else {
			return 0;
		}	
	}
	
//	public static void main(String[] args) {
//		ReadProperties readProperties = new ReadProperties();
//		String urlString = readProperties.getProperty("bowser");
//		System.out.println(urlString);
//		String urlString2 = readProperties.getProperty(null);
//		System.out.println(urlString2);
//		String urlString3 = readProperties.getProperty("abc");
//		System.out.println(urlString3);
//		
//		long wait = readProperties.getNumProperty("pageloadTime");
//		System.out.println(wait);
//	}
}
