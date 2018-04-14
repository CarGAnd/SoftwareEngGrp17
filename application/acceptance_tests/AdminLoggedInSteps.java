package acceptance_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import business_logic.Admin;
import business_logic.FailedLoginException;
import business_logic.Management;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;

public class AdminLoggedInSteps {
	
	Management management;
	ErrorHandler errorHandler;
	
	public AdminLoggedInSteps(Management mag, ErrorHandler errorHandler) {
		this.management = mag;
		this.errorHandler = errorHandler;
	}

	@Given("^that the administrator is not logged in$")
	public void thatTheAdministratorIsNotLoggedIn() throws Exception {
		assertFalse(management.userIsLoggedIn());
	}

	@When("^the adminstrator enters the password \"([^\"]*)\" and the ID \"([^\"]*)\"$")
	public void theAdminstratorEntersThePasswordAndTheID(String arg1, String arg2) throws Exception {
		try {
			management.adminLogin(arg2, arg1);
		}
		catch(FailedLoginException e) {
			errorHandler.errorMessage = e.getMessage();
		}
	}

	@Then("^the adminstrator is logged in$")
	public void theAdminstratorIsLoggedIn() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
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
}
