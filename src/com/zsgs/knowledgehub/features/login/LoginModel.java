package com.zsgs.knowledgehub.features.login;


import com.zsgs.knowledgehub.repository.db.KnowledgeHubDb;

class LoginModel {
		
	private final LoginView view;
	
	public LoginModel(LoginView view) {
	
		this.view = view;
	}

	 void ValidateCredential(String userName, String password) {
		if(KnowledgeHubDb.getInstance().isValidCrediential(userName,password)) {
			view.onSuccessfullLogin(userName);
		}
		else {
			view.invalidCretentialMsg();
		}
		
	}

	
}
