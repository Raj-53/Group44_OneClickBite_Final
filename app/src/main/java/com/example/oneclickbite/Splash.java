package com.example.oneclickbite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    TextView txt1, txt2, txt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);

        Animation anim1 = AnimationUtils.loadAnimation(Splash.this, R.anim.fade_in);
        txt1.startAnimation(anim1);
        txt2.startAnimation(anim1);
        txt3.startAnimation(anim1);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent iHome = new Intent(Splash.this, MainActivity.class);
                startActivity(iHome);
                finish();
            }
        }, 3000);


    }
}