package com.example.mynavigation.viewModel;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mynavigation.Repository.AuthAppRepository;
import com.google.firebase.auth.FirebaseUser;

public class SignInViewModel extends AndroidViewModel {
    private AuthAppRepository authAppRepository;
    private MutableLiveData<FirebaseUser> userLiveData;

    public SignInViewModel(@NonNull Application application) {
        super(application);
        authAppRepository = new AuthAppRepository(application);
        userLiveData = authAppRepository.getUserLiveData();
    }

    public void login(String email, String password) {
        authAppRepository.login(email, password);
    }

    public void register(String email, String password) {
        authAppRepository.register(email, password);
    }

    public MutableLiveData<FirebaseUser> getUserLiveData() {
        return userLiveData;
    }
    public LiveData<FirebaseUser> getCurrentUser(){
        return authAppRepository.getCurrentUser();
    }
}
