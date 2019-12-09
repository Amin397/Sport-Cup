package com.example.sportcup.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
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
import android.view.View;
import android.widget.Toast;

import com.example.sportcup.R;
import com.example.sportcup.activities.marked_items.MarkedItems;
import com.example.sportcup.activities.my_items.MyItems;
import com.example.sportcup.activities.profile.Profile;
import com.example.sportcup.add_new_item.AddNewItem;
import com.example.sportcup.fragments.AllItems;
import com.example.sportcup.fragments.MostViewed;
import com.example.sportcup.fragments.NearMe;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    BottomNavigationView bottom_nav_left;
    BottomNavigationView bottom_nav_right;
    FloatingActionButton fab_adItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        initView();

        fab_adItem.setOnClickListener(mFabAddItemClickListener);
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

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_id);
        navigationView = (NavigationView) findViewById(R.id.navigation_view_id);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_id);
        bottom_nav_left = (BottomNavigationView) findViewById(R.id.bottom_navigation_left_id);
        bottom_nav_right = (BottomNavigationView) findViewById(R.id.bottom_navigation_right_id);
        fab_adItem = (FloatingActionButton) findViewById(R.id.fab_add_item_id);
    }

    private FloatingActionButton.OnClickListener mFabAddItemClickListener
             = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this , AddNewItem.class));
        }
    };

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

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce){
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "برای خروج دوباره بزنید !", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        } , 2000);



        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private NavigationView.OnNavigationItemSelectedListener mNavigationDrawerItemSelectedListener
             = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.nav_profile_item_id:{
                    startActivity(new Intent(MainActivity.this , Profile.class));
                    break;
                }
                case R.id.nav_my_items_id:{
                    startActivity(new Intent(MainActivity.this , MyItems.class));
                    break;
                }
                case R.id.nav_marked_id:{
                    startActivity(new Intent(MainActivity.this , MarkedItems.class));
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