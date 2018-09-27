package com.example.steph.socialapp;

import android.app.ProgressDialog;

public class DataUtil {

    ProgressDialog loadingBar;

    public void loadingBarSetup(String title, String message) {
            loadingBar.setTitle(title);
            loadingBar.setMessage(message);
            loadingBar.show();
            loadingBar.setCanceledOnTouchOutside(true);

    }


}
