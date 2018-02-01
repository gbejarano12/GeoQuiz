package com.csci448.gbejaran.geoquiz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.Gravity.TOP;
import static android.widget.Toast.*;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mCheatButton;
    private TextView mQuestionView;
    private int questionNum = 0;
    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";
    private static final int REQUEST_CODE_CHEAT = 0;
    private boolean mIsCheater;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, questionNum);
    }

    private Question questions[] = new Question[] {
            new Question(R.string.question_strikes, true),
            new Question(R.string.question_zone, false),
            new Question(R.string.question_foul, false),
            new Question(R.string.question_bock, true),
            new Question(R.string.question_jackie, true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        if (savedInstanceState != null) {
            questionNum = savedInstanceState.getInt(KEY_INDEX, 0);
        }

        mQuestionView = (TextView) findViewById(R.id.question_view);
        mQuestionView.setText(questions[questionNum].getTextResId());


        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast;
                if (mIsCheater) {
                    toast = Toast.makeText(QuizActivity.this,
                            "You Cheated!", LENGTH_SHORT);
                } else {
                    if (questions[questionNum].getAnswerTrue() == true) {
                        toast = Toast.makeText(QuizActivity.this,
                                R.string.correct_toast,
                                LENGTH_SHORT);
                    } else {
                        toast = Toast.makeText(QuizActivity.this,
                                R.string.incorrect_toast,
                                LENGTH_SHORT);
                    }
                }
                toast.setGravity(Gravity.TOP, 10, 180);
                toast.show();
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast;
                if (mIsCheater) {
                    toast = Toast.makeText(QuizActivity.this,
                            "You Cheated!", LENGTH_SHORT);
                } else {
                    if (questions[questionNum].getAnswerTrue() == false) {
                        toast = Toast.makeText(QuizActivity.this,
                                R.string.correct_toast,
                                LENGTH_SHORT);
                    } else {
                        toast = Toast.makeText(QuizActivity.this,
                                R.string.incorrect_toast,
                                LENGTH_SHORT);
                    }
                }
                toast.setGravity(Gravity.TOP, 10, 180);
                toast.show();
            }
        });

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionNum++;
                mIsCheater = false;
                mQuestionView.setText(questions[questionNum].getTextResId());
            }
        });

        mCheatButton = (Button) findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean answerIsTrue = questions[questionNum].getAnswerTrue();
                Intent intent = CheatActivity.newIntent(QuizActivity.this,
                        answerIsTrue);
                startActivityForResult(intent, REQUEST_CODE_CHEAT);
            }
        });

        mQuestionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionNum++;
                mQuestionView.setText(questions[questionNum].getTextResId());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == REQUEST_CODE_CHEAT) {
            if (data == null){
                return;
            }
            mIsCheater = CheatActivity.wasAnswerShown(data);
        }
    }

}