package dtu.library.app;

import java.util.ArrayList;
import java.util.List;

public class LibraryApp {
	
	public boolean isLoggedIn = false;
	ArrayList<Book> books = new ArrayList<Book>();
	ArrayList<User> users = new ArrayList<User>();

	public boolean adminLoggedIn() {
		return isLoggedIn;
	}

	public boolean adminLogin(String password) {
		if(password.equals("adminadmin")) {
			isLoggedIn = true;
			return true;
		}
		else {
			return false;
		}
	}

	public void adminLogout() {
		if(isLoggedIn) {
			isLoggedIn = false;
		}
	}

	public void addBook(Book book) throws OperationNotAllowedException {
		if(isLoggedIn) {
			books.add(book);
		}
		else {
			throw new OperationNotAllowedException("Administrator login required");
		}
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public ArrayList<Book> search(String searchText) {
		ArrayList<Book> booksThatMatch = new ArrayList<Book>();
		for (int i = 0; i < books.size(); i++) {
			if(books.get(i).signature.contains(searchText) || books.get(i).title.contains(searchText) || books.get(i).author.contains(searchText)) {
				booksThatMatch.add(books.get(i));
			}
		}
		return booksThatMatch;
	}
	
	public ArrayList<User> GetUsers(){
		return users;
	}
	
	public void RegisterUser(User newUser) throws OperationNotAllowedException {
		if(isLoggedIn) {
			if(users.contains(newUser)) {
				throw new OperationNotAllowedException("User is already registered");
			}
			else {
				users.add(newUser);
			}
		}
		else {
			throw new OperationNotAllowedException("Administrator login required");
		}
	}
	
	public void lendBook(User user, Book book) throws OperationNotAllowedException {
		if(users.contains(user)) {
			user.borrowedBooks.add(book);
		}
		else {
			throw new OperationNotAllowedException("User registration required");
		}
	}
	
}
