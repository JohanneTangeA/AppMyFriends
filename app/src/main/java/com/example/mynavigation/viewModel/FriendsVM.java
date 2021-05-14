package com.example.mynavigation.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.mynavigation.Model.Friend;
import com.example.mynavigation.Repository.FriendsRepository;

import java.util.List;

public class FriendsVM extends AndroidViewModel {
    private FriendsRepository friendsRepository;
    private LiveData<List<Friend>> friendsList;

    public FriendsVM(@NonNull Application application) {
        super(application);

        friendsRepository = FriendsRepository.getInstance(application);
        friendsList = new LiveData<List<Friend>>() {
            @Override
            public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super List<Friend>> observer) {
                friendsRepository.getAllFriends().observe(owner, observer);
            }
        };
    }

    public void creteFriend(Friend friend){
        friendsRepository.insertFriend(friend);
    }

    public LiveData<List<Friend>> getFriendsList() {
        return friendsList;
    }
}
