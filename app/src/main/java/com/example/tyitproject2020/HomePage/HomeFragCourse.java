package com.example.tyitproject2020.HomePage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tyitproject2020.HomePage.CourseFrags.FYFrags;
import com.example.tyitproject2020.HomePage.CourseFrags.SYFrags;
import com.example.tyitproject2020.HomePage.CourseFrags.TYFrags;
import com.example.tyitproject2020.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragCourse extends Fragment {
    ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_courses_content_home,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<HomeFragCourseModel> list = new ArrayList<>();
        list.add(new HomeFragCourseModel("FY - BSCIT",R.drawable.banner1));
        list.add(new HomeFragCourseModel("SY - BSCIT",R.drawable.banner2));
        list.add(new HomeFragCourseModel("TY - BSCIT",R.drawable.banner3));
        listView = getActivity().findViewById(R.id.list_view);

        HomeFragCourseAdapter adapter = new HomeFragCourseAdapter(getActivity(),0,list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //listView.getItemAtPosition(position);
                if(position == 0){
                    Toast.makeText(getActivity(),list.get(position).toString(), Toast.LENGTH_SHORT).show();
                    FYFrags fyfrag= new FYFrags();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fyfrag).addToBackStack("back1").commit();

                    return;
                }
                if(position == 1){
                    Toast.makeText(getActivity(),list.get(position).toString(), Toast.LENGTH_SHORT).show();
                    SYFrags syfrag= new SYFrags();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,syfrag).addToBackStack("back1").commit();
                    return;
                }
                if(position == 2){
                    Toast.makeText(getActivity(),list.get(position).toString(), Toast.LENGTH_SHORT).show();
                    TYFrags tyfrag= new TYFrags();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,tyfrag).addToBackStack("back1").commit();
                    return;
                }

            }
        });
    } // onActivity created ends here
}
