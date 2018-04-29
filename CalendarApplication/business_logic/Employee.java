package business_logic;

import java.util.ArrayList;

import business_logic.Management.userType;

public class Employee extends User {

	public ArrayList<Project> leaderOfProjects;
	private ArrayList<Activity> memberOfActivities;
	
	public Employee(String employeeID, String employeePass) {
		super(employeeID, employeePass, userType.Employee);
		
	}
	
	public void addActivityToEmployee(Activity act) {
		memberOfActivities.add(act);
	}
}
