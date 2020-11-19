package com.example.tyitproject2020.HomePage.CourseContent.FYITfrags;

import android.content.Context;
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

import com.example.tyitproject2020.HomePage.CourseContent.FYITfrags.Sub1Unit1.testing;
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
        list.add(new ModelCommon(R.drawable.unitone,"subject 1 -course 1.0",image1));
        list.add(new ModelCommon(R.drawable.unitone,"subject 1 course 2.0",image2));
        list.add(new ModelCommon(R.drawable.unitone,"subject 1 -course 1.0",image3));
        list.add(new ModelCommon(R.drawable.unitone,"subject 1 course 2.0",image4));
        list.add(new ModelCommon(R.drawable.unittwo,"subject 1 course 3.0",image5));
        list.add(new ModelCommon(R.drawable.unittwo,"subject 1 course 4.0",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unittwo,"subject 1 course 3.0",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unittwo,"subject 1 course 4.0",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitthree,"subject 1 course 5.0",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitthree,"subject 1 course 6.0",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitthree,"subject 1 course 5.0",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitthree,"subject 1 course 6.0",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitfour,"subject 1 course 7.0",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitfour,"subject 1 course 8.0",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitfour,"subject 1 course 7.0",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitfour,"subject 1 course 8.0",R.drawable.ic_uncolorcheck));

        SubjectOneAdapter adapter = new SubjectOneAdapter(getActivity(),0,list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    testing frag = new testing();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.courseFrame,frag).addToBackStack("one").commit();
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
