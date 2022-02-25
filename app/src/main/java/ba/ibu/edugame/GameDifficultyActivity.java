package ba.ibu.edugame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GameDifficultyActivity extends AppCompatActivity {

    public static final String GAME_DIFFICULTY = "edugame.GAME_DIFFICULTY";
    public static final String USER_ID = "edugame.USER_ID";

    private static String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //Hide action bar on top
        setContentView(R.layout.activity_game_difficulty);

        Intent intent = getIntent();
        user_id = intent.getStringExtra(LoginActivity.USER_ID);
    }

    public void openLevelEasy(View view) {
        Intent intent = new Intent(this, GameModeActivity.class);
        String level = "EASY";
        intent.putExtra(GAME_DIFFICULTY, level);
        intent.putExtra(USER_ID, user_id);
        startActivity(intent);
    }

    public void openLevelMedium(View view) {
        Intent intent = new Intent(this, GameModeActivity.class);
        String level = "MEDIUM";
        intent.putExtra(GAME_DIFFICULTY, level);
        intent.putExtra(USER_ID, user_id);
        startActivity(intent);
    }

    public void openLevelHard(View view) {
        Intent intent = new Intent(this, GameModeActivity.class);
        String level = "HARD";
        intent.putExtra(GAME_DIFFICULTY, level);
        intent.putExtra(USER_ID, user_id);
        startActivity(intent);
    }
}