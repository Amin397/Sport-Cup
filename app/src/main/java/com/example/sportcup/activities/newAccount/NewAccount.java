package com.example.sportcup.activities.newAccount;

import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.sportcup.R;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class NewAccount extends AppCompatActivity {

    private AppCompatEditText userName , password , re_password , fullName , nationalCode , phoneNumber;
    private TextInputLayout l_user , l_pass , l_repass , l_fullName , l_nationalCode , l_phoneNumber;
    private Button btn_save , btn_test_userName;
    private AlertDialog.Builder alertDialog;
    private ProgressBar progress_test;
    private ImageView img_test;

    private static final int EXISTED = 1;
    private static final int NOTEXISTED = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_new_account);

        initView();

        fullName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (fullName.getText().toString().length() < 4){
                    l_fullName.setErrorEnabled(true);
                    l_fullName.setError("لطفا بیشتر از 4 حرف وارد کنید");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (fullName.getText().toString().length() > 3){
                    l_fullName.setErrorEnabled(false);
                }

                if (fullName.getText().toString().isEmpty()){
                    l_fullName.setErrorEnabled(false);
                }
            }
        });

        nationalCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (nationalCode.getText().toString().length() < 10){
                    l_nationalCode.setErrorEnabled(true);
                    l_nationalCode.setError("کد ملی باید 10 رقم باشد !");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (nationalCode.getText().toString().length() == 10){
                    l_nationalCode.setErrorEnabled(false);
                }

                if (nationalCode.getText().toString().isEmpty()){
                    l_nationalCode.setErrorEnabled(false);
                }
            }
        });
        l_nationalCode.setCounterEnabled(true);
        l_nationalCode.setCounterMaxLength(10);

        phoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (phoneNumber.getText().toString().length() < 11){
                    l_phoneNumber.setErrorEnabled(true);
                    l_phoneNumber.setError("شماره موبایل وارد شده صحیح نیست !");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (phoneNumber.getText().toString().length() == 11){
                    l_phoneNumber.setErrorEnabled(false);
                }

                if (phoneNumber.getText().toString().isEmpty()){
                    l_phoneNumber.setErrorEnabled(false);
                }
            }
        });
        l_phoneNumber.setCounterEnabled(true);
        l_phoneNumber.setCounterMaxLength(11);

        userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (userName.getText().toString().length() < 6){
                    l_user.setErrorEnabled(true);
                    l_user.setError("نام کاربری باید بیشتر از 6 حرف باشد !");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (userName.getText().toString().length() > 6){
                    l_user.setErrorEnabled(false);
                }

                if (userName.getText().toString().isEmpty()){
                    l_user.setErrorEnabled(false);
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

                if (password.getText().toString().isEmpty()){
                    l_pass.setErrorEnabled(false);
                }
            }
        });

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

                if (re_password.getText().toString().isEmpty()){
                    l_repass.setErrorEnabled(false);
                }
            }
        });

        btn_test_userName.setOnClickListener(testUserNameClickListener);
        btn_save.setOnClickListener(saveClickListener);

    }

    private Button.OnClickListener testUserNameClickListener
             = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            progress_test.setVisibility(View.VISIBLE);

            new CountDownTimer(2000, 1000) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    //اینو هم بذار اگه خالی بود یوزر نیم چیکار کنه
                    if (Existed()){
                        progress_test.setVisibility(View.GONE);
                        img_test.setImageResource(R.drawable.ic_verified_user_black_24dp);
                    }else {
                        progress_test.setVisibility(View.GONE);
                        img_test.setImageResource(R.drawable.ic_error_outline_red_24dp);
                    }
                }
            }.start();
        }
    };

    private boolean Existed() {
        return false;
    }

    private Button.OnClickListener saveClickListener
             = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //اینو هم چک کنه اگه همه مقادیر خالی بود چیکار کنه
            if (l_fullName.isErrorEnabled() || l_nationalCode.isErrorEnabled() || l_phoneNumber.isErrorEnabled()
                    || l_user.isErrorEnabled() || l_pass.isErrorEnabled() || l_repass.isErrorEnabled()){

                alertDialog = new AlertDialog.Builder(NewAccount.this)
                        .setTitle("خطا")
                        .setMessage("لطفا تمامی مقادیر را صحیح وارد کنید !")
                        .setCancelable(true)
                        .setPositiveButton("تایید !", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog builder = alertDialog.create();
                builder.show();
            }else {
                sendReqForCreateAccount();
            }
        }
    };

    private void sendReqForCreateAccount() {
        Toast.makeText(this, "Request", Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        userName = (AppCompatEditText) findViewById(R.id.txt_username_new_acc_id);
        l_user = (TextInputLayout) findViewById(R.id.l_user_id);
        password = (AppCompatEditText) findViewById(R.id.txt_password_new_acc_id);
        l_pass = (TextInputLayout) findViewById(R.id.l_pass_id);
        re_password = (AppCompatEditText) findViewById(R.id.txt_re_password_new_acc_id);
        l_repass = (TextInputLayout) findViewById(R.id.l_repass_id);
        fullName = (AppCompatEditText) findViewById(R.id.txt_fullname_new_acc_id);
        l_fullName = (TextInputLayout) findViewById(R.id.l_fullname_id);
        nationalCode = (AppCompatEditText) findViewById(R.id.txt_national_code_new_acc_id);
        l_nationalCode = (TextInputLayout) findViewById(R.id.l_national_code_id);
        phoneNumber = (AppCompatEditText) findViewById(R.id.txt_phone_new_acc_id);
        l_phoneNumber = (TextInputLayout) findViewById(R.id.l_phone_id);
        btn_save = (Button) findViewById(R.id.btn_save_new_account_id);
        btn_test_userName = (Button) findViewById(R.id.btn_test_user_id);
        progress_test = (ProgressBar) findViewById(R.id.progress_test_username_id);
        img_test = (ImageView) findViewById(R.id.image_test_username_id);
    }
}
