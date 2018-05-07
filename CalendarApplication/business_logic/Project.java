package business_logic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/*
 * @author Carsten Andersen
 */

public class Project {
	public ArrayList<Activity> activities;
	String projectName;
	private String projectID;

	String adminID;
	String adminPass;
	String projectLeaderID = "";
	Date startDate;
	Date endDate;
	int estimatedTimeUsage;
	String projectState;
	Management management;

	public Project(String projectname, String projectID, Date startDate, Date endDate, int estimatedTimeUsage) {
		
		this.projectName = projectname;
		this.projectID = projectID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.estimatedTimeUsage = estimatedTimeUsage;

		
		activities = new ArrayList<Activity>();
	}
	
	public Activity createActivity(String description, String ID, Date dueDate, int estimatedTime) throws Exception { // creates a project and adds it to the management object
		ArrayList<Activity> actAtPre = new ArrayList<>(activities);
		if(management.getLoggedInUserID().equals(this.projectLeaderID)) { 
			assert management.getLoggedInUserID().equals(this.getProjectLeaderID()); //pre
			Activity activity = new Activity(ID,dueDate,estimatedTime,description); 
			this.addActivity(activity); 
			actAtPre.add(activity);
			assert this.activities.equals(actAtPre);
			return activity;
		}
		else {
			throw new OperationNotAllowedException("Insufficient permissions");
		}
		
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
			if(!projectLeaderID.equals("")){
				Employee user = (Employee) (management.getUserByID(projectLeaderID));
				user.leaderOfProjects.remove(this);
			}
			this.projectLeaderID = EmployeeID; 
			Employee user = (Employee) (management.getUserByID(EmployeeID));
			user.leaderOfProjects.add(this);
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
		if(management.userIsLoggedIn() && this.projectLeaderID.equals(management.getLoggedInUserID())) {
			return true;
		}
		else {
			throw new OperationNotAllowedException("User is not project leader");
		}
	
	}
}
