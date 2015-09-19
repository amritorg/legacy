package webinar.scheduler;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import webinar.common.CommonHelper;

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
	 */

	public void createNewWebinar(String webinarTitle, String frequency,
			String xDays) {

		this.setText(SchedulerPageMap.newWebinarTitle, webinarTitle);
		// TODO select frequency , for now assume the default which is once
		this.waitAndClick(SchedulerPageMap.startDate);
		System.out.println(SchedulerPageMap.activeDate.getText());
		String activeDate = SchedulerPageMap.activeDate.getText();
		int todayDate = Integer.parseInt(activeDate);
		int targetDate = todayDate + Integer.parseInt(xDays);
		clickDateOnCalendar(String.valueOf(targetDate));

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
