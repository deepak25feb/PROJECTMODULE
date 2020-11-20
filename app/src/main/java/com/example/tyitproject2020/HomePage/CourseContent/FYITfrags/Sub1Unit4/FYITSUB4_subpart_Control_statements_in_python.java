package com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub1Unit4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.tyitproject2020.R;

public class FYITSUB4_subpart_Control_statements_in_python extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_y_i_t_s_u_b4_subpart__control_statements_in_python);
        Intent intent = getIntent();
        String title = intent.getStringExtra("TITLE");
        getSupportActionBar().setTitle(title);

    }
}