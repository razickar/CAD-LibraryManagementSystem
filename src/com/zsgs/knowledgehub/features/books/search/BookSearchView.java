package com.zsgs.knowledgehub.features.books.search;

import java.util.List;
import java.util.Scanner;

import com.zsgs.knowledgehub.features.baseview.BaseView;
import com.zsgs.knowledgehub.features.books.BooksView;
import com.zsgs.knowledgehub.features.librarysetup.LibrarySetupView;
import com.zsgs.knowledgehub.features.login.LoginView;
import com.zsgs.knowledgehub.repository.dto.Book;

public class BookSearchView extends BaseView {

	private final BookSearchModel model;
	private final Scanner sc = new Scanner(System.in);
	
	public BookSearchView() {
		model = new BookSearchModel(this);
	}

	public void init() {
		
		showMenu();
	}

	private void showMenu() {
		
		   while (true) {
	            System.out.println("\n=== Search Books ===");
	            System.out.println("1. Search by Name");
	            System.out.println("2. Search by Author");
	            System.out.println("3. Search by Genre");
	            System.out.println("4. Back to Book-Menu");
	            System.out.println("5. Back to Main Menu");
	            System.out.println("6. Logout");
	            System.out.println("7. Exit");
	            System.out.print("Enter your choice: ");
	            
	            try {
	                int choice = Integer.parseInt(sc.nextLine());
	                switch (choice) {
	                    case 1:
	                        System.out.println("Enter book name:");
	                        model.searchByName(sc.nextLine().trim());
	                        break;
	                    case 2:
	                        System.out.println("Enter author name:");
	                        model.searchByAuthor(sc.nextLine().trim());
	                        break;
	                    case 3:
	                        System.out.println("Enter genre:");
	                        model.searchByGenre(sc.nextLine().trim());
	                        break;
	                    case 4:
	                    	new BooksView().init();
	                    	return;
	                    case 5:
	                        new LibrarySetupView().mainMenu();
	                        return;
	                    case 6:
	                    	new LoginView().init();
	    					return;
	                    case 7:
	                    	System.exit(0);
	                    default:
	                        System.out.println("Invalid choice. Please try again.");
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("Please enter a valid number.");
	            }
	        }
		
	}

	public void displayBookSearch(List<Book> books) {
		books.forEach(x -> {
		    System.out.println("Book name :- " + x.getName());
		    System.out.println("Author :- " + x.getAuthor());
		    System.out.println("Genre :- " + x.getGenre());
		    System.out.println("Year :- " + x.getPublishedYear());
		    System.out.println("------------------------------");
		});
		
	}

}
