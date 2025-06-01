package com.zsgs.librasphere.features.users.search;

class SearchModel {

    private final SearchView view;

    public SearchModel(SearchView view) {
        this.view = view;
    }

    void init() {
        System.out.println("SearchModel - " + view);
    }
}
