package com.example.gudduroy.theflyingfishgameapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StartingOfGameActivity extends AppCompatActivity {
    private Button StartingGameBtn;
    private EditText highest_score_txtView;
    private String HighestScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_of_game);
        highest_score_txtView=findViewById(R.id.highest_score);



        StartingGameBtn=findViewById(R.id.play_btn);

        StartingGameBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {


                Intent mainIntent = new Intent(StartingOfGameActivity.this,MainActivity.class);
                startActivity(mainIntent);
            }
        });


    }
}
