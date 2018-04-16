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
	Employee testEmployee = new Employee("test","password");
	Admin testAdmin = new Admin();
	
	public LoginSteps(ErrorHandler errorHandler) {
		this.errorHandler = errorHandler;
	}
	
	@Given("^a user is logged in$")
	public void aUserIsLoggedIn() throws Exception {
		if(!Management.userIsLoggedIn()) {
			Management.adminLogin("admin", "adminadmin");
		}
	    assertTrue(Management.userIsLoggedIn());
	}
	
	@Given("^a user is not logged in$")
	public void aUserIsNotLoggedIn() throws Exception {
		Management.logUserOut();
	    assertFalse(Management.userIsLoggedIn());
	}
	
	@Given("^an adminstrator exists$")
	public void anAdminstratorExists() throws Exception {
	    if(Management.getAdmins().size() == 0) {
	    	Management.addAdmin(testAdmin);
	    }
	    assertTrue(Management.getAdmins().size() > 0);
	}
	
	@Given("^an employee exists$")
	public void anEmployeeExists() throws Exception {
	    if(Management.getEmployees().size() == 0) {
	    	Management.addEmployee(testEmployee);
	    }
	    assertTrue(Management.getEmployees().size() > 0);
	}
	
	@Given("^a user exists$")
	public void aUserExists() throws Exception {
		anEmployeeExists();
		anAdminstratorExists();
	}

	@When("^the adminstrator enters the ID \"([^\"]*)\" and the password \"([^\"]*)\"$")
	public void theAdminstratorEntersThePasswordAndTheID(String arg1, String arg2) throws Exception {
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
		assertTrue(Management.getLoggedInUserID() == null || !Management.getLoggedInUserID().equals(testAdmin.getAdminID()));
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
