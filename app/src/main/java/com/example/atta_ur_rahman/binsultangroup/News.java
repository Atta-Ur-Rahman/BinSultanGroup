package com.example.atta_ur_rahman.binsultangroup;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ms.square.android.expandabletextview.ExpandableTextView;


public class News extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        ExpandableTextView expTv1 = (ExpandableTextView) view.findViewById(R.id.expand_text_view);
        expTv1.setText(getString(R.string.text1));

        return view;
    }

}
