package com.zsgs.librasphere.features.users.search;

public class SearchView {

    private final SearchModel model;

    public SearchView() {
        model = new SearchModel(this);
    }

    public void init() {
        model.init();
    }

    public void onSuccessLogin() {
        System.out.println("SearchView: Login successful");
    }
}
