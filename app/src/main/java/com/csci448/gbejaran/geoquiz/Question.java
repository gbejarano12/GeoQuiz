package com.csci448.gbejaran.geoquiz;

/**
 * Created by bajafresh12 on 1/19/18.
 */

public class Question {
    int mTextResId;
    boolean mAnswerTrue;

    Question(int qNum, boolean ans){
        mTextResId = qNum;
        mAnswerTrue = ans;
    }

    boolean getAnswerTrue() {
        return mAnswerTrue;
    }

    int getTextResId() {
        return mTextResId;
    }

    void setAnswerTrue(boolean ans) {
        mAnswerTrue = ans;
    }

    void setTextResId(int qNum) {
        mTextResId = qNum;
    }
}
