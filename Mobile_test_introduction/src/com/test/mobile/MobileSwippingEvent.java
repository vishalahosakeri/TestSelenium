/**
 * 
 */
package com.test.mobile;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.offset.PointOption.point;

/**
 * @author sanvijanvi
 *
 */
public class MobileSwippingEvent extends Base {

	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = Capabilities();
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
		driver.findElementByXPath("//*[@content-desc='9']").click();
		//driver.findElementByXPath("//*[@content-desc='45']").click();
		TouchAction touchAction = new TouchAction(driver);
		WebElement element = driver.findElementByXPath("//*[@content-desc='15']");//moveTo(point(340, 1230)).release().perform();
		WebElement element1 = driver.findElementByXPath("//*[@content-desc='45']");
		touchAction.longPress(longPressOptions().withElement(element(element)).withDuration(ofSeconds(2))).
		moveTo(element(element1)).release().perform();
		
		
		
	}

}
