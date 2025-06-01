package com.zsgs.librasphere;


import com.zsgs.librasphere.features.registration.RegistrationView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Librasphere {

    public static final String appVersion = "0.0.1";

    public static final String appName = "Librasphare";

    public static void main(String[] args) {
        System.out.println("Welcome to " + appName + " - Version: " + appVersion);
        new RegistrationView().init();
    }
}