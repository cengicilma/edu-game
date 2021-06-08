package ba.ibu.edugame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameModeActivity extends AppCompatActivity {

    public static final String GAME_DIFFICULTY = "edugame.GAME_DIFFICULTY";
    public static final String GAME_MODE_TEXT = "edugame.GAME_MODE_TEXT";
    public static final String GAME_MODE = "edugame.GAME_MODE";
    private String difficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //Hide action bar on top
        setContentView(R.layout.activity_game_mode);

        //Get chosen level string
        Intent intent = getIntent();
        difficulty = intent.getStringExtra(GameDifficultyActivity.GAME_DIFFICULTY);

        //Set text view to chosen level
        TextView txtLevelDifficulty = findViewById(R.id.txtLevelDifficulty);
        txtLevelDifficulty.setText(difficulty);
    }

    public void openGameMode30sec(View view) {
        Intent intent = new Intent(this, MainGameScreen.class);
        intent.putExtra(GAME_DIFFICULTY, difficulty);
        intent.putExtra(GAME_MODE_TEXT, "30 seconds");
        intent.putExtra(GAME_MODE, "5"); //for testing, later will be 30
        startActivity(intent);
    }

    public void openGameMode1min(View view) {
        Intent intent = new Intent(this, MainGameScreen.class);
        intent.putExtra(GAME_DIFFICULTY, difficulty);
        intent.putExtra(GAME_MODE_TEXT, "1 minute");
        intent.putExtra(GAME_MODE, "60");
        startActivity(intent);
    }

    public void openGameMode2min(View view) {
        Intent intent = new Intent(this, MainGameScreen.class);
        intent.putExtra(GAME_DIFFICULTY, difficulty);
        intent.putExtra(GAME_MODE_TEXT, "2 minutes");
        intent.putExtra(GAME_MODE, "120");
        startActivity(intent);
    }

}