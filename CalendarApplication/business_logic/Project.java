package business_logic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
	public void setProjectName(String projectname) throws Exception {
		if(userLoggedInHasRights()) {
			this.projectName = projectname;
		}
	}
	
	public void setProjectStartDate(String StartDate) throws Exception {
		if(userLoggedInHasRights()) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			this.startDate = formatter.parse(StartDate);
		}
	}
	public void setProjectEndDate(String endDate) throws Exception {
		if(userLoggedInHasRights()) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			this.endDate = formatter.parse(endDate);
		}
	}
	public void setEstimatedTimeUsed(String time) throws Exception {
		if(userLoggedInHasRights()) {
			this.estimatedTimeUsage = Integer.parseInt(time);
		}
	}
	public void setProjectState(String state) throws Exception {
		if(userLoggedInHasRights()) {
			this.projectState = state;
		}
	}
	public void setProjectLeader(String EmployeeID) throws Exception {
		if(management.getListOfProjects().contains(this) && management.userIsLoggedIn() && management.getLoggedInUser().hasAdminPermissions()){
			this.projectLeaderID = EmployeeID; 
		}
		else {
			throw new OperationNotAllowedException("User does not have Admin Privilige");
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
	public String getProjectLeaderID() {
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
	private boolean userLoggedInHasRights() throws OperationNotAllowedException {
		if(management.userIsLoggedIn() && this.projectLeaderID == management.getLoggedInUserID()) {
			return true;
		}
		else {
			throw new OperationNotAllowedException("User is not project leader");
		}
	
	}
}