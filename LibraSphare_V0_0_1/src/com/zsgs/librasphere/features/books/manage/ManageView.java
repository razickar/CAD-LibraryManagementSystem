package com.zsgs.librasphere.features.books.manage;

public class ManageView {

    private final ManageModel model;

    public ManageView() {
        model = new ManageModel(this);
    }

    public void init() {
        model.init();
    }

    public void onSuccessLogin() {
        System.out.println("ManageView: Login successful");
    }
}
