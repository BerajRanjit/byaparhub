package com.byaparhub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;

    Animation topanim, bottomAnim;
    ImageView image;
    TextView logo, slogon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TextView textView = findViewById(R.id.splash_tag);
        String text = "Track your Business";
        SpannableString ss = new SpannableString(text);
        ForegroundColorSpan fcsOrange = new ForegroundColorSpan(Color.rgb(255,110,0));

        ss.setSpan(fcsOrange, 11, 19, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(ss);

        topanim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        image = findViewById(R.id.splash_logo);
        logo = findViewById(R.id.splash_name);
        slogon = findViewById(R.id.splash_tag);

        image.setAnimation(topanim);
        logo.setAnimation(bottomAnim);
        slogon.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);


    }
}