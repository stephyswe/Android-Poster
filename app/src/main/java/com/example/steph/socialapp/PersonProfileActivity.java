package com.example.steph.socialapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class PersonProfileActivity extends AppCompatActivity {

    private TextView userName, userProfileName, userStatus, userCountry, userGender, userRelation, userDOB;
    private CircleImageView userProfileImage;
    private Button SendFriendReqButton, DeclineFriendReqButton;

    private DatabaseReference profileUserRef, UsersRef;
    private FirebaseAuth mAuth;
    private String senderUserId, receiverUserId, currentState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_profile);

        mAuth = FirebaseAuth.getInstance();
        senderUserId = mAuth.getCurrentUser().getUid();

        receiverUserId = getIntent().getExtras().get("visit_user_id").toString();
        UsersRef = FirebaseDatabase.getInstance().getReference().child("Users");

        InitFields();

        UsersRef.child(receiverUserId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    if (dataSnapshot.hasChild("profileimage")) {
                        String myProfileImage = dataSnapshot.child("profileimage").getValue().toString();
                        Picasso.with(PersonProfileActivity.this).load(myProfileImage).placeholder(R.drawable.profile).into(userProfileImage);
                    }

                    String myUserName = dataSnapshot.child("username").getValue().toString();
                    String myProfileName = dataSnapshot.child("fullname").getValue().toString();
                    String myProfileStatus = dataSnapshot.child("status").getValue().toString();
                    String myDOB = dataSnapshot.child("dob").getValue().toString();
                    String myCountry = dataSnapshot.child("country").getValue().toString();
                    String myGender = dataSnapshot.child("gender").getValue().toString();
                    String myRelationStatus = dataSnapshot.child("relationship").getValue().toString();

                    userProfileName.setText(myProfileName);
                    userName.setText("@" + myUserName);
                    userStatus.setText(myProfileStatus);
                    userDOB.setText("DOB: " + myDOB);
                    userCountry.setText("Country: " +myCountry);
                    userGender.setText("Gender: " + myGender);
                    userRelation.setText("Relationship: " + myRelationStatus);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        DeclineFriendReqButton.setVisibility(View.INVISIBLE);
        DeclineFriendReqButton.setEnabled(false);

        if (!senderUserId.equals(receiverUserId)) {
            SendFriendReqButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SendFriendReqButton.setEnabled(false);
                }
            });

        } else {
            SendFriendReqButton.setVisibility(View.INVISIBLE);
            DeclineFriendReqButton.setVisibility(View.INVISIBLE);
        }
    }

    private void InitFields() {
        userName = findViewById(R.id.person_username);
        userProfileName = findViewById(R.id.person_full_name);
        userStatus = findViewById(R.id.person_profile_status);
        userCountry = findViewById(R.id.person_profile_country);
        userGender = findViewById(R.id.person_gender);
        userRelation = findViewById(R.id.person_relationship_status);
        userDOB = findViewById(R.id.person_profile_dob);
        userProfileImage = findViewById(R.id.person_profile_pic);

        SendFriendReqButton = findViewById(R.id.person_send_friend_request_button);
        DeclineFriendReqButton = findViewById(R.id.person_decline_friend_request_button);
        currentState = "not_friends";
    }
}
