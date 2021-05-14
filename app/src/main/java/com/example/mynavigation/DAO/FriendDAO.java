package com.example.mynavigation.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mynavigation.Model.Friend;

import java.util.List;

@Dao
public interface FriendDAO {
    @Insert
    void insert(Friend note);

    // @Update
    // void update(Note note);

    //@Delete
    //void delete(Note note);

    // @Query("DELETE FROM note_table")
    // void deleteAllNotes();

    @Query("SELECT * FROM friends;")
    LiveData<List<Friend>> getAllFriends();
}

