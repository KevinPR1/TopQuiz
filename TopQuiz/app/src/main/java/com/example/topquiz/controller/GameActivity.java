package com.example.topquiz.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.topquiz.R;
import com.example.topquiz.model.Question;
import com.example.topquiz.model.QuestionBank;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity {

    private TextView mQuestion;
    private Button mPlayB1 ;
    private Button mPlayB2 ;
    private Button mPlayB3 ;
    private Button mPlayB4 ;
    private QuestionBank mQuestionBank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mQuestion = (TextView) findViewById(R.id.activity_game_question_text);
        mPlayB1 = (Button) findViewById(R.id.activity_game_answer1_btn);
        mPlayB2 = (Button) findViewById(R.id.activity_game_answer2_btn);
        mPlayB3 = (Button) findViewById(R.id.activity_game_answer3_btn);
        mPlayB4 = (Button) findViewById(R.id.activity_game_answer4_btn);
        mQuestionBank = this.generateQuestions();


    }



    


    private QuestionBank generateQuestions(){

        Question question1 = new Question("Quel clavier est utilisé en france ?",
                Arrays.asList("Querty",
                        "Azerty",
                        "Fwerty",
                        "Merty"),
                1);

        Question question2 = new Question("Quel animé est attendu pour une saison 3 ?",
                Arrays.asList("One punch Man",
                        "One piece",
                        "Dr Stone",
                        "Radiant"),
                0);

        Question question3 = new Question("Qui est Shisui Uchiwa ?",
                Arrays.asList("L'ami d'itachi",
                        "Le frère de danzo",
                        "le père de madara",
                        "Pain"),
                0);

        return new QuestionBank(Arrays.asList(question1,
                question2,
                question3));



    }





}
