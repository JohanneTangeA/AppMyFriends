package com.example.mynavigation.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mynavigation.DAO.FriendDAO;
import com.example.mynavigation.Model.Friend;

@Database(entities = {Friend.class}, version = 1)
public abstract class FriendsDB extends RoomDatabase {

    private static FriendsDB instance;
    public abstract FriendDAO friendsDao();

    public static synchronized FriendsDB getInstance(Context context){
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    FriendsDB.class, "friends")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}

