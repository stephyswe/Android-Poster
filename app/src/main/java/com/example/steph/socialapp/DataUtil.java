package com.example.steph.socialapp;

import android.app.ProgressDialog;

public class DataUtil {

    ProgressDialog loadingBar;


    // Credentials for User
    String currentID;
    String profileImage;
    private String username;
    private String fullname;
    private String country;


    public void loadingBarSetup(String title, String message) {
        loadingBar.setTitle(title);
        loadingBar.setMessage(message);
        loadingBar.show();
        loadingBar.setCanceledOnTouchOutside(true);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCurrentID(String currentID) {
        this.currentID = currentID;
    }

    public String getCurrentID() {
        return currentID;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
