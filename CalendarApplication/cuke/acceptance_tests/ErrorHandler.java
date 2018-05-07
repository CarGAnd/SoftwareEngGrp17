package cuke.acceptance_tests;

import business_logic.Absence;
import business_logic.Activity;
import business_logic.Employee;
import business_logic.Project;
import business_logic.User;

/*
 * @author Andreas Handberg
 */

public class ErrorHandler {
	
	public String errorMessage;
	public Project testProject;
	public Activity testActivity;
	public Employee testEmployee;
	public Employee testEmployee2;
	public Absence testAbsence;
	public User testUser;
	
	public ErrorHandler() {
		
	}
}
