package ba.ibu.edugame.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UsersDao {
    @Query("SELECT * FROM Users WHERE user_name = :username AND user_password = :password")
    Users getUser(String username, String password);

    @Insert
    void insert(Users user);

    @Query("SELECT user_name FROM Users WHERE users_id = :userID")
    String getUserNameById(int userID);
}
