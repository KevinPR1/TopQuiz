package com.example.topquiz.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.topquiz.R;
import com.example.topquiz.model.Question;
import com.example.topquiz.model.QuestionBank;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mQuestion;
    private Button mPlayB1 ;
    private Button mPlayB2 ;
    private Button mPlayB3 ;
    private Button mPlayB4 ;
    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mQuestionBank = this.generateQuestions();

        mQuestion = (TextView) findViewById(R.id.activity_game_question_text);
        mPlayB1 = (Button) findViewById(R.id.activity_game_answer1_btn);
        mPlayB2 = (Button) findViewById(R.id.activity_game_answer2_btn);
        mPlayB3 = (Button) findViewById(R.id.activity_game_answer3_btn);
        mPlayB4 = (Button) findViewById(R.id.activity_game_answer4_btn);
        mQuestionBank = this.generateQuestions();

// Use the tag property to 'name' the buttons

        mPlayB1.setTag(0);
        mPlayB2.setTag(1);
        mPlayB3.setTag(2);
        mPlayB4.setTag(3);

        mCurrentQuestion = mQuestionBank.getQuestion();
        this.displayQuestion(mCurrentQuestion);


        // Use the same listener for the four buttons.
// The tag value will be used to distinguish the button triggered
        mPlayB1.setOnClickListener(this);
        mPlayB2.setOnClickListener(this);
        mPlayB3.setOnClickListener(this);
        mPlayB4.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        int responseIndex = (int) v.getTag();

        if (responseIndex == mCurrentQuestion.getAnswerIndex()) {

            // Good answer

            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();

            

        } else {

            // Wrong answer

            Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();

        }

    }

    private void displayQuestion(final Question question) {
        // Set the text for the question text view and the four buttons
        mQuestion.setText(question.getQuestion());
        mPlayB1.setText(question.getChoiceList().get(0));
        mPlayB2.setText(question.getChoiceList().get(1));
        mPlayB3.setText(question.getChoiceList().get(2));
        mPlayB4.setText(question.getChoiceList().get(3));
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

        Question question4 = new Question("Qui est Madara ?",
                Arrays.asList("Le grand frère de Sasuke Uchiwa",
                        "Un Hokage",
                        "Le fondateur du clan Uchiwa",
                        "Le fondateur de l'akatsuki"),
                2);

        return new QuestionBank(Arrays.asList(question1,
                question2,
                question3,question4));



    }





}
