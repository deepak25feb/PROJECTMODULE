package com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub1Unit2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.tyitproject2020.R;

public class FYITSUB2_subpart_Conditional_Statements_and_Loops extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_y_i_t_s_u_b2_subpart__conditional__statements_and__loops);
        Intent intent = getIntent();
        String title = intent.getStringExtra("TITLE");
        getSupportActionBar().setTitle(title);
    }
}