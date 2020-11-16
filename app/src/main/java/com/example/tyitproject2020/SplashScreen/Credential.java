package com.example.tyitproject2020.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tyitproject2020.R;
import com.google.android.material.button.MaterialButton;

public class Credential extends AppCompatActivity {
    MaterialButton mStudentButton;
    MaterialButton mGuestButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credential);
        mStudentButton = findViewById(R.id.studentButton);
        mGuestButton = findViewById(R.id.guestButton);
        studentListner();
        guestListner();
    }

    //student onclick Listner Method
    void studentListner(){
        mStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Credential.this,StudentLogin.class);
                startActivity(intent);
            }
        });
    }
    //--------------------------------------------------------------------

    //guest onclick Listner
    void guestListner(){
        mGuestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent intent = new Intent(Credential.this,GuestLogin.class);
             startActivity(intent);
            }
        });
    }
    //--------------------------------------------------------------------




} // MainaActivity ends

