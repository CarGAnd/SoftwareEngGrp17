Feature: White Box Add User.
	Description: This is a white box feature case for the method Add User
	Actor: Administrator and User

#Scenario: User Already Exists
#	Given an employee exists with the ID "Test" and the password "passy"
#	When a user with ID "Test" is added to the managment 
#	Then the user gets the error message "another user with that ID already exists"
#	
#Scenario: User is not an admin
#	Given the employee with ID "SomeID" doesn't exist
#	And an employee exists with the ID "Tester" and the password "passy"
#	And an employee with the ID "Tester" and the password "passy" is logged in
#	And the user doesn't have admin permissions
#	When the logged in user adds the user with ID "SomeID"
#	Then the user gets the error message "The user does not have admin permissions"
#
#Scenario: Add User
#	Given an adminstrator exists
#	And the user is logged in as an administrator
#	When the logged in user adds the user with ID "SomeID"
#	Then the user with ID "SomeID" is added