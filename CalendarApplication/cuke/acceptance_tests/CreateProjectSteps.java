package cuke.acceptance_tests;

import business_logic.Management;

public class CreateProjectSteps {
	private Management managementApp;

	public <managementApp> CreateProjectSteps(managementApp timeManagementApp) {
		this.managementApp = managementApp;//TODO: Warning that the assignment has no effect..
	}
}