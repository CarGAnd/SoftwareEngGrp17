Feature: xxx
	Description: xxx
	Actor: xxx
	
#comment
#Scenario: Create an activity
#	Given a project exists and a user wishes to create an activity for that project
#	And the user ID matches the project leader ID
#	When the user enters a description for the activity
#	And the users enters a due date for the activity
#	And the user enters an estimated number of works hours
#	Then an activity is created in the system with an ID
#	
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