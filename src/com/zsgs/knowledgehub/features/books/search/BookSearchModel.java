package com.zsgs.knowledgehub.features.books.search;

import java.util.List;
import java.util.stream.Collectors;

import com.zsgs.knowledgehub.repository.db.KnowledgeHubDb;
import com.zsgs.knowledgehub.repository.dto.Book;

class BookSearchModel {
	
	private final BookSearchView view;
	
	public BookSearchModel(BookSearchView view) {
		this.view = view;
	}

	 void searchByName(String name) {
		
		 List<Book> books = KnowledgeHubDb.getInstance().getBooks().stream().filter(x->x.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
		 view.displayBookSearch(books);
	}

	 void searchByAuthor(String author) {

		 List<Book> books = KnowledgeHubDb.getInstance().getBooks().stream().filter(x->x.getAuthor().toLowerCase().contains(author.toLowerCase())).collect(Collectors.toList());
		 view.displayBookSearch(books);
	 }

	 void searchByGenre(String genre) {
		List<Book> books = KnowledgeHubDb.getInstance().getBooks().stream().filter(x->x.getGenre().toLowerCase().contains(genre.toLowerCase())).collect(Collectors.toList());
		view.displayBookSearch(books);
	}

}
