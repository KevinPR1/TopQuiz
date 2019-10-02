package com.example.topquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private TextView mQuestion;
    private Button mPlayB1 ;
    private Button mPlayB2 ;
    private Button mPlayB3 ;
    private Button mPlayB4 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mQuestion = (TextView) findViewById(R.id.activity_game_question_text);
        mPlayB1 = (Button) findViewById(R.id.activity_game_answer1_btn);
        mPlayB2 = (Button) findViewById(R.id.activity_game_answer2_btn);
        mPlayB3 = (Button) findViewById(R.id.activity_game_answer3_btn);
        mPlayB4 = (Button) findViewById(R.id.activity_game_answer4_btn);

    }
}
