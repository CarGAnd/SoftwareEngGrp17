package cuke.acceptance_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import business_logic.Absence;
import business_logic.Activity;
import business_logic.Admin;
import business_logic.Employee;
import business_logic.Management;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/*
 * @author Andreas Handberg
 */

public class ManageProjectEmployeeSteps {
	
	ErrorHandler errorHandler;
	Admin testAdmin;
	Management management;
	
	public ManageProjectEmployeeSteps(ErrorHandler errorHandler, Management management) {
		this.errorHandler = errorHandler;
		this.management = management;
	}
	
	@Given("^the employee with the ID \"([^\"]*)\" is not busy$")
	public void theEmployeeWithTheIDIsNotBusy(String arg1) throws Exception {
	    assertFalse(((Employee) management.getUserByID(arg1)).isBusy());
	}
	
	@Given("^the employee is not absent during the period of the activity$")
	public void theEmployeeIsNotAbsentDuringThePeriodOfTheActivity() throws Exception {
	    assertTrue(errorHandler.testEmployee.getUserCalendar().isUserAvailable(new Date(), errorHandler.testActivity.getEndDate()));
	}
	
	@Given("^the employee is assigned to the activity$")
	public void theEmployeeIsAssignedToTheActivity() throws Exception {
		errorHandler.testActivity.addEmployeeToActivity(errorHandler.testEmployee);
	    assertTrue(errorHandler.testActivity.getListOfEmployees().contains(errorHandler.testEmployee));
	    assertTrue(errorHandler.testEmployee.getMemberOfActivities().contains(errorHandler.testActivity));
	}
	
	@Given("^the employee is busy$")
	public void theEmployeeIsBusy() throws Exception {
	    while(!errorHandler.testEmployee.isBusy()) {
	    	errorHandler.testEmployee.addActivityToEmployee(new Activity());
	    }
	    assertTrue(errorHandler.testEmployee.isBusy());
	}
	
	@Then("^the employee is not added to the activity$")
	public void theEmployeeIsNotAssignedToTheActivity() throws Exception {
		assertFalse(errorHandler.testActivity.getListOfEmployees().contains(errorHandler.testEmployee));
	    assertFalse(errorHandler.testEmployee.getMemberOfActivities().contains(errorHandler.testActivity));
	}
	
	@When("^the user adds the employee to the activity$")
	public void theUserAddsTheEmployeeToTheActivity() throws Exception {
		try {
			errorHandler.testActivity.addEmployeeToActivity(errorHandler.testEmployee);
		}
		catch(Exception e) {
			errorHandler.errorMessage = e.getMessage();
		}
	}
	
	@Given("^the employee is currently absent$")
	public void theEmployeeIsCurrentlyAbsent() throws Exception {
		Date endDate = new Date();
		endDate.setTime(System.currentTimeMillis() + 1000 * 24 * 60 * 60); // adds a day in milliseconds
	    errorHandler.testEmployee.getUserCalendar().addAbsence(new Absence(new Date(),endDate));
	    assertTrue(errorHandler.testEmployee.getUserCalendar().isAbsent(new Date()));
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
