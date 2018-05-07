package cuke.acceptance_tests;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import business_logic.Admin;
import business_logic.Management;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;

public class AssistanceSteps {
	
	ErrorHandler errorHandler;
	Admin testAdmin;
	Management management;
	String tempUser;
	public AssistanceSteps(ErrorHandler errorHandler, Management management) {
		this.errorHandler = errorHandler;
		this.management = management;
	}
	@Given("^the user with ID \"([^\"]*)\" is working on an activity with ID \"([^\"]*)\"$")
	public void theUserWithIDIsWorkingOnAnActivityWithID(String arg1, String arg2) throws Exception {
	    assertTrue(management.getProjectByID("project").getActivityByID(arg2).getListOfEmployees().contains(management.getUserByID(arg1)));
	}

	@Given("^there is an available employee$")
	public void thereIsAnAvailableEmployee() throws Exception {
	    boolean availableEmployee = false;
		for(int i = 0; i < management.getUsers().size(); i++) {
	    	if(!management.getEmployees().get(i).checkAbsent()) {
	    		if(!management.getEmployees().get(i).isBusy()) {
	    			availableEmployee = true;
	    		}
	    	}
	    }
		assertTrue(availableEmployee);
		
	}

	@When("^the user with ID \"([^\"]*)\" requests assistance$")
	public void theUserWithIDRequestsAssistance(String arg1) throws Exception {
	    tempUser = management.requestAssistance(management.getProjectByID("project").getActivityByID("test")).getUserID();
	}

	@Then("^the available employee is assigned to the activity$")
	public void theAvailableEmployeeIsAssignedToTheActivity() throws Exception {
	    assertTrue(management.getProjectByID("project").getActivityByID("test").getListOfEmployees().contains(management.getUserByID(tempUser)));
	    throw new PendingException();
	}
}
