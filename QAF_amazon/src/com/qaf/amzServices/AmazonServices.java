package com.qaf.amzServices;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;

public interface AmazonServices {
	
	public void findSignIn();
	public void login();
	public void selectCategory(QAFExtendedWebDriver qafExtendedWebDriver);
	public void selectAge(QAFExtendedWebDriver driver);
	

}
