package com.example.gudduroy.theflyingfishgameapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity
{
    MediaPlayer mySong3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mySong3 = MediaPlayer.create(SplashActivity.this,R.raw.mysong3);
        mySong3.start();

        Thread thread = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                   sleep(5000);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    Intent mainIntent = new Intent(SplashActivity.this,StartingOfGameActivity.class);
                    startActivity(mainIntent);
                }
            }
        };
        thread.start();
    }
    protected void onPause()
    {
        super.onPause();
        mySong3.release();
        finish();
    }
}
