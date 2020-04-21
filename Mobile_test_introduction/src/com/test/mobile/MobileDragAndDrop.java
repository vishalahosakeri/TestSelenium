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

/**
 * @author sanvijanvi
 *
 */
public class MobileDragAndDrop extends Base {

	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = Capabilities();

		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
		
		TouchAction tc = new TouchAction(driver);
		WebElement elem1 = driver.findElementById("io.appium.android.apis:id/drag_dot_1");
		WebElement elem2 = driver.findElementById("io.appium.android.apis:id/drag_dot_2");
		//tc.longPress(longPressOptions().withElement(element(elem1)).withDuration(ofSeconds(2))).moveTo(element(elem2)).release().perform();
		tc.longPress(element(elem1)).moveTo(element(elem2)).release().perform();
	}

}
