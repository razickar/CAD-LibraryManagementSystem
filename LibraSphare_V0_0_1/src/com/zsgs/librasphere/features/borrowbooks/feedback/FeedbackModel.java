package com.zsgs.librasphere.features.borrowbooks.feedback;

class FeedbackModel {

    private final FeedbackView view;

    public FeedbackModel(FeedbackView view) {
        this.view = view;
    }

    void init() {
        System.out.println("FeedbackModel - " + view);
    }
}
