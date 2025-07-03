package com.zsgs.knowledgehub.features.users.search;

import java.util.List;
import java.util.Scanner;

import com.zsgs.knowledgehub.features.baseview.BaseView;
import com.zsgs.knowledgehub.repository.dto.User;

public class UserSearchView extends BaseView {

	private final UserSearchModel model;
	private final Scanner sc = new Scanner(System.in);
	
	public UserSearchView() {
		model = new UserSearchModel(this);
	}

	 public void init() {
	        showMenu();
	    }

	    private void showMenu() {
	        while (true) {
	            System.out.println("\n=== Search Users ===");
	            System.out.println("1. Search by Name");
	            System.out.println("2. Search by Email");
	            System.out.println("3. Search by Mobile");
	            System.out.println("4. Back");
	            System.out.println("5. Logout");
	            System.out.println("6. Exit");
	            System.out.print("Enter your choice: ");
	            
	            try {
	                int choice = Integer.parseInt(sc.nextLine());
	                switch (choice) {
	                    case 1:
	                        searchByName();
	                        break;
	                    case 2:
	                        searchByEmail();
	                        break;
	                    case 3:
	                        searchByMobile();
	                        break;
	                    case 4:
	                        return;
	                    case 5:
	                        logoutApp();
	                        return;
	                    case 6:
	                        exitApp();
	                    default:
	                        System.out.println("Invalid choice. Please try again.");
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("Please enter a valid number.");
	            }
	        }
	    }

	    private void searchByName() {
	        System.out.println("\nEnter name to search:");
	        String name = sc.nextLine();
	        model.searchByName(name);
	    }

	    private void searchByEmail() {
	        System.out.println("\nEnter email to search:");
	        String email = sc.nextLine();
	        model.searchByEmail(email);
	    }

	    private void searchByMobile() {
	        System.out.println("\nEnter mobile number to search:");
	        String mobile = sc.nextLine();
	        model.searchByMobile(mobile);
	    }

	    public void displayUsers(List<User> users) {
	        if (users.isEmpty()) {
	            System.out.println("\nNo users found.");
	            return;
	        }

	        System.out.println("\n=== Search Results ===");
	        System.out.printf("%-15s %-20s %-20s %-15s %-15s%n",
	                "User ID", "First Name", "Last Name", "Email", "Mobile");
	        System.out.println("--------------------------------------------------------------------------------");
	        
	        users.forEach(x->{
	        	
	        	System.out.printf("%-15s %-20s %-20s %-15s %-15s%n",
	                    x.getUserId(),
	                    x.getFirstName(),
	                    x.getLastName(),
	                    x.getEmail(),
	                    x.getMobileNumber());
	        });
	            
	        }
	    

	    public void showMessage(String message) {
	        System.out.println(message);
	    }

}
