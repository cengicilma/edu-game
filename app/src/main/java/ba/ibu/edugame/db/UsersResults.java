package ba.ibu.edugame.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseView;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Query;

import java.util.List;

@DatabaseView("SELECT Users.user_name, Results.result FROM Users, Results WHERE Users.users_id = Results.userId ORDER BY Results.result DESC LIMIT 5")
public class UsersResults {
    @NonNull
    public String userName;

    @NonNull
    public double result;


    public String toString() {
        return this.userName + " " + this.result;
    }

}
