package com.example.tyitproject2020.HomePage.CourseContent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;

import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.FYITcommonFragSub1;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.FYITcommonFragSub2;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.FYITcommonFragSub3;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.FYITcommonFragSub4;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.FYITcommonFragSub5;
import com.example.tyitproject2020.R;
//THIS NEW activity host FYIT fragments.
public class FYITcourse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_y_i_tcourse);
        Intent intent = getIntent();
        String name = intent.getStringExtra("subjectName");
        String id =intent.getStringExtra("subjectCode");
        getSupportActionBar().setTitle(name);
//        getSupportActionBar().setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.banner1));
        if(id.equals("SB101")) {
            FYITcommonFragSub1 frag = new FYITcommonFragSub1();
            getSupportFragmentManager().beginTransaction().replace(R.id.courseFrame, frag).commit();
            return;
        }
        if(id.equals("SB102")) {
            FYITcommonFragSub2 frag = new FYITcommonFragSub2();
            getSupportFragmentManager().beginTransaction().replace(R.id.courseFrame, frag).commit();
            return;
        }
        if(id.equals("SB103")) {
            FYITcommonFragSub3 frag = new FYITcommonFragSub3();
            getSupportFragmentManager().beginTransaction().replace(R.id.courseFrame, frag).commit();
            return;
        }
        if(id.equals("SB104")) {
            FYITcommonFragSub4 frag = new FYITcommonFragSub4();
            getSupportFragmentManager().beginTransaction().replace(R.id.courseFrame, frag).commit();
            return;
        }
        if(id.equals("SB201")) {
            FYITcommonFragSub5 frag = new FYITcommonFragSub5();
            getSupportFragmentManager().beginTransaction().replace(R.id.courseFrame, frag).commit();
            return;
        }

    }
}