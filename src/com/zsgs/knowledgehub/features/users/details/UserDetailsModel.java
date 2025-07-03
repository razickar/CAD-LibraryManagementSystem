package com.zsgs.knowledgehub.features.users.details;

import java.util.Optional;

import com.zsgs.knowledgehub.repository.db.KnowledgeHubDb;
import com.zsgs.knowledgehub.repository.dto.User;


class UserDetailsModel {
	
	private final UserDetailsView view;
	public UserDetailsModel(UserDetailsView view) {
		this.view = view;
	}
	 void getUserDetails(String userId) {
	        if (userId == null || userId.trim().isEmpty()) {
	            view.showMessage("Please enter a valid User ID.");
	            return;
	        }

	        Optional<User> user = KnowledgeHubDb.getInstance().getUsers().stream()
	                .filter(u -> u.getUserId().equals(userId))
	                .findFirst();

	        view.displayUserDetails(user.orElse(null));
	    }
}
