package ba.ibu.edugame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import ba.ibu.edugame.db.AppDatabase;
import ba.ibu.edugame.db.Results;
import ba.ibu.edugame.db.ResultsDao;

public class FinishedGameActivity extends AppCompatActivity {

    public static final String RESULTS = "edugame.RESULTS";
    public static final String USER_ID = "edugame.USER_ID";
    public static final String GAME_TIME = "edugame.GAME_TIME";
    public static final String DIFFICULTY = "edugame.DIFFICULTY";

    private static String user_id;

    private double result = 0.0;
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
        difficulty = intent.getStringExtra(MainGameScreenActivity.DIFFICULTY);
        gameTimeInSeconds = intent.getStringExtra(MainGameScreenActivity.GAME_TIME);
        user_id = intent.getStringExtra(MainGameScreenActivity.USER_ID);

        //Set results
        TextView txtQuestionsAsked = findViewById(R.id.txtQuestionsAsked);
        txtQuestionsAsked.setText("Total questions asked: " + String.valueOf(questionsAsked));

        TextView txtCorrectAnswers = findViewById(R.id.txtCorrectAnswers);
        txtCorrectAnswers.setText("Correct answers: " + String.valueOf(numberOfCorrectAnswers));

        TextView txtWrongAnswers = findViewById(R.id.txtWrongAnswers);
        txtWrongAnswers.setText("Wrong answers: " + String.valueOf(wrongAnswers));

        result = calculateResult();

        TextView txtResults = findViewById(R.id.txtResults);
        txtResults.setText("Result: " + String.valueOf(result));

        AppDatabase appDatabase = AppDatabase.getDatabase(this.getApplicationContext());
        ResultsDao resultsDao = appDatabase.resultsDao();
        Results results = new Results(Integer.parseInt(user_id), result);
        resultsDao.insertResult(results);
    }

    public void openNewGame(View view) {
        Intent intent = new Intent(this, GameDifficultyActivity.class);
        //intent.putExtra(USER_ID, user_id);
        startActivity(intent);
    }

    public void openHome(View view) {
        Intent intent = new Intent(this, GameDifficultyActivity.class);
       // intent.putExtra(USER_ID, user_id);
        startActivity(intent);
    }

    public void openResults(View view) {
        Intent intent = new Intent(this, HighScoresActivity.class);
        intent.putExtra(USER_ID, user_id);
        startActivity(intent);
    }

    public double calculateResult() {
        //numberOfCorrectAnswers * difficulty / time
        //easy = 1, medium = 2, hard = 3; 30sec = 1, 60 sec = 2, 120 sec  = 4

        double res = 0.0;

        int timer = Integer.parseInt(gameTimeInSeconds);
        if(timer == 5) { //TODO PROMIJENITI
            if(difficulty.equals("EASY")) {
                res = numberOfCorrectAnswers;
            }
            else if(difficulty.equals("MEDIUM")) {
                res = numberOfCorrectAnswers * 2;
            }
            else {
                res = numberOfCorrectAnswers * 3;
            }
        }
        else if(timer == 60) {
            if(difficulty.equals("EASY")) {
                res = numberOfCorrectAnswers / 2;
            }
            else if(difficulty.equals("MEDIUM")) {
                res = numberOfCorrectAnswers;
            }
            else {
                res = numberOfCorrectAnswers * 3 / 2;
            }
        }
        else if(timer == 120) {
            if(difficulty.equals("EASY")) {
                res = numberOfCorrectAnswers * 1 / 4;
            }
            else if(difficulty.equals("MEDIUM")) {
                res = numberOfCorrectAnswers * 2 / 4;
            }
            else {
                res = numberOfCorrectAnswers * 3 / 4;
            }
        }
        return res;
    }

}