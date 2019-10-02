package com.example.topquiz.model;

import java.util.Collections;
import java.util.List;

/**
 * Created by Kevin  - Openclassrooms on 02/10/2019
 */
public class QuestionBank {

    private List<Question> mQuestionList;
    private int mNextQuestionIndex;

    public QuestionBank(List<Question> questionList) {
        mQuestionList = questionList;

        // Shuffle the question list before storing it
        Collections.shuffle(mQuestionList);
    }

    public Question getQuestion() {
        if (mNextQuestionIndex == mQuestionList.size()) {
            mNextQuestionIndex = 0;
        }

        // Loop over the questions and return a new one at each call
        return mQuestionList.get(mNextQuestionIndex++);
    }


}
