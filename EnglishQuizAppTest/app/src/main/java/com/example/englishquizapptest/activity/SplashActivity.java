package com.example.englishquizapptest.activity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.englishquizapptest.R;

public class SplashActivity extends AppCompatActivity {

    private ImageView imageView;
    private Animation animation;
    private ProgressBar progressBar;
    private ConstraintLayout layout;

    private static final int SPLASH_DURATION = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        layout = (ConstraintLayout) findViewById(R.id.splashLayout);
        imageView = (ImageView) findViewById(R.id.ivSplashIcon);
        animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotate);
    }

    private void initFunctionality() {
        layout.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
                imageView.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        com.example.englishquizapptest.activity.utilities.ActivityUtilities.getInstance().invokeNewActivity(SplashActivity.this, MainActivity.class, true);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        }, SPLASH_DURATION);
    }

    protected void onResume() {
        super.onResume();
        initFunctionality();
    }
}