package ba.ibu.edugame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FinishedGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //Hide action bar on top
        setContentView(R.layout.activity_finished_game);

        Intent intent = getIntent();
        int questionsAsked = intent.getIntExtra(MainGameScreenActivity.QUESTIONS_ASKED, 0);
        int correctAnswers = intent.getIntExtra(MainGameScreenActivity.CORRECT_ANSWERS, 0);
        int wrongAnswers = intent.getIntExtra(MainGameScreenActivity.WRONG_ANSWERS, 0);

        //Set results
        TextView txtQuestionsAsked = findViewById(R.id.txtQuestionsAsked);
        txtQuestionsAsked.setText("Total questions asked: " + String.valueOf(questionsAsked));

        TextView txtCorrectAnswers = findViewById(R.id.txtCorrectAnswers);
        txtCorrectAnswers.setText("Correct answers: " + String.valueOf(correctAnswers));

        TextView txtWrongAnswers = findViewById(R.id.txtWrongAnswers);
        txtWrongAnswers.setText("Wrong answers: " + String.valueOf(wrongAnswers));
    }

    public void openNewGame(View view) {
        Intent intent = new Intent(this, GameDifficultyActivity.class);
        startActivity(intent);
    }

    public void openHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void exitGame(View view) {
        finish();
        System.exit(0);
    }
}