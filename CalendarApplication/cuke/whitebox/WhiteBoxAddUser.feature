Feature: White Box Add User.
	Description: This is a white box feature case for the method Add User
	Actor: Administrator and User

Scenario: User Already Exists
	Given an employee exists with the ID "Test" and the password "Wubbadubawublob"
	When a user with ID "SomeID" is added to the managment 
	Then the user recieves the error message "A user with that ID already exists"
	
Scenario: User is not an admin
	Given the user with ID "SomeID" doesn't exist
	And a user with ID "Tester" is logged in
	And the user doesn't have admin permissions
	When the logged in user adds the user with ID "SomeID"
	Then the user recieves the error message "The user does not have admin permissions"

Scenario: Add User
	Given the user with ID "SomeID" doesn't exist
	And a user with ID "Tester" is logged in
	And the user does have admin permissions
	When the logged in user adds the user with ID "SomeID"
	Then the user with ID "SomeID" is added