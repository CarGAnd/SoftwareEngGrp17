Scenario: Project Leader checks project status
	Given the user ID matches the project leader ID
	When the user assesses a project’s status
	Then he receives a list of activities in the project and their status

Scenario: employee checks project status
	Given the user ID does not match the project leader ID
	When the user assesses a project’s status
	Then the user gets the error message "Access Denied"