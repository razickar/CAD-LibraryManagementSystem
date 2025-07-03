package com.zsgs.knowledgehub.features.users.details;

import java.util.Scanner;

import com.zsgs.knowledgehub.features.baseview.BaseView;
import com.zsgs.knowledgehub.repository.dto.User;

public class UserDetailsView extends BaseView {

	private final UserDetailsModel model;
	private final Scanner sc = new Scanner(System.in);
	public UserDetailsView() {
		model = new UserDetailsModel(this);
	}
	 public void init() {
	        showMenu();
	    }

	    private void showMenu() {
	        while (true) {
	            System.out.println("\n=== User Details ===");
	            System.out.println("1. View User Details");
	            System.out.println("2. Back");
	            System.out.println("3. Logout");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");
	            
	            try {
	                int choice = Integer.parseInt(sc.nextLine());
	                switch (choice) {
	                    case 1:
	                        viewUserDetails();
	                        break;
	                    case 2:
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

	    private void viewUserDetails() {
	        System.out.println("\nEnter User ID:");
	        String userId = sc.nextLine();
	        model.getUserDetails(userId);
	    }

	    public void displayUserDetails(User user) {
	        if (user == null) {
	            System.out.println("\nUser not found.");
	            return;
	        }

	        System.out.println("\n=== User Details ===");
	        System.out.println("User ID: " + user.getUserId());
	        System.out.println("First Name: " + user.getFirstName());
	        System.out.println("Last Name: " + user.getLastName());
	        System.out.println("Email: " + user.getEmail());
	        System.out.println("Mobile: " + user.getMobileNumber());
	        System.out.println("Address: " + user.getAddress());
	        System.out.println("Date of Birth: " + user.getDOB());
	    }
		public void showMessage(String message) {
			System.out.println(message);
		}


}
