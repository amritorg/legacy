package webinar.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contain WebElement locator used in the tests and helper methods of
 * this package. It suppose to contain webelement which are transversal such as
 * common webinar toolbar
 * 
 * @author amrit kumar
 */

public class CommonPageMap {

	public CommonPageMap(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
	}

	// WebElement locator which will get initialized by PageFactory

	// Login Form on login page
	@FindBy(css = "form[id='credentials']")
	public static WebElement loginForm;

	// Username text field inside login form

	@FindBy(css = "input[id='emailAddress']")
	public static WebElement userName;

	// Password text field inside login form

	@FindBy(css = "input[id='password']")
	public static WebElement password;

	// Submit button inside login form
	@FindBy(css = "input[id='submit']")
	public static WebElement loginSubmit;

	// Getting location of header used to display common toolbar

	@FindBy(css = "div[class='header']")
	public static WebElement welcomeheader;

	// ----------------------------------------------------

	// CSS selector constants. We need CSS selector sometime as required by
	// WebDriver api

}
