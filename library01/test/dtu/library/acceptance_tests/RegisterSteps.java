package dtu.library.acceptance_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dtu.library.app.Book;
import dtu.library.app.LibraryApp;
import dtu.library.app.OperationNotAllowedException;
import dtu.library.app.User;

public class RegisterSteps {
	
	private LibraryApp libraryApp;
	private User user;
	private String errorMessage;
	
	public RegisterSteps(LibraryApp libraryApp) {
		this.libraryApp = libraryApp;
	}
	
	@Given("^there is a user with CPR \"([^\"]*)\", name \"([^\"]*)\", e-mail \"([^\"]*)\"$")
	public void ThereIsAUserWith(String CPR, String name, String email) {
		user = new User(CPR, name, email);
	}
	
	@Given("^the user has address street \"([^\"]*)\", post code (\\d+), and city \"([^\"]*)\"$")
	public void TheUserHasInfo(String street, int postCode, String city) {
		user.SetStreet(street);
		user.SetPostcode(postCode);
		user.SetCity(city);
	}
	
	@When("^the administrator registers the user$")
	public void TheAdminRegistersTheUser() throws OperationNotAllowedException{
		libraryApp.RegisterUser(user);	
		
	}
	
	@Then("^the user is a registered user of the library$")
	public void TheUserIsRegisteredAtTheLibrary() throws OperationNotAllowedException {
		assertTrue(libraryApp.GetUsers().contains(user));
	}
	
//	@Then("^I get the error message \"([^\"]*)\"$")
//	public void iGetTheErrorMessage(String errorMessage) throws Exception {
//		assertEquals(errorMessage, this.errorMessage);
//	}
	
	@Given("^a user is registered with the library$")
	public void AnUserIsRegistered() throws OperationNotAllowedException {
		assertTrue(libraryApp.adminLogin("adminadmin"));
		user = new User("1", "2", "3");
		libraryApp.RegisterUser(user);
		assertTrue(libraryApp.GetUsers().contains(user));
	}
	
	@When("^the administrator registers the user again$")
	public void theAdministratorRegistersTheUserAgain() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		try {
			libraryApp.RegisterUser(user);			
		}
		catch(OperationNotAllowedException e) {
			errorMessage = e.getMessage();
		}
	}
}
