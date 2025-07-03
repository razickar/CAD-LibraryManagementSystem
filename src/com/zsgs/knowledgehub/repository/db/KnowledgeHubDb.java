package com.zsgs.knowledgehub.repository.db;

import java.util.ArrayList;
import java.util.List;

import com.zsgs.knowledgehub.repository.dto.Book;
import com.zsgs.knowledgehub.repository.dto.LibrarySetup;
import com.zsgs.knowledgehub.repository.dto.RegistrationInfo;
import com.zsgs.knowledgehub.repository.dto.User;

public class KnowledgeHubDb {
	
	private static KnowledgeHubDb sKnowledgwHubDb;
	private RegistrationInfo Registrationinfo;
	private LibrarySetup library;
	private List<Book> books = new ArrayList<>();
	private List<User> users = new ArrayList<>();
	
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
	
	
	
}
