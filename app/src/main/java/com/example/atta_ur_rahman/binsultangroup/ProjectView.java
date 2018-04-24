package com.example.atta_ur_rahman.binsultangroup;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.R.attr.defaultValue;


public class ProjectView extends Fragment {

    TextView tvTitle, tvText;
    ImageView imageView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_project_view, container, false);

        tvTitle = (TextView)view.findViewById(R.id.tv_projects_text);
        tvText = (TextView)view.findViewById(R.id.tv_projects_text_detail);
        imageView = (ImageView)view.findViewById(R.id.iv_projects_images);

      //retrieving data using bundle

        Bundle bundle=getArguments();
        tvTitle.setText(String.valueOf(bundle.getString("title")));
        tvText.setText(String.valueOf(bundle.getString("text")));
        imageView.setImageResource(bundle.getInt("Image"));

        return view;
    }

}