package business_logic;

import java.util.ArrayList;

public class Employee {

	String employeePass;
	private String employeeID;
	
	

	public ArrayList<Project> leaderOfProjects;
	private ArrayList<Activity> memberOfActivities;
	
	public Employee(String employeeID, String employeePass) {
	
		this.employeeID = employeeID;
		this.employeePass = employeePass;
		
	}
	
	public void addActivityToEmployee(Activity act) {
		memberOfActivities.add(act);
	}
	
	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
}
