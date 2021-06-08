package ba.ibu.edugame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FinishedGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //Hide action bar on top
        setContentView(R.layout.activity_finished_game);
    }
}