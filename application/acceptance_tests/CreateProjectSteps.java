package acceptance_tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import business_logic.Management;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;

public class CreateProjectSteps {
	private Management managementApp;

	public <managementApp> CreateProjectSteps(managementApp timeManagementApp) {
		this.managementApp = managementApp;
	}
}