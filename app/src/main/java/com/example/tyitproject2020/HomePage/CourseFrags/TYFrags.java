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

import com.example.tyitproject2020.HomePage.CourseContent.SYITcourse;
import com.example.tyitproject2020.HomePage.CourseContent.TYITcourse;
import com.example.tyitproject2020.R;

import java.util.ArrayList;
import java.util.List;

public class TYFrags extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tyfragment_course_subject,container,false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<TYModel> list = new ArrayList<>();
        list.add(new TYModel("TYBscIT","Research Methodology",R.drawable.banner9,"SBIT501"));
        list.add(new TYModel("TYBscIT","Physical Computing and IoT Programming",R.drawable.banner10,"SBIT502"));
        list.add(new TYModel("TYBscIT","Mobile Application Development",R.drawable.banner11,"SBIT503"));
        list.add(new TYModel("TYBscIT","Machine Learning and Deep Learning",R.drawable.banner12,"SBIT504"));
        list.add(new TYModel("TYBscIT","Enterprise Jakarta 8",R.drawable.banner13,"SBIT505"));

        ListView listView = getActivity().findViewById(R.id.list_view33);
        TYAdapter adapter = new TYAdapter(getActivity(),0,list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    startActivity(new Intent(getActivity(), TYITcourse.class).putExtra("subjectName","Research Methodology").putExtra("subjectCode","SBIT501").setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    return;
                }

                if(position==1){
                    startActivity(new Intent(getActivity(), TYITcourse.class).putExtra("subjectName","Physical Computing and IoT Programming").putExtra("subjectCode","SBIT502").setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    return;
                }

                if(position==2){
                    startActivity(new Intent(getActivity(), TYITcourse.class).putExtra("subjectName","Mobile Application Development").putExtra("subjectCode","SBIT503").setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    return;
                }

                if(position==3){
                    startActivity(new Intent(getActivity(), TYITcourse.class).putExtra("subjectName","Machine Learning and Deep Learning").putExtra("subjectCode","SBIT504").setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    return;
                }

                if(position==4){
                    startActivity(new Intent(getActivity(), TYITcourse.class).putExtra("subjectName","Enterprise Jakarta 8").putExtra("subjectCode","SBIT505").setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    return;
                }
            }
        });

    }


}
