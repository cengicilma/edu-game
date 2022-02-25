package ba.ibu.edugame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.List;

import ba.ibu.edugame.db.AppDatabase;
import ba.ibu.edugame.db.Results;
import ba.ibu.edugame.db.ResultsDao;
import ba.ibu.edugame.db.UserResultsDao;
import ba.ibu.edugame.db.Users;
import ba.ibu.edugame.db.UsersDao;
import ba.ibu.edugame.db.UsersResults;

public class HighScoresActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //Hide action bar on top
        setContentView(R.layout.activity_high_scores);

        /*test = findViewById(R.id.textView4);



        LiveData<List<Results>> allResults;
        allResults = resultsDao.getAllLive();

        test.setText(String.valueOf(allResults.getValue().get(1).result));*/

        AppDatabase appDatabase = AppDatabase.getDatabase(this.getApplicationContext());
        ResultsDao resultsDao = appDatabase.resultsDao();
        UsersDao usersDao = appDatabase.usersDao();

        List<Results> allResults = resultsDao.getAll();
        Results allRez[] = new Results[allResults.size()];
        allResults.toArray(allRez);


        String resultsString[] = new String[allResults.size()];
        for(int i=0; i<allResults.size(); i++) {
            String userName = usersDao.getUserNameById(allRez[i].userId);

            resultsString[i] = userName + "     " + allRez[i].resultToString();
        }

        listView = findViewById(R.id.listView);
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(
                this, R.layout.support_simple_spinner_dropdown_item, resultsString);
        listView.setAdapter(arr);
    }
}