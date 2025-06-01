package com.zsgs.librasphere.features.users;

class UsersModel {

    private final UsersView view;

    public UsersModel(UsersView view) {
        this.view = view;
    }

    void init() {
        System.out.println("UsersModel - " + view);
    }
}
