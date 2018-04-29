package business_logic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import business_logic.Management.userType;

public class Project {
	ArrayList<Activity> activities;
	String projectName = "";
	private String projectID = "";

	String adminID = "";
	String adminPass = "";
	String projectLeaderID = "";
	Date startDate = null;
	Date endDate = null;
	int estimatedTimeUsage;
	String projectState = "";
	Management management;

	public Project(String projectname, String projectID, Date startDate, Date endDate, int estimatedTimeUsage) {
		
		this.projectName = projectname;
		this.projectID = projectID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.estimatedTimeUsage = estimatedTimeUsage;

		activities = new ArrayList<Activity>();
	}
	public void setProjectName(String projectname, Management management) throws Exception {
		if(!this.projectState.equals("Completed")) {
			System.out.println(this.projectState);
			if(management.getListOfProjects().contains(this) && management.userIsLoggedIn() && management.getProjectByID(this.projectID).projectLeaderID == management.getLoggedInUserID()) {
				this.projectName = projectname;
			}
			else {
				throw new OperationNotAllowedException("User is not project leader");
			}
		}
		else {
			throw new OperationNotAllowedException("Completed projects cannot be altered");
		}
	}
	public void setProjectStartDate(String StartDate, Management management) throws Exception {
		if(!this.projectState.equals("Completed")) {
			if(management.getListOfProjects().contains(this) && management.userIsLoggedIn() && management.getProjectByID(this.projectID).projectLeaderID == management.getLoggedInUserID()) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				this.startDate = formatter.parse(StartDate);
			}
			else {
				throw new OperationNotAllowedException("User is not project leader");
			}
		}
		else {
			throw new OperationNotAllowedException("Completed projects cannot be altered");
		}
	}
	public void setProjectEndDate(String endDate, Management management) throws Exception {
		if(!this.projectState.equals("Completed")) {
			if(management.getListOfProjects().contains(this) && management.userIsLoggedIn() && management.getProjectByID(this.projectID).projectLeaderID == management.getLoggedInUserID()) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				this.endDate = formatter.parse(endDate);
			}
			else {
				throw new OperationNotAllowedException("User is not project leader");
			}
		}
		else {
			throw new OperationNotAllowedException("Completed projects cannot be altered");
		}
	}
	public void setEstimatedTimeUsed(String time, Management management) throws Exception {
		if(!this.projectState.equals("Completed")) {
			if(management.getListOfProjects().contains(this) && management.userIsLoggedIn() && management.getProjectByID(this.projectID).projectLeaderID == management.getLoggedInUserID()) {
				this.estimatedTimeUsage = Integer.parseInt(time);
			}
			else {
				throw new OperationNotAllowedException("User is not project leader");
			}
		}
		else {
			throw new OperationNotAllowedException("Completed projects cannot be altered");
		}
	}
	public void setProjectState(String state, Management management) throws Exception {
		if(management.getListOfProjects().contains(this) && management.userIsLoggedIn() && management.getProjectByID(this.projectID).projectLeaderID == management.getLoggedInUserID()) {
			this.projectState = state;
		}
		else {
			throw new OperationNotAllowedException("User is not project leader");
			}
		}
	public void setProjectLeader(String EmployeeID, Management management) throws Exception {
		if(!this.projectState.equals("Completed")) {
			if(management.getListOfProjects().contains(this) && management.userIsLoggedIn() && management.getLoggedInUser().hasAdminPermissions()){
				this.projectLeaderID = EmployeeID; 
			}
			else {
				throw new OperationNotAllowedException("User does not have Admin Privilige");
			}
		}
		else {
			throw new OperationNotAllowedException("Completed projects cannot be altered");
		}
	}
	public String getProjectName() {
		return projectName;
	}
	public String getProjectID() {
		return projectID;
	}
	public String getProjectState() {
		return projectState;
	}
	public Date getProjectStartDate() {
		return startDate;
	}
	public Date getProjectEndDate() {
		return endDate;
	}
	public long getTimeUsed() {
		return startDate.getTime();
	}
	public int getEstimatedTimeUsed() {
		return estimatedTimeUsage;
	}
	public String getProjectLeader() {
		return projectLeaderID;
	}
	
	public Activity addActivity(Activity a) {
		activities.add(a);
		a.setProject(this);
		return a;
	}
	
	public Activity getActivityByID(String ID) {
		for(int i = 0; i < activities.size(); i++) {
			if(activities.get(i).getActivityID().equals(ID)) {
				return activities.get(i);
			}
		}
		return null;
	}
	
}
