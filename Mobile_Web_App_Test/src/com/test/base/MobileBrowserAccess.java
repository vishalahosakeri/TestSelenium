/**
 * 
 */
package com.test.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author sanvijanvi
 *This class gives demo on monile web app testing.
 *Browser : chrome , website : infostretch corporation
 */
public class MobileBrowserAccess {

	AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void Capabilities() throws MalformedURLException {

		DesiredCapabilities capability = new DesiredCapabilities();

		capability.setCapability("deviceId", "192.168.86.136:5555");
		capability.setCapability("platformName", "Android");
		capability.setCapability("appPackage", "com.android.chrome");
		capability.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		capability.setCapability(MobileCapabilityType.NO_RESET, true);
		
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capability);

	}

	@Test
	public void testChromePage() throws MalformedURLException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.MINUTES);
		driver.findElementById("com.android.chrome:id/search_box_text").sendKeys("infostretch corporation");
		driver.findElementsByClassName("android.view.ViewGroup").get(0).click();
		driver.findElementByXPath("//android.view.View[@text='WEBSITE']").click();
	}

	@AfterTest

	public void quitDriver() {
		driver.quit();
	}

}
