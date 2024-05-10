package com.hjuivc.networkScannerAndroidJava.ui.register;

public class RegisterResult {
    private boolean success;
    private String error;

    public RegisterResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public RegisterResult(int registerFailed) {

    }

    public RegisterResult(RegisteredUserView registeredUserView) {
    }

    public boolean isSuccess() {
        return success;
    }

    public String getError() {
        return error;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setError(String error) {
        this.error = error;
    }
}
