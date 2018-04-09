Use case: Add or remove employee to or from activity

Scenario: Add employee to activity
	Given a project exists and a user wishes to add an employee
	And the user ID matches the project leader ID
	And the employee does not have more than 20 activities
	And the employee is not absent during the period of the activity
	When the user adds the employee to the activity
	Then the employee is added to the activity
	
Scenario: Remove employee from activity
	Given a project exists and a user wishes to remove an employee
	And the user ID matches the project leader ID
	And the employee is assigned to the activity
	When the user removes the employee to the activity
	Then the employee is removed to the activity
	
Scenario: Add busy employee to activity
	Given a project exists and a user wishes to add an employee
	And the user ID matches the project leader ID
	And the employee is busy
	When the user adds the employee to the activity
	Then the user gets an error message
	
Scenario: Add absent employee to activity
	Given a project exists and a user wishes to add an employee
	And the user ID matches the project leader ID
	And the employee is absent
	When the user adds the employee to the activity
	Then the user gets an error message
	
Scenario: Remove a employee not assigned to activity
	Given a project exists and a user wishes to remove an employee
	And the user ID matches the project leader ID
	And the employee is not assigned to the activity
	When the user removes the employee to the activity
	Then the user gets an error message