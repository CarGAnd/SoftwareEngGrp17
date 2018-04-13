package acceptance_tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import time_management.app.TimeManagementApp;

public class CreateProjectSteps {
	private TimeManagementApp timeManagementApp;

	public CreateProjectSteps(TimeManagementApp timeManagementApp) {
		this.timeManagementApp = timeManagementApp;
	}
}