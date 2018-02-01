package com.csci448.gbejaran.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by bajafresh12 on 1/26/18.
 */

public class CheatActivity extends AppCompatActivity {

    private TextView mAnswerView;
    private Button mShowAnswerButton;
    private static final String EXTRA_ANSWER_IS_TRUE =
            "com.csci448.gbejaran.geoquiz.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN =
            "com.csci448.gbejaran.geoquiz.answer_shown";
    private boolean mAnswerIsTrue;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerView = (TextView) findViewById(R.id.answer_text_view);
        mShowAnswerButton = (Button) findViewById(R.id.show_answer_button);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAnswerIsTrue) {
                    mAnswerView.setText(R.string.true_button);
                } else {
                    mAnswerView.setText(R.string.false_button);
                }
                setAnswerShownResult(true);
            }
        });

    }

    public static Intent newIntent(Context packageContext, boolean answerIsTrue) {
        Intent intent = new Intent(packageContext, CheatActivity.class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return intent;
    }

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    public static boolean wasAnswerShown(Intent result) {
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
    }

}

