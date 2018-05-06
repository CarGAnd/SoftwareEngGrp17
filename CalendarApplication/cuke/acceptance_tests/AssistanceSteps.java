package cuke.acceptance_tests;

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
	Admin testAdmin;
	Management management;
	Activity testActivity;
	Project testProject;
	
	public AssistanceSteps(ErrorHandler errorHandler, Management management) {
		this.errorHandler = errorHandler;
		this.management = management;
	}
	@Given("^the user with ID \"([^\"]*)\" is working on an activity with ID \"([^\"]*)\"$")
	public void theUserWithIDIsWorkingOnAnActivityWithID(String arg1, String arg2) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^there is an available employee$")
	public void thereIsAnAvailableEmployee() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^the user with ID \"([^\"]*)\" requests assistance$")
	public void theUserWithIDRequestsAssistance(String arg1) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the available employee is assigned to the activity$")
	public void theAvailableEmployeeIsAssignedToTheActivity() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^there is no available employees$")
	public void thereIsNoAvailableEmployees() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}


