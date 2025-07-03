package com.zsgs.knowledgehub.features.librarysetup;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.zsgs.knowledgehub.features.baseview.BaseView;
import com.zsgs.knowledgehub.features.books.BooksView;
import com.zsgs.knowledgehub.features.borrowbooks.BorrowBooksView;
import com.zsgs.knowledgehub.features.librarysetup.details.LibraryDetailsView;
import com.zsgs.knowledgehub.features.login.LoginView;
import com.zsgs.knowledgehub.features.users.UsersView;
import com.zsgs.knowledgehub.repository.dto.LibrarySetup;

public class LibrarySetupView extends BaseView {

    private final LibrarySetupModel model;
    private final Scanner sc = new Scanner(System.in);
    
    // Regex patterns for validation
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
    );
    private static final Pattern NAME_PATTERN = Pattern.compile(
        "^[a-zA-Z\\s]{2,50}$"
    );
    private static final Pattern TIME_PATTERN = Pattern.compile(
        "^([01]?[0-9]|2[0-3]):[0-5][0-9]$"
    );

    public LibrarySetupView() {
        model = new LibrarySetupModel(this);
    }

    public void init() {
        model.init();
    }

    public void RegisterLibrarySetup() {
        LibrarySetup librarySetup = new LibrarySetup();

        librarySetup.setName(getName());
        librarySetup.setIncharge(getInchargeName());
        librarySetup.setAddress(getAddress());
        librarySetup.setEmailId(getEmail());
        librarySetup.setOpeningTime(getOpenTime());
        librarySetup.setClosingTime(getCloseTime());
        
        
        model.saveLibrarySetup(librarySetup);
    }

    private String getName() {
        System.out.println("ENTER LIBRARY NAME........");
        String name = "";
        do {
            name = sc.nextLine().trim();
            if (isValidName(name)) {
                break;
            }
            System.out.println("Invalid library name! Please enter a valid name (2-50 characters, letters and spaces only):");
        } while (true);
        return name;
    }

    private String getInchargeName() {
        System.out.println("ENTER INCHARGE NAME:");
        String name = "";
        do {
            name = sc.nextLine().trim();
            if (isValidName(name)) {
                break;
            }
            System.out.println("Invalid incharge name! Please enter a valid name (2-50 characters, letters and spaces only):");
        } while (true);
        return name;
    }

    private String getAddress() {
        System.out.println("ENTER LIBRARY ADDRESS:");
        String address = "";
        do {
            address = sc.nextLine().trim();
            if (isValidAddress(address)) {
                break;
            }
            System.out.println("Invalid address! Please enter a valid address (minimum 10 characters):");
        } while (true);
        return address;
    }

    private String getEmail() {
        System.out.println("ENTER EMAIL ID:");
        String email = "";
        do {
            email = sc.nextLine().trim();
            if (isValidEmail(email)) {
                break;
            }
            System.out.println("Invalid email format! Please enter a valid email (e.g., example@domain.com):");
        } while (true);
        return email;
    }

    private String getOpenTime() {
        System.out.println("ENTER OPENING TIME (HH:MM format, e.g., 09:00):");
        String time = "";
        do {
            time = sc.nextLine().trim();
            if (isValidTime(time)) {
                break;
            }
            System.out.println("Invalid time format! Please enter time in HH:MM format (e.g., 09:00):");
        } while (true);
        return time;
    }

    private String getCloseTime() {
        System.out.println("ENTER CLOSING TIME (HH:MM format, e.g., 18:00):");
        String time = "";
        String openTime = ""; // You might want to store opening time to validate closing time is after opening
        do {
            time = sc.nextLine().trim();
            if (isValidTime(time)) {
                break;
            }
            System.out.println("Invalid time format! Please enter time in HH:MM format (e.g., 18:00):");
        } while (true);
        return time;
    }

    
    private boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        return NAME_PATTERN.matcher(name.trim()).matches();
    }

    private boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email.trim()).matches();
    }

    private boolean isValidAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            return false;
        }
        return address.trim().length() >= 10 && address.trim().length() <= 200;
    }

    private boolean isValidTime(String time) {
        if (time == null || time.trim().isEmpty()) {
            return false;
        }
        
       
        if (!TIME_PATTERN.matcher(time.trim()).matches()) {
            return false;
        }
        
        // Additional validation - try to parse as LocalTime
        try {
            LocalTime.parse(time.trim(), DateTimeFormatter.ofPattern("HH:mm"));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    // Additional method to validate that closing time is after opening time
    private boolean isClosingTimeAfterOpening(String openTime, String closeTime) {
        try {
            LocalTime opening = LocalTime.parse(openTime, DateTimeFormatter.ofPattern("HH:mm"));
            LocalTime closing = LocalTime.parse(closeTime, DateTimeFormatter.ofPattern("HH:mm"));
            return closing.isAfter(opening);
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    // Method to display success message
    public void showSuccessMessage(String message) {
        System.out.println("✓ " + message);
    }

    // Method to display error message
    public void showErrorMessage(String message) {
        System.err.println("✗ Error: " + message);
    }

	public void onSuccessFullLibrarySetup() {
		System.out.println("Succefully LIbrary Settuped..!....!");
		mainMenu();
		
	}

	public void mainMenu() {
					
		
		while(true) {
			String choice = "";
			
			System.out.println("\n=======KNOWLEDGW-HUB MAIN MENU======\n");
			System.out.println("1. Books");
			System.out.println("2. Users");
			System.out.println("3. BorrowBooks");
			System.out.println("4. Show Library Details");
			System.out.println("5. logout");
			System.out.println("6. exit..");
			System.out.println("ENTER YOUR CHOICE");

			
			try {
				switch(Integer.parseInt(choice)) {
				
				case 1:
					new BooksView().init();
					return;
				case 2:
					new UsersView().init();
					return;
//				case 3:
//					new BorrowBooksView().init();
//					return;
				case 4:
					new LibraryDetailsView().init();
					return;
				case 5:
					new LoginView().init();
					return;
				case 6:
					System.exit(0);
				default:
					System.out.println("ENTER VALID OPTION..");
				}
				
				
			}catch(Exception e) {
				System.out.println("type valid number........");
			}
		}
		
	}
}