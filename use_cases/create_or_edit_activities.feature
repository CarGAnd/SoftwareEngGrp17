Feature: Create or edit an activity for a project
	Description: Create or edit an activity for a project
	Actor: Employee

#Scenario: Create an activity
#	Given a user is logged in 
#	And a project exists
#	And the logged in user's ID matches the project leader ID
#	When the user creates an activity in the project with the description "test description" and the due date "01-01-2020" and 20 estimated work hours
#	Then an activity is created in the project with the description "test description" and the due date "01-01-2020" and 20 estimated work hours
	
#Scenario: Finish an activity
#	Given a project exists and a user wishes to edit an activity for that project
#	And the user ID matches the project leader ID
#	When the user changes the status of the activity to "finished"
#	Then the activity status is changed to "finished"
#
#Scenario: Edit an activity
#	Given a project exists and a user wishes to edit an activity for that project
#	And the user ID matches the project leader ID
#	And the project status is not "finished"
#	Then the activity is edited
#	
#Scenario: Edit a finished activity
#	Given a project exists and a user wishes to edit an activity for that project
#	And the user ID matches the project leader ID
#	And the activity is finished
#	When the user edits details
#	Then the user gets an error message
#	
#Scenario: Non-project leader attempts to edit activity
#	Given a project exists and a user wishes to edit an activity for that project
#	And the user ID does not match the project leader ID
#	When the user edits details
#	Then the project leader is notified
#	And the user gets an error message