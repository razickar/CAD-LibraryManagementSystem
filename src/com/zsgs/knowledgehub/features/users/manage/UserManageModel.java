package com.zsgs.knowledgehub.features.users.manage;

import java.util.List;
import java.util.UUID;

import com.zsgs.knowledgehub.repository.db.KnowledgeHubDb;
import com.zsgs.knowledgehub.repository.dto.User;


class UserManageModel {
	
	private final UserManageView view;
	
	public UserManageModel(UserManageView view) {
		this.view = view; 
	}


    void addUser(User user) {
        if (validateUser(user)) {
            user.setUserId(generateUserId());
            KnowledgeHubDb.getInstance().setUsers(user);
            view.showSuccessMessage("User added successfully!");
        } else {
            view.showErrorMessage("Invalid user information. Please try again.");
        }
    }

    void viewAllUsers() {
        List<User> users = KnowledgeHubDb.getInstance().getUsers();
        view.displayUsers(users);
    }

    private boolean validateUser(User user) {
        return user != null &&
               user.getFirstName() != null && !user.getFirstName().trim().isEmpty() &&
               user.getLastName() != null && !user.getLastName().trim().isEmpty() &&
               user.getEmail() != null && user.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$") &&
               user.getMobileNumber() != null && user.getMobileNumber().matches("\\d{10}") &&
               user.getAddress() != null && !user.getAddress().trim().isEmpty() &&
               user.getDOB() != null && user.getDOB().matches("\\d{2}/\\d{2}/\\d{4}");
    }

    private String generateUserId() {
        return "USR" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}


