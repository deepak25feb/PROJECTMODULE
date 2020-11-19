package com.example.tyitproject2020.HomePage;

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

public class HomeFragCourseAdapter extends ArrayAdapter<HomeFragCourseModel> {

    public HomeFragCourseAdapter(@NonNull Context context,int textViewResourceId, @NonNull List<HomeFragCourseModel> objects) {
        super(context,0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.course_list_view, parent, false);
        }

        HomeFragCourseModel model = getItem(position); //its a array adapter function which return objects at a particular position.
        ImageView imageView = listItemView.findViewById(R.id.imageView5);
        TextView textView = listItemView.findViewById(R.id.textSubject);
        imageView.setImageResource(model.getResId());
        textView.setText(model.getText());



        return listItemView;
    }
}
