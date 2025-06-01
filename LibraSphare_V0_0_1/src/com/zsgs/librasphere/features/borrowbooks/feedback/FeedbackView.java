package com.zsgs.librasphere.features.borrowbooks.feedback;

public class FeedbackView {

    private final FeedbackModel model;

    public FeedbackView() {
        model = new FeedbackModel(this);
    }

    public void init() {
        model.init();
    }

    public void onSuccessLogin() {
        System.out.println("FeedbackView: Login successful");
    }
}
