package com.example.sportcup.activities.hoviat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.sportcup.activities.MainActivity;
import com.example.sportcup.R;


public class Hoviat extends AppCompatActivity {

    private LinearLayout lnr_hoviat , lnr_code;
    private EditText txt_mobile , txt_code;
    private Button btn_sendMobile , btn_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoviat);

        initView();

        btn_sendMobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                lnr_hoviat.setVisibility(View.GONE);
                lnr_code.setVisibility(View.VISIBLE);
            }
        });

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Hoviat.this , MainActivity.class));
                finish();

            }
        });
    }

    private void initView() {
        lnr_hoviat = findViewById(R.id.lnr_hoviat_id);
        lnr_code = findViewById(R.id.lnr_code_id);
        txt_mobile = findViewById(R.id.txt_phone_number_id);
        txt_code = findViewById(R.id.txt_code_id);
        btn_sendMobile = findViewById(R.id.btn_send_code_id);
        btn_confirm = findViewById(R.id.btn_confirm_id);
    }
}
