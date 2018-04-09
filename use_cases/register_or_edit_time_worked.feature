Feature: xxx
	Description: xxx
	Actor: xxx
	
#comment
Scenario: Input is invalid
	Given an employee wishes to register or edit his working hours of a day
	And the employee is logged in with his ID
	When he tries to register or edit his working hours
	And the input is invalid
	Then he gets an error message
	
Scenario: Edit time
	Given an employee wishes to edit the number of hours he has worked
	And the employee is logged in with his ID
	And the employee has already registered the number of hours he has worked
	When the employee edits the number of hours he has worked
	Then the number of hours he has worked is updated within the system
	
Scenario: Register time
	Given an employee wishes to register how many hours he has worked
	And the employee is logged in with his ID
	When he enters the number of hours worked
	Then the number of hours is registered within the system
	
Scenario: Register time worked in an absent period
	Given an employee wishes to register his working hours
	And the employee is logged in with his ID
	And the employee was absent
	When he enters the number of hours worked
	Then the employee gets an error message