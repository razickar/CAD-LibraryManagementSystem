package com.zsgs.knowledgehub.features.books.details;

import java.util.Optional;

import com.zsgs.knowledgehub.repository.db.KnowledgeHubDb;
import com.zsgs.knowledgehub.repository.dto.Book;

class BookDetailsModel {

	private final BookDetailsView view;
	
	public BookDetailsModel(BookDetailsView view) {
		this.view = view;
	}

	public void getBookDetails(String bookId) {
		
		Optional<Book> book = KnowledgeHubDb.getInstance().getBooks().stream().filter(x->x.getId().toUpperCase().equals(bookId.toUpperCase())).findFirst();
		if (book.isPresent()) {
		    view.displayBookDetails(book.get());  // Pass the actual Book object
		} else {
		    view.displayError("Book not found with ID: " + bookId);
		}
		
	}

}
