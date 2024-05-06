package com.hjuivc.networkScannerAndroidJava.ui.register;

public class RegisteredUserView {
    private String displayName;
    private String email;

    public RegisteredUserView(String displayName, String email) {
        this.displayName = displayName;
        this.email = email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }
}
