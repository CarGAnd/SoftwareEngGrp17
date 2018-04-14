package business_logic;

import java.util.ArrayList;
import java.util.Date;

public class Activity {
	
	String name;
	String activityID;
	int estimatedTime;
	int timeUsed;
	String activityStatus;
	Date startDate;
	Date endDate;
	String projectLeaderID;
	private ArrayList<Employee> listOfEmployees;
	
	public Activity() {
		
	}
	
	public void addEmployeeToActivity(Employee emp) {
		listOfEmployees.add(emp);
		emp.addActivityToEmployee(this);
	}
	

}
