package com.zsgs.librasphere.features.books;

class BooksModel {

    private final BooksView view;

    public BooksModel(BooksView view) {
        this.view = view;
    }

    void init() {
        System.out.println("BooksModel - " + view);
    }
}
