package business_logic;

import business_logic.Management.userType;

public class User {
	
	private String userID;
	private String password;
	private userType typeOfUser;

	public User(String ID, String password, userType type) {
		this.userID = ID;
		this.password = password;
		this.typeOfUser = type;
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
}
