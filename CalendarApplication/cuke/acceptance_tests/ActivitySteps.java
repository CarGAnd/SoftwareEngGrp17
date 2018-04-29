package cuke.acceptance_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import business_logic.Activity;
import business_logic.Admin;
import business_logic.Employee;
import business_logic.FailedLoginException;
import business_logic.Management;
import business_logic.Project;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;
//TODO: Many unused imports, remove please if not needed.
public class ActivitySteps {
	
	ErrorHandler errorHandler;
	Employee testEmployee;
	Admin testAdmin;
	Management management;
	Activity testActivity;
	Project testProject;
	
	public ActivitySteps(ErrorHandler errorHandler, Management management) {
		this.errorHandler = errorHandler;
		this.management = management;
	}
}
