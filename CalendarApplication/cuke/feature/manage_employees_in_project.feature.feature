Feature: add and remove employees to and from activities
	Description: manage employees and activities
	Actor: Employee
	
Background:
	Given a project with the ID "project" exists
	And the projects leader has the ID "test"
	And an employee exists with the ID "test" and the password "password"
	And an activity with the ID "test" exists in the project with the ID "project"
	
Scenario: Add employee to activity
	Given an employee with the ID "test" and the password "password" is logged in
	And the logged in user's ID matches the project leader ID
	And the employee with the ID "test" does not have more than 20 activities
#	And the employee is not absent during the period of the activity
	When the user adds the employee to the activity
	Then the employee is added to the activity
#	
#Scenario: Remove employee from activity
#	Given a project exists and a user wishes to remove an employee
#	And the user ID matches the project leader ID
#	And the employee is assigned to the activity
#	When the user removes the employee to the activity
#	Then the employee is removed to the activity
#	
#Scenario: Add busy employee to activity
#	Given a project exists and a user wishes to add an employee
#	And the user ID matches the project leader ID
#	And the employee is busy
#	When the user adds the employee to the activity
#	Then the user gets an error message
#	
#Scenario: Add absent employee to activity
#	Given a project exists and a user wishes to add an employee
#	And the user ID matches the project leader ID
#	And the employee is absent
#	When the user adds the employee to the activity
#	Then the user gets an error message
#	
#Scenario: Remove a employee not assigned to activity
#	Given a project exists and a user wishes to remove an employee
#	And the user ID matches the project leader ID
#	And the employee is not assigned to the activity
#	When the user removes the employee to the activity
#	Then the user gets an error message
#
