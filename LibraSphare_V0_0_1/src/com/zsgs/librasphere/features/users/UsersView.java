package com.zsgs.librasphere.features.users;

public class UsersView {

    private final UsersModel model;

    public UsersView() {
        model = new UsersModel(this);
    }

    public void init() {
        model.init();
    }

    public void onSuccessLogin() {
        System.out.println("UsersView: Login successful");
    }
}
