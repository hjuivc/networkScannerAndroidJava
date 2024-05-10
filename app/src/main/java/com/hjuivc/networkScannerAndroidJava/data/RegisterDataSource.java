package com.hjuivc.networkScannerAndroidJava.data;

import com.hjuivc.networkScannerAndroidJava.data.model.LoggedInUser;
import com.hjuivc.networkScannerAndroidJava.data.model.RegisteredInUser;

import java.io.IOException;

public class RegisterDataSource {
    public Result<RegisteredInUser> register(String email, String password) {
        try {
            // TODO: handle loggedInUser authentication
            LoggedInUser fakeUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            "Jane Doe");
            return new Result.Success<>(fakeUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }
}
