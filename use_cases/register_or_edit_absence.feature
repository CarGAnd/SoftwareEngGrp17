Feature: xxx
	Description: xxx
	Actor: xxx
	
#comment
Scenario: Register sick
	Given an employee wishes to register his absence due to illness
	And the employee is logged in with his ID
	When the employee registers his absence
	Then his absence is registered within the system

Scenario: No longer sick (got better)
	Given an employee has registered sick
	And the employee is logged in with his ID
	When the employee becomes available
	Then the employee is no longer registered sick

Scenario: Register vacation
	Given an employee wishes to schedule a vacation
	And the employee is logged in with his ID
	When the employee tries to register a vacation
	And he schedules a time period for the vacation
	Then the employee has scheduled a vacation

Scenario: Edit vacation
	Given an employee has already scheduled a vacation
	And he wishes to edit the time or length of his vacation
	When the employee enters the new information
	Then his scheduled vacation is updated within the system