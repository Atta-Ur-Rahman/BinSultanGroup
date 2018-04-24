package com.example.atta_ur_rahman.binsultangroup;

import android.animation.Animator;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import static com.example.atta_ur_rahman.binsultangroup.R.id.fl_real_estate_investment_hide;


public class Services extends Fragment {

    TextView tv_bussness_sector_hide,tv_bussness_sector,tv_bussness_sector_text,tv_construction_section,tv_construction_section_text,
            tv_construction_section_hide,tv_real_estate_investment,tv_real_estate_investment_hide,tv_real_estate_investmen_text,
            tv_bin_sultan_celebrations,tv_bin_sultan_celebrations_hide,tv_bin_sultan_celebrations_text,
            tv_maintenance_department,tv_maintenance_department_hide,tv_maintenance_department_text;

    ViewFlipper vf_bussness_sector;

    ImageView iv_bussness_sector_down,iv_bussness_sector_up;
    FrameLayout fl_bussness_sector,fl_bussness_sector_hide,fl_construction_sector_hide,fl_construction_sector,
            fl_real_estate_investment,fl_real_estate_investment_hide,fl_bin_sultan_celebrations,fl_bin_sultan_celebrations_hide,
            fl_maintenance_department,fl_maintenance_department_hide;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_services, container, false);

