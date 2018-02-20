Feature: Borrow Book
	Description: The User borrows a book from the library
	Actors: User
	
#Scenario: Borrow a book
#	Given that a user is registered with the library
#	When the user borrows a book
#	Then the book is borrowed by the user
	
#Scenario: borrowing with too many books borrowed
#	Given that a user is registered with the library
#	And the user has borrowed more than 10 books
#	When the user borrows a book
#	Then I get the error message "Can't borrow more than 10 books"

Scenario: borrowing a book without being a registered user
	Given that a user is not registered with the library
	When the user borrows a book
	Then I get the error message "User registration required"