package com.example.tyitproject2020.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.tyitproject2020.MainActivity;
import com.example.tyitproject2020.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class IntroductionSlider extends AppCompatActivity {
    private OnboardingAdapter onboardingAdapter;
    private LinearLayout layoutOnboardingIndicator;
    private MaterialButton materialButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction_slider);


        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        materialButton = findViewById(R.id.buttonOnboardingAction);
        layoutOnboardingIndicator = findViewById(R.id.layoutOnboardingIndicators);



        // called the constructor of OnboardingAdapter
        setOnboardingItems();
        // till now only list is populated.

        ViewPager2 pager = findViewById(R.id.onboardingViewPager);

        //calls Adapter oncreateviewHolder
        pager.setAdapter(onboardingAdapter);

        //below setup small image view within linearlayout
        setupOnboardingIndicator();


        //
        setCurrentOnboardingIndicator(0);

        pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnboardingIndicator(position);
            }
        });


        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pager.getCurrentItem()+1 < onboardingAdapter.getItemCount()){
                    pager.setCurrentItem(pager.getCurrentItem()+1);
                }else{
                    startActivity(new Intent(getApplicationContext(), Credential.class));

                }
            }
        });



    } //oncreate ends



    private void setOnboardingItems(){
        List<OnboardingItem> onboardingItem = new ArrayList<>();
        onboardingItem.add(new OnboardingItem(R.drawable.image_intro));
        onboardingItem.add(new OnboardingItem(R.drawable.image_intro));
        onboardingItem.add(new OnboardingItem(R.drawable.image_intro));
        onboardingAdapter = new OnboardingAdapter(onboardingItem);


    }



    private void setupOnboardingIndicator(){
        ImageView[] indicator = new ImageView[onboardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(8,0,8,0);
        for(int i = 0 ; i < indicator.length ; i++){
            indicator[i] = new ImageView(getApplicationContext());
            indicator[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboarding_indicator_inactive));
            indicator[i].setLayoutParams(layoutParams);
            layoutOnboardingIndicator.addView(indicator[i]);

        }

    }


    private void setCurrentOnboardingIndicator(int index){
        int childCount = layoutOnboardingIndicator.getChildCount(); //this method is of viewgroup class and LinearLayout is a subclass of viewgroup
        //childcount contains no of child views
        for(int i = 0 ; i < childCount ; i++){
            ImageView imageView = (ImageView) layoutOnboardingIndicator.getChildAt(i);
            //getChildAt : Returns the view at the specified position in the group.
            if(i == index){
                imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboarding_indicator_active));
            } else{
                imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboarding_indicator_inactive));
            }

        }
        // onboardingAdapter.getItemCount() means List size thus view size i.e no of views
        if(index == onboardingAdapter.getItemCount() - 1){
            materialButton.setText("Start");

        }else{
            materialButton.setText("Next");
        }


    }

}