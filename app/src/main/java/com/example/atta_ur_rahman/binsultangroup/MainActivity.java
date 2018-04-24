package com.example.atta_ur_rahman.binsultangroup;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Locale;

import static com.example.atta_ur_rahman.binsultangroup.R.id.nav_view;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Locale mylocale;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sharedPreferences = getSharedPreferences(GeneralUtils.MY_PREF, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        String strLang = String.valueOf(GeneralUtils.getSharedPreferences(MainActivity.this).getString("language", ""));
        if (!strLang.isEmpty()){
            setLanguage(strLang);

        }




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Locale.getDefault().getDisplayLanguage();


///////change app language change title language;

        setTitle(R.string.app_name);



        Fragment fragment = new Employment();
        getFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();


       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the home action
            Fragment fragment_home = new Home();
            getFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment_home).addToBackStack("tag").commit();
        } else if (id == R.id.nav_team) {
            Fragment fragment_team = new Team();
            getFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment_team).addToBackStack("tag").commit();

        } else if (id == R.id.nav_services) {
            Fragment fragment_services = new Services();
            getFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment_services).addToBackStack("tag").commit();
        } else if (id == R.id.nav_projects) {

            Fragment fragment_projects = new Projcets();
            getFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment_projects).addToBackStack("tag").commit();

        }
        else if (id == R.id.nav_customers) {

            Fragment fragment_customers = new Customers();
            getFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment_customers).addToBackStack("tag").commit();

        }

        else if (id == R.id.nav_contact_us) {
            Fragment fragment_contact_us = new ContactUs();
            getFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment_contact_us).addToBackStack("tag").commit();

        }

        else if (id == R.id.nav_employment) {
            Fragment fragment_employment = new Employment();
            getFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment_employment).addToBackStack("tag").commit();

        }
        else if (id == R.id.nav_language) {
            Fragment fragment_language = new ChangeLanguage();
            getFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment_language).addToBackStack("tag").commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    private void setLanguage(String language) {

        editor.putString("language", language).commit();
        mylocale = new Locale(language);
        Resources resources = getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration config = resources.getConfiguration();
        config.locale = mylocale;
        if (Build.VERSION.SDK_INT >= 17) {
            config.setLayoutDirection(mylocale);
        }
        resources.updateConfiguration(config, dm);
        updateTexts();




    }





    private void updateTexts() {
        MenuItem nav_home,nav_team,nav_services,nav_projects,nav_customers,nav_contact_us,nav_employment,nav_language;



        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        TextView header_bin_sultan_group = (TextView)headerView.findViewById(R.id.header_bin_sultan_group);
        header_bin_sultan_group.setText(R.string.bin_sultan_group);


        Menu menu = navigationView.getMenu();

        nav_home = (MenuItem)menu.findItem(R.id.nav_home);
        nav_team = (MenuItem)menu.findItem(R.id.nav_team);
        nav_services = (MenuItem)menu.findItem(R.id.nav_services);
        nav_projects = (MenuItem)menu.findItem(R.id.nav_projects);
        nav_customers = (MenuItem)menu.findItem(R.id.nav_customers);
        nav_contact_us = (MenuItem)menu.findItem(R.id.nav_contact_us);
        nav_employment = (MenuItem)menu.findItem(R.id.nav_employment);
        nav_language = (MenuItem)menu.findItem(R.id.nav_language);



        nav_home.setTitle(R.string.home);
        nav_team.setTitle(R.string.team);
        nav_services.setTitle(R.string.services);
        nav_projects.setTitle(R.string.project);
        nav_customers.setTitle(R.string.customers);
        nav_contact_us.setTitle(R.string.contact_us);
        nav_employment.setTitle(R.string.employment);
        nav_language.setTitle(R.string.language);


    }

    public void updateDrawer() {
        Intent i = new Intent(MainActivity.this, MainActivity.class);
        startActivity(i);
        finish();


//full refresh app code
//        Intent intent = getIntent();
//        finish();
//        startActivity(intent);


        //super.recreate();
    }
}

