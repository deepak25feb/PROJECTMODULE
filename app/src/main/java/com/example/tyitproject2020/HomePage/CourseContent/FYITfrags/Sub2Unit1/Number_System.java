package com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub2Unit1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.tyitproject2020.R;

public class Number_System extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number__system);
        Intent intent = getIntent();
        String title = intent.getStringExtra("TITLE");
        getSupportActionBar().setTitle(title);
    }
}