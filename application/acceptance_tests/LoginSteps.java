package acceptance_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import business_logic.Admin;
import business_logic.Employee;
import business_logic.FailedLoginException;
import business_logic.Management;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;

public class LoginSteps {
	
	Management management;
	ErrorHandler errorHandler;
	Employee testEmployee;
	
	public LoginSteps(Management mag, ErrorHandler errorHandler) {
		this.management = mag;
		this.errorHandler = errorHandler;
	}

	
	@Given("^a user is logged in$")
	public void aUserIsLoggedIn() throws Exception {
		management.adminLogin("admin", "adminadmin");
	    assertTrue(management.userIsLoggedIn());
	}
	
	@Given("^a user is not logged in$")
	public void aUserIsNotLoggedIn() throws Exception {
	    assertFalse(management.userIsLoggedIn());
	}

	@When("^the adminstrator enters the ID \"([^\"]*)\" and the password \"([^\"]*)\"$")
	public void theAdminstratorEntersThePasswordAndTheID(String arg1, String arg2) throws Exception {
		try {
			management.adminLogin(arg1, arg2);
		}
		catch(FailedLoginException e) {
			errorHandler.errorMessage = e.getMessage();
		}
	}
	
	@When("^the user logs out$")
	public void theUserLogsOut() throws Exception {
	    management.logUserOut();
	}
	
	@When("^the employee enters the ID \"([^\"]*)\" and the password \"([^\"]*)\"$")
	public void theEmployeeEntersThePasswordAndTheID(String arg1, String arg2) throws Exception {
	    testEmployee = management.addEmployee(new Employee("test", "password"));
	    try {
	    	management.employeeLogin(arg1, arg2);
	    }
	    catch(FailedLoginException e) {
	    	errorHandler.errorMessage = e.getMessage();
	    }
	}

	@Then("^the adminstrator is logged in$")
	public void theAdminstratorIsLoggedIn() throws Exception {
		assertTrue(management.adminIsLoggedIn());
	}
	
	@Then("^the administrator is not logged in$")
	public void theAdministratorIsNotLoggedIn() throws Exception {
		assertFalse(management.adminIsLoggedIn());
	}
	
	@Then("^i get the error message \"([^\"]*)\"$")
	public void iGetTheErrorMessage(String arg1) throws Exception {
	    assertTrue(errorHandler.errorMessage.equals(arg1));
	}
	
	@Then("^the user is no longer logged in$")
	public void theUserIsNoLongerLoggedIn() throws Exception {
	    assertFalse(management.userIsLoggedIn());
	}
	
	@Then("^the employee is not logged in$")
	public void theEmployeeIsNotLoggedIn() throws Exception {
	    assertTrue(management.getLoggedInUserID() == null || !management.getLoggedInUserID().equals(testEmployee.getEmployeeID()));
	}
	
	@Then("^the employee is logged in$")
	public void theEmployeeIsLoggedIn() throws Exception {
	    assertTrue(management.employeeIsLoggedIn());
	    assertTrue(management.getLoggedInUserID().equals(testEmployee.getEmployeeID()));
	}	
}
