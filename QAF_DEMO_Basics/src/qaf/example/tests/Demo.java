package qaf.example.tests;

import static com.qmetry.qaf.automation.step.CommonStep.get;
import org.testng.annotations.Test;
//import static qaf.example.steps.StepsLibrary.searchFor;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

import qaf.example.locators.GoogleLoc;


public class Demo extends WebDriverTestCase{
	@Test
	public void testGoogleSearch() {
		get("/");
		
		GoogleLoc googleLoc = new GoogleLoc();
		
		googleLoc.launchPage();
		googleLoc.getClikLink().click();
		
	}
}
