package cuke.acceptance_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import business_logic.Admin;
import business_logic.Management;
import business_logic.OperationNotAllowedException;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;

/*
 * @author Carsten Guldbrand Andersen
 */

public class AssistanceSteps {
	
	ErrorHandler errorHandler;
	Admin testAdmin;
	Management management;
	String tempUser;
	public AssistanceSteps(ErrorHandler errorHandler, Management management) {
		this.errorHandler = errorHandler;
		this.management = management;
	}
	@Given("^the employee with ID \"([^\"]*)\" is working on an activity with ID \"([^\"]*)\"$")
	public void theUserWithIDIsWorkingOnAnActivityWithID(String arg1, String arg2) throws Exception {
		if(!management.getProjectByID("project").getActivityByID(arg2).getListOfEmployees().contains(management.getEmployeeByID(arg1))) {
			management.getProjectByID("project").getActivityByID(arg2).addEmployeeToActivity(management.getEmployeeByID(arg1));;	
		}
		assertTrue(management.getProjectByID("project").getActivityByID(arg2).getListOfEmployees().contains(management.getEmployeeByID(arg1)));
	}

	@Given("^there is an available employee$")
	public void thereIsAnAvailableEmployee() throws Exception {
	    boolean availableEmployee = false;
		for(int i = 0; i < management.getEmployees().size(); i++) {
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
		try{
	    tempUser = management.requestAssistance(management.getProjectByID("project").getActivityByID("test")).getUserID();
		}
		catch(OperationNotAllowedException e) {
			errorHandler.errorMessage = e.getMessage();
		}
	}
	@Then("^the available employee is assigned to the activity$")
	public void theAvailableEmployeeIsAssignedToTheActivity() throws Exception {
	    assertTrue(management.getProjectByID("project").getActivityByID("test").getListOfEmployees().contains(management.getUserByID(tempUser)));
	}


	@Given("^there are no available employees$")
	public void thereIsNoAvailableEmployees() throws Exception {
		management.logUserOut();
		management.userLogin("admin", "adminadmin");
		management.getProjectByID("project").setProjectLeader("Tester");
		management.logUserOut();
		management.userLogin("Tester", "passy");
		for(int i = 0; i < 20; i++) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date dueDate = formatter.parse("1"+i+"/03/2020");
			if(management.getEmployeeByID("SomeID").getMemberOfActivities().size() < 20) {
				management.getProjectByID("project").createActivity("words"+i, "have", dueDate, 40).addEmployeeToActivity(management.getEmployeeByID("SomeID"));
			}
			if(management.getEmployeeByID("Tester").getMemberOfActivities().size() < 20) {
				management.getProjectByID("project").createActivity("words"+2*i, "have", dueDate, 40).addEmployeeToActivity(management.getEmployeeByID("Tester"));
			}
		}
		boolean availableEmployee = false;
		for(int i = 0; i < management.getEmployees().size(); i++) {
	    	if(!management.getEmployees().get(i).checkAbsent()) {
	    		if(!management.getEmployees().get(i).isBusy()) {
	    			availableEmployee = true;
	    		}
	    	}
	    }
		assertFalse(availableEmployee); 
	}
}
