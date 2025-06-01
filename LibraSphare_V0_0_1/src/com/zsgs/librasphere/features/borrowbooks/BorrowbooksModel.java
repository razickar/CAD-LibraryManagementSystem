package com.zsgs.librasphere.features.borrowbooks;

class BorrowbooksModel {

    private final BorrowbooksView view;

    public BorrowbooksModel(BorrowbooksView view) {
        this.view = view;
    }

    void init() {
        System.out.println("BorrowbooksModel - " + view);
    }
}
