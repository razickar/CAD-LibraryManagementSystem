package com.zsgs.librasphere.features.books;

public class BooksView {

    private final BooksModel model;

    public BooksView() {
        model = new BooksModel(this);
    }

    public void init() {
        model.init();
    }

    public void onSuccessLogin() {
        System.out.println("BooksView: Login successful");
    }
}
