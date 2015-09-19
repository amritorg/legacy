package webinar.scheduler;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import toolkit.MasterHelper;
import webinar.common.CommonPageMap;

/**
 * @author amrit kumar
 */

public class TestScheduleWebinar extends SchedulerHelper {

	private String userName;
	private String password;
	private String webinarTitle;
	private String frequency;
	private String xDays;
	private String startTime;
	private String endTime;
	private String startAmPm;
	private String endAmPm;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		MasterHelper.init();
		new SchedulerPageMap(MasterHelper.getWebdriver());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		Properties prop = MasterHelper.loadProperties(this.m_dataFolder
				+ "DataTestScheduleWebinar.properties");
		userName = prop.getProperty("username").trim();
		password = prop.getProperty("password").trim();
		webinarTitle = prop.getProperty("webinar_title").trim();
		frequency = prop.getProperty("frequency").trim();
		xDays = prop.getProperty("x_days_from_now").trim();
		startTime = prop.getProperty("start_time").trim();
		endTime = prop.getProperty("end_time").trim();
		startAmPm = prop.getProperty("start_ampm").trim();
		endAmPm = prop.getProperty("end_ampm").trim();
	}

	@After
	public void tearDown() throws Exception {
	}

	// Test to make sure a new webinar could be scheduled x days from now which
	// occurs only once
	@Test
	public void schedule_webinar_xdays_fromnow() throws Exception {

		// open go to webinar application
		this.openBrowser(MasterHelper.m_appUrl);

		// validation
		assertTrue(this.waitAndCheckDisplay(CommonPageMap.loginForm));
		// logon
		this.logon(userName, password);
		// little extra wait cushion however this shouldn't be necessary
		Thread.sleep(2000);
		// validation
		assertTrue(this.waitAndCheckDisplay(CommonPageMap.welcomeheader));
		// navigate to schedule tab
		this.navigateToScedule();
		// create new webinar
		String targetDay = this.createNewWebinar(webinarTitle, frequency,
				xDays, startTime, endTime, startAmPm, endAmPm);
		this.waitAndClick(SchedulerPageMap.scheduleSubmit);
		// validation
		assertTrue(this
				.waitAndCheckDisplay(SchedulerPageMap.newWebinarCreatedTitle));
		assertTrue(SchedulerPageMap.newWebinarCreatedDateTime.getText()
				.contains(targetDay));
		// TODO validate time

	}

}
