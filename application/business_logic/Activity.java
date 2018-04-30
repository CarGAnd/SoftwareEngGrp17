package business_logic;

import java.util.ArrayList;
import java.util.Date;

public class Activity {
	
	private String name;
	private String activityID;
	private int estimatedTime;
	private int timeUsed;
	private String activityStatus;
	private String description;
	private Date startDate;
	private Date endDate;
	private ArrayList<Employee> listOfEmployees;
	private Project project;
	
	public Activity(String ID, Date dueDate, int estimatedTime, String description) {
		assert dueDate.getTime() > System.currentTimeMillis();
		this.name = "";
		this.activityID = ID;
		this.endDate = dueDate;
		this.description = description;
		this.estimatedTime = estimatedTime;
		this.activityStatus = "";	
		listOfEmployees = new ArrayList<Employee>();
		
	}
	
	public Activity(Project pro, String ID, Date dueDate, int estimatedTime, String description) {
		this(ID,dueDate,estimatedTime,description);
		pro.addActivity(this);
	}

	public void addEmployeeToActivity(Employee emp) {
		listOfEmployees.add(emp);
		emp.addActivityToEmployee(this);
	}
	
	private boolean loggedInUserHasPermission() {
		return project.management.userIsLoggedIn() && project.management.getLoggedInUserID().equals(project.getProjectLeader());
	}
	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws OperationNotAllowedException {
		if(loggedInUserHasPermission()){
			this.name = name;
		}
		else {
			throw new OperationNotAllowedException("user must be project leader to change project details");
		}
	}

	public String getActivityID() {
		return activityID;
	}

	public void setActivityID(String activityID) throws OperationNotAllowedException {
		if(loggedInUserHasPermission()){
			this.activityID = activityID;
		}
		else {
			throw new OperationNotAllowedException("user must be project leader to change project details");
		}
	}

	public int getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(int estimatedTime) throws OperationNotAllowedException {
		if(loggedInUserHasPermission()){
			this.estimatedTime = estimatedTime;
		}
		else {
			throw new OperationNotAllowedException("user must be project leader to change project details");
		}
	}

	public int getTimeUsed() {
		return timeUsed;
	}

	public void setTimeUsed(int timeUsed) throws OperationNotAllowedException {
		if(loggedInUserHasPermission()){
			this.timeUsed = timeUsed;
		}
		else {
			throw new OperationNotAllowedException("user must be project leader to change project details");
		}
	}

	public String getActivityStatus() {
		return activityStatus;
	}

	public void setActivityStatus(String activityStatus) throws OperationNotAllowedException {
		if(loggedInUserHasPermission()){
			this.activityStatus = activityStatus;
		}
		else {
			throw new OperationNotAllowedException("user must be project leader to change project details");
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) throws OperationNotAllowedException {
		if(loggedInUserHasPermission()){
			this.description = description;
		}
		else {
			throw new OperationNotAllowedException("user must be project leader to change project details");
		}
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) throws OperationNotAllowedException {
		if(loggedInUserHasPermission()){
			this.startDate = startDate;
		}
		else {
			throw new OperationNotAllowedException("user must be project leader to change project details");
		}
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) throws OperationNotAllowedException {
		if(loggedInUserHasPermission()){
			this.endDate = endDate;
		}
		else {
			throw new OperationNotAllowedException("user must be project leader to change project details");
		}
	}

	public ArrayList<Employee> getListOfEmployees() {
		return listOfEmployees;
	}
}
