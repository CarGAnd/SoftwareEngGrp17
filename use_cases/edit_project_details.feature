Feature: xxx
	Description: xxx
	Actor: xxx
	
#comment
Scenario: Project is finished
	Given a project exists and a user wishes to edit the project details
	And the user ID matches project leader ID
	And the project is finished
	Then the user gets an error message
	
Scenario: Project is not finished
	Given a project exists and a user wishes to edit the project details
	And the user ID matches the project leader ID
	And the project is not finished
	When the user edits the details of the project
	Then the updates to the project are registered
	
Scenario: Non-project leader attempts to edit project details
	Given a project exists and a user wishes to edit the project details
	And the user ID does not match the project leader ID
	When the user edits the details of the project
	Then the project leader is notified
	And the user gets an error message