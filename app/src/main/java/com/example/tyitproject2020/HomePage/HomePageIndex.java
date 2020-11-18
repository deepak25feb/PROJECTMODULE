package com.example.tyitproject2020.HomePage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tyitproject2020.R;

public class HomePageIndex extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_index);
        getActionBar().setTitle("WELCOME");

    }
}