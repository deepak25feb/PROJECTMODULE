package com.example.tyitproject2020.SideNavFrag;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.tyitproject2020.HomePage.HomePageIndex;
import com.example.tyitproject2020.R;
import com.example.tyitproject2020.SplashScreen.Credential;
import com.example.tyitproject2020.SplashScreen.IntroductionSlider;
import com.example.tyitproject2020.SplashScreen.SigningFirebaseBuffer;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogoutFrag extends Fragment {
    Context context;
    TextView name_or_uid;
    ImageView image_dp;
    FirebaseAuth firebaseAuth;
    GoogleSignInClient googleSignInClient;
    Button button;
    String local;

    public LogoutFrag(Context context){
        this.context = context;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sidenavfrag_logout,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        button = getActivity().findViewById(R.id.loguotButton);//logout TextView
        image_dp = getActivity().findViewById(R.id.image_image);
        name_or_uid = getActivity().findViewById(R.id.username);

        //-------------------
        Intent intent = getActivity().getIntent();

        SharedPreferences sharedPreferences = context.getSharedPreferences("Session_student",Context.MODE_PRIVATE);
        local = sharedPreferences.getString("UIDNAME","DEFAULT");
        //-------------------

        //------------------firebase
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        if(firebaseUser != null){
            Glide.with(context).load(firebaseUser.getPhotoUrl()).into(image_dp);
            name_or_uid.setText(firebaseUser.getDisplayName());
        }
        if(firebaseUser == null){
            name_or_uid.setText(local);
        }
        //---------------------------------

        googleSignInClient = GoogleSignIn.getClient(context, GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(firebaseUser != null){

                    googleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                firebaseAuth.signOut();
                                Toast.makeText(context, "LOGOUT SUCCESSFULL", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(context, Credential.class));
                                getActivity().finish();
                            }
                        }
                    });



                }
                SharedPreferences sharedPreferences = context.getSharedPreferences("Session_student", Context.MODE_PRIVATE);
//                int i = sharedPreferences.getInt("Session_student",-1);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("session_number",-1);
                editor.commit();
                startActivity(new Intent(context, Credential.class));
                getActivity().finish();
            }
        }); //Button Listner ends here
    }
}
