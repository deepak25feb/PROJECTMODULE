package com.example.tyitproject2020.HomePage.CourseContent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.tyitproject2020.R;

public class SYITcourse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_y_i_tcourse);
        Intent intent = getIntent();
        String name = intent.getStringExtra("subjectName");
        String id =intent.getStringExtra("subjectCode");
        getSupportActionBar().setTitle(name);
    }
}