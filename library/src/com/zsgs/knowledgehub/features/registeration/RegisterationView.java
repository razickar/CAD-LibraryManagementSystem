package com.zsgs.knowledgehub.features.registeration;

public class RegisterationView {

	
	private final RegisterationModel model ;
	
	public RegisterationView(){
		model = new RegisterationModel(this);
	}
	
	public void init() {
		model.init();
		System.out.println("\nRegisterationView");
	}
}
