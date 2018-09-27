package com.example.steph.socialapp;

import android.app.ProgressDialog;

public class DataUtil {

    ProgressDialog loadingBar;
    String currentID;

    public void loadingBarSetup(String title, String message) {
        loadingBar.setTitle(title);
        loadingBar.setMessage(message);
        loadingBar.show();
        loadingBar.setCanceledOnTouchOutside(true);
    }

    public void setCurrentID(String currentID) {
        this.currentID = currentID;
    }

    public String getCurrentID() {
        return currentID;
    }
}
