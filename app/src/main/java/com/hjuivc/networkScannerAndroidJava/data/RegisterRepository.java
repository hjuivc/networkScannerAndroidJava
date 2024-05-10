package com.hjuivc.networkScannerAndroidJava.data;

import com.hjuivc.networkScannerAndroidJava.data.model.RegisteredInUser;

/**
 * Class that requests registration and user information from the remote data source and
 * maintains an in-memory cache of registration status and user credentials information.
 */
public class RegisterRepository {

    private static volatile RegisterRepository instance;

    private RegisterDataSource dataSource;

    // If user credentials will be cached in local storage, it is recommended it be encrypted
    // @see https://developer.android.com/training/articles/keystore
    private RegisteredInUser user = null;

    // private constructor : singleton access
    private RegisterRepository(RegisterDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static RegisterRepository getInstance(RegisterDataSource dataSource) {
        if(instance == null){
            instance = new RegisterRepository(dataSource);
        }
        return instance;
    }

    public boolean isRegistered() {
        return user != null;
    }

    private void setRegisteredUser(RegisteredInUser user) {
        this.user = user;
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }

    public Result<RegisteredInUser> register(String email, String password) {
        // handle registration
        Result<RegisteredInUser> result = dataSource.register(email, password);
        if (result instanceof Result.Success) {
            setRegisteredUser(((Result.Success<RegisteredInUser>) result).getData());
        }
        return result;
    }
}