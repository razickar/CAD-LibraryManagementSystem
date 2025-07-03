package com.zsgs.knowledgehub.features.baseview;

import com.zsgs.knowledgehub.features.registration.RegistrationView;

public class BaseView {

	 protected void logoutApp(){
	        System.out.println("Logging out...");
	        new RegistrationView().init();
	    }
	    protected void exitApp(){
	        System.out.println("Thank you for using KnowlwdgeHub!");
	        System.exit(0);
	    }
	    public void showMessage(String message) {
	        System.out.println(message);
	    }
}
