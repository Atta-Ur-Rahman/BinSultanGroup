package com.example.atta_ur_rahman.binsultangroup;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.phlox.datepick.CalendarNumbersView;
import com.phlox.datepick.CalendarPickerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import cn.pedant.SweetAlert.SweetAlertDialog;
import static android.app.Activity.RESULT_OK;


public class Employment extends Fragment {


    Button btn_employment_cv, btn_employment_certificates, btn_employment_send;

    File file_cv, file_certificates;

    private EditText et_employment_date_of_birth, et_employment_name, et_employment_family_name, et_employment_mobile_number,
            et_employment_telephone_number, et_employment_email, et_employment_place_residence, et_employment_city,
            et_employment_nationality, et_employment_gender;

    private PopupWindow calendarPopup;

    private static final int SELECT_PICTURE_CV = 100;
    private static final int SELECT_PICTURE_CERTIFICATES = 200;

    ImageView iv_employment_cv, iv_employment_certificates;

    SweetAlertDialog sweetAlertDialog_response,sweetAlertDialog_loding,sweetAlertDialog_success,sweetAlertDialog_no_internet;

    RadioButton rbtnmale, rbtnfemale;

    private static final Pattern EMAIL_PATTERN = Pattern
            .compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");


    private static final Pattern USERFIRSTNAME_PATTERN = Pattern
            .compile("[a-zA-Z0-9 ]{1,250}");
    private static final Pattern PHONE_PATTERN = Pattern
            .compile("[a-zA-Z0-9]{1,250}");





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_employment, container, false);

        sweetAlertDialog_loding  = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
        sweetAlertDialog_loding.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        sweetAlertDialog_loding.setTitleText(getString(R.string.loading));

        sweetAlertDialog_success  = new SweetAlertDialog(getActivity(), SweetAlertDialog.SUCCESS_TYPE);
        sweetAlertDialog_success.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        sweetAlertDialog_success.setTitleText(getString(R.string.we_have_received_cv));
        sweetAlertDialog_success.setContentText(getString(R.string.will_get_back));

        sweetAlertDialog_response = new  SweetAlertDialog(getActivity(), SweetAlertDialog.ERROR_TYPE);
        sweetAlertDialog_response.setTitleText(getString(R.string.oop));
        sweetAlertDialog_response .setContentText(getString(R.string.something_went_wrong));


        iv_employment_cv = (ImageView) view.findViewById(R.id.iv_employment_cv);
        iv_employment_certificates = (ImageView) view.findViewById(R.id.iv_employment_certificates);

        et_employment_name = (EditText) view.findViewById(R.id.et_employment_name);
        et_employment_family_name = (EditText) view.findViewById(R.id.et_employment_family_name);

        et_employment_date_of_birth = (EditText) view.findViewById(R.id.et_employment_date_of_birth);

        et_employment_gender = (EditText) view.findViewById(R.id.et_employment_gender);

        rbtnfemale = (RadioButton) view.findViewById(R.id.rbtnf);

        rbtnmale = (RadioButton) view.findViewById(R.id.rbtnm);
        et_employment_mobile_number = (EditText) view.findViewById(R.id.et_employment_mobile_number);
        et_employment_telephone_number = (EditText) view.findViewById(R.id.et_employment_telephone_number);
        et_employment_email = (EditText) view.findViewById(R.id.et_employment_email);
        et_employment_place_residence = (EditText) view.findViewById(R.id.et_employment_place_residence);
        et_employment_city = (EditText) view.findViewById(R.id.et_employment_city);
        et_employment_nationality = (EditText) view.findViewById(R.id.et_employment_nationality);


        btn_employment_cv = view.findViewById(R.id.btn_employment_cv);
        btn_employment_certificates = view.findViewById(R.id.btn_employment_certificates);
        btn_employment_send =  view.findViewById(R.id.btn_employment_send);


        et_employment_date_of_birth.setOnClickListener(onButtonClickListener);


        rbtnmale = (RadioButton) view.findViewById(R.id.rbtnm);
        rbtnfemale = (RadioButton) view.findViewById(R.id.rbtnf);

        btn_employment_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE_CV);
            }
        });


        btn_employment_certificates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE_CERTIFICATES);
            }
        });


        rbtnmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_employment_gender.setText(getString(R.string.employment_male));
            }
        });


        rbtnfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_employment_gender.setText(getString(R.string.employment_female));

            }
        });


        btn_employment_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String check_name = et_employment_name.getText().toString();
                String check_family_name = et_employment_family_name.getText().toString();
                String check_mobile_number  = et_employment_mobile_number.getText().toString();
                String  check_telephone_number = et_employment_telephone_number.getText().toString();
                String  check_email = et_employment_email.getText().toString();
                String check_residence = et_employment_place_residence.getText().toString();
                String check_city = et_employment_city.getText().toString();
                String check_nationality = et_employment_nationality.getText().toString();


                if (et_employment_name.length() <= 0) {
                    et_employment_name.setError(getString(R.string.enter_name));

                } else if (et_employment_family_name.length() <= 0) {
                    et_employment_family_name.setError(getString(R.string.enter_family_name));

                } else if (et_employment_date_of_birth.length() <= 0) {
                    et_employment_date_of_birth.setError(getString(R.string.ente_dob));

                } else if (et_employment_gender.length() <= 0) {
                    et_employment_gender.setError(getString(R.string.enter_gender));

                } else if (et_employment_mobile_number.length() <= 0) {
                    et_employment_mobile_number.setError(getString(R.string.enter_mobile_number));

                } else if (et_employment_telephone_number.length() <= 0) {
                    et_employment_telephone_number.setError(getString(R.string.enter_telephone_number));

                } else if (et_employment_email.length() <= 0) {
                    et_employment_email.setError(getString(R.string.enter_email));

                }else if (et_employment_place_residence.length()<=0){
                    et_employment_place_residence.setError(getString(R.string.enter_place_r));

                }else if (et_employment_city.length()<=0) {
                    et_employment_city.setError(getString(R.string.enter_city));
                }else if (et_employment_nationality.length()<=0){
                    et_employment_nationality.setError(getString(R.string.enter_nationality));
                }
                else if (!CheckEmail(check_email)){
                    et_employment_email.setError(getString(R.string.correct_email));

                } else if (iv_employment_cv.getDrawable() == null){
                    btn_employment_cv.setError(getString(R.string.cv_doesnot_exist));

                }else if(iv_employment_certificates.getDrawable() == null){
                    btn_employment_certificates.setError(getString(R.string.certificates_dosenot_exist));

                }else if (et_employment_name.equals(et_employment_family_name)){
                    et_employment_name.setError(getString(R.string.name_family_same));
                    }
                    else

                apicall();
            }
        });


        return view;
    }

    private boolean CheckChar(String check_name) {
        return USERFIRSTNAME_PATTERN.matcher(check_name).matches();
    }

    private boolean CheckPhone(String check_phone_number) {

        return PHONE_PATTERN.matcher(check_phone_number).matches();
    }

    private boolean CheckEmail(String check_email) {

        return EMAIL_PATTERN.matcher(check_email).matches();
    }

    //// onButton click listener for calender

    private View.OnClickListener onButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (calendarPopup == null) {
                calendarPopup = new PopupWindow(getActivity());
                CalendarPickerView calendarView = new CalendarPickerView(getActivity());
                calendarView.setListener(dateSelectionListener);
                calendarPopup.setContentView(calendarView);
                calendarPopup.setWindowLayoutMode(
                        View.MeasureSpec.makeMeasureSpec(view.getWidth(), View.MeasureSpec.EXACTLY),
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                calendarPopup.setHeight(1);
                calendarPopup.setWidth(view.getWidth());
                calendarPopup.setOutsideTouchable(true);
            }
            calendarPopup.showAsDropDown(view);
        }
    };

    private CalendarNumbersView.DateSelectionListener dateSelectionListener = new CalendarNumbersView.DateSelectionListener() {
        @Override
        public void onDateSelected(Calendar selectedDate) {
            if (calendarPopup.isShowing()) {
                calendarPopup.getContentView().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        calendarPopup.dismiss();
                    }
                }, 500);//For clarity, we close the popup not immediately.
            }
            SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
            et_employment_date_of_birth.setText(formatter.format(selectedDate.getTime()));
        }
    };


    public void onActivityResult(int requestCode, int resultCode, Intent data) {


        if (resultCode == RESULT_OK) {

            if (requestCode == SELECT_PICTURE_CV && null != data) {
                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getActivity().getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String picturePath = cursor.getString(columnIndex);
                file_cv = new File(GeneralUtils.getRealPathFromURI(getActivity(), selectedImage));

                Log.d("zma file", file_cv.getPath());
                cursor.close();
                iv_employment_cv.setImageBitmap(BitmapFactory.decodeFile(picturePath));

            } else
                if (requestCode == SELECT_PICTURE_CERTIFICATES && null != data) {
                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getActivity().getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String picturePath = cursor.getString(columnIndex);
                file_certificates = new File(GeneralUtils.getRealPathFromURI(getActivity(), selectedImage));

                Log.d("zma file", file_certificates.getPath());
                cursor.close();
                iv_employment_certificates.setImageBitmap(BitmapFactory.decodeFile(picturePath));


            }

        }
    }


    ////api class

    private void apicall() {

        // loading or check internet connection or something...
        // ... then

        if (CheckNetwork.isInternetAvailable(getActivity())){



        sweetAlertDialog_loding.show();

        String url = "http://testingcodes.com/apis/Api/user_details";
        VolleyMultipartRequest multipartRequest = new VolleyMultipartRequest(Request.Method.POST, url, new Response.Listener<NetworkResponse>() {
            @Override
            public void onResponse(NetworkResponse response) {
                String resultResponse = new String(response.data);
                if (response.statusCode == 200) {

                    sweetAlertDialog_loding.dismiss();
                    sweetAlertDialog_success.show();


                    et_employment_name.setText("");
                    et_employment_family_name.setText("");
                    et_employment_date_of_birth.setText("");
                    et_employment_gender.setText("");
                    rbtnfemale.setChecked(false);
                    rbtnmale.setChecked(false);
                    et_employment_mobile_number.setText("");
                    et_employment_telephone_number.setText("");
                    et_employment_email.setText("");
                    et_employment_place_residence.setText("");
                    et_employment_city.setText("");
                    et_employment_nationality.setText("");
                    iv_employment_cv.setImageDrawable(null);
                    iv_employment_certificates.setImageDrawable(null);

                    //Toast.makeText(getActivity(), "Send", Toast.LENGTH_SHORT).show();
                    Log.d("zma response", String.valueOf(response.statusCode+"\n"+resultResponse));
                } else {
                    //Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                    sweetAlertDialog_response.show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

               // Toast.makeText(getActivity(), "ERROR", Toast.LENGTH_SHORT).show();
                sweetAlertDialog_response.show();
                sweetAlertDialog_loding.dismiss();
                NetworkResponse networkResponse = error.networkResponse;

                String errorMessage = "Unknown error";
                if (networkResponse == null) {
                    if (error.getClass().equals(TimeoutError.class)) {
                        errorMessage = "Request timeout";
                        sweetAlertDialog_loding.dismiss();
                        sweetAlertDialog_response.show();

                    } else if (error.getClass().equals(NoConnectionError.class)) {
                        sweetAlertDialog_loding.dismiss();
                        sweetAlertDialog_response.show();
                        errorMessage = "Failed to connect server";
                    }
                } else {
                    String result = new String(networkResponse.data);
                    try {
                        JSONObject response = new JSONObject(result);
                        String status = response.getString("status");
                        String message = response.getString("message");

                        Log.e("Error Status", status);
                        Log.e("Error Message", message);

                        if (networkResponse.statusCode == 404) {
                            errorMessage = "Resource not found";
                            sweetAlertDialog_loding.dismiss();
                            sweetAlertDialog_response.show();

                        } else if (networkResponse.statusCode == 401) {
                            errorMessage = message + " Please login again";

                            sweetAlertDialog_loding.dismiss();
                            sweetAlertDialog_response.show();

                        } else if (networkResponse.statusCode == 400) {
                            errorMessage = message + " Check your inputs";

                            sweetAlertDialog_loding.dismiss();
                            sweetAlertDialog_response.show();

                        } else if (networkResponse.statusCode == 500) {
                            errorMessage = message + " Something is getting wrong";

                            sweetAlertDialog_loding.dismiss();
                            sweetAlertDialog_response.show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                Log.i("Error", errorMessage);
                error.printStackTrace();
            }
        }) {

            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("name", et_employment_name.getText().toString());
                params.put("family_name", et_employment_family_name.getText().toString());
                params.put("dob", et_employment_date_of_birth.getText().toString());
                params.put("gender", et_employment_gender.getText().toString());
                params.put("mobile_no", et_employment_mobile_number.getText().toString());
                params.put("telephone_no", et_employment_telephone_number.getText().toString());
                params.put("email", et_employment_email.getText().toString());
                params.put("residence", et_employment_place_residence.getText().toString());
                params.put("city", et_employment_city.getText().toString());
                params.put("nationality", et_employment_nationality.getText().toString());
                Log.d("zma value params", params.toString());
                return params;
            }


            protected Map<String, DataPart> getByteData() {
                Map<String, DataPart> params = new HashMap<>();
                // file name could found file base or direct access from real path
                // for now just get bitmap data from ImageView
                String mimeType = GeneralUtils.getMimeTypeofFile(file_cv);
                String mimeType_ce = GeneralUtils.getMimeTypeofFile(file_certificates);
                params.put("cv", new DataPart("cv", GeneralUtils.getByteArrayFromFile(file_cv), mimeType));
                params.put("certificate", new DataPart("certificate", GeneralUtils.getByteArrayFromFile(file_certificates), mimeType_ce));
                Log.d("zma files params", params.toString());
                return params;
            }
        };

        RequestQueue mRequestQueue = Volley.newRequestQueue(getActivity());
        multipartRequest.setRetryPolicy(new DefaultRetryPolicy(200000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        mRequestQueue.add(multipartRequest);

    }else {
            sweetAlertDialog_no_internet = new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE);
            sweetAlertDialog_no_internet.setTitleText(getString(R.string.oop))
                    .setContentText(getString(R.string.no_internet))
                    .show();
        }
    }
}