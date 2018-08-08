package com.example.syamiyer.infs3634_quizapp.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.syamiyer.infs3634_quizapp.Model.Question;
import com.example.syamiyer.infs3634_quizapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView question;
    private TextView feedback;
    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private Button prevButton;

    ArrayList<Question> questions = new ArrayList<>();
    int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question = findViewById(R.id.question);
        feedback = findViewById(R.id.feedback);
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);
        prevButton = findViewById(R.id.prevButton);
        nextButton = findViewById(R.id.nextButton);

        questions.add(0, new Question(getResources().getString(R.string.q1), true));
        questions.add(1, new Question(getResources().getString(R.string.q2), false));
        questions.add(2, new Question(getResources().getString(R.string.q3), false));
        questions.add(3, new Question(getResources().getString(R.string.q4), true));
        questions.add(4, new Question(getResources().getString(R.string.q5), false));

        question.setText(questions.get(0).getmTextResId());

    }

    public void clickedTrue(View view) {
        checkAnswer(true);
    }

    public void clickedFalse(View view) {
        checkAnswer(false);
    }

    public void clickedPrev(View view) {
        feedback.setVisibility(View.INVISIBLE);
        if (currentIndex == 0) {
            currentIndex = questions.size()-1;
        } else {
            currentIndex--;
        }

        question.setText(questions.get(currentIndex).getmTextResId());
    }

    public void clickedNext(View view) {
        feedback.setVisibility(View.INVISIBLE);
        nextQuestion();

    }

    public boolean checkAnswer(boolean answer) {

        if (answer == questions.get(currentIndex).getmAnswerTrue()) {
            //change text to true then go to next
            feedback.setVisibility(View.VISIBLE);
            feedback.setText("CORRECT");

            return true;
        }
        else {
            //change text to false then go to next
            feedback.setVisibility(View.VISIBLE);
            feedback.setText("INCORRECT");

            return false;
        }

    }

    public void nextQuestion() {
        if (currentIndex == questions.size()-1) {
            currentIndex = 0;
        }
        else {
            currentIndex++;
        }

        question.setText(questions.get(currentIndex).getmTextResId());
    }

}
