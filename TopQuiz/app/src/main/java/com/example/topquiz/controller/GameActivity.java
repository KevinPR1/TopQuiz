package com.example.topquiz.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
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
    private int mScore ;
    private int mNumberOfQuestion ;
    public static final String BUNDLE_EXTRA_SCORE = "BUNDLE_EXTRA_SCORE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mQuestionBank = this.generateQuestions();
        mScore = 0 ;

        mNumberOfQuestion = 4;

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
            mScore ++ ;
        } else {
            // Wrong answer
            Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();
        }

        if (-- mNumberOfQuestion == 0) {
            // No question left, end the game
            endGame() ;
        } else {
            mCurrentQuestion = mQuestionBank.getQuestion();
            displayQuestion(mCurrentQuestion);
        }
    }

    private void endGame (){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Braavo!")
                .setMessage("Ton score est de " + mScore + "/4")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent();
                        intent.putExtra(BUNDLE_EXTRA_SCORE, mScore);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                })
                .create()
                .show();

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

        Question question5 = new Question("Qui est le Fondateur de l'akatsuki ?",
                Arrays.asList("Madara",
                        "Minato",
                        "Pain",
                        "Kyubi"),
                2);

        Question question6 = new Question("Qui a invoqué Madara et les 5 Kages pendant la 3ème grande guerre Shinobi ?",
                Arrays.asList("Sakura",
                        "Kabuto",
                        "Tsunade",
                        "Luffy"),
                1);

        Question question7 = new Question("Qui est le rival de Madara?",
                Arrays.asList("Hashirama senju",
                        "Jiraya",
                        "Zoro",
                        "Konoha-Maru Sarutobi"),
                0);

        Question question8 = new Question("L'oeil gauche de Kakashi sensei est à ...?",
                Arrays.asList("Shisui",
                        "Minato",
                        "Gaara",
                        "Tobi(Obito)"),
                3);

        Question question9 = new Question("Quel village a été détruit par Pain?",
                Arrays.asList("Suna",
                        "Konoha",
                        "Kumo",
                        "Kiri"),
                1);


        return new QuestionBank(Arrays.asList(question1,
                question2,
                question3,
                question4,question5, question6,question7,question8,question9 ));



    }





}
