package ba.ibu.edugame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GameDifficultyActivity extends AppCompatActivity {

    public static final String GAME_DIFFICULTY = "edugame.GAME_DIFFICULTY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //Hide action bar on top
        setContentView(R.layout.activity_game_difficulty);
    }

    public void openLevelEasy(View view) {
        Intent intent = new Intent(this, GameModeActivity.class);
        String level = "Easy";
        intent.putExtra(GAME_DIFFICULTY, level);
        startActivity(intent);
    }

    public void openLevelMedium(View view) {
        Intent intent = new Intent(this, GameModeActivity.class);
        String level = "Medium";
        intent.putExtra(GAME_DIFFICULTY, level);
        startActivity(intent);
    }

    public void openLevelHard(View view) {
        Intent intent = new Intent(this, GameModeActivity.class);
        String level = "Hard";
        intent.putExtra(GAME_DIFFICULTY, level);
        startActivity(intent);
    }
}