Feature: xxx
	Description: xxx
	Actor: xxx
	
Scenario: Register sick
	Given a user is logged in with his ID
	When the user registers his absence
	Then his absence is registered within the system

#Scenario: No longer sick (got better)
#	Given an employee has registered sick
#	And the employee is logged in with his ID
#	When the employee becomes available
#	Then the employee is no longer registered sick
#
#Scenario: Register vacation
#	Given an employee wishes to schedule a vacation
#	And the employee is logged in with his ID
#	When the employee tries to register a vacation
#	And he schedules a time period for the vacation
#	Then the employee has scheduled a vacation
#
#Scenario: Edit vacation
#	Given an employee has already scheduled a vacation
#	And he wishes to edit the time or length of his vacation
#	When the employee enters the new information
#	Then his scheduled vacation is updated within the system
#
#Scenario: Input is invalid
#	Given an employee wishes to register or edit his working hours of a day
#	And the employee is logged in with his ID
#	When he tries to register or edit his working hours
#	And the input is invalid
#	Then he gets an error message
#	
#Scenario: Edit time
#	Given an employee wishes to edit the number of hours he has worked
#	And the employee is logged in with his ID
#	And the employee has already registered the number of hours he has worked
#	When the employee edits the number of hours he has worked
#	Then the number of hours he has worked is updated within the system
#	
#Scenario: Register time
#	Given an employee wishes to register how many hours he has worked
#	And the employee is logged in with his ID
#	When he enters the number of hours worked
#	Then the number of hours is registered within the system
#	
#Scenario: Register time worked in an absent period
#	Given an employee wishes to register his working hours
#	And the employee is logged in with his ID
#	And the employee was absent
#	When he enters the number of hours worked
#	Then the employee gets an error message