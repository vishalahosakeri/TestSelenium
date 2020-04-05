package com.qaf.amz;

import org.testng.annotations.Test;
import static com.qmetry.qaf.automation.step.CommonStep.get;
import com.qaf.amzServices.AmazonServiceImpl;
import com.qaf.amzServices.AmazonServices;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

/*
 * Calling amazon services
 */

public class AmazonQAF extends WebDriverTestCase{
	
	@Test
	public void amazonServices() {
		get("/");
		AmazonServices service = new AmazonServiceImpl();
		
		//loginLink
		service.findSignIn();
		
		//login process
		service.login();
		
		//select the product category
		service.selectCategory(getDriver());
		service.selectAge(getDriver());
		
	}

	

	
}
