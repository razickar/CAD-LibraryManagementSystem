package com.zsgs.librasphere.features.users.details;

public class DetailsView {

    private final DetailsModel model;

    public DetailsView() {
        model = new DetailsModel(this);
    }

    public void init() {
        model.init();
    }

    public void onSuccessLogin() {
        System.out.println("DetailsView: Login successful");
    }
}
