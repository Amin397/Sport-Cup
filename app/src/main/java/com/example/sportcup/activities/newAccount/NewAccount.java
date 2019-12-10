package com.example.sportcup.activities.newAccount;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.Toast;

import com.example.sportcup.R;

public class NewAccount extends AppCompatActivity {

    private AppCompatEditText username , password , re_password;
    private TextInputLayout l_user , l_pass , l_repass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_new_account);

        initView();

        re_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!password.getText().toString().equals(re_password.getText().toString())){
                    l_repass.setErrorEnabled(true);
                    l_repass.setError("رمز عبور یکسان نیست !");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (password.getText().toString().equals(re_password.getText().toString())){
                    l_repass.setErrorEnabled(false);
                }
            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (password.getText().toString().length() <= 5){
                    l_pass.setErrorEnabled(true);
                    l_pass.setError("رمز عبور باید بیشتر از 5 حرف باشد !");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (password.getText().toString().length() > 5){
                    l_pass.setErrorEnabled(false);
                }
            }
        });

    }

    private void initView() {
        username = (AppCompatEditText) findViewById(R.id.txt_username_new_acc_id);
        l_user = (TextInputLayout) findViewById(R.id.l_user_id);
        password = (AppCompatEditText) findViewById(R.id.txt_password_new_acc_id);
        l_pass = (TextInputLayout) findViewById(R.id.l_pass_id);
        re_password = (AppCompatEditText) findViewById(R.id.txt_re_password_new_acc_id);
        l_repass = (TextInputLayout) findViewById(R.id.l_repass_id);
    }
}
