package com.example.sportcup.activities;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.sportcup.R;

public class Item_detiels extends AppCompatActivity {

    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton fab_location;
    FloatingActionButton fab_mark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detiels);

        toolbar = (Toolbar) findViewById(R.id.toolbar_item_detailes_id);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collaps_toolbar_items_id);
        fab_location = (FloatingActionButton) findViewById(R.id.fab_location_id);
        fab_mark = (FloatingActionButton) findViewById(R.id.fab_mark_item_id);

        toolbar.setTitle(getIntent().getStringExtra("name"));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int imagepath = getIntent().getIntExtra("image" , 0);

        collapsingToolbarLayout.setBackgroundResource(imagepath);


        fab_location.setOnClickListener(mLocationOnClickListener);
        fab_mark.setOnClickListener(mMarkOnClickListener);
    }

    private FloatingActionButton.OnClickListener mLocationOnClickListener
             = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Snackbar.make(view, "نقشه و موقعیت سالن ورزشی !", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    };

    private FloatingActionButton.OnClickListener mMarkOnClickListener
             = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Snackbar.make(view, "آیتم نشان شد !", Snackbar.LENGTH_LONG)
                    .setAction("لغو", null).show();
        }
    };
}
