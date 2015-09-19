package webinar.scheduler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webinar.common.CommonPageMap;

/**
 * This class contain WebElement locator used in the tests and helper methods of
 * this package. It suppose to contain webelement which are specific to
 * "Schedule to Webinar" area
 * 
 * @author amrit kumar
 */

public class SchedulerPageMap extends CommonPageMap {

	public SchedulerPageMap(WebDriver webDriver) {
		super(webDriver);
	}

	// WebElement locator which will get initialized by PageFactory

	// Schedule a webinar Tab in left side panel
	private static final String WebinarLink = "/schedule.tmpl";
	@FindBy(css = "[href='" + WebinarLink + "']")
	public static WebElement ScheduleWebinarTab;

	// New webinar Title text field
	@FindBy(css = "input[id='name']")
	public static WebElement newWebinarTitle;

	// Start Date input field
	@FindBy(css = "input[id='webinarTimesForm.dateTimes_0.baseDate']")
	public static WebElement startDate;

	// Active date on start date calendar
	@FindBy(css = "#ui-datepicker-div > table > tbody td.ui-datepicker-today > a")
	public static WebElement activeDate;

	// Parent div containing the date calander
	@FindBy(css = "#ui-datepicker-div")
	public static WebElement baseDateTable;

	// Schedule Submit button
	@FindBy(css = "input[name='schedule.submit.button']")
	public static WebElement scheduleSubmit;

	// Title of newly created webinar
	@FindBy(css = "p[id='trainingName']")
	public static WebElement newWebinarCreatedTitle;

	// ----------------------------------------------------

	// CSS selector constants. We need CSS selector sometime as required by
	// WebDriver api
}
