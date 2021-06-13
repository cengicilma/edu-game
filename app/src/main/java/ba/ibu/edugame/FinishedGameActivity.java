package ba.ibu.edugame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FinishedGameActivity extends AppCompatActivity {

    public static final String RESULTS = "edugame.RESULTS";

    private double result;
    private String difficulty;
    private int numberOfCorrectAnswers;
    private String gameTimeInSeconds;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //Hide action bar on top
        setContentView(R.layout.activity_finished_game);

        Intent intent = getIntent();
        int questionsAsked = intent.getIntExtra(MainGameScreenActivity.QUESTIONS_ASKED, 0);
        numberOfCorrectAnswers = intent.getIntExtra(MainGameScreenActivity.CORRECT_ANSWERS, 0);
        int wrongAnswers = intent.getIntExtra(MainGameScreenActivity.WRONG_ANSWERS, 0);
        difficulty = intent.getStringExtra(MainGameScreenActivity.difficulty);
        gameTimeInSeconds = intent.getStringExtra(MainGameScreenActivity.gameTimeInSeconds);

        //Set results
        TextView txtQuestionsAsked = findViewById(R.id.txtQuestionsAsked);
        txtQuestionsAsked.setText("Total questions asked: " + String.valueOf(questionsAsked));

        TextView txtCorrectAnswers = findViewById(R.id.txtCorrectAnswers);
        txtCorrectAnswers.setText("Correct answers: " + String.valueOf(numberOfCorrectAnswers));

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

    public void calculateResult() {
        //numberOfCorrectAnswers * difficulty / time
        //easy = 1, medium = 2, hard = 3; 30sec = 1, 60 sec = 2, 120 sec  = 4
        int timer = Integer.parseInt(gameTimeInSeconds);
        if(timer == 30) {
            if(difficulty.equals("EASY")) {
                result = numberOfCorrectAnswers * 1 / timer;
            }
            else if(difficulty.equals("MEDIUM")) {
                result = numberOfCorrectAnswers * 2 / timer;
            }
            else {
                result = numberOfCorrectAnswers * 3 / timer;
            }
        }
        else if(timer == 60) {
            if(difficulty.equals("EASY")) {
                result = numberOfCorrectAnswers * 1 / timer;
            }
            else if(difficulty.equals("MEDIUM")) {
                result = numberOfCorrectAnswers * 2 / timer;
            }
            else {
                result = numberOfCorrectAnswers * 3 / timer;
            }
        }
        else if(timer == 120) {
            if(difficulty.equals("EASY")) {
                result = numberOfCorrectAnswers * 1 / timer;
            }
            else if(difficulty.equals("MEDIUM")) {
                result = numberOfCorrectAnswers * 2 / timer;
            }
            else {
                result = numberOfCorrectAnswers * 3 / timer;
            }
        }
    }

}