package cuke.acceptance_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import business_logic.Admin;
import business_logic.Employee;
import business_logic.Management;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ManageProjectEmployeeSteps {
	
	ErrorHandler errorHandler;
	Admin testAdmin;
	Management management;
	
	public ManageProjectEmployeeSteps(ErrorHandler errorHandler, Management management) {
		this.errorHandler = errorHandler;
		this.management = management;
	}
	
	@Given("^the employee with the ID \"([^\"]*)\" does not have more than (\\d+) activities$")
	public void theEmployeeWithTheIDDoesNotHaveMoreThanActivities(String arg1, int arg2) throws Exception {
	    assertTrue(((Employee) management.getUserByID(arg1)).getMemberOfActivities().size() < 20);
	}
	
	@Given("^the employee is assigned to the activity$")
	public void theEmployeeIsAssignedToTheActivity() throws Exception {
		errorHandler.testActivity.addEmployeeToActivity(errorHandler.testEmployee);
	    assertTrue(errorHandler.testActivity.getListOfEmployees().contains(errorHandler.testEmployee));
	    assertTrue(errorHandler.testEmployee.getMemberOfActivities().contains(errorHandler.testActivity));
	}
	
	@Given("^the employee is not assigned to the activity$")
	public void theEmployeeIsNotAssignedToTheActivity() throws Exception {
		assertFalse(errorHandler.testActivity.getListOfEmployees().contains(errorHandler.testEmployee));
	    assertFalse(errorHandler.testEmployee.getMemberOfActivities().contains(errorHandler.testActivity));
	}
	
	@When("^the user adds the employee to the activity$")
	public void theUserAddsTheEmployeeToTheActivity() throws Exception {
	    errorHandler.testActivity.addEmployeeToActivity(errorHandler.testEmployee);
	}
	
	@When("^the user removes the employee from the activity$")
	public void theUserRemovesTheEmployeeToTheActivity() throws Exception {
		try {
	    errorHandler.testActivity.removeEmployeeFromActivity(errorHandler.testEmployee);
		}
		catch (Exception e) {
			errorHandler.errorMessage = e.getMessage();
		}
	}
	
	@Then("^the employee is added to the activity$")
	public void theEmployeeIsAddedToTheActivity() throws Exception {
		assertTrue(errorHandler.testActivity.getListOfEmployees().contains(errorHandler.testEmployee));
		assertTrue(errorHandler.testEmployee.getMemberOfActivities().contains(errorHandler.testActivity));
	}
	
	@Then("^the employee is removed from the activity$")
	public void theEmployeeIsRemovedFromTheActivity() throws Exception {
	    assertFalse(errorHandler.testActivity.getListOfEmployees().contains(errorHandler.testEmployee));
	    assertFalse(errorHandler.testEmployee.getMemberOfActivities().contains(errorHandler.testActivity));
	}
}
