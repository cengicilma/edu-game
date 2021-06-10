package ba.ibu.edugame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FinishedGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //Hide action bar on top
        setContentView(R.layout.activity_finished_game);

        Intent intent = getIntent();
        int questionsAsked = intent.getIntExtra(MainGameScreen.QUESTIONS_ASKED, 0);
        int correctAnswers = intent.getIntExtra(MainGameScreen.CORRECT_ANSWERS, 0);
        int wrongAnswers = intent.getIntExtra(MainGameScreen.WRONG_ANSWERS, 0);

        //Set results
        TextView txtQuestionsAsked = findViewById(R.id.txtQuestionsAsked);
        txtQuestionsAsked.setText(String.valueOf(questionsAsked));

        TextView txtCorrectAnswers = findViewById(R.id.txtCorrectAnswers);
        txtCorrectAnswers.setText(String.valueOf(correctAnswers));

        TextView txtWrongAnswers = findViewById(R.id.txtWrongAnswers);
        txtWrongAnswers.setText(String.valueOf(wrongAnswers));
    }
}