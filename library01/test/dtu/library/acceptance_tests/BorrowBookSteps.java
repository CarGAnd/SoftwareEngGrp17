package dtu.library.acceptance_tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dtu.library.app.*;

public class BorrowBookSteps {
	
	LibraryApp libraryApp;
	User user = new User("1","2","3");
	Book book;
	String errorMessage;
	
	public BorrowBookSteps(LibraryApp libraryApp) {
		this.libraryApp = libraryApp;
	}
	@Given("^that a user is registered with the library$")
	public void thatAUserIsRegistered() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(libraryApp.adminLogin("adminadmin"));
		libraryApp.RegisterUser(user);
	    assertTrue(libraryApp.GetUsers().contains(user));
	}
	
	@Given("^the user has borrowed more than (\\d+) books$")
	public void theUserHasBorrowedMoreThanBooks(int arg1) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    for(int i = 0; i < arg1; i++) {
	    	user.borrowBook(libraryApp, new Book("1","2","3"));
	    }
	    assertTrue(user.getBorrowedBooks().size() >= 10);
	}
	
	@Given("^that a user is not registered with the library$")
	public void thatAUserIsNotRegisteredWithTheLibrary() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    assertFalse(libraryApp.GetUsers().contains(user));
	}

	@When("^the user borrows a book$")
	public void theUserBorrowsABook() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    try {
	    	user.borrowBook(libraryApp, book);	    	
	    }
	    catch(OperationNotAllowedException e) {
	    	errorMessage = e.getMessage();
	    }
	}

	@Then("^the book is borrowed by the user$")
	public void theBookIsBorrowedByTheUser() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    assertTrue(user.getBorrowedBooks().contains(book));
	}
	
	@Then("^I get the error message \"([^\"]*)\"$")
	public void iGetTheErrorMessage(String errorMessage) throws Exception {
		assertEquals(errorMessage, this.errorMessage);
	}
}
