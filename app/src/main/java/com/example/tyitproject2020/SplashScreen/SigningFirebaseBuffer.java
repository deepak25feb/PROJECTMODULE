package com.example.tyitproject2020.SplashScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.tyitproject2020.HomePage.HomePageIndex;
import com.example.tyitproject2020.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SigningFirebaseBuffer extends AppCompatActivity {
    ImageView ivImage;

    TextView tvName;
    Button btLogout;
    FirebaseAuth firebaseAuth;
    GoogleSignInClient googleSignInClient;
    boolean b = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signing_firebase_buffer);
        ivImage = findViewById(R.id.iv_image);
        tvName = findViewById(R.id.tv_name);
        btLogout = findViewById(R.id.bt_logout);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        if(firebaseUser != null){
            Glide.with(SigningFirebaseBuffer.this).load(firebaseUser.getPhotoUrl()).into(ivImage);
            tvName.setText(firebaseUser.getDisplayName());
        }









        googleSignInClient = GoogleSignIn.getClient(SigningFirebaseBuffer.this, GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN);
        btLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                googleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            firebaseAuth.signOut();
                            b= false;
                            Toast.makeText(SigningFirebaseBuffer.this, "LOGOUT SUCCESSFULL", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SigningFirebaseBuffer.this,Credential.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                            finish();
                        }
                    }
                });
            }
        });


            Handler handler = new Handler();
            Runnable run = new Runnable() {
                @Override
                public void run() {

                    startActivity(new Intent(SigningFirebaseBuffer.this, HomePageIndex.class));
                    finish();
                }
            };
            handler.postDelayed(run, 2500);

    }


    } //Main Activity ends Here
