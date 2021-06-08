package ba.ibu.edugame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

public class MainGameScreen extends AppCompatActivity {

    private String difficulty;
    private String gameTimeText;
    private String gameTimeInSeconds;
    private TextView txtTimeInSeconds;
    private int time;
    private CountDownTimer cTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //Hide action bar on top
        setContentView(R.layout.activity_main_game_screen);

        //Get chosen level, game time, game time in seconds strings
        Intent intent = getIntent();
        difficulty = intent.getStringExtra(GameModeActivity.GAME_DIFFICULTY);
        gameTimeText = intent.getStringExtra(GameModeActivity.GAME_MODE_TEXT);
        gameTimeInSeconds = intent.getStringExtra(GameModeActivity.GAME_MODE);

        //Set text view to chosen level
        TextView txtLevelDifficulty = findViewById(R.id.txtDifficulty);
        txtLevelDifficulty.setText(difficulty);

        //Set text view to chosen time
        TextView txtGameTimeText = findViewById(R.id.txtTime);
        txtGameTimeText.setText(gameTimeText);

        //Set text view to chosen time for countdown
        txtTimeInSeconds = findViewById(R.id.txtTimeInSeconds);
        txtTimeInSeconds.setText(gameTimeInSeconds);

        startTimer(Integer.parseInt(gameTimeInSeconds));
    }


    void startTimer(int time) {
        cTimer = new CountDownTimer(time * 1000, 100) {
            public void onTick(long millisUntilFinished) {
                double d = (double) millisUntilFinished / 1000;
                txtTimeInSeconds.setText((String.format("%.1f", d)));
            }

            public void onFinish() {
                double d = 0.0;
                txtTimeInSeconds.setText((String.format("%.1f", d)));
                Intent i = new Intent(MainGameScreen.this, FinishedGameActivity.class);
                //TODO add results to intent
                startActivity(i);
                finish();
            }
        };
        cTimer.start();
    }

    void cancelTimer() {
        if(cTimer != null) {
            cTimer.cancel();
        }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(MainGameScreen.this, "You quit the game!", Toast.LENGTH_SHORT).show();
        cancelTimer();
        finish();
        super.onBackPressed();
    }
}