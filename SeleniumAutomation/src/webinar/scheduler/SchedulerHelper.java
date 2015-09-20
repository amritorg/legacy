package webinar.scheduler;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import toolkit.TestWebinarException;
import webinar.common.CommonHelper;
import webinar.common.CommonPageMap;

/**
 * @description If the code of tests is reusable then it should probably become
 *              a helper. This class contain helper for "Schedule a webinar"
 *              functionality in webinar application.
 * @author amrit kumar
 */
public abstract class SchedulerHelper extends CommonHelper {

	public void navigateToScedule() {
		this.waitAndClick(SchedulerPageMap.ScheduleWebinarTab);
	}

	/**
	 * This method is to logon to create a new webinar. Data input should be be
	 * provided from respective data properties file.
	 * 
	 * @param webinarTitle
	 *            Name of webinar to be created
	 * @param frequency
	 *            input for the occurence
	 * @param xDays
	 *            Number of days from now to schedule the webinar
	 * @return targetDay Day on which webinar has been scheduled
	 * @throws InterruptedException
	 */

	public String createNewWebinar(String webinarTitle, String frequency,
			String xDays, String startTime, String endTime, String startAmPm,
			String endAmPm) throws InterruptedException {

		this.setText(SchedulerPageMap.newWebinarTitle, webinarTitle);

		// TODO select frequency , for now assume the default which is once

		// Calendar date selection
		this.waitAndClick(SchedulerPageMap.startDate);
		String activeDate = SchedulerPageMap.activeDate.getText();
		int todayDate = Integer.parseInt(activeDate);
		int targetDate = todayDate + Integer.parseInt(xDays);
		clickDateOnCalendar(String.valueOf(targetDate));

		// start time selection
		this.waitAndClick(SchedulerPageMap.startTime);
		SchedulerPageMap.startTime.clear();
		this.setText(SchedulerPageMap.startTime, startTime);
		SchedulerPageMap.startTime.sendKeys(Keys.TAB);
		SchedulerPageMap.startTimeAmPmTrig.click();
		if (startAmPm.equalsIgnoreCase("PM"))
			SchedulerPageMap.startTimePM.click();
		else if (startAmPm.equalsIgnoreCase("AM"))
			SchedulerPageMap.startTimeAM.click();
		else
			throw new TestWebinarException("AM/PM input is invalid");
		// end time selection
		this.waitAndClick(SchedulerPageMap.endTime);
		SchedulerPageMap.endTime.clear();
		this.setText(SchedulerPageMap.endTime, endTime);
		// TODO set endtTime AmPm
		SchedulerPageMap.endTime.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		SchedulerPageMap.endTimeAmPmTrig.click();
		if (endAmPm.equalsIgnoreCase("PM"))
			SchedulerPageMap.endTimePM.click();
		else if (startAmPm.equalsIgnoreCase("AM"))
			SchedulerPageMap.endTimeAM.click();
		else
			throw new TestWebinarException("AM/PM input is invalid");

		return String.valueOf(targetDate);

	}

	/**
	 * Click a target day in the calendar
	 * 
	 * @param targetDate
	 *            Day to be selected on calendar
	 */
	// TODO logic need to be enhanced to click any day in any month
	public void clickDateOnCalendar(String targetDate) {

		List<WebElement> rows = SchedulerPageMap.baseDateTable.findElements(By
				.tagName("tr"));
		List<WebElement> columns = SchedulerPageMap.baseDateTable
				.findElements(By.tagName("td"));

		for (WebElement cell : columns) {
			// Select 13th Date
			if (cell.getText().equals(targetDate)) {
				cell.findElement(By.linkText(targetDate)).click();
				break;
			}
		}
	}

}
