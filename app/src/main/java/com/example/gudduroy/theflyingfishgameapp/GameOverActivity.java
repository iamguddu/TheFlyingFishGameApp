package com.example.gudduroy.theflyingfishgameapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameOverActivity extends AppCompatActivity {
    private Button StartGameAgain,Exit;
    private TextView DisplayScore,DisplayHighestScore;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        DisplayScore=findViewById(R.id.displayScore);
        DisplayHighestScore=findViewById(R.id.highest_score);


        score=getIntent().getIntExtra("score",score);
        DisplayScore.setText("Your Score : "+score);

        SharedPreferences setting = getSharedPreferences("GAME_DATA",Context.MODE_PRIVATE);
        int highScore =setting.getInt("HIGH_SCORE",0);

        if(score > highScore)
        {
            DisplayHighestScore.setText("High Score :" +score);

            SharedPreferences.Editor editor =setting.edit();
            editor.putInt("HIGH_SCORE",score);
            editor.commit();
        }else{
            DisplayHighestScore.setText("High Score : "+highScore );
        }



        Exit=findViewById(R.id.exit_btn);
        StartGameAgain=findViewById(R.id.play_again_btn);
        StartGameAgain.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent mainIntent = new Intent(GameOverActivity.this,MainActivity.class);
                startActivity(mainIntent);
            }
        });
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(GameOverActivity.this,StartingOfGameActivity.class);
                startActivity(mainIntent);
            }
        });




    }
}
