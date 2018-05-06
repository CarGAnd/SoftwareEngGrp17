Feature: White Box User Login.
	Description: This is a white box feature case for the method User Login
	Actor: User

#Scenario: User already logged in
#	Given a user is already logged in
#	When a user with ID "SomeID" and password "passwording" attempts to log in 
#	Then the user recieves the error message "A user is already logged in"
#	
#Scenario: User ID/Pass doesn't match
#	Given a user is not logged in
#	And a user with ID "SomeID" and password "passwording" exists
#	When a user logs in with ID "SomeID" and password "passworded"
#	Then the user recieves the error message "incorrect ID or password"
#	
#Scenario: User doesn't exist
#	Given a user is not logged in
#	And a user with ID "SomeID" and password "passwording" doesn't exist
#	When a user logs in with the ID "SomeID" and password "passwording"
#	Then the user recieves the error message "incorrect ID or password"
#	
#Scenario: User logs in
#	Given a user is not logged in
#	And a user with ID "SomeID" and password "passwording" exists
#	When a user logs in with the ID "SomeID" and password "passwording"
#	Then the user with ID "SomeID" is now logged in
