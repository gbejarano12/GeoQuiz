package com.csci448.gbejaran.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    private TextView mQuestionView;
    private int questionNum = 0;

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



        mQuestionView = (TextView) findViewById(R.id.question_view);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast;
                if (questions[questionNum].getAnswerTrue() == true) {
                    toast = Toast.makeText(QuizActivity.this,
                            R.string.correct_toast,
                            LENGTH_SHORT);
                }
                else {
                    toast = Toast.makeText(QuizActivity.this,
                            R.string.incorrect_toast,
                            LENGTH_SHORT);
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
                if (questions[questionNum].getAnswerTrue() == false) {
                    toast = Toast.makeText(QuizActivity.this,
                            R.string.correct_toast,
                            LENGTH_SHORT);
                }
                else {
                    toast = Toast.makeText(QuizActivity.this,
                            R.string.incorrect_toast,
                            LENGTH_SHORT);
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
                mQuestionView.setText(questions[questionNum].getTextResId());
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
}
