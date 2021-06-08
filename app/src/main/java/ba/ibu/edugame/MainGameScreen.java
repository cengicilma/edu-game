package ba.ibu.edugame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainGameScreen extends AppCompatActivity {

    private String difficulty;
    private String gameTimeText;
    private String gameTimeInSeconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //Hide action bar on top
        setContentView(R.layout.activity_main_game_screen);

        //Get chosen level string
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
        TextView txtTimeInSeconds = findViewById(R.id.txtTimeInSeconds);
        txtTimeInSeconds.setText(gameTimeInSeconds);
    }
}