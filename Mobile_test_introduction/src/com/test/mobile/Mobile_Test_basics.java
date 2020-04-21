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
public class Mobile_Test_basics extends Base {

	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = Capabilities();
		 
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		driver.findElementByXPath("//android.widget.TextView[@index='2']").click();
		driver.findElementById("android:id/checkbox").click();
		//XPATH : driver.findElementByXPath("//android.widget.CheckBox[@index='0']").click();
		driver.findElementByXPath("//android.widget.LinearLayout[2]").click();//android:id/title
		//driver.findElementById("android:id/title").click();
		driver.findElementByXPath("//android.widget.EditText[@index='0']").sendKeys("Onhubjet");
		//driver.findElementByXPath("//android.widget.Button[@index='1']").click();
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		
	}

}
