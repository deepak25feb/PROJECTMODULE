package com.example.tyitproject2020.HomePage.CourseContent.FYITfrags;

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

import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub2Unit1.Alphanumeric_codes;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub2Unit1.Arithmetic;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub2Unit1.Logic_Gates;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub2Unit1.Number_System;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub2Unit2.Combinational_Logic_Circuits;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub2Unit2.KarnaughMaps;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub2Unit3.Arithmetic_Circuits;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub2Unit3.Sequential_Circuits;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub2Unit4.Counters;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub2Unit4.Shift_Register;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub3Unit1.Compiler_Design;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub3Unit1.IntroductionOS;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub3Unit1.Principles_of_Input_Output;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub3Unit1.Processes_and_Threads;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub3Unit1.User_interfaces;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub3Unit2.File_Systems;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub3Unit2.Memory_Management;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub3Unit3.Deadlocks;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub3Unit3.Protection_and_Security;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub3Unit4.Cloud;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub3Unit4.Multiple_Processor_Systems;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub3Unit4.Virtualization;
import com.example.tyitproject2020.R;

import java.util.ArrayList;
import java.util.List;

public class FYITcommonFragSub3 extends Fragment {
    ListView listView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fyitcommonfraglistview,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView = getActivity().findViewById(R.id.list_view_common);
        List<ModelCommon> list = new ArrayList<>();
        list.add(new ModelCommon(R.drawable.unitone,"Introduction",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitone,"Compiler Design",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitone,"Principles of Input-Output",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitone,"User interfaces",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitone,"Processes and Threads",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unittwo,"Memory Management",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unittwo,"File Systems",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitthree,"Deadlocks",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitthree,"Protection and Security",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitfour,"Virtualization",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitfour,"Cloud",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitfour,"Multiple Processor Systems",R.drawable.ic_uncolorcheck));


        SubjectThreeAdapter adapter = new SubjectThreeAdapter(getActivity(),0,list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    startActivity(new Intent(getActivity(), IntroductionOS.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==1){
                    startActivity(new Intent(getActivity(), Compiler_Design.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==2){
                    startActivity(new Intent(getActivity(), Principles_of_Input_Output.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==3){
                    startActivity(new Intent(getActivity(), User_interfaces.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==4){
                    startActivity(new Intent(getActivity(), Processes_and_Threads.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==5){
                    startActivity(new Intent(getActivity(), Memory_Management.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==6){
                    startActivity(new Intent(getActivity(), File_Systems.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==7){
                    startActivity(new Intent(getActivity(), Deadlocks.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==8){
                    startActivity(new Intent(getActivity(), Protection_and_Security.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==9){
                    startActivity(new Intent(getActivity(), Cloud.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==10){
                    startActivity(new Intent(getActivity(), Multiple_Processor_Systems.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==11){
                    startActivity(new Intent(getActivity(), Virtualization.class).putExtra("TITLE",list.get(position).getTitle()));
                }





            }
        });



    }
}
