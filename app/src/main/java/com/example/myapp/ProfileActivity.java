package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;


public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        AppCompatButton police_btn = findViewById(R.id.viewPolice_btn);
        police_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, ListPoliceActivity.class);
                startActivity(intent);
            }
        });

        ImageButton signOut_btn =(ImageButton) findViewById(R.id.signOut_button);
        signOut_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ProfileActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });

//
        LinearLayout list_friend = findViewById(R.id.list_friend);
//        ImageButton signIn_btn =(ImageButton) findViewById(R.id.signOut_button);
//        ConstraintLayout friend_btn = (ConstraintLayout) findViewById(R.id.friends_button) ;
//
//        signIn_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ProfileActivity.this, HomeActivity.class);
//                startActivity(intent);
//            }
//        });
//
        list_friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, ListPoliceActivity.class);
                startActivity(intent);
            }
        });
    }
}