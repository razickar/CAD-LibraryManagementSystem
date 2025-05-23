package com.zsgs.knowledgehub.features.registeration;

public class RegisterationModel {
	
	private final RegisterationView view ;
	
	public RegisterationModel(RegisterationView view){
		this.view  = view;
	}
	
	public void init() {
		
		System.out.print("RegisterationModel");
	}
}
