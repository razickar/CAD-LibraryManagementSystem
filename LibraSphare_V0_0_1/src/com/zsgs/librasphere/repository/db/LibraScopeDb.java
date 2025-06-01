package com.zsgs.librasphere.repository.db;

import com.zsgs.librasphere.repository.dto.Library;
import com.zsgs.librasphere.repository.dto.RegistrationInfo;

public class LibraScopeDb {
    private static LibraScopeDb sLibraScopeDb;

    private LibraScopeDb() {
    }

    public static LibraScopeDb getInstance() {
        if (sLibraScopeDb == null) {
            sLibraScopeDb = new LibraScopeDb();
        }
        return sLibraScopeDb;
    }

    private RegistrationInfo registrationInfo;
    private Library library;


    public RegistrationInfo getRegistrationInfo() {
        return registrationInfo;
    }

    public void setRegistrationInfo(RegistrationInfo registrationInfo) {
        this.registrationInfo = registrationInfo;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public boolean validateLoginIngo(String userName, String password) {
        return registrationInfo.getUserName().equals(userName) && registrationInfo.getPassword().equals(password);
    }
}
