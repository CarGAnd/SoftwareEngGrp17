package cuke.acceptance_tests.whiteBox;

import business_logic.Admin;
import business_logic.Management;
import business_logic.OperationNotAllowedException;
import business_logic.Project;
import cuke.acceptance_tests.ErrorHandler;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import business_logic.Admin;
import business_logic.Employee;
import business_logic.FailedLoginException;
import business_logic.Management;
import business_logic.User;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;

public class WhiteBoxCreateActivitySteps {

	ErrorHandler errorHandler;
	Admin testAdmin;
	Management management;
	
	public WhiteBoxCreateActivitySteps(ErrorHandler errorHandler, Management management) {
		this.errorHandler = errorHandler;
		this.management = management;
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
	    	errorHandler.testProject.createActivity(arg2, arg1, dueDate, arg4);
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
}
