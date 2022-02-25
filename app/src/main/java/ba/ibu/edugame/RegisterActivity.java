package ba.ibu.edugame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

import ba.ibu.edugame.db.AppDatabase;
import ba.ibu.edugame.db.Users;
import ba.ibu.edugame.db.UsersDao;

public class RegisterActivity extends AppCompatActivity {

    EditText usernameInput;
    EditText passwordInput;
    EditText confirmPasswordInput;
    Button registerBtn;

    UsersDao usersDao;
    AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //Hide action bar on top
        setContentView(R.layout.activity_register);

        usernameInput = findViewById(R.id.userNameRegisterTxt);
        passwordInput = findViewById(R.id.passwordRegister);
        confirmPasswordInput = findViewById(R.id.confirmPasswordRegister);
        registerBtn = findViewById(R.id.registerBtn);

        appDatabase = AppDatabase.getDatabase(this.getApplicationContext());
        usersDao = appDatabase.usersDao();

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();
                String passwordConf = confirmPasswordInput.getText().toString().trim();

                if(password.equals(passwordConf)) {
                    Users user = new Users(username, password);
                    usersDao.insert(user);

                    Intent moveToLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(moveToLogin);
                } else {
                    Toast.makeText(RegisterActivity.this, "Password is not matching", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}


