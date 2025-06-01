package com.zsgs.librasphere.features.users.details;

class DetailsModel {

    private final DetailsView view;

    public DetailsModel(DetailsView view) {
        this.view = view;
    }

    void init() {
        System.out.println("DetailsModel - " + view);
    }
}
