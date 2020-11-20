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

import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub1Unit1.FYITSUB1_subpart_Data_Input_and_output;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub1Unit1.FYITSUB1_subpart_Fundamentals;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub1Unit1.FYITSUB1_subpart_Introduction;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub1Unit1.FYITSUB1_subpart_Operators_and_Expressions;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub1Unit2.FYITSUB2_subpart_Conditional_Statements_and_Loops;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub1Unit2.FYITSUB2_subpart_Functions;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub1Unit2.FYITSUB2_subpart_Preprocessor;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub1Unit2.FYITSUB2_subpart_Program_structure;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub1Unit3.FYITSUB3_subpart_Arrays;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub1Unit3.FYITSUB3_subpart_Pointers;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub1Unit3.FYITSUB3_subpart_Structures_and_Unions;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub1Unit4.FYITSUB4_subpart_Conditional_Statements_and_loops_in_python;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub1Unit4.FYITSUB4_subpart_Control_statements_in_python;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub1Unit4.FYITSUB4_subpart_Introduction_to_Python;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub1Unit4.FYITSUB4_subpart_Variables_and_Expressions_in_Python;
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
import com.example.tyitproject2020.R;

import java.util.ArrayList;
import java.util.List;

public class FYITcommonFragSub2 extends Fragment {
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
        list.add(new ModelCommon(R.drawable.unitone,"Number System",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitone,"Alphanumeric codes",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitone,"Arithmetic",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitone,"Logic Gates",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unittwo,"Karnaugh Maps",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unittwo,"Combinational Logic Circuits",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitthree,"Arithmetic Circuits",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitthree,"Sequential Circuits",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitfour,"Counters",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitfour,"Shift Register",R.drawable.ic_uncolorcheck));

        SubjectTwoAdapter adapter = new SubjectTwoAdapter(getActivity(),0,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    startActivity(new Intent(getActivity(), Number_System.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==1){
                    startActivity(new Intent(getActivity(), Alphanumeric_codes.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==2){
                    startActivity(new Intent(getActivity(), Arithmetic.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==3){
                    startActivity(new Intent(getActivity(), Logic_Gates.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==4){
                    startActivity(new Intent(getActivity(), KarnaughMaps.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==5){
                    startActivity(new Intent(getActivity(), Combinational_Logic_Circuits.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==6){
                    startActivity(new Intent(getActivity(), Arithmetic_Circuits.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==7){
                    startActivity(new Intent(getActivity(), Sequential_Circuits.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==8){
                    startActivity(new Intent(getActivity(), Counters.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==9){
                    startActivity(new Intent(getActivity(), Shift_Register.class).putExtra("TITLE",list.get(position).getTitle()));
                }




            }
        });



    }
}
