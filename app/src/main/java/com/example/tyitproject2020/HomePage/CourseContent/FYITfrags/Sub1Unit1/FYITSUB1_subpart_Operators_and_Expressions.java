package com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub1Unit1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.tyitproject2020.R;

public class FYITSUB1_subpart_Operators_and_Expressions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_y_i_t_s_u_b1_subpart__operators_and__expressions);
        Intent intent = getIntent();
        String title = intent.getStringExtra("TITLE");
        getSupportActionBar().setTitle(title);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}