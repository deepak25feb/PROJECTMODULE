package com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub3Unit1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.tyitproject2020.R;

public class Principles_of_Input_Output extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principles_of__input__output);
        Intent intent = getIntent();
        String title = intent.getStringExtra("TITLE");
        getSupportActionBar().setTitle(title);
    }
}