Feature: Create a project or edit the details of an existing project.
	Description: 
	Actor: Administrator and Project Leader

Scenario: Create a project
	Given the user is logged in as an administrator
	When a project with name "name" ID "ID1234" start date "4/12/2020" end date "4/2/2021" and estimated time used "40" is created 
	Then the project is created
	
Scenario: Remove a project
	Given a project with the ID "project" exists
	And an adminstrator exists
	And an adminstrator is logged in
	When the adminstrator removes the project with the ID "project"
	Then the project is removed from the list of projects

Scenario: Non-project leader attempts to edit project details
	Given a project with ID "ID1234" exists
	And the user ID "NewUser" does not match the project leader ID
	When the user sets the project name to "BadName"
	And the user gets the error message "User is not project leader"
	
Scenario: Admin sets project leader
	Given a project with ID "ID1234" exists
	And the user is logged in as an administrator
	And the project does not have a leader
	When the admin designates an employee to be project leader
	Then the employee becomes project leader for the project

