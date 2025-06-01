package com.zsgs.librasphere.features.registration;

import com.zsgs.librasphere.repository.dto.RegistrationInfo;
import com.zsgs.librasphere.features.librarysetup.LibrarySetupView;

import java.util.Scanner;

public class RegistrationView {

    private final RegistrationModel model;

    private final Scanner scanner = new Scanner(System.in);

    public RegistrationView() {
        model = new RegistrationModel(this);
    }

    public void init() {
        model.init();
    }


    public void onRegistrationSuccess(RegistrationInfo info) {
        System.out.println("Registration Successfull!");
        init();
    }

    public void proceedRegistration() {
        System.out.println("Please provide the following info for registration");
        RegistrationInfo info = new RegistrationInfo();
        info.setFirstName(getName());
        info.setUserName(getUserName("Enter User name", "username should not be empty and length min 3 and max 20\n\nEnter valid username:"));
        info.setPassword(getPassword());
        model.registerUser(info);
    }

    public void showErrorMessage(String usernameAlreadyExist) {
        System.out.println(usernameAlreadyExist);
        proceedRegistration();
    }

    public void proceedLogin() {
        model.validateCredentials(getUserName("Enter user name for login", "Enter valid user name"), getPasswordForLogin());
    }

    public void onSuccessLogin(String userName) {
        System.out.println("Logged in successfully!");
        System.out.println("Welcome " + userName);
        new LibrarySetupView().init();
    }

    private String getName() {
        String userName = "";
        System.out.println("Enter name");
        do {
            userName = scanner.nextLine();
            if (userName.length() < 3 || userName.length() > 50)
                System.out.println("Name should not be empty and length min 3 and Max 50\n\nEnter valid name:");
            else break;
        } while (true);
        return userName;
    }

    private String getUserName(String initialInfo, String errorInfo) {
        String userName = "";
        System.out.println(initialInfo);
        do {
            userName = scanner.nextLine();
            if (userName.length() < 3 || userName.length() > 20) System.out.println(errorInfo);
            else break;
        } while (true);
        return userName;
    }

    private String getPassword() {
        String password = "";
        System.out.println("Enter password");
        do {
            password = scanner.nextLine();
            if (password.length() < 8 || password.length() > 32)
                System.out.println("Password should not be empty and length min 8 and max 32\n\nEnter valid password:");
            else break;
        } while (true);
        System.out.println("Confirm password");
        do {
            String confirmPassword = scanner.nextLine();
            if (!password.equals(confirmPassword))
                System.out.println("Password did not match. \n\nEnter confirm password again");
            else break;
        } while (true);
        return password;
    }

    private String getPasswordForLogin() {
        String password = "";
        System.out.println("Enter password");
        do {
            password = scanner.nextLine();
            if (password.length() < 8 || password.length() > 32) System.out.println("Enter valid password");
            else break;
        } while (true);
        return password;
    }

    public void onInvalidCredentials() {
        System.out.println("Username and password did not match");
        System.out.println("Do you want to proceed? Type Y or N");
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            proceedLogin();
        }
    }
}
