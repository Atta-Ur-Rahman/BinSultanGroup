package com.example.atta_ur_rahman.binsultangroup;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;


public class ChangeLanguage extends Fragment {

    TextView tv_arabic,tv_english,tv_slang;
    Locale mylocale;
    ImageView iv_english,iv_arabic;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_change_language, container, false);

        tv_english = (TextView)view.findViewById(R.id.tv_english);
        tv_arabic  = (TextView)view.findViewById(R.id.tv_arabic);

        iv_english = (ImageView) view.findViewById(R.id.iv_english);
        iv_arabic  = (ImageView)view.findViewById(R.id.iv_arabic);





        sharedPreferences = getActivity().getSharedPreferences(GeneralUtils.MY_PREF,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();



        tv_english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLanguage("en");
            }
        });

        tv_arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setLanguage("ar");

            }
        });

        iv_english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLanguage("en");
            }
        });

        iv_arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setLanguage("ar");

            }
        });
    /*    tv_slang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(Intent.ACTION_MAIN);
//                intent.setClassName("com.android.settings", "com.android.settings.LanguageSettings");
//                startActivity(intent);

                Intent i = new Intent( android.provider.Settings.ACTION_LOCALE_SETTINGS );
                startActivity( i );
            }
        });
*/
        return view;
    }

    private void setLanguage(String language) {

        editor.putString("language",language).commit();
        mylocale=new Locale(language);
        Resources resources=getResources();
        DisplayMetrics dm=resources.getDisplayMetrics();
        Configuration config= resources.getConfiguration();
        config.locale=mylocale;
        if (Build.VERSION.SDK_INT >= 17) {
            config.setLayoutDirection(mylocale);
        }
        resources.updateConfiguration(config,dm);

        ((MainActivity) getActivity()).updateDrawer();



    }

}
