package com.example.mynavigation.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "friends")
public class Friend {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String description;

    public Friend(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}

