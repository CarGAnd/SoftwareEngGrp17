package cuke.acceptance_tests.whiteBox;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import business_logic.Admin;
import business_logic.Employee;
import business_logic.FailedLoginException;
import business_logic.Management;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import cuke.acceptance_tests.ErrorHandler;

public class WhiteBoxUserLogin {
	
	ErrorHandler errorHandler;
	Admin testAdmin;
	Management management;

public WhiteBoxUserLogin(ErrorHandler errorHandler, Management management) {
	this.errorHandler = errorHandler;
	this.management = management;
}

	@Given("^a user is already logged in$")
	public void aUserIsAlreadyLoggedIn() throws Exception {
		management.logUserOut();
		management.userLogin("admin", "adminadmin");
		errorHandler.testEmployee = new Employee("SomeID", "passy");
		management.addUser(errorHandler.testEmployee);
		management.logUserOut();
		management.userLogin("SomeID", "passy");
	}

	@When("^a user with ID \"([^\"]*)\" and password \"([^\"]*)\" attempts to log in$")
	public void aUserWithIDAndPasswordAttemptsToLogIn(String arg1, String arg2) throws Exception {
	    try {
	    	management.userLogin(arg1, arg2);
	    }
	    catch(FailedLoginException e) {
	    	errorHandler.errorMessage = e.getMessage();
	    }
	}
	@Given("^an employee with the ID \"([^\"]*)\" and the password \"([^\"]*)\" doesn't exist$")
	public void anEmployeeWithTheIDAndThePasswordDoesnTExist(String arg1, String arg2) throws Exception {
	   assertFalse(management.getUsers().contains(management.getUserByID(arg1)));
	}
	
	@Then("^the user with ID \"([^\"]*)\" is now logged in$")
	public void theUserWithIDIsNowLoggedIn(String arg1) throws Exception {
	    assertTrue(management.getLoggedInUserID() == arg1);
	}
}
