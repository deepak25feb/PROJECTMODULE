package com.example.tyitproject2020.HomePage.CourseFrags;

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

public class TYAdapter  extends ArrayAdapter<TYModel> {
    public TYAdapter(@NonNull Context context, int resource, @NonNull List<TYModel> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.itemviewforcoursefragment, parent, false);
        }


        ImageView imageView = listItemView.findViewById(R.id.imageView5);
        TextView textViewYear = listItemView.findViewById(R.id.textFYBSCIT);
        TextView textViewSubject = listItemView.findViewById(R.id.textSubject);
        TextView textViewSubjectCode = listItemView.findViewById(R.id.textsubjectid);

        TYModel model = getItem(position);
        imageView.setImageResource(model.getImageResId());
        textViewYear.setText(model.getYear());
        textViewSubject.setText(model.getSubject());
        textViewSubjectCode.setText(model.getSubjectCode());


        return listItemView;
    }
}