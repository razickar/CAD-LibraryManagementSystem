package com.zsgs.knowledgehub.features.users.search;

import java.util.List;
import java.util.stream.Collectors;

import com.zsgs.knowledgehub.repository.db.KnowledgeHubDb;
import com.zsgs.knowledgehub.repository.dto.User;



class UserSearchModel {

	private final UserSearchView view;
	public UserSearchModel(UserSearchView view) {
		this.view = view;
	}
	void searchByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            view.showMessage("Please enter a valid name.");
            return;
        }

        List<User> users = KnowledgeHubDb.getInstance().getUsers().stream()
                .filter(user -> user.getFirstName().toLowerCase().contains(name.toLowerCase()) ||
                        user.getLastName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
// 			THIS IS CHECKING FIRST NAME OR LAST NAME.......
        view.displayUsers(users);
    }

    void searchByEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            view.showMessage("Please enter a valid email.");
            return;
        }

        List<User> users = KnowledgeHubDb.getInstance().getUsers().stream()
                .filter(user -> user.getEmail().toLowerCase().contains(email.toLowerCase()))
                .collect(Collectors.toList());

        view.displayUsers(users);
    }

    void searchByMobile(String mobile) {
        if (mobile == null || mobile.trim().isEmpty()) {
            view.showMessage("Please enter a valid mobile number.");
            return;
        }

        List<User> users = KnowledgeHubDb.getInstance().getUsers().stream()
                .filter(user -> user.getMobileNumber().contains(mobile))
                .collect(Collectors.toList());

        view.displayUsers(users);
    }

}