//        //vf_bussness_sector = (ViewFlipper)view.findViewById(R.id.vf_bussness_sector);
//
//        tv_bussness_sector_hide = (TextView)view.findViewById(R.id.tv_bussness_sector_hide);
//        tv_bussness_sector = (TextView)view.findViewById(R.id.tv_bussness_sector);
//        tv_bussness_sector_text = (TextView)view.findViewById(R.id.tv_bussness_sector_text);
//        tv_construction_section  = (TextView)view.findViewById(R.id.tv_construction_section);
//        tv_construction_section_hide  = (TextView)view.findViewById(R.id.tv_construction_sector_hide);
//        tv_construction_section_text  = (TextView)view.findViewById(R.id.tv_construction_sector_text);
//        tv_real_estate_investment = (TextView)view.findViewById(R.id.tv_real_estate_investment);
//        tv_real_estate_investment_hide = (TextView)view.findViewById(R.id.tv_real_estate_investment_hide);
//        tv_real_estate_investmen_text = (TextView)view.findViewById(R.id.tv_real_estate_investment_text);
//        tv_bin_sultan_celebrations = (TextView)view.findViewById(R.id.tv_bin_sultan_celebrations);
//        tv_bin_sultan_celebrations_hide = (TextView)view.findViewById(R.id.tv_bin_sultan_celebrations_hide);
//        tv_bin_sultan_celebrations_text = (TextView)view.findViewById(R.id.tv_bin_sultan_celebrations_text);
//        tv_maintenance_department = (TextView)view.findViewById(R.id.tv_maintenance_department);
//        tv_maintenance_department_hide = (TextView)view.findViewById(R.id.tv_maintenance_department_hide);
//        tv_maintenance_department_text = (TextView)view.findViewById(R.id.tv_maintenance_department_text);

        fl_bussness_sector = (FrameLayout) view.findViewById(R.id.fl_bussness_sector);
        fl_bussness_sector_hide = (FrameLayout) view.findViewById(R.id.fl_bussness_sector_hide);
        fl_construction_sector  = (FrameLayout) view.findViewById(R.id.fl_construction_sector);
        fl_construction_sector_hide  = (FrameLayout) view.findViewById(R.id.fl_construction_sector_hide);
        fl_real_estate_investment = (FrameLayout) view.findViewById(R.id.fl_real_estate_investment);
        fl_real_estate_investment_hide = (FrameLayout) view.findViewById(R.id.fl_real_estate_investment_hide);
        fl_bin_sultan_celebrations = (FrameLayout) view.findViewById(R.id.fl_bin_sultan_celebrations);
        fl_bin_sultan_celebrations_hide = (FrameLayout) view.findViewById(R.id.fl_bin_sultan_celebrations_hide);
        fl_maintenance_department = (FrameLayout) view.findViewById(R.id.fl_maintenance_department);
        fl_maintenance_department_hide = (FrameLayout) view.findViewById(R.id.fl_maintenance_department_hide);


        fl_bussness_sector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fl_bussness_sector.setVisibility(View.GONE);
                fl_bussness_sector_hide.setVisibility(View.VISIBLE);

                fl_construction_sector.setVisibility(View.VISIBLE);
                fl_construction_sector_hide.setVisibility(View.GONE);

                fl_real_estate_investment.setVisibility(View.VISIBLE);
                fl_real_estate_investment_hide.setVisibility(View.GONE);

                fl_bin_sultan_celebrations.setVisibility(View.VISIBLE);
                fl_bin_sultan_celebrations_hide.setVisibility(View.GONE);

                fl_maintenance_department.setVisibility(View.VISIBLE);
                fl_maintenance_department_hide.setVisibility(View.GONE);
            }
        });

        fl_bussness_sector_hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fl_bussness_sector.setVisibility(View.VISIBLE);
                fl_bussness_sector_hide.setVisibility(View.GONE);


            }
        });

        fl_construction_sector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fl_bussness_sector.setVisibility(View.VISIBLE);
                fl_bussness_sector_hide.setVisibility(View.GONE);

                fl_construction_sector.setVisibility(View.GONE);
                fl_construction_sector_hide.setVisibility(View.VISIBLE);

                fl_real_estate_investment.setVisibility(View.VISIBLE);
                fl_real_estate_investment_hide.setVisibility(View.GONE);

                fl_bin_sultan_celebrations.setVisibility(View.VISIBLE);
                fl_bin_sultan_celebrations_hide.setVisibility(View.GONE);

                fl_maintenance_department.setVisibility(View.VISIBLE);
                fl_maintenance_department_hide.setVisibility(View.GONE);


            }
        });

        fl_construction_sector_hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fl_construction_sector.setVisibility(View.VISIBLE);
                fl_construction_sector_hide.setVisibility(View.GONE);


            }
        });

        fl_real_estate_investment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fl_bussness_sector.setVisibility(View.VISIBLE);
                fl_bussness_sector_hide.setVisibility(View.GONE);

                fl_construction_sector.setVisibility(View.VISIBLE);
                fl_construction_sector_hide.setVisibility(View.GONE);

                fl_real_estate_investment.setVisibility(View.GONE);
                fl_real_estate_investment_hide.setVisibility(View.VISIBLE);

                fl_bin_sultan_celebrations.setVisibility(View.VISIBLE);
                fl_bin_sultan_celebrations_hide.setVisibility(View.GONE);

                fl_maintenance_department.setVisibility(View.VISIBLE);
                fl_maintenance_department_hide.setVisibility(View.GONE);


            }
        });

        fl_real_estate_investment_hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fl_real_estate_investment.setVisibility(View.VISIBLE);
                fl_real_estate_investment_hide.setVisibility(View.GONE);


            }
        });

        fl_bin_sultan_celebrations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fl_bussness_sector.setVisibility(View.VISIBLE);
                fl_bussness_sector_hide.setVisibility(View.GONE);

                fl_construction_sector.setVisibility(View.VISIBLE);
                fl_construction_sector_hide.setVisibility(View.GONE);

                fl_real_estate_investment.setVisibility(View.VISIBLE);
                fl_real_estate_investment_hide.setVisibility(View.GONE);

                fl_bin_sultan_celebrations.setVisibility(View.GONE);
                fl_bin_sultan_celebrations_hide.setVisibility(View.VISIBLE);

                fl_maintenance_department.setVisibility(View.VISIBLE);
                fl_maintenance_department_hide.setVisibility(View.GONE);


            }
        });


        fl_bin_sultan_celebrations_hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fl_bin_sultan_celebrations.setVisibility(View.VISIBLE);
                fl_bin_sultan_celebrations_hide.setVisibility(View.GONE);


            }
        });

        fl_maintenance_department.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fl_bussness_sector.setVisibility(View.VISIBLE);
                fl_bussness_sector_hide.setVisibility(View.GONE);

                fl_construction_sector.setVisibility(View.VISIBLE);
                fl_construction_sector_hide.setVisibility(View.GONE);

                fl_real_estate_investment.setVisibility(View.VISIBLE);
                fl_real_estate_investment_hide.setVisibility(View.GONE);

                fl_bin_sultan_celebrations.setVisibility(View.VISIBLE);
                fl_bin_sultan_celebrations_hide.setVisibility(View.GONE);

                fl_maintenance_department.setVisibility(View.GONE);
                fl_maintenance_department_hide.setVisibility(View.VISIBLE);



            }
        });

        fl_maintenance_department_hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fl_maintenance_department.setVisibility(View.VISIBLE);
                fl_maintenance_department_hide.setVisibility(View.GONE);


            }
        });


        return view;
    }

}

