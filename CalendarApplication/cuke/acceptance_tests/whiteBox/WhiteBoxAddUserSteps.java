package cuke.acceptance_tests.whiteBox;

import business_logic.Admin;
import business_logic.Employee;
import business_logic.Management;
import business_logic.OperationNotAllowedException;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import cucumber.api.java.en.*;
import cuke.acceptance_tests.ErrorHandler;


public class WhiteBoxAddUserSteps {
	
	ErrorHandler errorHandler;
	Admin testAdmin;
	Management management;
	
	public WhiteBoxAddUserSteps(ErrorHandler errorHandler, Management management) {
		this.errorHandler = errorHandler;
		this.management = management;
	}

	@When("^a user with ID \"([^\"]*)\" is added to the managment$")
	public void aUserWithIDIsAddedToTheManagment(String arg1) throws Exception {
		errorHandler.testEmployee = new Employee("Tester", "passy");
		management.userLogin("Tester", "passy");
		errorHandler.testEmployee = new Employee(arg1, "passy");
		try {
		management.addUser(errorHandler.testEmployee);
		}
		catch(OperationNotAllowedException e) {
			errorHandler.errorMessage = e.getMessage();
		}
	}
	
	@Given("^the employee with ID \"([^\"]*)\" doesn't exist$")
	public void theEmployeeWithIDDoesnTExist(String arg1) throws Exception {
	    assertFalse(management.getUsers().contains(management.getUserByID(arg1)));
	}

	@Given("^the user doesn't have admin permissions$")
	public void theUserDoesnTHaveAdminPermissions() throws Exception {
	    assertFalse(management.getLoggedInUser().hasAdminPermissions());
	    
	}

	@When("^the logged in user adds the user with ID \"([^\"]*)\"$")
	public void theLoggedInUserAddsTheUserWithID(String arg1) throws Exception {
	    errorHandler.testEmployee = new Employee(arg1, "passy");
		try {
	    	management.addUser(errorHandler.testEmployee);
	    }
	    catch(OperationNotAllowedException e) {
	    	errorHandler.errorMessage = e.getMessage();
	    }
	}

	@Then("^the user with ID \"([^\"]*)\" is added$")
	public void theUserWithIDIsAdded(String arg1) throws Exception {
	    assertTrue(management.getUsers().contains(management.getUserByID(arg1)));
	}
}
