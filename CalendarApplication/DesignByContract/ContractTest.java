package DesignByContract;

import business_logic.Admin;
import business_logic.Employee;
import business_logic.FailedLoginException;
import business_logic.Management;
import business_logic.OperationNotAllowedException;
import business_logic.Project;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import cucumber.api.java.en.*;
import cuke.acceptance_tests.ErrorHandler;

/*
 * @author Mark Uttrup Ewing
 */

public class ContractTest {
	
	ErrorHandler errorHandler;
	Admin testAdmin;
	Management management;

	
	public ContractTest(ErrorHandler errorHandler, Management management) {
		this.errorHandler = errorHandler;
		this.management = management;
	}
	
	@When("^a user with ID \"([^\"]*)\" is added to the managment$")
	public void aUserWithIDIsAddedToTheManagment(String arg1) throws Exception {
		management.logUserOut();
		management.userLogin("admin", "adminadmin");
		errorHandler.testEmployee = new Employee("Tester", "passy");
		management.addUser(errorHandler.testEmployee);
		management.logUserOut();
		management.userLogin("Tester", "passy");
		errorHandler.testEmployee = new Employee(arg1, "passy");
		try {
		management.ASSERTaddUser(errorHandler.testEmployee);
		}
		catch(OperationNotAllowedException e) {
			errorHandler.errorMessage = e.getMessage();
		}

	}
	
	@Given("^the employee with ID \"([^\"]*)\" doesn't exist$")
	public void theEmployeeWithIDDoesnTExist(String arg1) throws Exception {
	    assertFalse(management.getUsers().contains(management.getUserByID(arg1)));
	}

	@Given("^the user doesn't have admin permissions$")
	public void theUserDoesnTHaveAdminPermissions() throws Exception {
	    assertFalse(management.getLoggedInUser().hasAdminPermissions());
	    
	}

	@When("^the logged in user adds the user with ID \"([^\"]*)\"$")
	public void theLoggedInUserAddsTheUserWithID(String arg1) throws Exception {
	    errorHandler.testEmployee = new Employee(arg1, "passy");
		try {
	    	management.ASSERTaddUser(errorHandler.testEmployee);
	    }
	    catch(OperationNotAllowedException e) {
	    	errorHandler.errorMessage = e.getMessage();
	    }
	}

	@Then("^the user with ID \"([^\"]*)\" is added$")
	public void theUserWithIDIsAdded(String arg1) throws Exception {
	    assertTrue(management.getUsers().contains(management.getUserByID(arg1)));
	}
	
	
	@Given("^the employee is not project leader$")
	public void theEmployeeIsNotProjectLeader() throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date startDate = formatter.parse("2/22/2020");
		Date endDate = formatter.parse("3/13/3030");
		errorHandler.testProject = new Project("name","ID",startDate,endDate,50);
		if(!management.userIsLoggedIn()) {
			management.userLogin("admin", "adminadmin");
		}
		management.addProject(errorHandler.testProject);
		assertFalse(errorHandler.testProject.getProjectLeaderID() == errorHandler.testEmployee.getUserID());
	}

	@When("^the employee creates a activity with ID \"([^\"]*)\" description \"([^\"]*)\" due date \"([^\"]*)\" and estimated time usage (\\d+)$")
	public void theEmployeeCreatesAActivityWithIDDescriptionDueDateAndEstimatedTimeUsage(String arg1, String arg2, String arg3, int arg4) throws Exception {
	    try {
	    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	    	Date dueDate = formatter.parse(arg3);
	    	errorHandler.testProject.ASSERTcreateActivity(arg2, arg1, dueDate, arg4);
	    }
	    catch(OperationNotAllowedException e) {
	    	errorHandler.errorMessage = e.getMessage();
	    }
	}

	@Given("^the employee is project leader$")
	public void theEmployeeIsProjectLeader() throws Exception {
		management.logUserOut();
		management.userLogin("admin", "adminadmin");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date startDate = formatter.parse("2/22/2020");
		Date endDate = formatter.parse("3/13/3030");
		errorHandler.testProject = new Project("name","ID",startDate,endDate,50);
		if(!management.userIsLoggedIn()) {
			management.userLogin("admin", "adminadmin");
		}
		management.addProject(errorHandler.testProject);
		errorHandler.testProject.setProjectLeader(errorHandler.testEmployee.getUserID());
		management.logUserOut();
		management.userLogin("SomeID", "passy");
	    assertTrue(errorHandler.testProject.getProjectLeaderID() == errorHandler.testEmployee.getUserID());

	}

	

	@Then("^the activity with ID \"([^\"]*)\" description \"([^\"]*)\" due date \"([^\"]*)\" and estimated time usage (\\d+) is created$")
	public void theActivityWithIDDescriptionDueDateAndEstimatedTimeUsageIsCreated(String arg1, String arg2, String arg3, int arg4) throws Exception {
	    assertTrue(errorHandler.testProject.activities.contains(errorHandler.testProject.getActivityByID(arg1)));

	}
	
	@When("^the user creates a project with ID \"([^\"]*)\" name \"([^\"]*)\" start date \"([^\"]*)\" end date \"([^\"]*)\" and estimated time usage (\\d+)$")
	public void theUserCreatesAProjectWithIDNameStartDateEndDateAndEstimatedTimeUsage(String arg1, String arg2, String arg3, String arg4, int arg5) throws Exception {
	    try {
	    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	    	Date startDate = formatter.parse(arg3);
	    	Date endDate = formatter.parse(arg4);
	    	management.ASSERTcreateProject(arg2, arg1, startDate, endDate, arg5);
	    }
	    catch(OperationNotAllowedException e) {
	    	errorHandler.errorMessage = e.getMessage();
	    }
	}
	@Then("^the project with ID \"([^\"]*)\" name \"([^\"]*)\" start date \"([^\"]*)\" end date \"([^\"]*)\" and estimated time usage (\\d+) is created$")
	public void theProjectWithIDNameStartDateEndDateAndEstimatedTimeUsageIsCreated(String arg1, String arg2, String arg3, String arg4, int arg5) throws Exception {
	    assertTrue(management.getListOfProjects().contains(management.getProjectByID(arg1)));
	}
	
	@Given("^a user is already logged in$")
	public void aUserIsAlreadyLoggedIn() throws Exception {
		management.logUserOut();
		management.userLogin("admin", "adminadmin");
		errorHandler.testEmployee = new Employee("SomeID", "passy");
		management.addUser(errorHandler.testEmployee);
		management.logUserOut();
		management.userLogin("SomeID", "passy");
	}

	@When("^a user with ID \"([^\"]*)\" and password \"([^\"]*)\" attempts to log in$")
	public void aUserWithIDAndPasswordAttemptsToLogIn(String arg1, String arg2) throws Exception {
	    try {
	    	management.ASSERTuserLogin(arg1, arg2);
	    }
	    catch(FailedLoginException e) {
	    	errorHandler.errorMessage = e.getMessage();
	    }
	}
	@Given("^an employee with the ID \"([^\"]*)\" and the password \"([^\"]*)\" doesn't exist$")
	public void anEmployeeWithTheIDAndThePasswordDoesnTExist(String arg1, String arg2) throws Exception {
	   assertFalse(management.getUsers().contains(management.getUserByID(arg1)));
	}
	
	@Then("^the user with ID \"([^\"]*)\" is now logged in$")
	public void theUserWithIDIsNowLoggedIn(String arg1) throws Exception {
	    assertTrue(management.getLoggedInUserID() == arg1);
	}
}

