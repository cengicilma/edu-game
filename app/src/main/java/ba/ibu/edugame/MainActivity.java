package ba.ibu.edugame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //Hide action bar on top
        setContentView(R.layout.activity_main);
    }

    public void openPlay(View view) {
        Intent intent = new Intent(this, GameDifficultyActivity.class);
        startActivity(intent);
    }
}