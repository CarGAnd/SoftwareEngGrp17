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
	private String projectLeaderID;
	private ArrayList<Employee> listOfEmployees;
	private String projectID;
	
	public Activity(Project project, Date dueDate, int estimatedTime, String description) {
		this.name = "";
		this.activityID = "";
		this.endDate = dueDate;
		this.description = description;
		this.estimatedTime = estimatedTime;
		this.projectLeaderID = project.getProjectLeaderID();
		this.projectID = project.getProjectID();
		this.activityStatus = "";		
	}

	public void addEmployeeToActivity(Employee emp) {
		listOfEmployees.add(emp);
		emp.addActivityToEmployee(this);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActivityID() {
		return activityID;
	}

	public void setActivityID(String activityID) {
		this.activityID = activityID;
	}

	public int getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(int estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	public int getTimeUsed() {
		return timeUsed;
	}

	public void setTimeUsed(int timeUsed) {
		this.timeUsed = timeUsed;
	}

	public String getActivityStatus() {
		return activityStatus;
	}

	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getProjectLeaderID() {
		return projectLeaderID;
	}

	public void setProjectLeaderID(String projectLeaderID) {
		this.projectLeaderID = projectLeaderID;
	}

	public ArrayList<Employee> getListOfEmployees() {
		return listOfEmployees;
	}
	
	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}
	

}
