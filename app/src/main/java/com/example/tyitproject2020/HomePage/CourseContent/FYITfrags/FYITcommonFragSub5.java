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
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub5Unit1.Classes_and_Objects;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub5Unit1.Object_Oriented_Methodology;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub5Unit1.Principles_of_OOPS;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub5Unit2.Constructors_and_Destructors;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub5Unit2.Polymorphism;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub5Unit2.Virtual_Functions;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub5Unit3.Exception_Handling;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub5Unit3.Templates;
import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub5Unit4.Working_with_Files;
import com.example.tyitproject2020.R;

import java.util.ArrayList;
import java.util.List;

public class FYITcommonFragSub5 extends Fragment {
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
        list.add(new ModelCommon(R.drawable.unitone,"Object Oriented Methodology",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitone,"Principles of OOPS",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitone,"Classes and Objects",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unittwo,"Constructors and Destructors",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unittwo,"Polymorphism",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unittwo,"Virtual Functions",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitthree,"Exception Handling",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitthree,"Templates",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitfour,"Working with Files",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitfour,"Classes and Objects in python",R.drawable.ic_uncolorcheck));

        SubjectFiveAdapter adapter = new SubjectFiveAdapter(getActivity(),0,list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    startActivity(new Intent(getActivity(), Object_Oriented_Methodology.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==1){
                    startActivity(new Intent(getActivity(), Principles_of_OOPS.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==2){
                    startActivity(new Intent(getActivity(), Classes_and_Objects.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==3){
                    startActivity(new Intent(getActivity(), Constructors_and_Destructors.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==4){
                    startActivity(new Intent(getActivity(), Polymorphism.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==5){
                    startActivity(new Intent(getActivity(), Virtual_Functions.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==6){
                    startActivity(new Intent(getActivity(), Exception_Handling.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==7){
                    startActivity(new Intent(getActivity(), Templates.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==8){
                    startActivity(new Intent(getActivity(), Working_with_Files.class).putExtra("TITLE",list.get(position).getTitle()));
                }
                if(position==9){
                    startActivity(new Intent(getActivity(), Classes_and_Objects.class).putExtra("TITLE",list.get(position).getTitle()));
                }




            }
        });



    }
}
