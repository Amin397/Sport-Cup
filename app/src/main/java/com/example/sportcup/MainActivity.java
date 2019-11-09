package com.example.sportcup;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
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

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        toolbar = (Toolbar) findViewById(R.id.toolbar_id);
        navigationView = (NavigationView) findViewById(R.id.navigation_view_id);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_id);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this , drawerLayout , toolbar , 0 , 0);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }

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


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_item1_id:{
                Toast.makeText(this, "item1", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.nav_item2_id:{
                Toast.makeText(this, "item2", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.nav_item3_id:{
                Toast.makeText(this, "item3", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.nav_item4_id:{
                Toast.makeText(this, "item4", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.nav_item5_id:{
                Toast.makeText(this, "item5", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.nav_item6_id:{
                Toast.makeText(this, "item6", Toast.LENGTH_SHORT).show();
                break;
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
