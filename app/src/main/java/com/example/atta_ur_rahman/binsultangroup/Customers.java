package com.example.atta_ur_rahman.binsultangroup;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;


public class Customers extends Fragment {

    TextView tv_engineer_salm_al_shammari;
    ViewFlipper view_flipper_images,view_flipper_text,view_flipper_name;
    ImageView iv_right_arrow,iv_left_arrow;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customers, container, false);

        view_flipper_images = (ViewFlipper)view.findViewById(R.id.view_flipper_images);
        view_flipper_text = (ViewFlipper)view.findViewById(R.id.view_flipper_text);
        view_flipper_name = (ViewFlipper)view.findViewById(R.id.view_flipper_name);
        iv_left_arrow = (ImageView)view.findViewById(R.id.iv_left_arrow);
        iv_right_arrow = (ImageView)view.findViewById(R.id.iv_right_arrow);

        iv_left_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view_flipper_images.showNext();
                view_flipper_text.showNext();
                view_flipper_name.showNext();
                Animation out = AnimationUtils.loadAnimation(getActivity(),android.R.anim.slide_in_left);
                Animation in = AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_out_right);

                view_flipper_images.setOutAnimation(out);
                view_flipper_images.setOutAnimation(in);
                view_flipper_text.setOutAnimation(out);
                view_flipper_text.setOutAnimation(in);
                view_flipper_name.setOutAnimation(out);
                view_flipper_name.setOutAnimation(in);

                view_flipper_images.startFlipping();
                view_flipper_text.startFlipping();
                view_flipper_name.startFlipping();

            }
        });
        iv_right_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view_flipper_images.showPrevious();
                view_flipper_text.showPrevious();
                view_flipper_name.showPrevious();

                Animation in = AnimationUtils.loadAnimation(getActivity(),android.R.anim.slide_out_right);
                Animation out = AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_in_left);
                view_flipper_images.setOutAnimation(out);
                view_flipper_images.setOutAnimation(in);
                view_flipper_text.setOutAnimation(out);
                view_flipper_text.setOutAnimation(in);
                view_flipper_name.setOutAnimation(out);
                view_flipper_name.setOutAnimation(in);

                view_flipper_images.startFlipping();
                view_flipper_text.startFlipping();
                view_flipper_name.startFlipping();


            }
        });


        view_flipper_images.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view_flipper_images.stopFlipping();
                view_flipper_name.stopFlipping();
                view_flipper_text.stopFlipping();
                return false;
            }
        });

        view_flipper_text.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view_flipper_images.stopFlipping();
                view_flipper_name.stopFlipping();
                view_flipper_text.stopFlipping();
                return false;
            }
        });



        return view;
    }

}
