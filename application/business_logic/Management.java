package business_logic;

import java.util.ArrayList;

public class Management {
	
	private userType loggedInUserType;
	private String loggedInUserID;
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	private ArrayList<Admin> admins = new ArrayList<Admin>();
	private ArrayList<Project> listOfProjects = new ArrayList<Project>();
	
	public Management() {
		this.addAdmin(new Admin()); 
	}
	
	public static void main(String[] args) {
		
	}
	
	public boolean userIsLoggedIn() {
		return loggedInUserType != null;
	}
	
	public boolean adminIsLoggedIn() {
		return loggedInUserType == userType.Admin;
	}
	
	public boolean employeeIsLoggedIn() {
		return loggedInUserType == userType.Employee;
	}
	
	public void employeeLogin(String ID, String password) throws FailedLoginException {
		Employee user = getEmployeeByID(ID);
		if(user != null && password.equals(user.employeePass)) {
			setLoggedInUserType(userType.Employee);
			setLoggedInUserID(ID);
		}
		else {
			throw new FailedLoginException("incorrect ID or password");
		}
	}
	
	public void adminLogin(String ID, String password) throws FailedLoginException {
		Admin user = getAdminByID(ID);
		if(user != null && password.equals(user.adminPass)) {
			setLoggedInUserType(userType.Admin);
			setLoggedInUserID(ID);
		}
		else {
			throw new FailedLoginException("incorrect ID or password");
		}
	}
	
	public void logUserOut() {
		setLoggedInUserType(null);
		setLoggedInUserID(null);
	}
	
	public void addEmployee(Employee emp) {
		employees.add(emp);
	}
	
	public void removeEmployee(Employee emp) {
		employees.remove(emp);
	}
	
	public void addAdmin(Admin ad) {
		admins.add(ad);
	}
	
	public void removeAdmin(Admin ad) {
		admins.remove(ad);
	}
	
	public Project addProject(Project pro) {
		listOfProjects.add(pro);
		return pro;
	}
	
	public Project removeProject(Project pro) {
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
	
	public Employee getEmployeeByID(String ID) {
		for(int i = 0; i < employees.size(); i++) {
			if(employees.get(i).employeeID.equals(ID)) {
				return employees.get(i);
			}
		}
		return null;
	}
	
	public Admin getAdminByID(String ID) {
		for(int i = 0; i < admins.size(); i++) {
			if(admins.get(i).adminID.equals(ID)) {
				return admins.get(i);
			}
		}
		return null;
	}
	
	public Project getProjectByID(String ID) {
		for(int i = 0; i < listOfProjects.size(); i++) {
			if(listOfProjects.get(i).projectID.equals(ID)) {
				return listOfProjects.get(i);
			}
		}
		return null;
	}
	
	public userType getLoggedInUserType() {
		return loggedInUserType;
	}


	public void setLoggedInUserType(userType loggedInUserType) {
		this.loggedInUserType = loggedInUserType;
	}


	public String getLoggedInUserID() {
		return loggedInUserID;
	}


	public void setLoggedInUserID(String loggedInUserID) {
		this.loggedInUserID = loggedInUserID;
	}
}
