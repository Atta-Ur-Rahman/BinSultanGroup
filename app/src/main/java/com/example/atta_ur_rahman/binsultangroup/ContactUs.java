package com.example.atta_ur_rahman.binsultangroup;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import cn.pedant.SweetAlert.SweetAlertDialog;
public class ContactUs extends Fragment {
    ImageView iv_phone,iv_email,iv_google_map,iv_google_plus,iv_youtube,iv_instagram,iv_facebook,iv_twitter;

    EditText et_talk_email,et_talk_name,et_talk_phone_number,et_talk_message;

    Button btn_send;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    SweetAlertDialog sweetAlertDialog_response,sweetAlertDialog_loding,sweetAlertDialog_no_internet;


    private static final Pattern EMAIL_PATTERN = Pattern
            .compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");


    private static final Pattern USERFIRSTNAME_PATTERN = Pattern
            .compile("[a-zA-Z0-9]{1,250}");
    private static final Pattern PHONE_PATTERN = Pattern
            .compile("[a-zA-Z0-9]{1,250}");


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view  =inflater.inflate(R.layout.fragment_contact_us, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();

        sweetAlertDialog_loding  = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
        sweetAlertDialog_loding.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        sweetAlertDialog_loding.setTitleText(getString(R.string.loading));

        btn_send = (Button)view.findViewById(R.id.btn_talk_send);

        iv_phone = (ImageView)view.findViewById(R.id.iv_phone);
        iv_email = (ImageView)view.findViewById(R.id.iv_email);
        iv_google_map = (ImageView)view.findViewById(R.id.iv_google_map);
        iv_google_plus = (ImageView)view.findViewById(R.id.iv_google_plus);
        iv_youtube = (ImageView)view.findViewById(R.id.iv_youtube);
        iv_instagram = (ImageView)view.findViewById(R.id.iv_instagram);
        iv_facebook = (ImageView)view.findViewById(R.id.iv_facebook);
        iv_twitter = (ImageView)view.findViewById(R.id.iv_twitter);


        et_talk_name = (EditText)view.findViewById(R.id.et_talk_name);
        et_talk_email = (EditText)view.findViewById(R.id.et_talk_email);
        et_talk_phone_number = (EditText)view.findViewById(R.id.et_talk_phone_number);
        et_talk_message = (EditText)view.findViewById(R.id.et_talk_message);


        ///add an image on EditText

//        et_talk_name.setCompoundDrawablesWithIntrinsicBounds(null, null,
//                getResources().getDrawable(R.drawable.down),
//                null);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                String check_name = et_talk_name.getText().toString();
                String check_email_address = et_talk_email.getText().toString();
                String check_phone_number = et_talk_phone_number.getText().toString();
                String check_message = et_talk_message.getText().toString();

              if (et_talk_name.length()<=0){

                  et_talk_name.setError(getString(R.string.enter_name));
                  sweetAlertDialog_loding.dismiss();

              }
              if (et_talk_email.length()<=0)
              {
                  et_talk_email.setError(getString(R.string.enter_email));
                  sweetAlertDialog_loding.dismiss();

              }
              if (et_talk_phone_number.length()<=0){

                  et_talk_phone_number.setError(getString(R.string.enter_phone_number));

              }
              if (et_talk_message.length()<=0){

                  et_talk_message.setError(getString(R.string.enter_message));
              }
            /*  else if (!CheckName(check_name)){

                  et_talk_name.setError("Correct Format");

              }*/ else if (!CheckEmail(check_email_address)){

                  et_talk_email.setError(getString(R.string.correct_email));

              }/*else if (!CheckPhone(check_phone_number)){

                  et_talk_phone_number.setError("Correct Format ");

              }*/ else
                  if (et_talk_name.getText().toString().equals(et_talk_message.getText().toString())){
                      et_talk_name.setError(getString(R.string.name_family_same));
                  }
                  else

                apicall();

            }
        });


        iv_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new
                        Intent(Intent.ACTION_CALL, Uri.parse("tel:" + 920002442));
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }
                startActivity(i);
            }
        });



        sharedPreferences = getActivity().getSharedPreferences("com.bin",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();


        iv_google_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment_bin_sultan_webview = new BinSultanWebView();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment_bin_sultan_webview).addToBackStack("tag").commit();
                String url_bin_sultan = "https://plus.google.com/u/0/b/115018533786799223884/115018533786799223884/posts";
                editor.putString("url_bin_sultan", String.valueOf(url_bin_sultan.toString())).commit();
            }
        });

        iv_youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment_bin_sultan_webview = new BinSultanWebView();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment_bin_sultan_webview).addToBackStack("tag").commit();
                String url_bin_sultan = "http://www.youtube.com/user/BinSultanGroup/videos";
                editor.putString("url_bin_sultan", String.valueOf(url_bin_sultan.toString())).commit();

            }
        });

        iv_instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment_bin_sultan_webview = new BinSultanWebView();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment_bin_sultan_webview).addToBackStack("tag").commit();
                String url_bin_sultan = "http://instagram.com/binsultangro";
                editor.putString("url_bin_sultan", String.valueOf(url_bin_sultan.toString())).commit();
               }
        });
        iv_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment_bin_sultan_webview = new BinSultanWebView();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment_bin_sultan_webview).addToBackStack("tag").commit();
                String url_bin_sultan = "https://www.facebook.com/alibinsultangroup";
                editor.putString("url_bin_sultan", String.valueOf(url_bin_sultan.toString())).commit();
            }
        });
        iv_twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment_bin_sultan_webview = new BinSultanWebView();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment_bin_sultan_webview).addToBackStack("tag").commit();
                String url_bin_sultan = "https://twitter.com/BinSultanGro";
                editor.putString("url_bin_sultan", String.valueOf(url_bin_sultan.toString())).commit();


            }
        });

        return view;
    }

   /* private boolean CheckPhone(String check_phone_number) {

        return PHONE_PATTERN.matcher(check_phone_number).matches();
    }
*/
    private boolean CheckEmail(String check_email) {

        return EMAIL_PATTERN.matcher(check_email).matches();
    }

  /*  private boolean CheckName(String check_name) {

        return USERFIRSTNAME_PATTERN.matcher(check_name).matches();
    }
*/
    private void apicall() {

        if (CheckNetwork.isInternetAvailable(getActivity())){


        sweetAlertDialog_loding.show();
        btn_send.setEnabled(false);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://testingcodes.com/apis/Api/contact_us"
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("zma log ", response);

                if (response.contains("true")) {

                    sweetAlertDialog_response = new SweetAlertDialog(getActivity(), SweetAlertDialog.SUCCESS_TYPE);
                    sweetAlertDialog_response.setTitleText(getString(R.string.thank_Contecting_us));
                    sweetAlertDialog_response.setContentText(getString(R.string.we_have_receved_message));
                    sweetAlertDialog_response.show();

                    btn_send.setEnabled(true);

                    sweetAlertDialog_loding.dismiss();

                    et_talk_name.setText("");
                    et_talk_email.setText("");
                    et_talk_phone_number.setText("");
                    et_talk_message.setText("");
                    // Toast.makeText(getActivity(), String.valueOf(response), Toast.LENGTH_SHORT).show();


                } else {
                    sweetAlertDialog_response.dismiss();
                    new SweetAlertDialog(getActivity(), SweetAlertDialog.ERROR_TYPE)
                            .setTitleText(getString(R.string.oop))
                            .setContentText(getString(R.string.error))
                            .show();

                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                new SweetAlertDialog(getActivity(), SweetAlertDialog.ERROR_TYPE)
                        .setTitleText(getString(R.string.oop))
                        .setContentText(getString(R.string.error))
                        .show();
                btn_send.setEnabled(true);
                sweetAlertDialog_loding.dismiss();

            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded;charset=UTF-8";
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name",et_talk_name.getText().toString());
                params.put("email", et_talk_email.getText().toString());
                params.put("phone_number",et_talk_phone_number.getText().toString());
                params.put("msg",et_talk_message.getText().toString());

                return params;
            }

        };
        RequestQueue mRequestQueue = Volley.newRequestQueue(getActivity());
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(200000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        mRequestQueue.add(stringRequest);
        }else {
            sweetAlertDialog_no_internet = new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE);
            sweetAlertDialog_no_internet.setTitleText(getString(R.string.oop))
                    .setContentText(getString(R.string.no_internet))
                    .show();

        }
    }


}
