package com.hjuivc.networkScannerAndroidJava.ui.register;

public class RegisteredUserView {
    private String displayName;
    private String email;

    public RegisteredUserView(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
