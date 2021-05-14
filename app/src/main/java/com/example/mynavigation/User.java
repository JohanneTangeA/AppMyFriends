package com.example.mynavigation;


public class User {

    private String mName;
    private int mIconId;
    private String description;
    private String number;



    public User(String name, int iconId, String desc, String numb) {
        mName = name;
        mIconId = iconId;
        description = desc;
        number = numb;

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
    public String getNumb() {
        return number;
    }


}
