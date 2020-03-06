package com.example.sportcup.activities.newAccount;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.sportcup.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Hashtable;
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
            if(userName.getText().toString().isEmpty() || l_user.isErrorEnabled()){
                Toast.makeText(NewAccount.this, "مقدار ورودی صحیح نیست !", Toast.LENGTH_SHORT).show();
            }else {
                progress_test.setVisibility(View.VISIBLE);

                new CountDownTimer(2000, 1000) {
                    @Override
                    public void onTick(long l) {
                    }

                    @Override
                    public void onFinish() {
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
        }
    };

    private boolean Existed() {
        return false;
    }

    private Button.OnClickListener saveClickListener
             = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            sendReqForCreateAccount();


            /*if (fullName.getText().toString().isEmpty() || nationalCode.getText().toString().isEmpty() || phoneNumber.getText().toString().isEmpty()
            || userName.getText().toString().isEmpty() || password.getText().toString().isEmpty() || re_password.getText().toString().isEmpty()){

                alertDialog = new AlertDialog.Builder(NewAccount.this)
                        .setTitle("خطا")
                        .setMessage("لطفا تمامی مقادیر را وار کنید !")
                        .setCancelable(true)
                        .setPositiveButton("تایید !", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog builder = alertDialog.create();
                builder.show();
            }*/

            /*if (l_fullName.isErrorEnabled() || l_nationalCode.isErrorEnabled() || l_phoneNumber.isErrorEnabled()
                    || l_user.isErrorEnabled() || l_pass.isErrorEnabled() || l_repass.isErrorEnabled() || Existed()){

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
            }*/
        }
    };

    private void sendReqForCreateAccount() {
        RequestQueue queue = Volley.newRequestQueue(NewAccount.this);
        String URL = "http://al1.best:88/api/signup/";
        Hashtable<String , String> params = new Hashtable<>();
        params.put("username" , userName.getText().toString());
        params.put("password" , password.getText().toString());

        final ProgressDialog dialog ;
        dialog = new ProgressDialog(NewAccount.this);
        dialog.setMessage("لطفا صبر کنید ..");
        dialog.setCancelable(false);
        dialog.show();

        JSONObject object = new JSONObject(params);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, URL, object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                dialog.dismiss();

                try {
                    String token = response.getString("token");
                    SharedPreferences.Editor editor = getSharedPreferences("token" , Context.MODE_PRIVATE).edit();
                    editor.putString("token" ,token);
                    editor.apply();

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Toast.makeText(NewAccount.this, response.toString(), Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dialog.dismiss();
                Toast.makeText(NewAccount.this, error.toString(), Toast.LENGTH_LONG).show();
            }
        });
        queue.add(request);
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
