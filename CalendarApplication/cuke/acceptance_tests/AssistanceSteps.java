package cuke.acceptance_tests;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import business_logic.Activity;
import business_logic.Admin;
import business_logic.Employee;
import business_logic.Management;
import business_logic.Project;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;

public class AssistanceSteps {

	ErrorHandler errorHandler;
	Employee testEmployee;
	Employee testHelper;
	Admin testAdmin;
	Management management;
	Activity testActivity;
	Project testProject;
	
	public AssistanceSteps(ErrorHandler errorHandler, Management management) {
		this.errorHandler = errorHandler;
		this.management = management;
	}
	@Given("^the user with ID \"([^\"]*)\" is working on an activity with ID \"([^\"]*)\"$")
	public void theUserWithIDIsWorkingOnAnActivityWithID(String userID, String activityID) throws Exception {
		SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		Date endDate = DateFormatter.parse("01/01/01");
		errorHandler.testActivity = new Activity(activityID, endDate, 8, "blabla");
		testEmployee.addActivityToEmployee(errorHandler.testActivity);
		assertTrue(testEmployee.getMemberOfActivities().contains(errorHandler.testActivity));
		
	}

	@Given("^there is an available employee$")
	public void thereIsAnAvailableEmployee() throws Exception {
	    testHelper = new Employee("ID","pass");
	    management.addUser(testHelper);
	    assertTrue(!testHelper.checkAbsent() && !testHelper.isBusy());
	}

	@When("^the user with ID \"([^\"]*)\" requests assistance$")
	public void theUserWithIDRequestsAssistance(String arg1) throws Exception {
	    management.requestAssistanceByID(arg1,testActivity);
	}

	@Then("^the available employee is assigned to the activity$")
	public void theAvailableEmployeeIsAssignedToTheActivity() throws Exception {
	    assertTrue(testHelper.getMemberOfActivities().contains(testActivity));
	}

	@Given("^there is no available employees$")
	public void thereIsNoAvailableEmployees() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the user recieves the error message \"([^\"]*)\"$")
	public void theUserRecievesTheErrorMessage(String arg1) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}

