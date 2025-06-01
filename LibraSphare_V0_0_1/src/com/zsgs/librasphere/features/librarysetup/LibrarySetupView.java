package com.zsgs.librasphere.features.librarysetup;

import com.zsgs.librasphere.features.registration.RegistrationModel;

public class LibrarySetupView {

    private final LibrarySetupModel model;

    public LibrarySetupView() {
        model = new LibrarySetupModel(this);
    }

    public void init() {
        model.init();
    }

    public void proceedToSetupLibrary() {
        //Write the code for setup library
        System.out.println("\n\n\nLibrary development is Under development");
        System.out.println("continue your code from here! - All the best");
    }

    public void onLibrarySetupCompleted() {

    }
}
