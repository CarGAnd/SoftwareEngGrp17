package dtu.library.app;

import java.util.ArrayList;

public class User {
	
	private String CPR,name,email,street,city;
	private int postCode;
	ArrayList<Book> borrowedBooks = new ArrayList<Book>();
	ArrayList<LibraryApp> memberShips = new ArrayList<LibraryApp>();

	public User(String CPR, String name, String email) {
		this.CPR = CPR;
		this.name = name;
		this.email = email;
	}
	
	public void SetStreet(String newStreet) {
		street = newStreet;
	}
	
	public void SetPostcode(int newCode) {
		postCode = newCode;
	}
	
	public void SetCity(String newCity) {
		city = newCity;
	}

	public void borrowBook(LibraryApp library, Book book) throws TooManyBooksException, OperationNotAllowedException {
		if(borrowedBooks.size() < 10) {
			library.lendBook(this, book);			
		}
		else {
			throw new TooManyBooksException("Can't borrow more than 10 books");
		}
	}

	public ArrayList<Book> getBorrowedBooks() {
		return borrowedBooks;
	}
	
	
	
}
