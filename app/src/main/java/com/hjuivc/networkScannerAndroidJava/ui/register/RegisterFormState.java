package com.hjuivc.networkScannerAndroidJava.ui.register;

public class RegisterFormState {
    // Data validation state of the register form. Remember that it only has e-mail / password and checked the FAQ checkbox
    private final Integer emailError;
    private final Integer passwordError;
    private Integer faqError = null;
    private final boolean isDataValid;

    // Constructor
    public RegisterFormState(Integer emailError, Integer passwordError) {
        this.emailError = emailError;
        this.passwordError = passwordError;
        this.faqError = faqError;
        this.isDataValid = false;
    }

    // Constructor
    public RegisterFormState(boolean isDataValid) {
        this.emailError = null;
        this.passwordError = null;
        this.faqError = null;
        this.isDataValid = isDataValid;
    }

    // Getters
    public Integer getEmailError() {
        return emailError;
    }

    public Integer getPasswordError() {
        return passwordError;
    }

    public Integer getFaqError() {
        return faqError;
    }

    public boolean isDataValid() {
        return isDataValid;
    }

    // Check if the form is valid
    public boolean isFormValid() {
        return emailError == null && passwordError == null && faqError == null;
    }

    // Check if the email is valid
    public boolean isEmailValid() {
        return emailError == null;
    }

    // Check if the password is valid
    public boolean isPasswordValid() {
        return passwordError == null;
    }

    // Check if the FAQ checkbox is checked
    public boolean isFaqValid() {
        return faqError == null;
    }

    // Check if the email is empty
    public boolean isEmailEmpty() {
        return emailError == null && passwordError == null && faqError == null && !isDataValid;
    }

    // Check if the password is empty
    public boolean isPasswordEmpty() {
        return emailError == null && passwordError == null && faqError == null && !isDataValid;
    }

    // Check if the FAQ checkbox is empty
    public boolean isFaqEmpty() {
        return emailError == null && passwordError == null && faqError == null && !isDataValid;
    }

    // Check if the email is invalid
    public boolean isEmailInvalid() {
        return emailError != null;
    }

    // Check if the password is invalid
    public boolean isPasswordInvalid() {
        return passwordError != null;
    }

    // Check if the FAQ checkbox is invalid
    public boolean isFaqInvalid() {
        return faqError != null;
    }
}
