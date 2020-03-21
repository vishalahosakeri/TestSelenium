package links;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PrintAllLinksInfo {
	
	public String driverurl = "//Users//sanvijanvi//Desktop//Vishala//selenuim//chromedriver";
	public String baseUrl = "https://www.infostretch.com/" ;
	WebDriver driver;
 
  @BeforeTest
  public void launch() {
	  System.setProperty("webdriver.chrome.driver", driverurl);
	  driver = new ChromeDriver();
	  driver.get(baseUrl);
  }
	
  @Test(priority = 0)
  public void printPagelLinks() {
	   driver.findElements(By.tagName("a")).stream().
	  filter(elem->!(elem.getText().isEmpty() || elem.getText().isBlank())).
	  forEach(elem->System.out.println(elem.getText()));
  } 
  
  /*
   * This method will print all the broken links in infostrech.com.
   * Filter out anchor tags which have href attribute with url in proper format.
   */
  @Test(priority = 1)
  public void printBrokenLinks() {
	  HttpURLConnection httpCon;
	  /*
	   * filter all the anchor tags whose href attribute is empty/broken/third party domain link and are commented.
	   */
	  List<WebElement> anchorElem = driver.findElements(By.tagName("a")).stream().filter(elem->elem.getAttribute("href")!=null || elem.getAttribute("href").startsWith("javaScript:void(0)")).
			  filter(elem-> !elem.getAttribute("href").isBlank() ||
			  !elem.getAttribute("href").isEmpty() ||
			  !elem.getAttribute("href").startsWith(baseUrl)).collect(Collectors.toList());
	  for (WebElement anchor : anchorElem) {
		String url = anchor.getAttribute("href");
		/*Get the http connection. connect to link and get response code
		 * Use HEAD request method. GET can be used. But, we need only response code.
		 * 
		 */
		try {
			System.out.println(url);
			httpCon = (HttpURLConnection) new URL(url).openConnection();
			httpCon.setRequestMethod("HEAD");
			httpCon.connect();
			int respCode = httpCon.getResponseCode();
			if(respCode >= 400) {
				System.out.println(url+" is a broken link.");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}finally {
			
		}
	}
					
			  
	  
  }
  @AfterTest
  public void quit() {
	  driver.quit();
  }
}
