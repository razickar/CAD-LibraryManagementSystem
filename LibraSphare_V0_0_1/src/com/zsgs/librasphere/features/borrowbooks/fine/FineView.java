package com.zsgs.librasphere.features.borrowbooks.fine;

public class FineView {

    private final FineModel model;

    public FineView() {
        model = new FineModel(this);
    }

    public void init() {
        model.init();
    }

    public void onSuccessLogin() {
        System.out.println("FineView: Login successful");
    }
}
