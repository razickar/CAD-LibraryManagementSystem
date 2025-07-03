package com.zsgs.knowledgehub.features.users;

import java.util.List;

import com.zsgs.knowledgehub.repository.db.KnowledgeHubDb;
import com.zsgs.knowledgehub.repository.dto.User;

class UsersModel {
	
	private final UsersView view;
	
	public UsersModel(UsersView view) {
		this.view = view;
	}

	 void listAllUsers() {
		
		 List<User> users = KnowledgeHubDb.getInstance().getUsers();
		 
		 view.displayAllUsers(users);
		
	}

}
