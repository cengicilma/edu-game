package ba.ibu.edugame.db;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserResultsDao {

    @Query("SELECT * FROM UsersResults")
    List<UsersResults> getAll();

}
