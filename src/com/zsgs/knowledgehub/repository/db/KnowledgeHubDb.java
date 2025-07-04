package com.zsgs.knowledgehub.repository.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zsgs.knowledgehub.repository.dto.Book;
import com.zsgs.knowledgehub.repository.dto.BorrowRecords;
import com.zsgs.knowledgehub.repository.dto.LibrarySetup;
import com.zsgs.knowledgehub.repository.dto.RegistrationInfo;
import com.zsgs.knowledgehub.repository.dto.User;

public class KnowledgeHubDb {
	
	private static KnowledgeHubDb sKnowledgwHubDb;
	private RegistrationInfo Registrationinfo;
	private LibrarySetup library;
	private List<Book> books = new ArrayList<>();
	private List<User> users = new ArrayList<>();
	private List<BorrowRecords> borrowRecords = new ArrayList<>();
	
	public List<BorrowRecords> getBorrowRecords() {
		return borrowRecords;
	}

	public void setBorrowRecords(BorrowRecords borrowRecords) {
		this.borrowRecords.add(borrowRecords);
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(User user) {
		 users.add(user);
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(Book book) {
		books.add(book);
	}

	public LibrarySetup getLibrary() {
		return library;
	}

	public void setLibrary(LibrarySetup library) {
		this.library = library;
	}

	public RegistrationInfo getRegistrationInfo() {
		return Registrationinfo;
	}

	public void setRegistrationInfo(RegistrationInfo info) {
		this.Registrationinfo = info;
	}

	private KnowledgeHubDb() {
		
	}
	
	public static KnowledgeHubDb getInstance() {
		if(sKnowledgwHubDb == null) {
			sKnowledgwHubDb = new KnowledgeHubDb();
		}
		
		return sKnowledgwHubDb;
	}

	public boolean isValidCrediential(String userName, String password) {
		
		return sKnowledgwHubDb.getRegistrationInfo().getUserName().equals(userName) &&  sKnowledgwHubDb.getRegistrationInfo().getPassword().equals(password);
	}

	public Optional<User> isUserAvailable(String userId) {
		
		return users.stream().filter(x->x.getUserId().toLowerCase().equals(userId.toLowerCase())).findFirst();
		
	}

	public Optional<Book> isBookAvailable(String bookId) {
		 System.out.println("Searching for book ID: " + bookId);
		    books.forEach(b -> {
		        System.out.println("Book: " + b.getId() + ", Available: " + b.getAvailableCount());
		    });
		return books.stream().filter(x->x.getId().toLowerCase().equals(bookId.toLowerCase())).filter(x->x.getAvailableCount()>0).findFirst();
	}
	
	
	
}
