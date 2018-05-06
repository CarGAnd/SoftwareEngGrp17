package cuke.acceptance_tests.whiteBox;

import business_logic.Admin;
import business_logic.Management;
import business_logic.Activity;
import cucumber.api.PendingException;
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

	}

	@Given("^the user with ID \"([^\"]*)\" doesn't exist$")
	public void theUserWithIDDoesnTExist(String arg1) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^a user with ID \"([^\"]*)\" is logged in$")
	public void aUserWithIDIsLoggedIn(String arg1) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^the user doesn't have admin permissions$")
	public void theUserDoesnTHaveAdminPermissions() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^the logged in user adds the user with ID \"([^\"]*)\"$")
	public void theLoggedInUserAddsTheUserWithID(String arg1) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^the user does have admin permissions$")
	public void theUserDoesHaveAdminPermissions() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the user with ID \"([^\"]*)\" is added$")
	public void theUserWithIDIsAdded(String arg1) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
