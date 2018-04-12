package time_management.app;



public class Login {
	String adminID = "AD2019";
	String adminPass = "adminadmin";
	String employeePass = "";
	
	
	public void AdminLogin(String adminID, String adminPass) throws FailedLoginException {
	
		AuthenticateAdmin(adminID, adminPass);
	}

	private void AuthenticateAdmin(String adminID, String adminPass) throws FailedLoginException {
		if(adminID == this.adminID && adminPass == this.adminPass) {
		
		}
		
		else {
			throw new FailedLoginException("Incorrect ID or Pass");
		}
	}
	/*Needs a system that checks an employee's ID and compare if the password is correct.
	
	public void EmployeeLogin(String employeeID, String employeePass) throws FailedLoginException {
		
		AuthenticateEmployee();
	}

	private void AuthenticateEmployee() throws FailedLoginException {
		if(true) {
			
		}
		else {
			throw new FailedLoginException("Incorrect ID or Pass");
		}
	}*/

}
