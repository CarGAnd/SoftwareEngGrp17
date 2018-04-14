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
	
	ErrorHandler errorHandler;
	Employee testEmployee;
	Admin testAdmin = new Admin();
	
	public LoginSteps(ErrorHandler errorHandler) {
		this.errorHandler = errorHandler;
	}
	
	@Given("^a user is logged in$")
	public void aUserIsLoggedIn() throws Exception {
		Management.adminLogin("admin", "adminadmin");
	    assertTrue(Management.userIsLoggedIn());
	}
	
	@Given("^a user is not logged in$")
	public void aUserIsNotLoggedIn() throws Exception {
		Management.logUserOut();
	    assertFalse(Management.userIsLoggedIn());
	}

	@When("^the adminstrator enters the ID \"([^\"]*)\" and the password \"([^\"]*)\"$")
	public void theAdminstratorEntersThePasswordAndTheID(String arg1, String arg2) throws Exception {
		Management.addAdmin(testAdmin);
		try {
			Management.adminLogin(arg1, arg2);
		}
		catch(FailedLoginException e) {
			errorHandler.errorMessage = e.getMessage();
		}
	}
	
	@When("^the user logs out$")
	public void theUserLogsOut() throws Exception {
		Management.logUserOut();
	}
	
	@When("^the employee enters the ID \"([^\"]*)\" and the password \"([^\"]*)\"$")
	public void theEmployeeEntersThePasswordAndTheID(String arg1, String arg2) throws Exception {
	    testEmployee = Management.addEmployee(new Employee("test", "password"));
	    try {
	    	Management.employeeLogin(arg1, arg2);
	    }
	    catch(FailedLoginException e) {
	    	errorHandler.errorMessage = e.getMessage();
	    }
	}

	@Then("^the adminstrator is logged in$")
	public void theAdminstratorIsLoggedIn() throws Exception {
		
		assertTrue(Management.adminIsLoggedIn());
	}
	
	@Then("^the administrator is not logged in$")
	public void theAdministratorIsNotLoggedIn() throws Exception {
		assertFalse(Management.adminIsLoggedIn());
	}
	
	@Then("^i get the error message \"([^\"]*)\"$")
	public void iGetTheErrorMessage(String arg1) throws Exception {
	    assertTrue(errorHandler.errorMessage.equals(arg1));
	}
	
	@Then("^the user is no longer logged in$")
	public void theUserIsNoLongerLoggedIn() throws Exception {
	    assertFalse(Management.userIsLoggedIn());
	}
	
	@Then("^the employee is not logged in$")
	public void theEmployeeIsNotLoggedIn() throws Exception {
	    assertTrue(Management.getLoggedInUserID() == null || !Management.getLoggedInUserID().equals(testEmployee.getEmployeeID()));
	}
	
	@Then("^the employee is logged in$")
	public void theEmployeeIsLoggedIn() throws Exception {
	    assertTrue(Management.employeeIsLoggedIn());
	    assertTrue(Management.getLoggedInUserID().equals(testEmployee.getEmployeeID()));
	}	
}
