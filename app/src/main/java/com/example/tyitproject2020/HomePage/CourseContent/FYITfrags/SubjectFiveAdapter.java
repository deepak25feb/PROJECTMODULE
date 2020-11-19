package com.example.tyitproject2020.HomePage.CourseContent.FYITfrags;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tyitproject2020.R;

import java.util.List;

public class SubjectFiveAdapter extends ArrayAdapter<ModelCommon> {
    public SubjectFiveAdapter(@NonNull Context context, int resource, @NonNull List<ModelCommon> objects) {
        super(context, 0, objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.inflate_fyit_inflation_course, parent, false);
        }

        ModelCommon model  = getItem(position);
        ImageView imageLogo = listItemView.findViewById(R.id.unitlogo);
        TextView textTitle = listItemView.findViewById(R.id.textsubjecttitle);
        ImageView imageView = listItemView.findViewById(R.id.checkSysmbol);

        imageLogo.setImageResource(model.getUnitImage());
        textTitle.setText(model.title);
        imageView.setImageResource(model.getChekSign());


        return listItemView;
    }
}
