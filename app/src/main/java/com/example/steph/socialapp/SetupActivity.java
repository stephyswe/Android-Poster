package com.example.steph.socialapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class SetupActivity extends AppCompatActivity {

    private EditText userName, fullName, countrySelector;
    private Button saveButton;
    private CircleImageView profileImage;
    private ProgressDialog loadingBar;

    private DatabaseReference UsersRef;

    private FirebaseAuth mAuth;
    private String currentID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        InitFields();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetupInformation();
            }
        });

    }

    private void SetupInformation() {
        String username = userName.getText().toString();
        String full_name = fullName.getText().toString();
        String country = countrySelector.getText().toString();

        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "Please write your username..", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(full_name)) {
            Toast.makeText(this, "Please write your full name..", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(country)) {
            Toast.makeText(this, "Please write your country..", Toast.LENGTH_SHORT).show();
        } else {

            loadingBarSetup("Saving Information","Please wait, updating profile information");

            HashMap userMap = new HashMap();
            userMap.put("username", username);
            userMap.put("full_name", full_name);
            userMap.put("country", country);
            userMap.put("status", "hey there, i am using this App");
            userMap.put("gender", "");
            userMap.put("dob", "");
            userMap.put("relationship", "");
            UsersRef.updateChildren(userMap).addOnCompleteListener(new OnCompleteListener() {
                @Override
                public void onComplete(@NonNull Task task) {
                    if(task.isSuccessful()) {
                        SendUserToMainActivity();
                        Toast.makeText(SetupActivity.this, "Your account is created Successfully.", Toast.LENGTH_LONG).show();
                        loadingBar.dismiss();
                    } else {
                        String message = task.getException().getMessage();
                        Toast.makeText(SetupActivity.this, "Error occurred: " + message, Toast.LENGTH_SHORT).show();
                        loadingBar.dismiss();
                    }
                }
            });
        }
    }

    private void SendUserToMainActivity() {
        Intent mainIntent = new Intent(SetupActivity.this, MainActivity.class);
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainIntent);
        finish();
    }

    private void InitFields() {
        userName = findViewById(R.id.setup_username);
        fullName = findViewById(R.id.setup_full_name);
        countrySelector = findViewById(R.id.setup_country);
        saveButton = findViewById(R.id.setup_save_button);
        profileImage = findViewById(R.id.setup_profile_image);
        loadingBar = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();
        currentID = mAuth.getCurrentUser().getUid();
        UsersRef = FirebaseDatabase.getInstance().getReference().child("Users").child(currentID);

    }

    public void loadingBarSetup(String title, String message) {
        loadingBar.setTitle(title);
        loadingBar.setMessage(message);
        loadingBar.show();
        loadingBar.setCanceledOnTouchOutside(true);
    }
}
