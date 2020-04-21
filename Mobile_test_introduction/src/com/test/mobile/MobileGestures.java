/**
 * 
 */
package com.test.mobile;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

/**
 * @author sanvijanvi
 *
 */
public class MobileGestures extends Base {

	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = Capabilities();
		
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		//driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")").click();
		//driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")").click();
		
		//Touch Actions
		TouchAction touchAct = new TouchAction(driver);
		WebElement webElem = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
		//tapOptions.
		touchAct.tap(tapOptions().withElement(element(webElem))).perform();
		driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")").click();
		WebElement peoplelement = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
		touchAct.longPress(longPressOptions().withElement(element(peoplelement)).withDuration(ofSeconds(2))).release().perform();
		System.out.println(driver.findElementById("android:id/title").isDisplayed());
		
	}

}
