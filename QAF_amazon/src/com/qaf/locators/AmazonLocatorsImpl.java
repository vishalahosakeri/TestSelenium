/**
 * 
 */
package com.qaf.locators;

import org.openqa.selenium.WebElement;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;

/**
 * @author sanvijanvi
 *
 */
public class AmazonLocatorsImpl extends WebDriverBaseTestPage<WebDriverTestPage> implements Locators.amazon_locators {
	
	@FindBy(locator = SIGN_UP_LINK)
	private WebElement signUpLink;
	
	@FindBy(locator = Menu_CLICK)
	private WebElement menuClick;
	
	@FindBy(locator = SELECT_CATAGORY)
	private WebElement selectCategory;
	
	@FindBy(locator = SELECT_SUB_CATAGORY)
	private WebElement selectSubCat;
	
	@FindBy(locator = SELECT_AGE_RANGE)
	private WebElement selectAge;
	
	@FindBy(locator = SELECT_BOOK)
	private WebElement selectBook;
	
	@FindBy(locator = ADD_TO_CART)
	private WebElement addToCart;
	
	

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		driver.get("/");	
	}
	
	public WebElement getSignUpLink() {
		return signUpLink;
	}

	public WebElement getMenuClick() {
		return menuClick;
	}

	public WebElement getSelectCategory() {
		return selectCategory;
	}

	public WebElement getSelectSubCat() {
		return selectSubCat;
	}
	
	public WebElement getSelectAge() {
		return selectAge;
	}

	public WebElement getSelectBook() {
		return selectBook;
	}

	
	public WebElement getAddToCart() {
		return addToCart;
	}

	
	
	

}
