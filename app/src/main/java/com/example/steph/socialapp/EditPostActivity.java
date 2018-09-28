package com.example.steph.socialapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class EditPostActivity extends AppCompatActivity {

    private ImageView PostImage;
    private TextView PostDescription;
    private Button PostDeleteButton, PostEditButton;

    private String PostKey;

    private DatabaseReference EditPostRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_post);

        PostKey = getIntent().getExtras().get("POST_KEY").toString();
        EditPostRef = FirebaseDatabase.getInstance().getReference().child("Posts").child(PostKey);

        PostImage = findViewById(R.id.edit_post_image);
        PostDescription = findViewById(R.id.edit_post_description);
        PostDeleteButton = findViewById(R.id.post_delete_button);
        PostEditButton = findViewById(R.id.post_edit_button);

        EditPostRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String description = dataSnapshot.child("description").getValue().toString();
                String postimage = dataSnapshot.child("postimage").getValue().toString();

                PostDescription.setText(description);
                Picasso.with(EditPostActivity.this).load(postimage).into(PostImage);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
