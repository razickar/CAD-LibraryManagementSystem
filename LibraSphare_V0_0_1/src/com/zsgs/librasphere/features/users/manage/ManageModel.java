package com.zsgs.librasphere.features.users.manage;

class ManageModel {

    private final ManageView view;

    public ManageModel(ManageView view) {
        this.view = view;
    }

    void init() {
        System.out.println("ManageModel - " + view);
    }
}
