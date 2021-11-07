package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.os.Bundle;

public class PromptActivity extends AppCompatActivity {

    public static final String KEY_EXTRA_ANSWER_SHOW = "answerShow";
    public static final String KEY_EXTRA_BACK = "";

    private boolean correctAnswer;
    private Button showCorrectAnsewrButton;
    private Button backButton;
    private TextView answerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prompt);
        correctAnswer = getIntent().getBooleanExtra(MainActivity.KEY_EXTRA_ANSWER, true);

        answerTextView = findViewById(R.id.answer_text_view);
        showCorrectAnsewrButton = findViewById(R.id.answer_button);

        showCorrectAnsewrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int answer = correctAnswer ? R.string.button_true : R.string.button_false;
                answerTextView.setText(answer);
                setAnswerShowResult(true);
            }

            private void setAnswerShowResult(boolean answerShowReult) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra(KEY_EXTRA_ANSWER_SHOW, answerShowReult);
                setResult(RESULT_OK, resultIntent);
            }
        });
    }
}