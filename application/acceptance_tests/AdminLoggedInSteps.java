package acceptance_tests;

import business_logic.Management;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;

public class AdminLoggedInSteps {
	Management management = new Management();
	@Given("^that the administrator is not logged in$")
	public void thatTheAdministratorIsNotLoggedIn() throws Exception {
		System.out.println("Print dette");
		throw new PendingException();
	}

	@When("^the adminstrator enters the password \"([^\"]*)\" and the ID \"([^\"]*)\"$")
	public void theAdminstratorEntersThePasswordAndTheID(String arg1, String arg2) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the adminstrator is logged in$")
	public void theAdminstratorIsLoggedIn() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
