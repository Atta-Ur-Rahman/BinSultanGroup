package com.example.atta_ur_rahman.binsultangroup;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.CheckResult;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import cn.pedant.SweetAlert.SweetAlertDialog;



public class BinSultanWebView extends Fragment {

    WebView bin_sultan_web_view;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ProgressBar pb_webview;
    Button button;
    SweetAlertDialog sweetAlertDialog,sweetAlertDialog_no_internet;
    FrameLayout fl_webview;




    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bin_sultan_web_view, container, false);
        fl_webview = (FrameLayout)view.findViewById(R.id.fl_webview);

        sharedPreferences = getActivity().getSharedPreferences("com.bin", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        final String url_bin_sultan = sharedPreferences.getString("url_bin_sultan", "");

        bin_sultan_web_view = (WebView) view.findViewById(R.id.bin_sultan_web_view);


       if(CheckNetwork.isInternetAvailable(getActivity())){

           ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
          // Toast.makeText(getActivity(), "internet avileble", Toast.LENGTH_SHORT).show();
       }
       else {

           fl_webview.setVisibility(View.GONE);
          sweetAlertDialog_no_internet = new SweetAlertDialog(getActivity(), SweetAlertDialog.ERROR_TYPE);
           sweetAlertDialog_no_internet.setTitleText("Oops...")
                   .setContentText("No Internet Connection")
                   .setConfirmText("Refresh")
                   .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                       @Override
                       public void onClick(SweetAlertDialog sDialog) {

                          /* Fragment fragment_webview = new BinSultanWebView();
                           getFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment_webview).commit();
                           sweetAlertDialog.dismiss();*/

                           if(CheckNetwork.isInternetAvailable(getActivity())){

                               ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
                               bin_sultan_web_view.loadUrl(url_bin_sultan);
                               fl_webview.setVisibility(View.VISIBLE);
                               sweetAlertDialog_no_internet.dismiss();

                           } else
                               sweetAlertDialog_no_internet.show();

                        //   sweetAlertDialog_no_internet.dismiss();
                             // Toast.makeText(getActivity(), "internet available", Toast.LENGTH_SHORT).show();


                         }
                   })
                   .setCancelText("OK")
                   .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                       @Override
                       public void onClick(SweetAlertDialog sweetAlertDialog) {
                           sweetAlertDialog.dismiss();
                           Fragment frament_webview = new ContactUs();
                           getFragmentManager().beginTransaction().replace(R.id.fragment_container,frament_webview).commit();
                       }
                   })
                   .show();
           //Toast.makeText(getActivity(), "no internet accecss", Toast.LENGTH_SHORT).show();
       }



       sweetAlertDialog  = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
        sweetAlertDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        sweetAlertDialog.setTitleText("Loading.....");





        bin_sultan_web_view.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {


                //sweetAlertDialog.setCancelable(false);
                sweetAlertDialog.show();


                //pb_webview.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {

                sweetAlertDialog.dismiss();



               // pb_webview.setVisibility(View.GONE);
                super.onPageFinished(view, url);

            }

            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {

                Toast.makeText(getActivity(), "Cannot load page", Toast.LENGTH_SHORT).show();
                new SweetAlertDialog(getActivity(), SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Oops...")
                        .setContentText("Cannot load page")
                        .show();
                super.onReceivedError(view, request, error);
                //pb_webview.setVisibility(View.GONE);
            }

        });

        WebSettings webSettings = bin_sultan_web_view.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setSupportMultipleWindows(true);

        bin_sultan_web_view.getSettings().setAppCacheEnabled(true);
        bin_sultan_web_view.getSettings().setDatabaseEnabled(true);
        bin_sultan_web_view.getSettings().setDomStorageEnabled(true);
        bin_sultan_web_view.getSettings().setDomStorageEnabled(true);
        bin_sultan_web_view.setSoundEffectsEnabled(true);
        bin_sultan_web_view.setHorizontalFadingEdgeEnabled(true);
        bin_sultan_web_view.setKeepScreenOn(true);
        bin_sultan_web_view.setScrollbarFadingEnabled(true);
        bin_sultan_web_view.setVerticalFadingEdgeEnabled(false);
        bin_sultan_web_view.getSettings().setAllowUniversalAccessFromFileURLs(true);
        bin_sultan_web_view.getSettings().setAppCacheEnabled(true);
        bin_sultan_web_view.getSettings().setUseWideViewPort(true);

        bin_sultan_web_view.loadUrl(url_bin_sultan);



        bin_sultan_web_view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    WebView webView = (WebView) v;

                    switch (keyCode) {
                        case KeyEvent.KEYCODE_BACK:
                            if (webView.canGoBack()) {
                                bin_sultan_web_view.goBack();
                                return true;
                            }
                            break;
                    }
                }

                return false;
            }
        });




//        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url_bin_sultan));
//        startActivity(myIntent);
        return view;
    }


    }
