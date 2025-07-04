package com.zsgs.knowledgehub.features.books;

import java.util.List;
import java.util.Scanner;

import com.zsgs.knowledgehub.features.baseview.BaseView;
import com.zsgs.knowledgehub.features.books.details.BookDetailsView;
import com.zsgs.knowledgehub.features.books.manage.BookManageView;
import com.zsgs.knowledgehub.features.books.search.BookSearchView;
import com.zsgs.knowledgehub.features.librarysetup.LibrarySetupView;
import com.zsgs.knowledgehub.features.login.LoginView;
import com.zsgs.knowledgehub.repository.dto.Book;

public class BooksView extends BaseView {

	private final BooksModel model;
	private final Scanner sc = new Scanner(System.in);
	
	public BooksView() {
		model = new BooksModel(this);
	}

	public void init() {
		
		showMenu();
	}

	public void showMenu() {
		
		
		while(true) {
			String choice = "";
			
			System.out.println("\n=======BOOKS MENU======\n");
			System.out.println("1. View All Books");
			System.out.println("2. Manage Books");
			System.out.println("3. Search Books");
			System.out.println("4. Book Details");
			System.out.println("5. Back To Main-Menu");
			System.out.println("6. logout");
			System.out.println("7. exit..");
			System.out.println("ENTER YOUR CHOICE");
		choice = sc.nextLine().trim();
			
			try {
				switch(Integer.parseInt(choice)) {
				
				case 1:
					featchingAllBooks();
					break;
				case 2:
					new BookManageView().init();
					return;
				case 3:
					new BookSearchView().init();
					return;
				case 4:
					new BookDetailsView().init();
					return;
				case 5:
					new LibrarySetupView().mainMenu();
					break;
				case 6:
					new LoginView().init();
					return;
				case 7:
					System.exit(0);
				default:
					System.out.println("ENTER VALID OPTION..");
				}
				
				
			}catch(Exception e) {
				System.out.println("type valid number........");
			}
		}
		
		
		
		
		
	}

	public void featchingAllBooks() {
		model.getBooksFromDb();
		
	}

	public void displayBooks(List<Book> books) {
		
		System.out.println("\nAll Books....");
		System.out.println("_".repeat(50));
		System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s%n",
			    "ID", "Name", "Author", "Genre", "Volume", "Year", "Available");

		System.out.println("_".repeat(50));
		for(Book book : books) {
		
			System.out.printf("%-20s%-20s %-20s %-20s %-20d %-20d %-20d%n",/*EDULA INDHA %N NA NOTE PANNU*/
                    book.getId(),
                    book.getName(),
                    book.getAuthor(),
                    book.getGenre(),
                    book.getVolume(),
                    book.getPublishedYear(),
                    book.getAvailableCount());
        }
		}

	public void showErrorMsg(String string) {
		System.out.println(string);
		
	}
		
	}




