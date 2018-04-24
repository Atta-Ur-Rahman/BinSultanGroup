package com.example.atta_ur_rahman.binsultangroup;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.io.ByteArrayOutputStream;

import static android.R.attr.id;
import static com.example.atta_ur_rahman.binsultangroup.R.layout.fragment_projcets;


public class Projcets extends Fragment {
    ImageView tv_ben_sultan_razdens,iv_ben_sultan_razdens,tv_housing_ben_sultan,iv_housing_ben_sultan,
            tv_rawabi_bin_sultan_project,iv_rawabi_bin_sultan_project,tv_ben_sultan_golden_belt,iv_ben_sultan_golden_belt
            ,iv_project_image;
    TextView tv_projects_text,tv_projects_text_detail;

    LinearLayout ll_services,ll_project,ll_project_image_text;
    ListView list;
    View view;
    Intent intent = null;
    ScrollView  scrollview;

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        if (savedInstanceState != null){
//            value = savedInstanceState.getInt("ourkey","0");
//        }
//    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(fragment_projcets, container, false);


        tv_projects_text = (TextView) view.findViewById(R.id.tv_projects_text);
        tv_projects_text_detail = (TextView) view.findViewById(R.id.tv_projects_text_detail);
        iv_ben_sultan_razdens = (ImageView)view.findViewById(R.id.iv_ben_sultan_razdens);
        iv_project_image = (ImageView)view.findViewById(R.id.iv_projects_images);



        iv_housing_ben_sultan = (ImageView)view.findViewById(R.id.iv_housing_ben_sultan);

        iv_rawabi_bin_sultan_project = (ImageView)view.findViewById(R.id.iv_rawabi_bin_sultan_project);

        iv_ben_sultan_golden_belt = (ImageView)view.findViewById(R.id.iv_ben_sultan_golden_belt);

        ll_project =(LinearLayout) view.findViewById(R.id.ll_projects);
        ll_project_image_text = (LinearLayout)view.findViewById(R.id.ll_projects_image_text);


        iv_ben_sultan_razdens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                FragmentTransaction transection=getFragmentManager().beginTransaction();
                ProjectView mfragment=new ProjectView();

//using Bundle to send data
                Bundle bundle=new Bundle();
                bundle.putString("title",getString(R.string.ben_sultan_razdens));
                bundle.putString("text",getString(R.string.details_ben_sultan_razdens));
                bundle.putInt("Image", (R.drawable.ben_sultan_razdens));
                mfragment.setArguments(bundle); //data being send to SecondFragment
                transection.replace(R.id.fragment_container, mfragment).addToBackStack("");
                transection.commit();


            }
        });


        iv_housing_ben_sultan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



//                View myFragmentView = inflater.inflate(R.layout.project_images_text, container, true);


                FragmentTransaction transection=getFragmentManager().beginTransaction();
                ProjectView mfragment=new ProjectView();

//using Bundle to send data
                Bundle bundle=new Bundle();
                bundle.putString("title",getString(R.string.housing_ben_sultan));
                bundle.putString("text",getString(R.string.details_housing_ben_sultan));
                bundle.putInt("Image", (R.drawable.housing_ben_sultan));
                mfragment.setArguments(bundle); //data being send to SecondFragment
                transection.replace(R.id.fragment_container, mfragment).addToBackStack("");
                transection.commit();




            }
        });


        iv_rawabi_bin_sultan_project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                FragmentTransaction transection=getFragmentManager().beginTransaction();
                ProjectView mfragment=new ProjectView();

//using Bundle to send data
                Bundle bundle=new Bundle();
                bundle.putString("title",getString(R.string.rawabi_bin_sultan_project));
                bundle.putString("text",getString(R.string.details_rawabi_bin_sultan_project));
                bundle.putInt("Image", (R.drawable.rawabi_bin_sultan_project));
                mfragment.setArguments(bundle); //data being send to SecondFragment
                transection.replace(R.id.fragment_container, mfragment).addToBackStack("");
                transection.commit();




            }
        });


        iv_ben_sultan_golden_belt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





                FragmentTransaction transection=getFragmentManager().beginTransaction();
                ProjectView mfragment=new ProjectView();

//using Bundle to send data
                Bundle bundle=new Bundle();
                bundle.putString("title",getString(R.string.ben_sultan_golden_belt));
                bundle.putString("text",getString(R.string.details_ben_sultan_golden_belt));
                bundle.putInt("Image", (R.drawable.ben_sultan_golden_belt));
                mfragment.setArguments(bundle); //data being send to SecondFragment
                transection.replace(R.id.fragment_container, mfragment).addToBackStack("");
                transection.commit();


            }
        });



        //// on back press use in fragment
//        view.setFocusableInTouchMode(true);
//        view.requestFocus();
//        view.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event)   {
//                if (keyCode == KeyEvent.KEYCODE_BACK) {
//
////                    ll_project_image_text.setVisibility(View.GONE);
////                    ll_project.setVisibility(View.VISIBLE);
//
//
//                    return true;
//                }
//                return false;
//            }
//        });





        return view;
    }

//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putInt("ourkey",value);
//    }

}

