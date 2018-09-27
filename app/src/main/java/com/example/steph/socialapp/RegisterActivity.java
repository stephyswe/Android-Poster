package com.example.steph.socialapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    private EditText regEmail, regPassword, regConfirmPassword;
    private Button regAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        IntializeFields();

    }

    private void IntializeFields() {
        regEmail = findViewById(R.id.register_email);
        regPassword = findViewById(R.id.register_password);
        regConfirmPassword = findViewById(R.id.register_confirm_password);
        regAccountButton = findViewById(R.id.register_create_account_button);
    }
}
