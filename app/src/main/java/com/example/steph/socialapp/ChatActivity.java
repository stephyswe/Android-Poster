package com.example.steph.socialapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.ImageButton;

public class ChatActivity extends AppCompatActivity {

    private Toolbar ChatToolbar;
    private ImageButton SendMessageButton, SendImageButton;
    private EditText ChatInputMessage;
    private RecyclerView ChatMessagesList;

    private String MessageReceiverID, MessageReceiverName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        MessageReceiverID = getIntent().getExtras().get("visit_user_id").toString();
        MessageReceiverName = getIntent().getExtras().get("userName").toString();

        InitializeFields();
    }

    private void InitializeFields() {

        ChatToolbar = findViewById(R.id.chat_appbar_layout);
        setSupportActionBar(ChatToolbar);

        SendMessageButton = findViewById(R.id.chat_send_message_button);
        SendImageButton = findViewById(R.id.chat_send_image_file_button);
        ChatInputMessage = findViewById(R.id.chat_input_message);
        ChatMessagesList = findViewById(R.id.chat_messages_list);


    }
}
