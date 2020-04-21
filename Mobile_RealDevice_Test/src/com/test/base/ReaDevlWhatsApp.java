/**
 * 
 */
package com.test.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

/**
 * @author sanvijanvi
 *tg
 */
public class ReaDevlWhatsApp {

	AndroidDriver<AndroidElement> driver;
	
	@BeforeMethod
	public  void Capabilities() throws MalformedURLException {
		
		DesiredCapabilities capability = new DesiredCapabilities();

		capability.setCapability("deviceId", "192.168.86.136:5555");
		capability.setCapability("platformName", "Android");
		
		/* Open chrome:
		capability.setCapability("appPackage", "com.android.chrome");
		capability.setCapability("appActivity", "com.google.android.apps.chrome.Main");*/
		/*Open play store:
		capability.setCapability("appPackage", "com.android.vending");
		capability.setCapability("appActivity", "com.google.android.finsky.activities.MainActivity");*/
		
		capability.setCapability("appPackage", "com.whatsapp");
		capability.setCapability("appActivity", "com.whatsapp.HomeActivity");
		capability.setCapability(MobileCapabilityType.NO_RESET, true);
		
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capability);
		

		//tc.tap(tapOptions().withElement(element(chat))).perform();
		
		
		
	}
	
	@Test
	public void whatsAppTest() {
		/*
		 * Sets wallpaper for whatsapp page.
		 */
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//*[@content-desc='More options']").click();
		driver.findElementsById("com.whatsapp:id/content").get(4).click();
		driver.findElementById("com.whatsapp:id/settings_chat").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.whatsapp:id/wallpaper_preference").click();
		driver.findElementsByClassName("android.widget.LinearLayout").get(2).click();
		driver.findElementByXPath("//android.widget.ImageView[@content-desc='Pelorus Blue']").click();
		//driver.findElementByXPath("//android.widget.TextView[@text='Camera photos']").click();
		//driver.findElementByClassName("android.widget.ImageView").click();
		driver.findElementById("com.whatsapp:id/set_wallpaper_button").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Navigate up']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Navigate up']").click();
		
		/*
		 * Click on status tab
		 */
		driver.findElementByAndroidUIAutomator("text(\"STATUS\")").click();
		driver.navigate().back();

		/*
		 * Main Page:Searches for text entered in search box 
		*/
		driver.findElementById("com.whatsapp:id/menuitem_search").click();
		driver.findElementById("com.whatsapp:id/search_src_text").sendKeys("hubby");
		//driver.findElementByXPath("//*[@content-desc='Apt Preeti Santosh']").click();
		driver.findElementsById("com.whatsapp:id/contact_row_container").get(0).click();
		driver.findElementById("com.whatsapp:id/entry").sendKeys("Automation Testing");
		driver.findElementById("com.whatsapp:id/send").click();
		driver.findElementByClassName("android.widget.ImageView").click();
		
		/*
		 * Scroll to see the last row of chat
		 */
		driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Namma Family\"))");
		
		
	}
	
	@AfterMethod
	public void quitDriver() {
		driver.quit();
	}
}
