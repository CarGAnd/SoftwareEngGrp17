package business_logic;

import business_logic.Management.userType;

public class Admin extends User{
	
	public Admin(){
		super("admin","adminadmin", userType.Admin);
	}
}
