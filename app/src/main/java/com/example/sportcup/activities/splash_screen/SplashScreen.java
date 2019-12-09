package com.example.sportcup.activities.splash_screen;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sportcup.activities.MainActivity;
import com.example.sportcup.R;
import com.example.sportcup.activities.newAccount.NewAccount;

public class SplashScreen extends AppCompatActivity {

    private TextView txt_splash;
    private ProgressBar loadProgressBar;
    private RelativeLayout rootView , afteranimation;
    private LinearLayout logos;
    private Button btn_login;
    private TextView btn_new_account , btn_forget_pass ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        initView();

        btn_login.setOnClickListener(loginClickListener);
        btn_new_account.setOnClickListener(newAccountClickListener);
        btn_forget_pass.setOnClickListener(forgetPassClickListener);

        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                logos.setVisibility(View.GONE);
                loadProgressBar.setVisibility(View.GONE);
                rootView.setBackgroundColor(ContextCompat.getColor(SplashScreen.this , R.color.colorSplashText));
                txt_splash.setTextColor(Color.parseColor("#DFC42155"));
                txt_splash.setTextSize(60f);
                animation();
            }
        }.start();
    }

    private TextView.OnClickListener forgetPassClickListener
             = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    private TextView.OnClickListener newAccountClickListener
             = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(SplashScreen.this , NewAccount.class));
            finish();
        }
    };

    private Button.OnClickListener loginClickListener
             = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(SplashScreen.this , MainActivity.class));
            finish();
        }
    };

    private void initView() {
        txt_splash = findViewById(R.id.txt_splashname_id);
        loadProgressBar = findViewById(R.id.loadingProgressBar);
        logos = findViewById(R.id.logos);
        rootView = findViewById(R.id.rootview_id);
        afteranimation = findViewById(R.id.afterAnimationView);
        btn_login = findViewById(R.id.btn_login_id);
        btn_new_account = findViewById(R.id.btn_new_account_id);
        btn_forget_pass = findViewById(R.id.btn_forget_pass_id);
    }

    private void animation() {
        ViewPropertyAnimator viewPropertyAnimator = txt_splash.animate();
        viewPropertyAnimator.y(100f);
        viewPropertyAnimator.setDuration(1000);
        viewPropertyAnimator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                afteranimation.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
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
