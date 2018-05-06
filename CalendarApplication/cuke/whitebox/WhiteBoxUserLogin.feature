Feature: White Box User Login.
	Description: This is a white box feature case for the method User Login
	Actor: User

Scenario: User already logged in
	Given a user is already logged in
	When a user with ID "SomeID" and password "passwording" attempts to log in 
	Then the user gets the error message "another user is already logged in"
	
Scenario: User ID/Pass doesn't match
	Given a user is not logged in
	And an employee exists with the ID "SomeID" and the password "passy"
	When the employee enters the ID "SomeID" and the password "Passoff"
	Then the user gets the error message "incorrect ID or password"
	
Scenario: User doesn't exist
	Given a user is not logged in
	And an employee with the ID "SomeID" and the password "passy" doesn't exist
	When the employee enters the ID "SomeID" and the password "passy"
	Then the user gets the error message "incorrect ID or password"

Scenario: User logs in
	Given a user is not logged in
	And an employee exists with the ID "SomeID" and the password "passy"
	When the employee enters the ID "SomeID" and the password "passy"
	Then the user with ID "SomeID" is now logged in
