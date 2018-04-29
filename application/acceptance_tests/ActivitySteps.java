package acceptance_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import business_logic.Activity;
import business_logic.Admin;
import business_logic.Employee;
import business_logic.FailedLoginException;
import business_logic.Management;
import business_logic.Project;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;

public class ActivitySteps {
	
	ErrorHandler errorHandler;
	Employee testEmployee;
	Admin testAdmin;
	Management management;
	Activity testActivity;
	Project testProject;
	
	public ActivitySteps(ErrorHandler errorHandler, Management management) {
		this.errorHandler = errorHandler;
		this.management = management;
	}
	
	@Given("^a project with the ID \"([^\"]*)\" exists$")
	public void aProjectWithTheIDExists(String arg1) throws Exception {
		if(!management.getListOfProjects().contains(management.getProjectByID(arg1))) {
			if(!management.adminIsLoggedIn()) {
				management.logUserOut();
				management.userLogin("admin", "adminadmin");
			}
		SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		int estimatedTime = Integer.parseInt("40");
		Date startDate = DateFormatter.parse("05/11/2020");
		Date endDate = DateFormatter.parse("10/11/2020");
			
		testProject = management.createProject("name", arg1, startDate, endDate, estimatedTime);
		}
		assertTrue(management.getListOfProjects().contains(management.getProjectByID(arg1)));
		
	}
	
	@Given("^the projects leader has the ID \"([^\"]*)\"$")
	public void theProjectsLeaderHasTheID(String arg1) throws Exception {
		testProject.setProjectLeader(arg1, management);
		assertTrue(testProject.getProjectLeader().equals(arg1));
	}
	
	@Given("^an employee with the ID \"([^\"]*)\" is logged in$")
	public void anEmployeeWithTheIDIsLoggedIn(String arg1) throws Exception {
	    management.userLogin(arg1, "password");
	    assertTrue(management.getLoggedInUser().getUserID().equals(arg1));
	}
	
	@Given("^the logged in user's ID matches the project leader ID$")
	public void theLoggedInUserSIDMatchesTheProjectLeaderID() throws Exception {
	    assertTrue(testProject.getProjectLeader().equals(management.getLoggedInUser().getUserID()));
	}
	
	@Given("^an activity with the ID \"([^\"]*)\" exists in the project with the ID \"([^\"]*)\"$")
	public void anActivityWithTheIDExistsInTheProjectWithTheID(String arg1, String arg2) throws Exception {
	    testProject = management.getProjectByID(arg2);
	    if(testProject.getActivityByID(arg1) == null) {
	    	SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyyy");
			Date endDate = DateFormatter.parse("10/11/2020");
	    	testActivity = new Activity(arg1, endDate, 40, "description");
	    	testProject.addActivity(testActivity);
	    }
	}
	
	@Given("^the activity status is not \"([^\"]*)\"$")
	public void theActivityStatusIsNot(String arg1) throws Exception {
	    assertFalse(testActivity.getActivityStatus().equals("finished"));
	}
	
	@Given("^the logged in user's ID does not match the project leader ID$")
	public void theLoggedInUserSIDDoesNotMatchTheProjectLeaderID() throws Exception {
	    assertFalse(management.getLoggedInUser().getUserID().equals(testProject.getProjectLeader()));
	}

	@When("^the user edits the name of the activity to \"([^\"]*)\"$")
	public void theUserEditsTheNameOfTheActivityTo(String arg1) throws Exception {
	    try{
	    	testActivity.setName(arg1);
	    }
	    catch (Exception e) {
	    	errorHandler.errorMessage = e.getMessage();
	    }
	}
	
	@When("^the user creates an activity in the project with the description \"([^\"]*)\" and the due date \"([^\"]*)\" and (\\d+) estimated work hours and the ID \"([^\"]*)\"$")
	public void theUserCreatesAnActivityInTheProjectWithTheDescriptionAndTheDueDateAndEstimatedWorkHoursAndTheID(String arg1, String arg2, int arg3, String arg4) throws Exception {
		SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		Date endDate = DateFormatter.parse(arg2);
	    testActivity = new Activity(arg4, endDate, arg3, arg1);
	    testProject.addActivity(testActivity);  
	}
	
	@When("^the user changes the status of the activity to \"([^\"]*)\"$")
	public void theUserChangesTheStatusOfTheActivityTo(String arg1) throws Exception {
	    try{
	    	testActivity.setActivityStatus(arg1);
	    }
	    catch (Exception e) {
	    	errorHandler.errorMessage = e.getMessage();
	    }
	}
	
	@Then("^the activity's name is edited to \"([^\"]*)\"$")
	public void theActivitySNameIsEditedTo(String arg1) throws Exception {
	    assertTrue(testActivity.getName().equals(arg1));
	}
	
	@Then("^the activity status is changed to \"([^\"]*)\"$")
	public void theActivityStatusIsChangedTo(String arg1) throws Exception {
	    assertTrue(testActivity.getActivityStatus().equals(arg1));
	}
	
	@Then("^an activity is created in the project with the description \"([^\"]*)\" and the due date \"([^\"]*)\" and (\\d+) estimated work hours and the Id \"([^\"]*)\"$")
	public void anActivityIsCreatedInTheProjectWithTheDescriptionAndTheDueDateAndEstimatedWorkHoursAndTheId(String arg1, String arg2, int arg3, String arg4) throws Exception {
		SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		Date endDate = DateFormatter.parse(arg2);
		Activity a = testProject.getActivityByID(arg4);
	    assertTrue(a.getDescription().equals(arg1));
	    assertTrue(a.getEndDate().equals(endDate));
	    assertTrue(a.getEstimatedTime() == arg3);
	}
}
