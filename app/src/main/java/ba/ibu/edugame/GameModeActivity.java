package ba.ibu.edugame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import ba.ibu.edugame.db.Users;

public class GameModeActivity extends AppCompatActivity {

    public static final String GAME_DIFFICULTY = "edugame.GAME_DIFFICULTY";
    public static final String GAME_MODE_TEXT = "edugame.GAME_MODE_TEXT";
    public static final String GAME_MODE = "edugame.GAME_MODE";
    public static final String USER_ID = "edugame.USER_ID";

    private static String user_id;

    private String difficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //Hide action bar on top
        setContentView(R.layout.activity_game_mode);

        //Get chosen level string
        Intent intent = getIntent();
        difficulty = intent.getStringExtra(GameDifficultyActivity.GAME_DIFFICULTY);
        user_id = intent.getStringExtra(GameDifficultyActivity.USER_ID);

        //Set text view to chosen level
        TextView txtLevelDifficulty = findViewById(R.id.txtLevelDifficulty);
        txtLevelDifficulty.setText(difficulty);
    }

    public void openGameMode30sec(View view) {
        Intent intent = new Intent(this, MainGameScreenActivity.class);
        intent.putExtra(GAME_DIFFICULTY, difficulty);
        intent.putExtra(GAME_MODE_TEXT, "30 seconds");
        intent.putExtra(GAME_MODE, "5"); //for testing, later will be 30
        intent.putExtra(USER_ID, user_id);
        startActivity(intent);
    }

    public void openGameMode1min(View view) {
        Intent intent = new Intent(this, MainGameScreenActivity.class);
        intent.putExtra(GAME_DIFFICULTY, difficulty);
        intent.putExtra(GAME_MODE_TEXT, "1 minute");
        intent.putExtra(GAME_MODE, "60");
        intent.putExtra(USER_ID, user_id);
        startActivity(intent);
    }

    public void openGameMode2min(View view) {
        Intent intent = new Intent(this, MainGameScreenActivity.class);
        intent.putExtra(GAME_DIFFICULTY, difficulty);
        intent.putExtra(GAME_MODE_TEXT, "2 minutes");
        intent.putExtra(GAME_MODE, "120");
        intent.putExtra(USER_ID, user_id);
        startActivity(intent);
    }
}