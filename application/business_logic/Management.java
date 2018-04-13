package business_logic;

import java.util.ArrayList;

public class Management {
	
	private static String loggedInUserID;
	private static userType loggedInUserType;
	private static ArrayList<Employee> employees = new ArrayList<Employee>();
	private static ArrayList<Admin> admins = new ArrayList<Admin>();
	private static ArrayList<Project> listOfProjects = new ArrayList<Project>();
		
	public static boolean userIsLoggedIn() {
		return loggedInUserType != null;
	}
	
	public static void employeeLogin(String ID, String password) throws FailedLoginException {
		Employee user = getEmployeeByID(ID);
		if(user != null && password.equals(user.employeePass)) {
			setLoggedInUserType(userType.Employee);
			setLoggedInUserID(ID);
		}
		else {
			throw new FailedLoginException("incorrect ID or password");
		}
	}
	
	public static void adminLogin(String ID, String password) throws FailedLoginException {
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
	
	public static void removeEmployee(Employee emp) {
		employees.remove(emp);
	}
	
	public static void addAdmin(Admin ad) {
		admins.add(ad);
	}
	
	public static void removeAdmin(Admin ad) {
		admins.remove(ad);
	}
	
	public static Project addProject(Project pro) {
		listOfProjects.add(pro);
		return pro;
	}
	
	public static Project removeProject(Project pro) {
		listOfProjects.remove(pro);
		return pro;
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
		
		public int toInteger() { 
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
	
	public static Project getProjectByID(String ID) {
		for(int i = 0; i < listOfProjects.size(); i++) {
			if(listOfProjects.get(i).projectID.equals(ID)) {
				return listOfProjects.get(i);
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
