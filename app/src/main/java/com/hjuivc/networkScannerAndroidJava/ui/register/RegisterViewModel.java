package com.hjuivc.networkScannerAndroidJava.ui.register;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import android.util.Patterns;

import com.hjuivc.networkScannerAndroidJava.data.RegisterRepository;
import com.hjuivc.networkScannerAndroidJava.data.Result;
import com.hjuivc.networkScannerAndroidJava.data.model.LoggedInUser;
import com.hjuivc.networkScannerAndroidJava.R;
import com.hjuivc.networkScannerAndroidJava.data.model.RegisteredInUser;
import com.hjuivc.networkScannerAndroidJava.ui.login.LoggedInUserView;

public class RegisterViewModel extends ViewModel {

    private MutableLiveData<RegisterFormState> registerFormState = new MutableLiveData<>();
    private MutableLiveData<RegisterResult> registerResult = new MutableLiveData<>();
    private RegisterRepository registerRepository;

    RegisterViewModel(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    LiveData<RegisterFormState> getRegisterFormState() {
        return registerFormState;
    }

    LiveData<RegisterResult> getRegisterResult() {
        return registerResult;
    }

    public void register(String email, String password) {
        // can be launched in a separate asynchronous job
        Result<RegisteredInUser> result = registerRepository.register(email, password);

        if (result instanceof Result.Success) {
            RegisteredInUser data = ((Result.Success<RegisteredInUser>) result).getData();
            registerResult.setValue(new RegisterResult(new RegisteredUserView(data.getEmail())));
        } else {
            registerResult.setValue(new RegisterResult(R.string.register_failed));
        }
    }

    public void registerDataChanged(String email, String password) {
        if (!isEmailValid(email)) {
            registerFormState.setValue(new RegisterFormState(R.string.invalid_email, null));
        } else if (!isPasswordValid(password)) {
            registerFormState.setValue(new RegisterFormState(null, R.string.invalid_password));
        } else {
            registerFormState.setValue(new RegisterFormState(true));
        }
    }

    // A placeholder email validation check
    private boolean isEmailValid(String email) {
        if (email == null) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }
}
