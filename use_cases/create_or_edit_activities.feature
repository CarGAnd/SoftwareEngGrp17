Feature: Create or edit an activity for a project
	Description: Create or edit an activity for a project
	Actor: Employee

Background: a project exists
	Given a project with the ID "project" exists
	And the projects leader has the ID "test"

Scenario: Create an activity
	Given an employee exists with the ID "test" and the password "password"
	And an employee with the ID "test" and the password "password" is logged in
	And the logged in user's ID matches the project leader ID
	When the user creates an activity in the project with the description "test description" and the due date "01/01/2020" and 20 estimated work hours and the ID "test"
	Then an activity is created in the project with the description "test description" and the due date "01/01/2020" and 20 estimated work hours and the Id "test"
	
Scenario: Finish an activity
	Given an employee exists with the ID "test" and the password "password"
	And an employee with the ID "test" and the password "password" is logged in
	And the logged in user's ID matches the project leader ID
	And an activity with the ID "test" exists in the project with the ID "project"
	When the user changes the status of the activity to "finished"
	Then the activity status is changed to "finished"

Scenario: Edit an activity
	Given an employee exists with the ID "test" and the password "password"
	And an activity with the ID "test" exists in the project with the ID "project"
	And an employee with the ID "test" and the password "password" is logged in
	And the logged in user's ID matches the project leader ID
	And the activity status is not "finished"
	When the user edits the name of the activity to "testName"
	Then the activity's name is edited to "testName"
	
#Scenario: Edit a finished activity
#	And the logged in user's ID matches the project leader ID
#	And the status of the activity is "finished"
#	When the user edits the name of the activity
#	Then the user gets an error message
#	
#Scenario: Non-project leader attempts to edit activity
#	And the logged in user's ID does not match the project leader ID
#	When the user edits the name of the activity
#	Then the project leader is notified
#	And the user gets an error message