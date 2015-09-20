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

	// Start Time input field
	@FindBy(css = "input[id='webinarTimesForm.dateTimes_0.startTime']")
	public static WebElement startTime;

	// Start Time AM/PM field
	@FindBy(css = "a[id='webinarTimesForm_dateTimes_0_startAmPm_trig']")
	public static WebElement startTimeAmPmTrig;

	// Start Time PM selection
	@FindBy(css = "#webinarTimesForm_dateTimes_0_startAmPm__menu > ul > li:nth-child(2)")
	public static WebElement startTimePM;

	// Start Time AM selection
	@FindBy(css = "#webinarTimesForm_dateTimes_0_startAmPm__menu > ul > li:nth-child(1)")
	public static WebElement startTimeAM;

	// End Time input field
	@FindBy(css = "input[id='webinarTimesForm.dateTimes_0.endTime']")
	public static WebElement endTime;

	// End Time AM/PM field
	@FindBy(css = "a[id='webinarTimesForm_dateTimes_0_endAmPm_trig']")
	public static WebElement endTimeAmPmTrig;

	// End Time PM selection
	@FindBy(css = "#webinarTimesForm_dateTimes_0_endAmPm__menu > ul > li:nth-child(2)")
	public static WebElement endTimePM;

	// End Time AM selection
	@FindBy(css = "#webinarTimesForm_dateTimes_0_endAmPm__menu > ul > li:nth-child(1)")
	public static WebElement endTimeAM;

	// Newly created webinar dateTime field
	@FindBy(css = "div[id='dateTime']")
	public static WebElement newWebinarCreatedDateTime;


	// ----------------------------------------------------

	// CSS selector constants. We need CSS selector sometime as required by
	// WebDriver api
}
