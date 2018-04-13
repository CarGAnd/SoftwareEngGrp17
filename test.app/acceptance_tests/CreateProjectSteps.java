package acceptance_tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import time_management.app.TimeManagementApp;

public class CreateProjectSteps {
	private TimeManagementApp timeManagementApp;

	public CreateProjectSteps(TimeManagementApp timeManagementApp) {
		this.timeManagementApp = timeManagementApp;
	}
}