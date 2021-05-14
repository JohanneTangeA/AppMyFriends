package com.example.mynavigation.Repository;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.core.os.HandlerCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.mynavigation.DAO.FriendDAO;
import com.example.mynavigation.Database.FriendsDB;
import com.example.mynavigation.Model.Friend;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FriendsRepository {
    private static FriendsRepository instance;
    FriendsDB friendsDB;
    FriendDAO friendDAO;
    ExecutorService executorService;
    Handler mainThreadHandler;

    LiveData<List<Friend>> allFriends;

    public FriendsRepository(Application app) {
        friendsDB = FriendsDB.getInstance(app);
        friendDAO = friendsDB.friendsDao();
        executorService = Executors.newFixedThreadPool(2);
        mainThreadHandler = HandlerCompat.createAsync(Looper.getMainLooper());

        allFriends = new LiveData<List<Friend>>() {
            @Override
            public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super List<Friend>> observer) {
                friendDAO.getAllFriends().observe(owner, observer);

            }
        };

    }
    public static FriendsRepository getInstance(Application app){
        if (instance == null){
            instance = new FriendsRepository(app);
        }
        return instance;
    }

    public LiveData<List<Friend>> getAllFriends() {
        return allFriends;
    }

    public void insertFriend(Friend friend){

        executorService.execute(()->{
            friendDAO.insert(friend);
        });
    }


}
