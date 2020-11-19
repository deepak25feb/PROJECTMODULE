package com.example.tyitproject2020.HomePage.CourseFrags;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tyitproject2020.HomePage.CourseContent.FYITcourse;
import com.example.tyitproject2020.MainActivity;
import com.example.tyitproject2020.R;

import java.util.ArrayList;
import java.util.List;

public class FYFrags extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fyfragment_course_subject,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<FYModel> list = new ArrayList<>();
        list.add(new FYModel("FYBscIT","Imperative Programming",R.drawable.banner4,"SB101"));
        list.add(new FYModel("FYBscIT","Digital Electronics",R.drawable.banner5,"SB102"));
        list.add(new FYModel("FYBscIT","Operating Systems ",R.drawable.banner6,"SB103"));
        list.add(new FYModel("FYBscIT","Discrete Mathematics",R.drawable.banner7,"SB104"));
        list.add(new FYModel("FYBscIT","Object Oriented Programming",R.drawable.banner8,"SB201"));


        ListView listView = getActivity().findViewById(R.id.list_view11);
        FYAdapter adapter = new FYAdapter(getActivity(),0,list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    startActivity(new Intent(getActivity(), FYITcourse.class).putExtra("subjectName","Imperative Programming").putExtra("subjectCode","SB101").setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    return;
                }

                if(position==1){
                    startActivity(new Intent(getActivity(), FYITcourse.class).putExtra("subjectName","Digital Electronics").putExtra("subjectCode","SB102").setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    return;
                }

                if(position==2){
                    startActivity(new Intent(getActivity(), FYITcourse.class).putExtra("subjectName","Operating Systems ").putExtra("subjectCode","SB103").setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    return;
                }

                if(position==3){
                    startActivity(new Intent(getActivity(), FYITcourse.class).putExtra("subjectName","Discrete Mathematics").putExtra("subjectCode","SB104").setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    return;
                }

                if(position==4){
                    startActivity(new Intent(getActivity(), FYITcourse.class).putExtra("subjectName","Object Oriented Programming").putExtra("subjectCode","SB201").setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    return;
                }





            }
            //-----------------





        });

    }
}
