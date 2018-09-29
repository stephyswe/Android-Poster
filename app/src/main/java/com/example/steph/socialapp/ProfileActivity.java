package com.example.steph.socialapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    private TextView userName, userProfileName, userStatus, userCountry, userGender, userRelation, userDOB;
    private CircleImageView userProfileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        userName = findViewById(R.id.my_username);
        userProfileName = findViewById(R.id.my_profile_full_name);
        userStatus = findViewById(R.id.my_profile_status);
        userCountry = findViewById(R.id.my_profile_country);
        userGender = findViewById(R.id.my_gender);
        userRelation = findViewById(R.id.my_relationship_status);
        userDOB = findViewById(R.id.my_profile_dob);
        userProfileImage = findViewById(R.id.my_profile_pic);
    }
}
