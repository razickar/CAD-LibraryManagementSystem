package com.zsgs.knowledgehub.features.users.manage;

import java.util.List;
import java.util.Scanner;

import com.zsgs.knowledgehub.features.baseview.BaseView;
import com.zsgs.knowledgehub.features.librarysetup.LibrarySetupView;
import com.zsgs.knowledgehub.repository.dto.User;



public class UserManageView extends BaseView {

	private final UserManageModel model;
	private final Scanner sc = new Scanner(System.in);
	public UserManageView() {
		model = new UserManageModel(this);
	}

	  public void init() {
        showMenu();
    }

    private void showMenu() {
        while (true) {
            System.out.println("\n=== User Management ===");
            System.out.println("1. Add New User");
            System.out.println("2. View All Users");
            System.out.println("3. Back to Main Menu");
            System.out.println("4. Logout");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        addNewUser();
                        break;
                    case 2:
                        model.viewAllUsers();
                        break;
                    case 3:
                        new LibrarySetupView().mainMenu();
                        return;
                    case 4:
                        logoutApp();
                        return;
                    case 5:
                        exitApp();
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private void addNewUser() {
        System.out.println("\n=== Add New User ===");
        User user = new User();
        
        user.setFirstName(getFirstName());
        user.setLastName(getLastName());
        user.setEmail(getEmail());
        user.setMobileNumber(getMobileNumber());
        user.setAddress(getAddress());
        user.setDOB(getDob());
        
        model.addUser(user);
    }

    private String getFirstName() {
        String name = "";
        System.out.println("Enter First Name:");
        do {
            name = sc.nextLine();
            if (name.length() < 2 || name.length() > 50)
                System.out.println("First name should be between 2 and 50 characters\nEnter valid name:");
            else break;
        } while (true);
        return name;
    }

    private String getLastName() {
        String name = "";
        System.out.println("Enter Last Name:");
        do {
            name = sc.nextLine();
            if (name.length() < 2 || name.length() > 50)
                System.out.println("Last name should be between 2 and 50 characters\nEnter valid name:");
            else break;
        } while (true);
        return name;
    }

    private String getEmail() {
        String email = "";
        System.out.println("Enter Email Address:");
        do {
            email = sc.nextLine();
            if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$"))
                System.out.println("Invalid email format\nEnter valid email:");
            else break;
        } while (true);
        return email;
    }

    private String getMobileNumber() {
        String mobile = "";
        System.out.println("Enter Mobile Number:");
        do {
            mobile = sc.nextLine();
            if (!mobile.matches("\\d{10}"))
                System.out.println("Mobile number should be 10 digits\nEnter valid number:");
            else break;
        } while (true);
        return mobile;
    }

    private String getAddress() {
        String address = "";
        System.out.println("Enter Address:");
        do {
            address = sc.nextLine();
            if (address.length() < 5 || address.length() > 100)
                System.out.println("Address should be between 5 and 100 characters\nEnter valid address:");
            else break;
        } while (true);
        return address;
    }

    private String getDob() {
        String dob = "";
        System.out.println("Enter Date of Birth (DD/MM/YYYY):");
        do {
            dob = sc.nextLine();
            if (!dob.matches("\\d{2}/\\d{2}/\\d{4}"))
                System.out.println("Invalid date format. Please use DD/MM/YYYY\nEnter valid date:");
            else break;
        } while (true);
        return dob;
    }

    public void displayUsers(List<User> users) {
        if (users.isEmpty()) {
            System.out.println("\nNo users found.");
            return;
        }

        System.out.println("\n=== User List ===");
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

    public void showSuccessMessage(String message) {
        System.out.println(message);
    }

    public void showErrorMessage(String message) {
        System.out.println(message);
    }
}



