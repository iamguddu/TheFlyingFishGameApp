package com.example.gudduroy.theflyingfishgameapp;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
{
    private FlyingFishView gameView;

    MediaPlayer mysong2;



    private Handler handler = new Handler();
    private final static  long interval =30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mysong2 = MediaPlayer.create(MainActivity.this,R.raw.startmusic);
        mysong2.setLooping(true);
        mysong2.start();

        gameView=new FlyingFishView(this);
        setContentView(gameView);

        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run()
                    {
                        gameView.invalidate();
                    }
                });
            }
        },0,interval);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mysong2.release();
    }
}
