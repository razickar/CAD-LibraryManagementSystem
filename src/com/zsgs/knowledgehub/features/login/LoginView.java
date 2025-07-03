package com.zsgs.knowledgehub.features.login;

import java.util.Scanner;

import com.zsgs.knowledgehub.features.baseview.BaseView;
import com.zsgs.knowledgehub.features.librarysetup.LibrarySetupView;

public class LoginView extends BaseView {
	
	 private final Scanner sc = new Scanner(System.in);
	private final LoginModel model;
	
	public LoginView() {
		model = new LoginModel(this);
	}

	public  void init() {
		model.ValidateCredential(getUserName("ENTER USER-NAME","INVALID CRIDENTIAL"),getPassword());
			
	}

	private String getPassword() {
		
		String password = "";
		System.out.println("ENTER PASSWORD ");
		do {
			password = sc.nextLine();
			
			if(password.length() < 3 || password.length() < 10) {
				System.out.println("weak pasword!!!");
			}
			else break;
			
		}while(true);
		return password;
	}

	private  String getUserName(String string, String invalidMsg) {
		System.out.println("LOGIN.....");
		String userName = "";
		System.out.println(string);
		do {
			userName = sc.nextLine();
			
			if(userName.length() < 3 || userName.length() > 20) {
				System.out.println(invalidMsg);
			}
			else break;
			
		}while(true);
		return userName;
	}

	public void invalidCretentialMsg() {
		System.out.println("INVALID CRITENTIAL ! \n do you want caontinue to login  ( y / n )");
		
		if(sc.nextLine().equalsIgnoreCase("y")) {
			init();	
		}
		else {
			System.out.println("THANKYOU FOR USING KNOWLWDGEHUB");
		}
		
		
	}

	public void onSuccessfullLogin(String userName) {
		System.out.println("LOGIN SUCCESSFULLY!!!!! "+userName);
		new LibrarySetupView().init();
		
	}

}
