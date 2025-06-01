package com.zsgs.librasphere.features.librarysetup;

import com.zsgs.librasphere.repository.db.LibraScopeDb;

class LibrarySetupModel {
    private final LibrarySetupView view;

    public LibrarySetupModel(LibrarySetupView view) {
        this.view = view;
    }

    void init() {
        if(LibraScopeDb.getInstance().getLibrary()==null){
            view.proceedToSetupLibrary();
        }else{
            view.onLibrarySetupCompleted();
        }
    }
}
