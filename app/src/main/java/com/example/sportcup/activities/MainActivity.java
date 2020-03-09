package com.example.sportcup.activities;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.sportcup.R;
import com.example.sportcup.fragments.AllItems;
import com.example.sportcup.fragments.MostViewed;
import com.example.sportcup.fragments.NearMe;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private BottomNavigationView bottom_nav;

    private AllItems allItems_fragments;
    private MostViewed mostViewed_fragments;
    private NearMe nearMe_fragments;
    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        allItems_fragments = new AllItems();
        mostViewed_fragments = new MostViewed();
        nearMe_fragments = new NearMe();
        window = this.getWindow();

        bottom_nav.setOnNavigationItemSelectedListener(mSelectetItemListener);
        bottom_nav.setSelectedItemId(R.id.bottom_allitems_id);





        Window window = MainActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mSelectetItemListener
             = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.bottom_allitems_id:{
                    bottom_nav.setItemBackgroundResource(R.color.color_all_items);
                    window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.color_all_items));
                    setFragments(allItems_fragments);
                    return true;
                }
                case R.id.bottom_mostview_id:{
                    bottom_nav.setItemBackgroundResource(R.color.color_most_view);
                    window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.color_most_view));
                    setFragments(mostViewed_fragments);
                    return true;
                }
                case R.id.bottom_nearme_id:{
                    bottom_nav.setItemBackgroundResource(R.color.color_near_me);
                    window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.color_near_me));
                    setFragments(nearMe_fragments);
                    return true;
                }
                default:{
                    return false;
                }
            }
        }
    };

    private void setFragments(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_id , fragment);
        fragmentTransaction.commit();
    }

    private void initView() {
        frameLayout = findViewById(R.id.frame_layout_id);
        bottom_nav = findViewById(R.id.bottom_nav_id);
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
    }
}