package com.example.steph.socialapp;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatActivity extends AppCompatActivity {

    private Toolbar ChatToolbar;
    private ImageButton SendMessageButton, SendImageButton;
    private EditText ChatInputMessage;
    private RecyclerView ChatMessagesList;

    private String MessageReceiverID, MessageReceiverName;

    private TextView ChatReceiverName;
    private CircleImageView ChatReceiverProfileImage;

    private DatabaseReference RootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        RootRef = FirebaseDatabase.getInstance().getReference();

        MessageReceiverID = getIntent().getExtras().get("visit_user_id").toString();
        MessageReceiverName = getIntent().getExtras().get("userName").toString();

        InitializeFields();

        DisplayReceiverInfo();
    }

    private void DisplayReceiverInfo() {
        ChatReceiverName.setText(MessageReceiverName);

        RootRef.child("Users").child(MessageReceiverID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    if (dataSnapshot.hasChild("profileimage")) {
                        final String profileImage = dataSnapshot.child("profileimage").getValue().toString();
                        Picasso.with(ChatActivity.this).load(profileImage).placeholder(R.drawable.profile).into(ChatReceiverProfileImage);
                    }

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void InitializeFields() {
        ChatToolbar = findViewById(R.id.chat_appbar_layout);
        setSupportActionBar(ChatToolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View action_bar_view = layoutInflater.inflate(R.layout.chat_custom_bar, null);
        actionBar.setCustomView(action_bar_view);

        ChatReceiverName = findViewById(R.id.chat_custom_profile_name);
        ChatReceiverProfileImage = findViewById(R.id.chat_custom_profile_image);

        SendMessageButton = findViewById(R.id.chat_send_message_button);
        SendImageButton = findViewById(R.id.chat_send_image_file_button);
        ChatInputMessage = findViewById(R.id.chat_input_message);
        ChatMessagesList = findViewById(R.id.chat_messages_list);
    }
}
