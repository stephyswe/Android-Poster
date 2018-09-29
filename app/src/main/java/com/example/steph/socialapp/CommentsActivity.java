package com.example.steph.socialapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageButton;

public class CommentsActivity extends AppCompatActivity {

    private ImageButton PostCommentButton;
    private EditText CommentInputText;
    private RecyclerView CommentsList;

    private String Post_Key;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        Post_Key = getIntent().getExtras().get("POST_KEY").toString();

        CommentsList = findViewById(R.id.comments_list);
        CommentsList.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        CommentsList.setLayoutManager(linearLayoutManager);

        PostCommentButton = findViewById(R.id.post_comment_button);
        CommentInputText = findViewById(R.id.comment_input);

    }
}
