package com.example.atta_ur_rahman.binsultangroup;

import android.content.res.Resources;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;


public class Team extends Fragment {


    ListView lv_team;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team, container, false);


        /*
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, name);
        lv_team.setAdapter(listViewAdapter);
*/

        lv_team = (ListView) view.findViewById(R.id.lv_team);
        CustomAdapter customAdapter = new CustomAdapter();
        lv_team.setAdapter(customAdapter);

        return view;
    }

    public class  CustomAdapter extends BaseAdapter{

        int[] images = {R.drawable.sultan_ali_bin_sultan, R.drawable.sultan_bin_sultan, R.drawable.ali_bin_sultan,
                R.drawable.ibrahim_bin_saed_al_ghamdi, R.drawable.walid_shishtawi, R.drawable.mohammed_fawzy};

        String[] name = {getResources().getString(R.string.name_sultan_ali_bin_sultan) ,getResources().getString(R.string.name_sultan_bin_sultan),
                getResources().getString(R.string.name_ali_bin_sultan), getResources().getString(R.string.name_ibrahim_bin_saed_al_ghamdi),
                getResources(). getString(R.string.name_walid_shistawi), getResources().getString(R.string.name_mohammed_fawzy)};

        String[] description = {getResources().getString(R.string.descoription_sultan_ali_bin_sultan),  getResources().getString(R.string.descoription_sultan_bin_sultan),
                getResources().getString(R.string.descoription_ali_bin_sultan), getResources().getString(R.string.descoription_ibrahim_bin_saed_al_ghamdi),
                getResources().getString(R.string.descoription_walid_shistawi), getResources().getString(R.string.descoription_mohammed_fawzy)};



        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {




            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_list_layout, parent, false);
            TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
            TextView tv_description = (TextView) view.findViewById(R.id.tv_description);
            ImageView iv_team_images = (ImageView) view.findViewById(R.id.iv_team_images);

            iv_team_images.setImageResource(images[position]);
            tv_name.setText(name[position]);
            tv_description.setText(description[position]);
            return view;
        }
    }


}
