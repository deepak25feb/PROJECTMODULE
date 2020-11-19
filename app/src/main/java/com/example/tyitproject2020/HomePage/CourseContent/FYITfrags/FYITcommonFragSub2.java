package com.example.tyitproject2020.HomePage.CourseContent.FYITfrags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
        list.add(new ModelCommon(R.drawable.unitone,"subject 2 - 1.0",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitone,"subject 2 -2.0",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unittwo,"subject 2 -3.0",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unittwo,"subject 2 -4.0",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitthree,"subject 2 - 5.0",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitthree,"subject 2 - 6.0",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitfour,"subject 2 -7.0",R.drawable.ic_uncolorcheck));
        list.add(new ModelCommon(R.drawable.unitfour,"subject 2 -8.0",R.drawable.ic_uncolorcheck));

        SubjectTwoAdapter adapter = new SubjectTwoAdapter(getActivity(),0,list);
        listView.setAdapter(adapter);



    }
}
