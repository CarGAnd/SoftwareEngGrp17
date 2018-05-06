Feature: xxx
	Description: xxx
	Actor: xxx
	
Background:
	Given an employee exists with the ID "test" and the password "password"
	
Scenario: Register Absence
	Given an employee with the ID "test" and the password "password" is logged in
	When the employee registers his absence from "01/01/12" to "02/01/12"
	Then his absence is registered within the system

Scenario: Edit Absence
	Given an employee with the ID "test" and the password "password" is logged in
	And the employee has registered absence
	When the user edits his absence to "01/02/12" to "02/03/12"
	Then the absence's start date is "01/02/12" and the end date is "02/03/12"
	
Scenario: Edit time
	Given an employee with the ID "test" and the password "password" is logged in
	And the user has already registered the number of hours he has worked on "01/01/01"
	When the user edits the number of hours he has worked on "01/01/01" to 7
	Then the number of hours the employee has worked on the date "01/01/01" is now 7
	
Scenario: Register time
	Given an employee with the ID "test" and the password "password" is logged in
	When he enters "01/01/01" with 8 hours worked
	Then the number of hours the employee has worked on the date "01/01/01" is now 8
	
Scenario: Register time worked in an absent period
	Given an employee with the ID "test" and the password "password" is logged in
	And the employee was absent "01/01/01" to "03/01/01"
	When he enters "01/01/01" with 8 hours worked
	Then the user gets the error message "Cannot register hours, you were absent on this date" 
#
#	