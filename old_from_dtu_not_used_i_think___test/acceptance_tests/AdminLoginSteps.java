package acceptance_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import time_management.app.Management;

public class AdminLoginSteps {

	public AdminLoginSteps() {
		
	}
	
	@Given("^that the administrator is not logged in$")
	public void thatTheAdministratorIsNotLoggedIn(){
	    assertFalse(Management.userIsLoggedIn());
	}
	
	@When("^the adminstrator enters the password \"([^\"]*)\" and the ID \"([^\"]*)\"$")
	public void theAdminstratorEntersThePasswordAndTheID(String arg1, String arg2) throws Exception {
		Management.logAdminIn(arg2, arg1);
	}
	
	@Then("^the adminstrator is logged in$")
	public void theAdminstratorIsLoggedIn() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}