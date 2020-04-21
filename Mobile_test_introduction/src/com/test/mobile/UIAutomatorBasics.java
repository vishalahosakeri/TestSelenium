/**
 * 
 */
package com.test.mobile;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author sanvijanvi
 *
 */
public class UIAutomatorBasics extends Base {

	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = Capabilities();
		//driver.findElementByAndroidUIAutomator("attribute("value")");
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		//driver.findElementByAndroidUIAutomator("text(\"Animation\")").click();
		//driver.findElementByXPath("//android.widget.TextView[@text='Animation']").click();
		//driver.findElementByAndroidUIAutomator("new UISelector().property(value)")
		//driver.findElementsByAndroidUIAutomator("new UISelector().clickable(true)").size();
		System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().checkable(true)").size());
	}

}
