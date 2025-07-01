package com.zsgs.knowledgehub.features.registration;

import com.zsgs.knowledgehub.repository.db.KnowledgeHubDb;
import com.zsgs.knowledgehub.repository.dto.RegistrationInfo;

class RegistrationModel {
	
	private final RegistrationView view;
	
	public RegistrationModel(RegistrationView view) {
		this.view = view;
	}

	 void init() {
		
		if(KnowledgeHubDb.getInstance().getRegistrationInfo() != null) {
			view.proceedLogin();
		}
		else {
			view.proceedRegistrstion();
		}
	}

	 void registerUser(RegistrationInfo info) {
		if(isUserNameAlreadyExists(info.getUserName())) {
			view.errorMessage("USER NAME ALREADY EXISTS");
		}
		else if(isPasswordWeak(info.getPassword())) {
			view.errorMessage("PASSWORD IS SO WEAK");
			
		}
		else if(isConfirmPasswordWrong(info.getConfirmPassword(),info.getPassword())) {
			view.errorMessage("confirm password is wrong");
		
		}
		else {
			KnowledgeHubDb.getInstance().setRegistrationInfo(info);
			view.onSuccessRegistration(info);
		}
		
	}

	private boolean isConfirmPasswordWrong(String confirmPassword, String originalPassword) {
		
		if(confirmPassword.equals(originalPassword)) {
			return false;
		}
		else {
			return true;
		}
		
	     
	}
	private boolean isPasswordWeak(String password) {
		
		return false; // NAMMA LOGIC YELUVOMMM
	}
	private boolean isUserNameAlreadyExists(String userName) {
		
		return false;
	}

}
