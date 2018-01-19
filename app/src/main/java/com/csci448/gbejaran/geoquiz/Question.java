package com.csci448.gbejaran.geoquiz;

/**
 * Created by bajafresh12 on 1/19/18.
 */

public class Question {
    int mTextResId;
    boolean mAnswerTrue;

    void Question(int qNum, boolean ans){
        mTextResId = qNum;
        mAnswerTrue = ans;
    }

    boolean getAnswerTrue() {
        return true;
    }

    int getTextResId() {
        return 0;
    }

    void setAnswerTrue(boolean ans) {

    }

    void setTextResId(int qNum) {

    }
}
