/**
 * 
 */
package com.test.ios;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
/**
 * @author sanvijanvi
 *
 */
public class BaseIOS {
	
	 IOSDriver<IOSElement> driver;
	 DesiredCapabilities capabilities = new DesiredCapabilities();
	 
	 
	 @BeforeMethod
	 public void setCaoabilities() {
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.4");
	 }
	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	 @Test(priority = 1)
	public  void testIos() throws MalformedURLException {
		 capabilities.setCapability(MobileCapabilityType.APP, "//Users/sanvijanvi//Library//Developer//Xcode//DerivedData//"
				+ "UIKitCatalog-hglxteahukizblajeazwpywlbdjh"
				+ "//Build//Products//Debug-iphonesimulator//UIKitCatalog.app");
	
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
	    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
	    capabilities.setCapability("useNewWDA", false);
		
		driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		driver.findElementByAccessibilityId("Alert Views").click();
		driver.findElementByAccessibilityId("Text Entry").click();
		driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("hello");	
		driver.findElementByAccessibilityId("OK").click();
		driver.navigate().back();
		
		Dimension size = driver.manage().window().getSize();
		int x= size.getWidth()/2;
		int starty = (int) (size.getHeight()*0.60);
		int endy = (int) (size.getHeight()*0.10);
		
		TouchAction tc = new TouchAction(driver);
		tc.press(point(x,starty)).moveTo(point(x,endy)).release().perform();
		
		driver.findElementByAccessibilityId("Steppers").click();
		IOSElement elem= driver.findElementByXPath("(//XCUIElementTypeButton[@name=\"Increment\"])[1]");
		tc.tap(tapOptions().withTapsCount(2).withElement(element(elem))).perform();
		String count = driver.findElementsByClassName("XCUIElementTypeStaticText").get(1).getText();
		System.out.println(count);
		driver.navigate().back();
		
		driver.findElementByAccessibilityId("Picker View").click();
		driver.findElementByName("Green color component value").sendKeys("100");;
		driver.findElementByAccessibilityId("Red color component value").sendKeys("100");
		driver.findElementsByClassName("XCUIElementTypePickerWheel").get(2).sendKeys("100");
		driver.navigate().back();
	
	}
	 
	 @Test(priority = 2)
	 public void testBrowser() throws MalformedURLException {
		 capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
		 driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		 driver.get("https://gmail.com");
		 //driver.findElementByLinkText("Sign in").click();
		 driver.findElementById("identifierId").sendKeys("vhosakeri@gmail.com");
		 driver.findElementById("identifierNext").click();
		 
		 
	 }

}
