package webinar.common;

import org.openqa.selenium.WebElement;

import toolkit.MasterHelper;

/**
 * @description If the code of tests is reusable then it should probably become
 *              a helper. This class contain helper for common functionality in
 *              Go to Webinar application.
 * @author amrit kumar
 */

public abstract class CommonHelper extends MasterHelper {

	/**
	 * This method is to logon to Webinar application. Parameter input need to
	 * be provided from global.properties file
	 * 
	 * @param userName
	 *            Name of user to login
	 * @param password
	 *            Password of the user to login
	 */

	public void logon(String userName, String password) {

		this.waitAndClick(CommonPageMap.userName);
		this.setText(CommonPageMap.userName, userName);
		this.waitAndClick(CommonPageMap.password);
		this.setText(CommonPageMap.password, password);
		this.waitAndClick(CommonPageMap.loginSubmit);

	}
}
