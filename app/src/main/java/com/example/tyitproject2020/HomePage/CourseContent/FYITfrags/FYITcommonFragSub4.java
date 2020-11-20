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
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub4Unit1.Functions;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub4Unit1.Quantified_Statements;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub4Unit1.Set_Theory;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub4Unit1.The_Logic_of_Compound_Statements;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub4Unit2.Graphs_and_Trees;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub4Unit2.Relations;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub4Unit3.Elementary_Number_Theory_and_Methods_of_Proof;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub4Unit3.Sequences_Mathematical_Induction_and_Recursion;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub4Unit4.Counting_and_Probability;
import com.example.tyitproject2020.R;

import java.util.ArrayList;
import java.util.List;

public class FYITcommonFragSub4 extends Fragment {
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
        list.add(new ModelCommon(R.drawable.unitone,"The Logic of Compound Statements",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitone,"Quantified Statements",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitone,"Set Theory",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitone,"Functions",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unittwo,"Relations",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unittwo,"Graphs and Trees",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitthree,"Elementary Number Theory and Methods of Proof",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitthree,"Sequences, Mathematical Induction, and Recursion",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitfour,"Counting and Probability",R.drawable.ic_uncolorcheck));


        SubjectFourAdapter adapter = new SubjectFourAdapter(getActivity(),0,list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    startActivity(new Intent(getActivity(), The_Logic_of_Compound_Statements.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==1){
                    startActivity(new Intent(getActivity(), Quantified_Statements.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==2){
                    startActivity(new Intent(getActivity(), Set_Theory.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==3){
                    startActivity(new Intent(getActivity(), Functions.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==4){
                    startActivity(new Intent(getActivity(), Relations.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==5){
                    startActivity(new Intent(getActivity(), Graphs_and_Trees.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==6){
                    startActivity(new Intent(getActivity(), Elementary_Number_Theory_and_Methods_of_Proof.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==7){
                    startActivity(new Intent(getActivity(), Sequences_Mathematical_Induction_and_Recursion.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==8){
                    startActivity(new Intent(getActivity(), Counting_and_Probability.class).putExtra("TITLE",list.get(position).getTitle()));
                }






            }
        });






    }
}
