package amfam.tdd.utils;

public class AutoData {

	private String zipCode;
	private String addressPageTitle;
	private String landingPageTitle;
	private String getAQtPageTitle;

	public AutoData(String landingPageTitle, String getAQtPageTitle, String zipCode, String addressPageTitle1) {
		if(zipCode == null || addressPageTitle1 == null || landingPageTitle == null || getAQtPageTitle == null ||
				zipCode.length() == 0 || addressPageTitle1.length() == 0 || landingPageTitle.length() == 0
				|| getAQtPageTitle.length() == 0) {
			throw new NullPointerException();
		}else {
			this.zipCode = zipCode;
			addressPageTitle = addressPageTitle1;
			this.landingPageTitle = landingPageTitle;
			this.getAQtPageTitle = getAQtPageTitle;
		}
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getAddressPageTitle() {
		return addressPageTitle;
	}

	public String getLandingPageTitle() {
		return landingPageTitle;
	}

	public String getGetAQtPageTitle() {
		return getAQtPageTitle;
	}
}
