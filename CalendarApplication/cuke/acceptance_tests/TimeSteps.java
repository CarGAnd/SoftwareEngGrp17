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

/*
 * @author Mark Uttrup Ewing
 */

public class TimeSteps {
	Management management;
	ErrorHandler errorHandler;
	
	public TimeSteps(Management management, ErrorHandler errorHandler) {
		this.errorHandler = errorHandler;
		this.management = management;
	}

	@When("^the employee registers his absence from \"([^\"]*)\" to \"([^\"]*)\"$")
	public void theUserRegistersHisAbsenceFromTo(String absenceStart, String absenceEnd) throws Exception {
		SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		Date start = DateFormatter.parse(absenceStart);
		Date end = DateFormatter.parse(absenceEnd);
		errorHandler.testAbsence = new Absence(start,end);
		errorHandler.testEmployee.registerAbsence(errorHandler.testAbsence);
	}

	@Then("^his absence is registered within the system$")
	public void hisAbsenceIsRegisteredWithinTheSystem() throws Exception {
		assertTrue(errorHandler.testEmployee.getAbsence().contains(errorHandler.testAbsence));
	}

	@Given("^the employee has registered absence$")
	public void aUserHasRegisteredAbsence() throws Exception {
		if(errorHandler.testEmployee.getAbsence().size() == 0) {
			SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyyy");
			Date start = new Date();
			Date end = new Date();
			end.setTime(System.currentTimeMillis() + 1000 * 60 * 60 * 24);
			errorHandler.testAbsence = new Absence(start,end);
			errorHandler.testEmployee.registerAbsence(errorHandler.testAbsence);
		}
		assertTrue(errorHandler.testEmployee.getAbsence().size() > 0);
	}

	@When("^the user edits his absence to \"([^\"]*)\" to \"([^\"]*)\"$")
	public void theUserEditsHisAbsenceToTo(String absenceStart, String absenceEnd) throws Exception {
		SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		Date start = DateFormatter.parse(absenceStart);
		Date end = DateFormatter.parse(absenceEnd);
		Date testStart = DateFormatter.parse("01/01/01");
		Date testEnd = DateFormatter.parse("02/01/02");
		errorHandler.testAbsence = new Absence(testStart,testEnd);
		errorHandler.testEmployee.registerAbsence(errorHandler.testAbsence);
	    errorHandler.testAbsence.editAbsence(start,end);
	}

	@Then("^the absence's start date is \"([^\"]*)\" and the end date is \"([^\"]*)\"$")
	public void theAbsenceSStartDateIsAndTheEndDateIs(String start, String end) throws Exception {
	  	SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		assertTrue(errorHandler.testAbsence.getAbsenceStart().equals(DateFormatter.parse(start)));
		assertTrue(errorHandler.testAbsence.getAbsenceEnd().equals(DateFormatter.parse(end)));
		
	}


	@When("^he enters \"([^\"]*)\" with (\\d+) hours worked$")
	public void heEntersWithHoursWorked(String date, int hours) throws Exception {
	 	try {
			SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyyy");
			errorHandler.testEmployee.updateRegisteredHours(DateFormatter.parse(date), hours);
		}
	    catch (Exception e){
			errorHandler.errorMessage = e.getMessage();
		}
	}

	@Then("^the number of hours the employee has worked on the date \"([^\"]*)\" is now (\\d+)$")
	public void theNumberOfHoursTheEmployeeHasWorkedOnTheDateIsNow(String date, int hoursWorked) throws Exception {
	  	SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyyy");
	    Date dateWorked = DateFormatter.parse(date);
		assertTrue(errorHandler.testEmployee.getRegisteredHoursByDate(dateWorked) == hoursWorked);
	}
	
	@Given("^the user has already registered the number of hours he has worked on \"([^\"]*)\"$")
	public void theUserHasAlreadyRegisteredTheNumberOfHoursHeHasWorkedOn(String date) throws Exception {
		SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = DateFormatter.parse(date);
		errorHandler.testEmployee.updateRegisteredHours(date1, 6.0);
	    assertTrue(errorHandler.testEmployee.getRegisteredHours().containsKey(date1));
	}

	@When("^the user edits the number of hours he has worked on \"([^\"]*)\" to (\\d+)$")
	public void theUserEditsTheNumberOfHoursHeHasWorkedOnTo(String dateWorked, int hours) throws Exception {
	 	SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyyy");
	    Date date = DateFormatter.parse(dateWorked);
	    errorHandler.testEmployee.updateRegisteredHours(date, hours);
	}

	@Given("^the employee was absent \"([^\"]*)\" to \"([^\"]*)\"$")
	public void theEmployeeWasAbsentTo(String startAbsence, String endAbsence) throws Exception {
		SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		Date start = DateFormatter.parse(startAbsence);
		Date end = DateFormatter.parse(endAbsence);
		errorHandler.testAbsence = new Absence(start,end);
		errorHandler.testEmployee.registerAbsence(errorHandler.testAbsence);
		assertTrue(errorHandler.testEmployee.getAbsence().contains(errorHandler.testAbsence));
	}
}

