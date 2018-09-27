package com.example.steph.socialapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import de.hdodenhof.circleimageview.CircleImageView;

public class SetupActivity extends AppCompatActivity {

    private EditText userName, fullName, country;
    private Button saveButton;
    private CircleImageView profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        IntializeFields();

    }

    private void IntializeFields() {
        userName = findViewById(R.id.setup_username);
        fullName = findViewById(R.id.setup_full_name);
        country = findViewById(R.id.setup_country);
        saveButton = findViewById(R.id.setup_save_button);
        profileImage = findViewById(R.id.setup_profile_image);
    }
}
