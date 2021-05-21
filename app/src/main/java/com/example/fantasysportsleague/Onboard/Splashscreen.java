package com.example.fantasysportsleague.Onboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.example.fantasysportsleague.Profile_maker;
import com.example.fantasysportsleague.R;

public class Splashscreen extends AppCompatActivity {
    private static int SPLASH_SCREEN_TIME_OUT=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);




        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (isFirstRun) {
                    //show start activity
                    Intent i=new Intent(Splashscreen.this,
                            OnBoardActivity.class);
                    //Intent is used to switch from one activity to another.

                    finish();
                    //the current activity will get finished.
                    startActivity(i);
                }
                else {

                    Intent i=new Intent(Splashscreen.this,
                            Profile_maker.class);
                    //Intent is used to switch from one activity to another.

                    finish();
                    //the current activity will get finished.
                    startActivity(i);

                }

                getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                        .putBoolean("isFirstRun", true).commit();


            }
        }, SPLASH_SCREEN_TIME_OUT);
    }
}