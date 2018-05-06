Feature: White Box Create Project.
	Description: This is a white box feature case for the method Create Project
	Actor: Admin

#Scenario: User logged in is not an admin
#	Given an employee exists with the ID "Tester" and the password "passy"
#	And an employee with the ID "Tester" and the password "passy" is logged in
#	When the user creates a project with ID "ID1234" name "Name" start date "22/4/2020" end date "28/4/2020" and estimated time usage 40
#	Then the user gets the error message "Insufficient permissions"
	
Scenario: A Project is created
	Given an adminstrator exists
	And the user is logged in as an administrator
	When the user creates a project with ID "ID1234" name "Name" start date "22/4/2020" end date "28/4/2020" and estimated time usage 40
	Then the project with ID "ID1234" name "Name" start date "22/4/2020" end date "28/4/2020" and estimated time usage 40 is created
	
