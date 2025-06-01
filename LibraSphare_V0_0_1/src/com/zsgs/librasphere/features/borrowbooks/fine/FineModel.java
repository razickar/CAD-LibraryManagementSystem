package com.zsgs.librasphere.features.borrowbooks.fine;

class FineModel {

    private final FineView view;

    public FineModel(FineView view) {
        this.view = view;
    }

    void init() {
        System.out.println("FineModel - " + view);
    }
}
