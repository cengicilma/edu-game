package ba.ibu.edugame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import ba.ibu.edugame.db.AppDatabase;
import ba.ibu.edugame.db.Users;
import ba.ibu.edugame.db.UsersDao;

public class LoginActivity extends AppCompatActivity {

    public static final String USER_ID = "edugame.USER_ID";
    
    Button loginBtn;
    EditText usernameTxt;
    EditText passwordTxt;

    AppDatabase appDatabase;
    UsersDao usersDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //Hide action bar on top
        setContentView(R.layout.activity_login);

        usernameTxt = findViewById(R.id.usernameLoginTxt);
        passwordTxt = findViewById(R.id.passwordLogin);
        loginBtn = findViewById(R.id.loginButton);

        appDatabase = AppDatabase.getDatabase(this.getApplicationContext());
        usersDao = appDatabase.usersDao();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameTxt.getText().toString().trim();
                String password = passwordTxt.getText().toString().trim();

                Users user = usersDao.getUser(username, password);

                if(user != null) {
                    Intent i = new Intent(LoginActivity.this, GameDifficultyActivity.class);
                    i.putExtra(USER_ID, String.valueOf(user.getId()));
                    startActivity(i);
                    finish();
                }
                else {
                    Toast.makeText(LoginActivity.this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



}