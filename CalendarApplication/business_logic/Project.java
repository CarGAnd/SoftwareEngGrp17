package business_logic;

import java.util.ArrayList;
import java.util.Date;

import business_logic.Management.userType;//TODO: Unused import, remove if not needed.

public class Project {
	ArrayList<Activity> Activities;
	String projectname = "";
	private String projectID = "";
	

	String adminID = "";
	String adminPass = "";
	private String projectLeaderID = "";
	Date startDate = null;
	Date endDate = null;
	int estimatedTimeUsage;

	public Project(String projectname, String projectID, Date startDate, Date endDate, int estimatedTimeUsage) {
		/*
		 * There needs to be a check that the person who's calling the project is an
		 * admin. this.adminID = adminID; this.adminPass = adminPass;
		 * Login.AdminLogin(adminID, adminPass);
		 */
		this.projectname = projectname;
		this.projectID = projectID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.estimatedTimeUsage = estimatedTimeUsage;

		Activities = new ArrayList<Activity>();
	}

	public void EditProjectDetails(String projectID) {
		
	}

	public void SetProjectLeader(String employeeID, String adminID, String adminPass, String projectID) {
		// bliver muligvis n�d til at sende en management ind som parameter. Kan ikke se hvordan man ellers skal checke hvem der er logget ind
	}

	public String getProjectLeaderID() {
		return projectLeaderID;
	}
	
	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}
}
