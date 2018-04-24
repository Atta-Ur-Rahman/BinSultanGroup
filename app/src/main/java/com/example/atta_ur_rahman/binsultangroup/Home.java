package com.example.atta_ur_rahman.binsultangroup;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



public class Home extends Fragment {

    ImageView btn_what_we_do;
    TextView tv_objectives, tv_the_letter, tv_vision, tv_what_we_do, tv_english, tv_arabic, tv_home_text;
    LinearLayout ll_what_we_do;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);




        tv_what_we_do = (TextView) view.findViewById(R.id.tv_what_we_do);
        tv_objectives = (TextView) view.findViewById(R.id.tv_objectives);
        tv_the_letter = (TextView) view.findViewById(R.id.tv_the_letter);
        tv_vision = (TextView) view.findViewById(R.id.tv_vision);
        tv_what_we_do.setText(R.string.text_what_we_do);
        tv_home_text = (TextView) view.findViewById(R.id.hometext);


        tv_what_we_do.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new What_WEdo();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();

            }
        });


        return view;
    }



}


