package com.example.tyitproject2020.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.tyitproject2020.MainActivity;
import com.example.tyitproject2020.R;

import static java.lang.Thread.sleep;

public class SplashScreen extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this,IntroductionSlider.class));
                finish();
            }
        };
        handler.postDelayed(run,2000);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Handler handler = new Handler();
//        Runnable run = new Runnable() {
//            @Override
//            public void run() {
//                startActivity(new Intent(SplashScreen.this,IntroductionSlider.class));
//                finish();
//            }
//        };
//       handler.postDelayed(run,2000);

//Alternative Way----------------------------
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                startActivity(new Intent(SplashScreen.this,MainActivity.class));
//                finish();
//            }
//        }, 2000);
//--------------------------------------
    }
}