package cuke.acceptance_tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import business_logic.Absence;
import business_logic.Employee;
import business_logic.Management;
import business_logic.User;



public class TimeSteps {
	Management management;
	User user;
	Absence testAbsence;
	ErrorHandler errorHandler;
	
	public TimeSteps(Management management, ErrorHandler errorHandler) {
		this.errorHandler = errorHandler;
		this.management = management;
	}

	


	@Given("^the user is logged in with ID \"([^\"]*)\"$")
	public void theUserIsLoggedInWithID(String ID) throws Exception {
		user = new Employee(ID,"password");
		management.addUser(user);
		if(!management.userIsLoggedIn()) {
			management.userLogin(ID, "password");
		}
		if(management.getLoggedInUserID() != ID) {
			management.logUserOut();
			management.userLogin(ID, "password");
		}
		assertTrue(management.getLoggedInUserID().equals(ID));
	}

	@When("^the user registers his absence from \"([^\"]*)\" to \"([^\"]*)\"$")
	public void theUserRegistersHisAbsenceFromTo(String absenceStart, String absenceEnd) throws Exception {
		SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		Date start = DateFormatter.parse(absenceStart);
		Date end = DateFormatter.parse(absenceEnd);
		testAbsence = new Absence(start,end);
		user.registerAbsence(testAbsence);
	}

	
	@Then("^his absence is registered within the system$")
	public void hisAbsenceIsRegisteredWithinTheSystem() throws Exception {
		assertTrue(user.getAbsence().contains(testAbsence));
	}

	@Given("^a user has registered absence$")
	public void aUserHasRegisteredAbsence() throws Exception {
		assertTrue(user.getAbsence() != null);
	}

	@When("^the user edits his absence to \"([^\"]*)\" to \"([^\"]*)\"$")
	public void theUserEditsHisAbsenceToTo(String absenceStart, String absenceEnd) throws Exception {
		SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		Date start = DateFormatter.parse(absenceStart);
		Date end = DateFormatter.parse(absenceEnd);
		Date testStart = DateFormatter.parse("01/01/01");
		Date testEnd = DateFormatter.parse("02/01/02");
		testAbsence = new Absence(testStart,testEnd);
		user.registerAbsence(testAbsence);
	    testAbsence.editAbsence(start,end);
	}

	@Then("^change is registered within the system$")
	public void changeIsRegisteredWithinTheSystem() throws Exception {
		SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		assertTrue(testAbsence.getAbsenceStart().equals(DateFormatter.parse("01/02/12")));
		assertTrue(testAbsence.getAbsenceEnd().equals(DateFormatter.parse("02/03/12")));
		
	}


	@When("^he enters \"([^\"]*)\" with \"([^\"]*)\" hours worked$")
	public void heEntersWithHoursWorked(String date, String hours) throws Exception {
		try {
			SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyyy");
			double hoursWorked = Double.parseDouble(hours);
			user.updateRegisteredHours(DateFormatter.parse(date), hoursWorked);
		}
	    catch (Exception e){
			errorHandler.errorMessage = e.getMessage();
		}
	}

	@Then("^the number of hours is registered within the system$")
	public void theNumberOfHoursIsRegisteredWithinTheSystem() throws Exception {
		SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyyy");
	    Date date = DateFormatter.parse("01/01/01");
		assertTrue(user.getRegisteredHoursByDate(date) == 8.0);
	}
	
	@Given("^the user has already registered the number of hours he has worked on \"([^\"]*)\"$")
	public void theUserHasAlreadyRegisteredTheNumberOfHoursHeHasWorkedOn(String date) throws Exception {
		SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = DateFormatter.parse(date);
		user.updateRegisteredHours(date1, 6.0);
	    assertTrue(user.getRegisteredHours().containsKey(date1));
	}

	@When("^the user edits the number of hours he has worked to \"([^\"]*)\"$")
	public void theUserEditsTheNumberOfHoursHeHasWorkedTo(String hours) throws Exception {
		SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyyy");
	    Date date = DateFormatter.parse("01/01/01");
	    double hoursWorked = Double.parseDouble(hours);
	    user.updateRegisteredHours(date, hoursWorked);
	}

	@Then("^the number of hours is updated within the system$")
	public void theNumberOfHoursIsUpdatedWithinTheSystem() throws Exception {
		SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyyy");
	    Date date = DateFormatter.parse("01/01/01");
		assertTrue(user.getRegisteredHoursByDate(date) == 7.0);
	}


	@Given("^the employee was absent \"([^\"]*)\" to \"([^\"]*)\"$")
	public void theEmployeeWasAbsentTo(String startAbsence, String endAbsence) throws Exception {
		SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		Date start = DateFormatter.parse(startAbsence);
		Date end = DateFormatter.parse(endAbsence);
		testAbsence = new Absence(start,end);
		user.registerAbsence(testAbsence);
		assertTrue(user.getAbsence().contains(testAbsence));
	}


	@Then("^the employee gets an error message \"([^\"]*)\"$")
	public void theEmployeeGetsAnErrorMessage(String arg1) throws Exception {
		assertTrue(errorHandler.errorMessage.equals(arg1));
	}
}

