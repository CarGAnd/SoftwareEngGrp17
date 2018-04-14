package business_logic;

import java.util.ArrayList;

public class Employee {

	String employeePass;
	String employeeID;
	
	public ArrayList<Project> leaderOfProjects;
	private ArrayList<Activity> memberOfActivities;
	
	public Employee(String employeePass, String employeeID) {
	
		employeeID = this.employeeID;
		employeePass = this.employeePass;
	}
	
	public void addActivityToEmployee(Activity act) {
		memberOfActivities.add(act);
	}
}
