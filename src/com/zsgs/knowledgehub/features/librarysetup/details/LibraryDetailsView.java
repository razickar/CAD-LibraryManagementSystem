package com.zsgs.knowledgehub.features.librarysetup.details;

import java.util.Scanner;

import com.zsgs.knowledgehub.features.librarysetup.LibrarySetupView;
import com.zsgs.knowledgehub.features.login.LoginView;
import com.zsgs.knowledgehub.repository.dto.LibrarySetup;


public class LibraryDetailsView extends BaseView {

	private final LibraryDetailsModel model;
	private final Scanner sc = new Scanner(System.in);
	
	public LibraryDetailsView() {
		model = new LibraryDetailsModel(this);
	}
	 public void init() {
		showMenu();
		
	}
	
	public void showMenu() {
		
		 while (true) {
	            System.out.println("\n=== Library Details ===");
	            System.out.println("1. View Library Details");
	            System.out.println("2. Back to Main Menu");
	            System.out.println("3. Logout");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");
	            
	            try {
	                int choice = Integer.parseInt(sc.nextLine());
	                switch (choice) {
	                    case 1:
	                    	 model.fetchLibraryDetails();
	                        break;
	                    case 2:
	                        new LibrarySetupView().mainMenu();
	                        return;
	                    case 3:
	                    	new LoginView().init();
	    					break;
	                    case 4:
	                        System.exit(0);
	                    default:
	                        System.out.println("Invalid choice. Please try again.");
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("Please enter a valid number.");
	            }
	        }
		
	}
	public void displayLibraryDetails(LibrarySetup libraryDetails) {
		
		
		    System.out.println("ID: " + libraryDetails.getID());
		    System.out.println("Name: " + libraryDetails.getName());
		    System.out.println("Incharge: " + libraryDetails.getIncharge());
		    System.out.println("Capacity: " + libraryDetails.getCapacity());
		    System.out.println("Address: " + libraryDetails.getAddress());
		    System.out.println("Phone No: " + libraryDetails.getPhoneNo());
		    System.out.println("WiFi Password: " + libraryDetails.getWifiPassword());
		    System.out.println("Email ID: " + libraryDetails.getEmailId());
		    System.out.println("Opening Time: " + libraryDetails.getOpeningTime());
		    System.out.println("Closing Time: " + libraryDetails.getClosingTime());
		    System.out.println("No of Available Days: " + libraryDetails.getNoAvailableDays());
		    System.out.println("---------------------------------------");

	}
	
	
	
	
	
	
	

}
