Feature: Request assistance from employees'
	Description: An employee requests assistance to a task from another employee.
	Actor: user
Background:
	Given an employee exists with the ID "Tester" and the password "passy"
	And an employee exists with the ID "SomeID" and the password "passy"
	And a project with the ID "project" exists
	And an activity with the ID "test" exists in the project with the ID "project"

Scenario: Request assistance from available employee
	Given the user with ID "Tester" is working on an activity with ID "test"
	And there is an available employee
	When the user with ID "Tester" requests assistance
	Then the available employee is assigned to the activity

#Scenario: Request assistance from absent employee
#	Given the user with ID "Tester" is working on an activity with ID "ID1234"
#	And there is no available employees
#	When the user with ID "Tester" requests assistance
#	Then the user gets the error message "There are no available employees" 