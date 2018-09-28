package com.example.steph.socialapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class EditPostActivity extends AppCompatActivity {

    private ImageView PostImage;
    private TextView PostDescription;
    private Button PostDeleteButton, PostEditButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_post);

        

        PostImage = findViewById(R.id.post_image);
        PostDescription = findViewById(R.id.post_description);
        PostDeleteButton = findViewById(R.id.post_delete_button);
        PostEditButton = findViewById(R.id.post_edit_button);
    }
}
