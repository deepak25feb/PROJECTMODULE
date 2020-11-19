package com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub1Unit1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.FYITcommonFragSub1;
import com.example.tyitproject2020.R;

public class testing extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.test,container,false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button button = getActivity().findViewById(R.id.buttonss);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("IMAGE_DATA", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("IMAGE 1",R.drawable.ic_colorcheck);
                editor.commit();
                FYITcommonFragSub1 frag = new FYITcommonFragSub1();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.courseFrame,frag).commit();
            }
        });


    }
}
