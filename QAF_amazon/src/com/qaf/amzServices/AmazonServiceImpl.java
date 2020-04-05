package com.qaf.amzServices;

import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;

import static com.qmetry.qaf.automation.step.CommonStep.click;

import com.qaf.locators.AmazonLocatorsImpl;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.util.FileUtil;
/*Implements amazon services 
 * 
 */

public class AmazonServiceImpl implements AmazonServices{
	
	AmazonLocatorsImpl amzLoc = new AmazonLocatorsImpl();

	@Override
	public void login() {
		String userName = "seleniumLearnVsh@gmail.com";
		String passWord = "sanu1$janu";

		sendKeys(userName, "userName.input");
		click("login.continue.click");
		sendKeys(passWord, "password.input");
		click("sigInsubmit.search");
		
	}

	@Override
	public void selectCategory(QAFExtendedWebDriver driver) {
		amzLoc.getMenuClick().click();
		amzLoc.getSelectCategory().click();
		amzLoc.getSelectSubCat().click();
	}
	
	@Override
	public void selectAge(QAFExtendedWebDriver driver) {
		amzLoc.getSelectAge().click();
		amzLoc.getSelectBook().click();
		amzLoc.getAddToCart().click();
		String scrShot = driver.getScreenshotAs(OutputType.BASE64);
		try {
			FileUtil.saveImageFile(scrShot, "amz_screen_shot", "//Users//sanvijanvi//Desktop//");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void findSignIn() {	
		amzLoc.getSignUpLink().click();
	}

}
