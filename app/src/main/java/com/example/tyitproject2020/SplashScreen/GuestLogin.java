package com.example.tyitproject2020.SplashScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tyitproject2020.HomePage.HomePageIndex;
import com.example.tyitproject2020.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class GuestLogin extends AppCompatActivity {
    //Initialize VARS
    SignInButton btnSignIn;
    GoogleSignInClient googleSignInClient;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_login);
        //Shared prefrence for user Course tracking--------------








        //catch the UI object
        btnSignIn = findViewById(R.id.bt_sign_in);

        //STEP 1:
        // Configure Google Sign In & This objects create a google sign client as well as define scope
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("553571441914-22nu3bdqum2j5ur9cuqo05lq8gmrpkeb.apps.googleusercontent.com")
                .requestEmail()
                .build();


        //STEP 5:
        // Build a GoogleSignInClient with the options specified by googleSignInOptions.
        //this command actually goin to help to opens a dialog box for sign in
        googleSignInClient = GoogleSignIn.getClient(GuestLogin.this, googleSignInOptions);


        //googleSignInClient will be tiggered when google  button is clicked
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = googleSignInClient.getSignInIntent(); //getSignInIntent() return intent with already start activity
                startActivityForResult(intent, 100); // here we will get user data  ---> Follow up onActivityResult for Data
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        //session code
        if(firebaseUser !=null){
            startActivity(new Intent(GuestLogin.this, SigningFirebaseBuffer.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }



    } //Oncreate Methods ends here

    //STEP 3:
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == 100) {
            //TASK WILL BE INITIALIZE HERE
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> signInAccountTask = GoogleSignIn.getSignedInAccountFromIntent(data);
            if(signInAccountTask.isSuccessful()){
                String s = "GOOGLE CLIENT HAS APPROVED AT CLIENT END!";
                displayToast(s);
                try {
                    GoogleSignInAccount googleSignInAccount = signInAccountTask.getResult(ApiException.class); //return google signed in account
                    if(googleSignInAccount != null){
                        //INITIALIZE AUTH CREDENTIAL
                        AuthCredential authCredential = GoogleAuthProvider.getCredential(googleSignInAccount.getIdToken(),null);
                        firebaseAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    courseCompletionSession();
                                    startActivity(new Intent(GuestLogin.this,SigningFirebaseBuffer.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK));
                                    displayToast("FIREBASE AUTHENTICATION SUCCESSFULL");
                                    finish();
                                } else {
                                    displayToast("FIREBASE AUTHENTICATION FAILED" + task.getException().getMessage() );
                                }
                            }
                        });
                    }
                } catch (ApiException e) {
                    e.printStackTrace();
                }
            } // 1st child if end here
        }//Parent if ends
    }

    private void displayToast(String s) {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
    }

    void courseCompletionSession(){
        SharedPreferences sharedPreferences = getSharedPreferences("IMAGE_DATA", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("IMAGE 1",R.drawable.ic_uncolorcheck);
        editor.putInt("IMAGE 2",R.drawable.ic_uncolorcheck);
        editor.putInt("IMAGE 3",R.drawable.ic_uncolorcheck);
        editor.putInt("IMAGE 4",R.drawable.ic_uncolorcheck);
        editor.putInt("IMAGE 5",R.drawable.ic_uncolorcheck);
        editor.commit();
    }


}//MAIN ACTIVITY ENDS HERE