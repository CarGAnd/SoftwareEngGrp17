package business_logic;

import java.util.ArrayList;

public class Management {
	
	private User loggedInUser;
	private ArrayList<Project> listOfProjects = new ArrayList<Project>();
	private ArrayList<User> users = new ArrayList<User>();
	
	public static void main(String[] args) {
		
	}
	
	public Management() {
		users.add(new Admin());
	}
	
	public boolean userIsLoggedIn() {
		return loggedInUser != null;
	}
	
	public boolean adminIsLoggedIn() {
		return userIsLoggedIn() && loggedInUser.getTypeOfUser() == userType.Admin;
	}
	
	public boolean employeeIsLoggedIn() {
		return userIsLoggedIn() && loggedInUser.getTypeOfUser() == userType.Employee;
	}
	
	public boolean userLogin(String ID, String password) throws FailedLoginException {
		if(userIsLoggedIn()) {
			throw new FailedLoginException("another user is already logged in");
		}
		else {
			User user = getUserByID(ID);
			if(user != null && password.equals(user.getPassword())) {
				setLoggedInUser(user);
				return true;
			}
			else {
				throw new FailedLoginException("incorrect ID or password");
			}
		}
	}
	
	public void logUserOut() {
		setLoggedInUser(null);
	}
	

	public User addUser(User emp) {
		if(!users.contains(emp)) {
			users.add(emp);			
		}
		return emp;
	}
	
	public void removeUser(User user) {
		users.remove(user);
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
				return "Admin";
			case Employee:
				return "Employee";
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
	
	public User getUserByID(String ID) {
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getUserID().equals(ID)) {
				return users.get(i);
			}
		}
		return null;
	}
	
	public Project getProjectByID(String ID) {
		for(int i = 0; i < listOfProjects.size(); i++) {
			if(listOfProjects.get(i).getProjectID().equals(ID)) {
				return listOfProjects.get(i);
			}
		}
		return null;
	}
	
	public ArrayList<User> getAdmins(){ // returns all users that are admins. does not return users that are employees
		ArrayList<User> admins = new ArrayList<User>();
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getTypeOfUser() == userType.Admin) {
				admins.add(users.get(i));
			}
		}
		return admins;
	}
	
	public ArrayList<User> getEmployees(){ // returns all users that are employees. does not return users that are admins
		ArrayList<User> employees = new ArrayList<User>();
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getTypeOfUser() == userType.Employee) {
				employees.add(users.get(i));
			}
		}
		return employees;
	}
		
	public userType getLoggedInUserType() {
		return userIsLoggedIn() ? getLoggedInUser().getTypeOfUser() : null;
	}

	public String getLoggedInUserID() {
		return userIsLoggedIn() ? getLoggedInUser().getUserID() : null;
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}

	public ArrayList<Project> getListOfProjects() {
		return listOfProjects;
	}
	
	public User getLoggedInUser() {
		return loggedInUser;
	}

	private void setLoggedInUser(User loggedInUser) {
		this.loggedInUser = loggedInUser;
	}
}