package com.zsgs.librasphere.features.registration;

import com.zsgs.librasphere.Librasphere;
import com.zsgs.librasphere.repository.db.LibraScopeDb;
import com.zsgs.librasphere.repository.dto.RegistrationInfo;

public class RegistrationModel {
    private final RegistrationView view;

    public RegistrationModel(RegistrationView registrationView) {
        view = registrationView;
    }

    void init() {
        if (LibraScopeDb.getInstance().getRegistrationInfo() != null) {
            view.proceedLogin();
        } else {
            view.proceedRegistration();
        }
    }

    void registerUser(RegistrationInfo info) {
        if (ifAlreadyExisit(info.getUserName())) {
            view.showErrorMessage("Username already Exist");
        } else if (isWeakPassword()) {
            view.showErrorMessage("Please enter strong password");
        } else {
            LibraScopeDb.getInstance().setRegistrationInfo(info);
            view.onRegistrationSuccess(info);
        }
    }

    private boolean isWeakPassword() {
        return false; // Write your logics here
    }

    private boolean ifAlreadyExisit(String userName) {
        return false;
    }

    public void validateCredentials(String userName, String password) {
        if(LibraScopeDb.getInstance().validateLoginIngo(userName,password)){
            view.onSuccessLogin(userName);
        } else{
            view.onInvalidCredentials();
        }
    }
}
