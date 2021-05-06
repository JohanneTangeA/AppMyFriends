package com.example.mynavigation;


public class User {

    private String mName;
    private int mIconId;
    private String description;



    public User(String name, int iconId, String desc) {
        mName = name;
        mIconId = iconId;
        description = desc;
    }

    public String getName() {
        return mName;
    }

    public int getIconId() {
        return mIconId;
    }
    public String getDesc() {
        return description;
    }


}
