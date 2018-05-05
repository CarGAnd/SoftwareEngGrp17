package business_logic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import business_logic.Management.userType;


public class User {
	
	private String userID;
	private String password;
	private userType typeOfUser;
	private UserCalendar userCalendar;
	

	public User(String ID, String password, userType type) {
		this.userID = ID;
		this.password = password;
		this.typeOfUser = type;
		
		userCalendar = new UserCalendar();
	}
	
	public boolean hasAdminPermissions() {
		return typeOfUser == userType.Admin;
	}
	
	public String getUserID() {
		return userID;
	}

	public void setID(String iD) {
		userID = iD;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public userType getTypeOfUser() {
		return typeOfUser;
	}

	public void setTypeOfUser(userType typeOfUser) {
		this.typeOfUser = typeOfUser;
	}
	public UserCalendar registerAbsence(Absence Abs) {
		userCalendar.addAbsence(Abs);
		return null;
	}
	
	
	public ArrayList<Absence> getAbsence() {
		return userCalendar.getAbsence();
	}

    public void updateRegisteredHours(Date date, double hours) throws OperationNotAllowedException {
    	userCalendar.registerHours(date, hours);
    }


	public double getRegisteredHoursByDate(Date date) {
		return userCalendar.getRegisteredHours().get(date);
	}
    
	public Map<Date, Double> getRegisteredHours() {
		return userCalendar.getRegisteredHours();
	}
	
	public boolean checkAbsent() {
		Date date = new Date();
		return userCalendar.isAbsent(date);
	}
	
	public boolean checkAbsentByDate(Date date) {
		return userCalendar.isAbsent(date);
	}
	
	public boolean checkAvailability(Date startDate, Date endDate) {
		return userCalendar.isUserAvailable(startDate, endDate);
		
	}
}
	


