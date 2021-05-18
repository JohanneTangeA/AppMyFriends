package com.example.mynavigation.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mynavigation.Model.Friend;

import java.util.List;

@Dao
public interface FriendDAO {
    @Insert
    void insert(Friend friend);

    @Query("SELECT * FROM friends;")
    LiveData<List<Friend>> getAllFriends();
}

