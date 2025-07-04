package com.zsgs.knowledgehub.features.borrowbooks;

import java.util.Scanner;

import com.zsgs.knowledgehub.features.baseview.BaseView;
import com.zsgs.knowledgehub.repository.dto.BorrowRecords;

public class BorrowBooksView extends BaseView {

	private final BorrowBooksModel model;
	private final Scanner sc = new Scanner(System.in);
	
	public BorrowBooksView() {
		model = new BorrowBooksModel(this);
	}
	public void init() {
		showMenu();
		
	}
	private void showMenu() {
		
		while (true) {

		    String choice = "";
		    System.out.println("\n=== BORROW BOOKS MANAGEMENT ===");
		    System.out.println("1. Borrow a Book");
		    System.out.println("2. Return a Book");
		    System.out.println("4. View All Borrowed Books");
		    System.out.println("5. Search Borrowed Books");
		    System.out.println("7. Calculate Fine");
		    System.out.println("9. Back to Main Menu");
		    System.out.print("Enter your choice: ");

		    try {
		        choice = sc.nextLine().trim();

		        switch (Integer.parseInt(choice)) {

		            case 1:
		                borrowBook();  
		                break;

//		            case 2:
//		                returnBook();  
//		                break;
//
//		            case 4:
//		                viewAllBorrowedBooks();  // Call your method to list borrowed books
//		                break;
//
//		            case 5:
//		                searchBorrowedBooks();  // Call your method to search borrowed books
//		                break;
//
//		            case 7:
//		                calculateFine();  
//		                break;

		            case 9:
		                System.out.println("Returning to main menu...");
		                return;  // Exit this loop and go back to main menu
		               
		            default:
		                System.out.println("Invalid choice. Please try again.");
		                break;
		        }

		    } catch (NumberFormatException e) {
		        System.out.println("Please enter a valid number!");
		    } catch (Exception e) {
		        System.out.println("An error occurred: " + e.getMessage());
		    }
		}

		
	}
	private void borrowBook() {
	    BorrowRecords borrowInfo = new BorrowRecords();
	    borrowInfo.setUserId(getUserId());
	    borrowInfo.setBookId(getBookId());
	    borrowInfo.setBookName(getBookTitle());
	   
	    model.saveBorrowRecord(borrowInfo);
	   
	}

	private String getUserId() {
	    System.out.println("ENTER User ID...");
	    String name = "";
	    do {
	        name = sc.nextLine().trim();
	        if(name.isEmpty()) {
	            System.out.println("Enter valid name");
	        } else {
	            break;
	        }
	    } while(true);
	    return name;
	}

	private String getBookId() {
	    System.out.println("Enter Book ID..");
	    String bookId = "";
	    do {
	        bookId = sc.nextLine().trim();
	        if(bookId.isEmpty()) {
	            System.out.println("Enter valid Book ID");
	        } else {
	            break;
	        }
	    } while(true);
	    return bookId;
	}

	private String getBookTitle() {
	    System.out.println("Enter Book Title..");
	    String title = "";
	    do {
	        title = sc.nextLine().trim();
	        if(title.isEmpty()) {
	            System.out.println("Enter valid Book Title");
	        } else {
	            break;
	        }
	    } while(true);
	    return title;
	}

	



	
	
	

}
