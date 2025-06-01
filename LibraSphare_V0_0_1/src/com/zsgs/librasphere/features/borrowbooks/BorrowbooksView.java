package com.zsgs.librasphere.features.borrowbooks;

public class BorrowbooksView {

    private final BorrowbooksModel model;

    public BorrowbooksView() {
        model = new BorrowbooksModel(this);
    }

    public void init() {
        model.init();
    }

    public void onSuccessLogin() {
        System.out.println("BorrowbooksView: Login successful");
    }
}
