/**
 * 
 */
package qaf.example.locators;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

/**
 * @author sanvijanvi
 *
 */
public class GoogleLoc extends WebDriverBaseTestPage<WebDriverTestPage> implements Loators.GoogleLoators{

	@FindBy(locator = ABOUT_LINK_GOOGLE)
	private QAFWebElement clikLink;
	
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		driver.get("/");
	}

	public QAFWebElement getClikLink() {
		return clikLink;
	}

	@QAFTestStep(description = "Navigate to google Page")
	public void launchPage() {
		System.out.println("QAF");
		super.launchPage(null);
	}
}
