package com.example.tyitproject2020.HomePage.CourseContent.FYITfrags;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.tyitproject2020.R;

import java.util.ArrayList;
import java.util.List;

public class FYITcommonFragSub1 extends Fragment {
    ListView listView;
    int image1;
    int image2;
    int image3;
    int image4;
    int image5;
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
        checkcourseCompletion();
        list.add(new ModelCommon(R.drawable.unitone,"Introduction",image1));
        list.add(new ModelCommon(R.drawable.unitone,"Fundamentals",image2));
        list.add(new ModelCommon(R.drawable.unitone,"Operators and Expressions",image3));
        list.add(new ModelCommon(R.drawable.unitone,"Data Input and output",image4));
        list.add(new ModelCommon(R.drawable.unittwo,"Conditional Statements and Loops",image5));
        list.add(new ModelCommon(R.drawable.unittwo,"Functions",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unittwo,"Program structure",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unittwo,"Preprocessor",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitthree,"Arrays",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitthree,"Pointers",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitthree,"Structures and Unions",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitfour,"Introduction to Python",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitfour,"Variables and Expressions in Python",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitfour,"Conditional Statements and loops in python",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitfour,"Control statements in python",R.drawable.ic_uncolorcheck));

        SubjectOneAdapter adapter = new SubjectOneAdapter(getActivity(),0,list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                     startActivity(new Intent(getActivity(), FYITSUB1_subpart_Introduction.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==1){
                    startActivity(new Intent(getActivity(), FYITSUB1_subpart_Fundamentals.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==2){
                    startActivity(new Intent(getActivity(), FYITSUB1_subpart_Operators_and_Expressions.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==3){
                    startActivity(new Intent(getActivity(), FYITSUB1_subpart_Data_Input_and_output.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==4){
                    startActivity(new Intent(getActivity(), FYITSUB2_subpart_Conditional_Statements_and_Loops.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==5){
                    startActivity(new Intent(getActivity(), FYITSUB2_subpart_Functions.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==6){
                    startActivity(new Intent(getActivity(), FYITSUB2_subpart_Program_structure.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==7){
                    startActivity(new Intent(getActivity(), FYITSUB2_subpart_Preprocessor.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==8){
                    startActivity(new Intent(getActivity(), FYITSUB3_subpart_Arrays.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==9){
                    startActivity(new Intent(getActivity(), FYITSUB3_subpart_Pointers.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==10){
                    startActivity(new Intent(getActivity(), FYITSUB3_subpart_Structures_and_Unions.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==11){
                    startActivity(new Intent(getActivity(), FYITSUB4_subpart_Introduction_to_Python.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==12){
                    startActivity(new Intent(getActivity(), FYITSUB4_subpart_Variables_and_Expressions_in_Python.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==13){
                    startActivity(new Intent(getActivity(), FYITSUB4_subpart_Conditional_Statements_and_loops_in_python.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==14){
                    startActivity(new Intent(getActivity(), FYITSUB4_subpart_Control_statements_in_python.class).putExtra("TITLE",list.get(position).getTitle()));
                }



            }
        });





    }



    void checkcourseCompletion(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("IMAGE_DATA", Context.MODE_PRIVATE);
        image1 = sharedPreferences.getInt("IMAGE 1",R.drawable.ic_uncolorcheck);
        image2 = sharedPreferences.getInt("IMAGE 2",R.drawable.ic_uncolorcheck);
        image3 = sharedPreferences.getInt("IMAGE 3",R.drawable.ic_uncolorcheck);
        image4 = sharedPreferences.getInt("IMAGE 4",R.drawable.ic_uncolorcheck);
        image5 = sharedPreferences.getInt("IMAGE 5",R.drawable.ic_uncolorcheck);
    }
}
