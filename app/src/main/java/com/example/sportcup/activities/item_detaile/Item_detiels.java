package com.example.sportcup.activities.item_detaile;

import android.os.Bundle;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.sportcup.R;

public class Item_detiels extends AppCompatActivity {

    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton fab_location;
    FloatingActionButton fab_mark;
    TextView txt_vizhegiha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detiels);

        initView();

        toolbar.setTitle(getIntent().getStringExtra("name"));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collapsingToolbarLayout.setBackgroundResource(getIntent().getIntExtra("image" , 0));

        fab_location.setOnClickListener(mLocationOnClickListener);
        fab_mark.setOnClickListener(mMarkOnClickListener);

        txt_vizhegiha.setOnClickListener(mVizhegihaClickListener);
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_item_detailes_id);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collaps_toolbar_items_id);
        fab_location = (FloatingActionButton) findViewById(R.id.fab_location_id);
        fab_mark = (FloatingActionButton) findViewById(R.id.fab_mark_item_id);
        txt_vizhegiha = (TextView) findViewById(R.id.txt_vizhegiha_id);
    }

    private TextView.OnClickListener mVizhegihaClickListener
             = new View.OnClickListener() {
        private boolean flag = false;
        @Override
        public void onClick(View view) {
            if (!flag){
                txt_vizhegiha.setMaxLines(10);
                flag = true;
            }else {
                txt_vizhegiha.setMaxLines(2);
                flag = false;
            }
        }
    };

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
