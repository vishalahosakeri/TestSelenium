package amazon;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
/*
 * Gives demo on basic amazon services.
 */

public class AmazonServices {

	//.exe file for chrome browser
	public String driverurl = "//Users//sanvijanvi//Desktop//Vishala//selenuim//chromedriver";
	public String baseUrl = "https://www.amazon.com/";
	WebDriver driver;

	/*
	 * Launch the chrome browser and got amazon website.
	 */
	@BeforeTest
	public void launch() {
		System.setProperty("webdriver.chrome.driver", driverurl);
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}

	/*
	 * Click on sigin link
	 */
	@Test (priority = 0)
	public void signInLink() {
		driver.findElement(By.id("nav-link-accountList")).click();
	}

	/*
	 * Login :Send user name and password to the login page and click on submit button
	 */
	@Test (priority = 1)
	public void login() {
		try {
			System.out.println("login");
			String userName = "seleniumLearnVsh@gmail.com";
			String passWord = "sanu1$janu";

			driver.findElement(By.id("ap_email")).sendKeys(userName);
			driver.findElement(By.id("continue")).click();
			driver.findElement(By.id("ap_password")).sendKeys(passWord);
			driver.findElement(By.id("signInSubmit")).submit();
			driver.findElement(By.id("continue")).submit();// 419779
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/*
	 * @Test(priority = 2) public void optCheck() { driver.findElement(By.
	 * cssSelector("input.a-input-text a-span12 cvf-widget-input cvf-widget-input-code"
	 * )). sendKeys("169617");//a-button-input
	 * driver.findElement(By.className("input.a-button-input")).submit();
	 * 
	 * }
	 */
   /*
    * This method click on top most right menu to display category.
    * Clicks on books & audio link
    * Clicks on childen's book
    * 
    * 
    */
	@Test(priority = 2)
	public void clickMenu() {
		
		try {
			driver.findElement(By.id("nav-hamburger-menu")).click();
			driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[10]/li[4]/a")).getText();
			System.out.println(driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[10]/li[4]/a")).getText());
			driver.findElement(By.xpath("//*[@id='hmenu-content']/ul[34]/li[13]/a")).click();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[10]/li[4]/a")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * This method does the follow:
	 * Click on age 2 link
     * click on 1st book and add it to cart
	 */
	@Test(priority = 3)
	public void selectAge() {
		try {
			driver.findElement(By.cssSelector("#a-page div.left_nav.browseBox ul li a")).click();
			driver.findElement(By.cssSelector(".acswidget-carousel .acs-product-block__product-image a")).click();
			driver.findElement(By.id("add-to-cart-button")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/*
	 * This method takes screenshot of the page and saves it it local drive.
	 */
	@Test(priority = 4)
	public void takeScreenshot() {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File scrSht = screen.getScreenshotAs(OutputType.FILE);
		File destFile = new File("//Users//sanvijanvi//Desktop//amz_sct.png");
		try {
			FileUtils.copyFile(scrSht,destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	  @AfterTest 
	  public void quit() {
		  driver.quit(); }
	 
}
