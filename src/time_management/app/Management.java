package time_management.app;

import java.util.ArrayList;

public class Management {
	
	public static ArrayList<Employee> Employees = new ArrayList<Employee>();
	private static String loggedInUserID;
	private static userType loggedInUserType;
	private static ArrayList<Employee> employees = new ArrayList<Employee>();
	private static ArrayList<Admin> admins = new ArrayList<Admin>();
		
	public static boolean userIsLoggedIn() {
		return loggedInUserType != null;
	}
	
	public static void logEmployeeIn(String ID, String password) throws FailedLoginException {
		Employee user = getEmployeeByID(ID);
		if(user != null && password.equals(user.employeePass)) {
			setLoggedInUserType(userType.Employee);
			setLoggedInUserID(ID);
		}
		else {
			throw new FailedLoginException("incorrect ID or password");
		}
	}
	
	public static void logAdminIn(String ID, String password) throws FailedLoginException {
		Admin user = getAdminByID(ID);
		if(user != null && password.equals(user.adminPass)) {
			setLoggedInUserType(userType.Admin);
			setLoggedInUserID(ID);
		}
		else {
			throw new FailedLoginException("incorrect ID or password");
		}
	}
	
	public static void logUserOut() {
		setLoggedInUserType(null);
		setLoggedInUserID(null);
	}
	
	public static void addEmployee(Employee emp) {
		employees.add(emp);
	}
	
	public static void addAdmin(Admin ad) {
		admins.add(ad);
	}
	
	public enum userType{
		Admin,Employee; //all the types of users
		
		public String toString() {
			switch(this) {
			case Admin:
				return "admin";
			case Employee:
				return "employee";
			default:
				return null;			
			}
		}
		
		public int powerLevel() { 
			switch(this) {
			case Admin:
				return 10;
			case Employee:
				return 1;
			default:
				return 0;			
			}
		}
	}
	
	public static Employee getEmployeeByID(String ID) {
		for(int i = 0; i < employees.size(); i++) {
			if(employees.get(i).employeeID.equals(ID)) {
				return employees.get(i);
			}
		}
		return null;
	}
	
	public static Admin getAdminByID(String ID) {
		for(int i = 0; i < admins.size(); i++) {
			if(admins.get(i).adminID.equals(ID)) {
				return admins.get(i);
			}
		}
		return null;
	}
	public static userType getLoggedInUserType() {
		return loggedInUserType;
	}


	public static void setLoggedInUserType(userType loggedInUserType) {
		Management.loggedInUserType = loggedInUserType;
	}


	public static String getLoggedInUserID() {
		return loggedInUserID;
	}


	public static void setLoggedInUserID(String loggedInUserID) {
		Management.loggedInUserID = loggedInUserID;
	}
}
