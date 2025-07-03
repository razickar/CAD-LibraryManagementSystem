package com.zsgs.knowledgehub.features.registration;

import java.util.Scanner;

import com.zsgs.knowledgehub.features.baseview.BaseView;
import com.zsgs.knowledgehub.features.login.LoginView;
import com.zsgs.knowledgehub.repository.dto.RegistrationInfo;

public class RegistrationView extends BaseView {

	  private final Scanner sc = new Scanner(System.in);
	
	private final RegistrationModel model;
	
	public RegistrationView() {
		model = new RegistrationModel(this);
	}
	
	public void init() {
		model.init();
		
	}

	public void proceedLogin() {
		
		new LoginView().init();
	}

	public void proceedRegistrstion() {
		System.out.println("REGISTRATION...");
		RegistrationInfo info = new RegistrationInfo();
		System.out.println("ENTER FIRST NAME");
		info.setFirstName(sc.nextLine());
		System.out.println("ENTER LAST NAME");
		info.setLastName(sc.nextLine());
	//	System.out.println("ENTER USER NAME ");
		info.setUserName(getUserName("ENTER YOUR USER NAME","INVALID LENGTH"));
		
		info.setPassword(getPassword());
		System.out.println("CoNFIRM PASSWORD");
		info.setConfirmPassword(getPassword());
		
		model.registerUser(info); 
			
		}
		
	

	private String getPassword() {
		
		String password = "";
		System.out.println("ENTER PASSWORD ");
		do {
			password = sc.nextLine();
			
//			 if(isWeakPassword(password)) {
//				 System.out.println("Password must include uppercase, number, special char!");
//
//			}
			if(false) {}
			else break;
			
		}while(true);
		return password;
	}

	private boolean isWeakPassword(String password) {
		 // Check length first
	    if (password.length() < 3 || password.length() > 10) {
	    	System.out.println("length is invalid");
	        return false;
	    }
	    // Regex:
	    // (?=.*[A-Z]) → at least one uppercase
	    // (?=.*[0-9]) → at least one digit
	    // (?=.*[!@#$%^&*()_+=-]) → at least one special char
	    String pattern = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+=-]).{3,10}$";
	    return !password.matches(pattern);
	}

	private String getUserName(String string, String invalidMsg) {
		String userName = "";
		System.out.println(string);
		do {
			userName = sc.nextLine();
			
			if(userName.length() < 3 || userName.length() < 5) {
				System.out.println(invalidMsg);
			}
			else break;
			
		}while(true);
		return userName;
	}

	public void errorMessage(String string) {
		System.out.println(string);
		
	}

	public void onSuccessRegistration(RegistrationInfo info) {
		System.out.println("successfully registered...!!!\n");
	    proceedLogin();
	    
	}

}
