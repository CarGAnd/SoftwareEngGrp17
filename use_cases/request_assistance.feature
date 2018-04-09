Scenario: Request assistance from available employee
	Given an employee requires assistance
	And the employee is working on an activity
	And the requested employee is available
	And the requested employee does not have 20 activities
	Then the requested employee is assigned to the activity

Scenario: Request assistance from busy employee
	Given an employee requires assistance
	And the employee is working on an activity
	And the requested employee is busy
	Then the user is asked to request for a different employee if possible

Scenario: Request assistance from absent employee
	Given an employee requires assistance
	And the employee is working on an activity
	And the requested employee is absent
	Then the user is asked to request for a different employee