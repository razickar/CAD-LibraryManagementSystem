package com.zsgs.knowledgehub;

import com.zsgs.knowledgehub.features.registration.RegistrationView;

public class KnowlwdgeHubMain {
	public static final String appVersion = "0.0.1";

    public static final String appName = "KnowlwdgeHub";

	public static void main(String[] args) {
		
		System.out.println("Welcome to "+appName+"\n");
		 
		    
		new RegistrationView().init();

	}

}
