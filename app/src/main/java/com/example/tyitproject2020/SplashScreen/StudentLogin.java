package com.example.tyitproject2020.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tyitproject2020.R;
import com.google.android.material.button.MaterialButton;

import java.util.regex.Pattern;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class StudentLogin extends AppCompatActivity {
    EditText mUID;
    EditText mPassword;
    MaterialButton mButton;
    String UID;
    String PASSWORD;
    TextView guideline;
    Boolean checker = true;
    private static final Pattern uid_pattern = Pattern.compile("[1-2][6-9](BIT)[0-9][0-9][0-9]");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        mUID = findViewById(R.id.editTextTextPersonName);
        mPassword = findViewById(R.id.editTextTextPassword);
        mButton = findViewById(R.id.button);
        buttonListner();
        intentRquest();
        guidelineListner();
    } // oncreate ends

    void buttonListner(){

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UID = mUID.getText().toString().trim();
                PASSWORD = mPassword.getText().toString().trim();
                //FAKE VALIDATION
                if(TextUtils.isEmpty(UID)){
                    mUID.setError("UID is Required");

                    return ;
                }
                if(TextUtils.isEmpty(PASSWORD)){
                    mPassword.setError("PASSWORD  is Required !");

                   return ;
                }

                if(!uid_pattern.matcher(UID).matches() ){
                    mUID.setError("UID doesn't conform authenticity !");

                    return ;
                }

                if(!TextUtils.isEmpty(UID) && !TextUtils.isEmpty(PASSWORD) && uid_pattern.matcher(UID).matches()) {
                    Toast.makeText(getApplicationContext(), "Logging Plese Wait!.......", Toast.LENGTH_SHORT).show();
                    Log.i("BEFORE ASYNCTASK STAUS",UID+"   "+ PASSWORD);
                    AsynTaskLogin task = new AsynTaskLogin(UID, PASSWORD, getApplicationContext());
                    task.execute();
                }

            } //onclick method ends
        });
    }

    void intentRquest(){
        TextView request = findViewById(R.id.textView4);
        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = "jiyacoolfreak@gmail.com";
                String subject = "REQUEST UID AND PASSWORD";
                String body = "To College@gmail.com \nDear Sir,\nI WANT TO REQUEST MY COLLEGE UID AND PASSWORD .\n Kindly mail it .\n I assure that this is my official college EMAIL ID";

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL,email);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,subject);
                emailIntent.putExtra(Intent.EXTRA_TEXT,body);
                if(emailIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(emailIntent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Contact College", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getApplicationContext(), "Remember To Follow College Guidelines!", Toast.LENGTH_SHORT).show();

            }
        });




    } //inttent request

    void guidelineListner(){
        guideline = findViewById(R.id.textView5);
        guideline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.guideline_inflator,null);
                Toast toast = new Toast(getApplicationContext());
                toast.setView(view);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }
        });
    }




}