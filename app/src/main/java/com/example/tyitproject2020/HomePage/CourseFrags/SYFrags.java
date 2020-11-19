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
import com.example.tyitproject2020.HomePage.CourseContent.SYITcourse;
import com.example.tyitproject2020.R;

import java.util.ArrayList;
import java.util.List;

public class SYFrags extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.syfragment_course_subject,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<SYModel> list = new ArrayList<>();
        list.add(new SYModel("SYBscIT","Advanced Python Programming",R.drawable.banner4,"SB301"));
        list.add(new SYModel("SYBscIT","Applied Data Structures and Algorithms",R.drawable.banner5,"SB302"));
        list.add(new SYModel("SYBscIT","Computer Networks",R.drawable.banner6,"SB303"));
        list.add(new SYModel("SYBscIT","Databases and Transactions",R.drawable.banner7,"SB304"));
        list.add(new SYModel("SYBscIT","Core Java with JSP",R.drawable.banner8,"SB305"));

        ListView listView = getActivity().findViewById(R.id.list_view22);
        SYAdapter adapter = new SYAdapter(getActivity(),0,list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    startActivity(new Intent(getActivity(), SYITcourse.class).putExtra("subjectName","Advanced Python Programming").putExtra("subjectCode","SB301").setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    return;
                }

                if(position==1){
                    startActivity(new Intent(getActivity(), SYITcourse.class).putExtra("subjectName","Applied Data Structures and Algorithms").putExtra("subjectCode","SB302").setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    return;
                }

                if(position==2){
                    startActivity(new Intent(getActivity(), SYITcourse.class).putExtra("subjectName","Computer Networks").putExtra("subjectCode","SB303").setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    return;
                }

                if(position==3){
                    startActivity(new Intent(getActivity(), SYITcourse.class).putExtra("subjectName","Databases and Transactions").putExtra("subjectCode","SB304").setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    return;
                }

                if(position==4){
                    startActivity(new Intent(getActivity(), SYITcourse.class).putExtra("subjectName","Core Java with JSP").putExtra("subjectCode","SB305").setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    return;
                }
            }
        });

    }


}
