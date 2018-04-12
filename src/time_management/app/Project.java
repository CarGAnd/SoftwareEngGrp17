package time_management.app;

import java.util.ArrayList;

import cucumber.api.java.it.Date;

public class Project {
	String projectname = "";
	String projectID = "";
	String adminID = "";
	String adminPass = "";
	Date startDate = null;
	Date endDate = null;
	int estimatedTimeUsage;
	
	public Project(String projectname, String projectID, Date startDate, Date endDate, String adminID, String adminPass, int estimatedTimeUsage) throws FailedLoginException {
	/*	
	* There needs to be a check that the person who's calling the project is an admin.
	this.adminID = adminID;
	this.adminPass = adminPass;
	Login.AdminLogin(adminID, adminPass);
	*/
	this.projectname = projectname;
	this.projectID = projectID;
	this.startDate = startDate;
	this.endDate = endDate;
	this.estimatedTimeUsage = estimatedTimeUsage;
	
	ArrayList<Activity> Activities = new ArrayList<Activity>();
	String projectLeaderID = "";
	}
	public void EditProjectDetails(String projectID) {
		
	}
	public void SetProjectLeader(String employeeID, String adminID, String adminPass, String projectID) {
			
	}

}
