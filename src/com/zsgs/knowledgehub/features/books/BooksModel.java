package com.zsgs.knowledgehub.features.books;

import java.util.List;

import com.zsgs.knowledgehub.repository.db.KnowledgeHubDb;
import com.zsgs.knowledgehub.repository.dto.Book;

class BooksModel {

	private final BooksView view;
	public BooksModel(BooksView view) {
		this.view = view;
	}
	
	void getBooksFromDb() {
		
	List<Book> books = KnowledgeHubDb.getInstance().getBooks();
	if(books.isEmpty()) {
		view.showErrorMsg("There is no books available X");
	}
	view.displayBooks(books);
		
	}

}
