Feature: Request assistance from employees'
#	Description: An employee requests assistance to a task from another employee.
#	Actor: user
#	
#Scenario: Request assistance from available employee
#	Given the user with ID "Tester" is working on an activity with ID "ID1234"
#	And there is an available employee
#	When the user with ID "Tester" requests assistance
#	Then the available employee is assigned to the activity
#
#Scenario: Request assistance from absent employee
#	Given the user with ID "Tester" is working on an activity with ID "ID1234"
#	And there is no available employees
#	When the user with ID "Tester" requests assistance
#	Then the user recieves the error message "There are no available employees" 