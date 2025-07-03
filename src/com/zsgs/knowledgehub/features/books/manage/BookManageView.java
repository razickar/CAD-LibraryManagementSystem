package com.zsgs.knowledgehub.features.books.manage;

import java.util.Scanner;

import com.zsgs.knowledgehub.features.baseview.BaseView;
import com.zsgs.knowledgehub.features.books.BooksView;
import com.zsgs.knowledgehub.features.librarysetup.LibrarySetupView;
import com.zsgs.knowledgehub.features.login.LoginView;
import com.zsgs.knowledgehub.repository.dto.Book;

public class BookManageView extends BaseView {

	private final BookManageModel model;
	private final Scanner sc = new Scanner(System.in);
	
	public BookManageView() {
		model = new BookManageModel(this);
	}

	public void init() {
		
		showMenu();
	}

	public void showMenu() {

		while(true) {
			String choice = "";
			
			System.out.println("\n=======MANAGE BOOKS ======\n");
			System.out.println("1. Add Book");
			System.out.println("2. Back to Books-Menu");
			System.out.println("3. Back To Main-Menu");
			System.out.println("4. logout");
			System.out.println("5. exit..");
			System.out.println("ENTER YOUR CHOICE");

			
			try {
				switch(Integer.parseInt(choice)) {
				
				case 1:
					collectBookdata();
					break;
				case 2:
					new BooksView().init();
					return;
				case 3:
					new LibrarySetupView().mainMenu();
					return;
				case 4:
					new LoginView().init();
					return;
				case 5:
					System.exit(0);
				default:
					System.out.println("ENTER VALID OPTION..");
				}
				
				
			}catch(Exception e) {
				System.out.println("type valid number........");
			}
		}
		
	}

	public void collectBookdata() {
		Book book = new Book();
		book.setId(getId());
		book.setName(sc.nextLine().trim());
		book.setAuthor(sc.nextLine().trim());
		book.setGenre(sc.nextLine().trim());
		book.setVolume(getVolume());
		book.setPublishedYear(getPublishedYear());
		book.setNoOfCopy(getNoOfCopy());
		
		model.addBook(book);
	}
	
	
	private String getId() {
		return model.generateId();
	}

	private byte getVolume() {
	    System.out.print("Enter Volume Number (1-127): ");
	    byte volume = 0;
	    
	    while (true) {
	        try {
	            String input = sc.nextLine().trim();
	            
	         
	            if (input.isEmpty()) {
	                System.out.print("Volume cannot be empty! Please enter a number (1-127): ");
	                continue;
	            }
	            
	           
	            int tempVolume = Integer.parseInt(input);
	            
	           
	            if (tempVolume < 1 || tempVolume > 127) {
	                System.out.print("Invalid volume! Please enter a number between 1 and 127: ");
	                continue;
	            }
	            
	            volume = (byte) tempVolume;
	            break;
	            
	        } catch (NumberFormatException e) {
	            System.out.print("Invalid input! Please enter a valid number (1-127): ");
	        }
	    }
	    
	    return volume;
	}

	
	private int getPublishedYear() {
	    System.out.print("Enter Published Year (eg.. 2023): ");
	    int year = 0;
	    
	    while (true) {
	        try {
	            String input = sc.nextLine().trim();
	            
	            // Check if input is empty
	            if (input.isEmpty()) {
	                System.out.print("Year cannot be empty! Please enter year (00-99): ");
	                continue;
	            }
	            
	         
	            int tempYear = Integer.parseInt(input);
	            
	          
	            if (tempYear < 0 || tempYear > 99) {
	                System.out.print("Invalid year! Please enter last 2 digits (00-99): ");
	                continue;
	            }
	            
	            year = tempYear;
	            break;
	            
	        } catch (NumberFormatException e) {
	            System.out.print("Invalid input! Please enter a valid year (00-99): ");
	        }
	    }
	    
	    return year;
	}

	
	private byte getNoOfCopy() {
	    System.out.print("Enter Number of Copies (1-127): ");
	    byte copies = 0;
	    
	    while (true) {
	        try {
	            String input = sc.nextLine().trim();
	            
	            // Check if input is empty
	            if (input.isEmpty()) {
	                System.out.print("Number of copies cannot be empty! Please enter a number (1-127): ");
	                continue;
	            }
	            
	          
	            int tempCopies = Integer.parseInt(input);
	            
	           
	            if (tempCopies < 1 || tempCopies > 127) {
	                System.out.print("Invalid number! Please enter copies between 1 and 127: ");
	                continue;
	            }
	            
	            copies = (byte) tempCopies;
	            break;
	            
	        } catch (NumberFormatException e) {
	            System.out.print("Invalid input! Please enter a valid number (1-127): ");
	        }
	    }
	    
	    return copies;
	}

	public void errorMessage(String string) {
		System.out.println(string);
		
	}

}
