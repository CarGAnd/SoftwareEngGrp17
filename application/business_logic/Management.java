package business_logic;

import java.util.ArrayList;

public class Management {
	
	private static userType loggedInUserType;
	private static String loggedInUserID;
	private static ArrayList<Employee> employees = new ArrayList<Employee>();
	private static ArrayList<Admin> admins = new ArrayList<Admin>();
	private static ArrayList<Project> listOfProjects = new ArrayList<Project>();
	
	public static void main(String[] args) {
		
	}
	
	public static boolean userIsLoggedIn() {
		return loggedInUserType != null;
	}
	
	public static boolean adminIsLoggedIn() {
		return loggedInUserType == userType.Admin;
	}
	
	public static boolean employeeIsLoggedIn() {
		return loggedInUserType == userType.Employee;
	}
	
	public static boolean employeeLogin(String ID, String password) throws FailedLoginException {
		if(userIsLoggedIn()) {
			throw new FailedLoginException("another user is already logged in");
		}
		else {
			Employee user = getEmployeeByID(ID);
			if(user != null && password.equals(user.employeePass)) {
				setLoggedInUserType(userType.Employee);
				setLoggedInUserID(ID);
				return true;
			}
			else {
				throw new FailedLoginException("incorrect ID or password");
			}
		}
	}
	
	public static boolean adminLogin(String ID, String password) throws FailedLoginException {
		if(userIsLoggedIn()) {
			throw new FailedLoginException("another user is already logged in");
		}
		else {
			Admin user = getAdminByID(ID);
			if(user != null && password.equals(user.adminPass)) {
				setLoggedInUserType(userType.Admin);
				setLoggedInUserID(ID);
				return true;
			}
			else {
				throw new FailedLoginException("incorrect ID or password");
			}
		}
	}
	
	public static void logUserOut() {
		setLoggedInUserType(null);
		setLoggedInUserID(null);
	}
	
	public static Employee addEmployee(Employee emp) {
		if(!employees.contains(emp)) {
			employees.add(emp);			
		}
		return emp;
	}
	
	public static void removeEmployee(Employee emp) {
		employees.remove(emp);
	}
	
	public static Admin addAdmin(Admin ad) {
		if(!admins.contains(ad)) {
			admins.add(ad);
		}
		return ad;
	}
	
	public static void removeAdmin(Admin ad) throws Exception {
		if(admins.size() > 1) {
			admins.remove(ad);
		}
		else {
			throw new Exception("must be at least one admin");
		}
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
		
		@Override
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
			if(employees.get(i)
					.getEmployeeID()
					.equals(ID)) {
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
			if(listOfProjects.get(i).getProjectID().equals(ID)) {
				return listOfProjects.get(i);
			}
		}
		return null;
	}
	
	public static userType getLoggedInUserType() {
		return loggedInUserType;
	}

	private static void setLoggedInUserType(userType loggedInUserType) {
		Management.loggedInUserType = loggedInUserType;
	}

	public static String getLoggedInUserID() {
		return loggedInUserID;
	}

	private static void setLoggedInUserID(String loggedInUserID) {
		Management.loggedInUserID = loggedInUserID;
	}
	
	public static ArrayList<Employee> getEmployees() {
		return employees;
	}

	public static ArrayList<Admin> getAdmins() {
		return admins;
	}

	public static ArrayList<Project> getListOfProjects() {
		return listOfProjects;
	}
}