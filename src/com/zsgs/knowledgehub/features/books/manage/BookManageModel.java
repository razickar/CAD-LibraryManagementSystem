package com.zsgs.knowledgehub.features.books.manage;

import java.util.UUID;

import com.zsgs.knowledgehub.repository.db.KnowledgeHubDb;
import com.zsgs.knowledgehub.repository.dto.Book;

class BookManageModel {

	private final BookManageView view;
	
	public BookManageModel(BookManageView view) {
		this.view =  view;
	}

	void addBook(Book book) {
		if(isValidBookInfo(book)) {
			book.setId(generateId());
			book.setAvailableCount(book.getNoOfCopy());
		KnowledgeHubDb.getInstance().setBooks(book);
		view.showMessage("BOOK is SUCCESSFULLY ADDED!!");
		}
		else {
			view.errorMessage("this is Invalid values");
		}
	}

	 private boolean isValidBookInfo(Book book) {
		 return true;
//		 book != null &&
//	               book.getName() != null && !book.getName().trim().isEmpty() &&
//	               book.getAuthor() != null && !book.getAuthor().trim().isEmpty() &&
//	               book.getGenre() != null && !book.getGenre().trim().isEmpty() &&
//	               book.getVolume() > 0 &&
//	               book.getPublishedYear() != null && book.getPublishedYear() >= 1800 && book.getPublishedYear() <= 2024 &&
//	               book.getNoOfCopy() > 0 &&
//	               book.getAvailableCount() >= 0 && book.getAvailableCount() <= book.getNoOfCopy();
	}

	String generateId() {
		return "BK"+UUID.randomUUID().toString().substring(0,8).toUpperCase();
	}

}
