package com.example.mynavigation.Model;


public class User {

    private String mName;
    //private int mIconId;
    private String description;
    private String number;
    private String age;
    private String email;
    private String password;

    public User(String mName, String description, String number, String age, String email, String password) {
        this.mName = mName;
        this.description = description;
        this.number = number;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return mName;
    }

   // public int getIconId() {
    //return mIconId;
    //}
    public String getDesc() {
        return description;
    }
    public String getNumb() {
        return number;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
