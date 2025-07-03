package com.zsgs.knowledgehub.features.books.details;

import java.util.Optional;
import java.util.Scanner;

import com.zsgs.knowledgehub.features.baseview.BaseView;
import com.zsgs.knowledgehub.features.librarysetup.LibrarySetupView;
import com.zsgs.knowledgehub.repository.dto.Book;





public class BookDetailsView extends BaseView {
	
	private final BookDetailsModel model;
	private final Scanner sc = new Scanner(System.in);

	public BookDetailsView() {
		model = new BookDetailsModel(this);
	}

	public void init() {
		showMenu();
	}

	 private void showMenu() {
	        while (true) {
	            System.out.println("\n=== Book Details ===");
	            System.out.println("1. View Book Details");
	            System.out.println("2. Back to Main Menu");
	            System.out.println("3. Logout");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");
	            
	            try {
	                int choice = Integer.parseInt(sc.nextLine());
	                switch (choice) {
	                    case 1:
	                        viewBookDetails();
	                        break;
	                    case 2:
	                        new LibrarySetupView().mainMenu();
	                        return;
	                    case 3:
	                        logoutApp();
	                        return;
	                    case 4:
	                        exitApp();
	                    default:
	                        System.out.println("Invalid choice. Please try again.");
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("Please enter a valid number.");
	            }
	        }
	    }

	 private void viewBookDetails() {
	        System.out.println("\nEnter Book ID:");
	        String bookId = sc.nextLine();
	        model.getBookDetails(bookId);
	    }

	public void displayBookDetails(Book book) {
	
		
	
			System.out.println("\n=== Book Details ===");
	        System.out.println("Book ID: " + book.getId());
	        System.out.println("Name: " + book.getName());
	        System.out.println("Author: " + book.getAuthor());
	        System.out.println("Genre: " + book.getGenre());
	        System.out.println("Volume: " + book.getVolume());
	        System.out.println("Published Year: " + book.getPublishedYear());
	        System.out.println("Total Copies: " + book.getNoOfCopy());
	        System.out.println("Available Copies: " + book.getAvailableCount());

		
	}

	public void displayError(String errorMsg) {
		System.out.println(errorMsg);
		
	}

	   

}
