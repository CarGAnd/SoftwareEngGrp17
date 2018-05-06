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

public class WhiteBoxCreateProject {

	ErrorHandler errorHandler;
	Admin testAdmin;
	Management management;
	
	public WhiteBoxCreateProject(ErrorHandler errorHandler, Management management) {
		this.errorHandler = errorHandler;
		this.management = management;
	}

	@When("^the user creates a project with ID \"([^\"]*)\" name \"([^\"]*)\" start date \"([^\"]*)\" end date \"([^\"]*)\" and estimated time usage (\\d+)$")
	public void theUserCreatesAProjectWithIDNameStartDateEndDateAndEstimatedTimeUsage(String arg1, String arg2, String arg3, String arg4, int arg5) throws Exception {
	    try {
	    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	    	Date startDate = formatter.parse(arg3);
	    	Date endDate = formatter.parse(arg4);
	    	management.createProject(arg2, arg1, startDate, endDate, arg5);
	    }
	    catch(OperationNotAllowedException e) {
	    	errorHandler.errorMessage = e.getMessage();
	    }
	}
	@Then("^the project with ID \"([^\"]*)\" name \"([^\"]*)\" start date \"([^\"]*)\" end date \"([^\"]*)\" and estimated time usage (\\d+) is created$")
	public void theProjectWithIDNameStartDateEndDateAndEstimatedTimeUsageIsCreated(String arg1, String arg2, String arg3, String arg4, int arg5) throws Exception {
	    assertTrue(management.getListOfProjects().contains(management.getProjectByID(arg1)));
	}
}
