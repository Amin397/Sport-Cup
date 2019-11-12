package com.example.sportcup;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.sportcup.fragments.AllItems;
import com.example.sportcup.fragments.MostViewed;
import com.example.sportcup.fragments.NearMe;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    BottomNavigationView bottom_nav_left;
    BottomNavigationView bottom_nav_right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        toolbar = (Toolbar) findViewById(R.id.toolbar_id);
        navigationView = (NavigationView) findViewById(R.id.navigation_view_id);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_id);
        bottom_nav_left = (BottomNavigationView) findViewById(R.id.bottom_navigation_left_id);
        bottom_nav_right = (BottomNavigationView) findViewById(R.id.bottom_navigation_right_id);

        bottom_nav_left.setOnNavigationItemSelectedListener(mLeftOnNavigationItemsSelectedListener);
        bottom_nav_left.setSelectedItemId(R.id.nav_allitems_id);
        bottom_nav_right.setOnNavigationItemSelectedListener(mRightOnNavigationItemSelectedListener);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this , drawerLayout , toolbar , 0 , 0);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(mNavigationDrawerItemSelectedListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mRightOnNavigationItemSelectedListener
             = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment;
            switch (menuItem.getItemId()){
                case R.id.nav_nearme_id:{
                    fragment = new NearMe();
                    loadFragment(fragment);
                    return true;
                }
            }
            return false;
        }
    };

    private BottomNavigationView.OnNavigationItemSelectedListener mLeftOnNavigationItemsSelectedListener
             = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment;
            switch (menuItem.getItemId()){
                case R.id.nav_mostviewed_id:{
                    fragment = new MostViewed();
                    loadFragment(fragment);
                    return true;
                }
                case R.id.nav_allitems_id:{
                    fragment = new AllItems();
                    loadFragment(fragment);
                    return true;
                }
            }
            return false;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_item1_id:{
                Toast.makeText(this, "item1", Toast.LENGTH_SHORT).show();
                break;
            }
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_id);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private NavigationView.OnNavigationItemSelectedListener mNavigationDrawerItemSelectedListener
             = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.nav_item1_id:{
                    Toast.makeText(MainActivity.this, "item1", Toast.LENGTH_SHORT).show();
                    break;
                }
                case R.id.nav_item2_id:{
                    Toast.makeText(MainActivity.this, "item2", Toast.LENGTH_SHORT).show();
                    break;
                }
                case R.id.nav_item3_id:{
                    Toast.makeText(MainActivity.this, "item3", Toast.LENGTH_SHORT).show();
                    break;
                }
                case R.id.nav_item4_id:{
                    Toast.makeText(MainActivity.this, "item4", Toast.LENGTH_SHORT).show();
                    break;
                }
                case R.id.nav_item5_id:{
                    Toast.makeText(MainActivity.this, "item5", Toast.LENGTH_SHORT).show();
                    break;
                }
                case R.id.nav_item6_id:{
                    Toast.makeText(MainActivity.this, "item6", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }
    };
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container_main_id , fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}